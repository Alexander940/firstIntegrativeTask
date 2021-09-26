package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.MenuItem;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class OrdersInventory implements Serializable {

    private static final long serialVersionUID = 1L;
    private ObservableList<Order> orders;
    private ObservableList<MenuItem> menuItems;
    private ObservableList<MenuItem> menuOrderItems;
    private ObservableList<SaucerOrdersQuantity> ordersQuantity;

    public OrdersInventory() {
        this.orders = loadOrders();
        menuItems = FXCollections.observableArrayList();
        menuOrderItems = FXCollections.observableArrayList();
        ordersQuantity = FXCollections.observableArrayList();
    }

    public ObservableList<MenuItem> getItems() {
        if (menuItems.isEmpty()) {
            for (Saucer saucer : Restaurant.getInstance().getMenu().getSaucers()) {

                menuItems.add(new MenuItem(saucer.getName()));
            }
        } else {

            for (int i = menuItems.size(); i < Restaurant.getInstance().getMenu().getSaucers().size(); i++) {
                menuItems.add(new MenuItem(Restaurant.getInstance().getMenu().getSaucers().get(i).getName()));
            }

        }
        return menuItems;
    }

    /**
     * Method to autogenerate the menu items of the Orders with the respective UUID
     *
     * @return the ObservableList with all the MenuItems
     */
    public ObservableList<MenuItem> getOrderItems() {
        if (menuOrderItems.isEmpty()) {
            for (Order order : orders) {
                menuOrderItems.add(new MenuItem(order.getuID()));

            }
        } else {
            for (int i = menuOrderItems.size(); i < orders.size(); i++) {
                menuOrderItems.add(new MenuItem(orders.get(i).getuID()));
            }
        }
        return menuOrderItems;
    }

    public void addOrder(String uID, double price, String date) {
        Order order = new Order(uID, OrderStatus.PENDING, date, price, new ArrayList<SaucerOrdersQuantity>(this.ordersQuantity));
        orders.add(order);
        for (int i = 0; i < ordersQuantity.size(); i++) {
            Restaurant.getInstance().getMenu().delVerIngredients(ordersQuantity.get(i).getSaucerName(), ordersQuantity.get(i).getQuantity());
        }
        saveOrder();
        Restaurant.getInstance().getIngredientsInventory().saveIngredients();
        ordersQuantity.clear();
    }

    public ObservableList<Order> getOrders() {
        return orders;
    }

    public void addSaucer(String name, int quantity) {
        SaucerOrdersQuantity orderQuantity = new SaucerOrdersQuantity(name, quantity);
        ordersQuantity.add(orderQuantity);
    }

    public ObservableList<SaucerOrdersQuantity> getOrdersQuantity() {
        return ordersQuantity;
    }

    public double calculatePrice() {
        double price;
        double totalPrice = 0;
        for (int i = 0; i < ordersQuantity.size(); i++) {
            price = (ordersQuantity.get(i).getQuantity()) * (Restaurant.getInstance().getMenu().getPrice(ordersQuantity.get(i).getSaucerName()));
            totalPrice += price;
        }
        return totalPrice;
    }

    private boolean saveOrder() {
        try {
            File file = new File("src/data/orders.txt");
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream output = new ObjectOutputStream(fos);
            output.writeObject(new ArrayList<Order>(this.orders));
            output.close();

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();

            return false;
        }
    }

    private ObservableList<Order> loadOrders() {
        try {
            File file = new File("src/data/orders.txt");
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream input = new ObjectInputStream(fis);
            List<Order> list = (List<Order>) input.readObject();
            ObservableList<Order> orders = FXCollections.observableArrayList(list);

            return orders;
        } catch (Exception ex) {
            ex.printStackTrace();

            return null;
        }
    }

    public void changeStatus(String uid, String status) {

        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getuID().equals(uid)) {
                orders.get(i).setState(OrderStatus.valueOf(status));
            }
        }
    }

    // M E T O D O           P O R           T E R M I N A R
    public void orderByInsertion() {

        for (int i = 1; i < orders.size(); i++) {

            for (int b = 0; b < i; b++) {

                double externo = orders.get(i).getPrice();
                double interno = orders.get(b).getPrice();

                if (externo < interno) {
                    orders.remove(i);
                    orders.add(b, orders.get(i));
                    break;
                }

            }

        }

    }

    /**
     * This method assign an order to employee did it
     * @param name This is employee's name
     */
    public void assignOrderEmployee(String name, double quantitySold){
        int position = Restaurant.getInstance().getEmployeesInventory().findEmployeeByName(name);
        Restaurant.getInstance().getEmployeesInventory().getEmployees().get(position).addOrder();
        Restaurant.getInstance().getEmployeesInventory().getEmployees().get(position).increaseQuantitySold(quantitySold);
        Restaurant.getInstance().getEmployeesInventory().saveEmployees();
    }

    public void assignOrderSaucer(String date){
        for(SaucerOrdersQuantity saucerOrdersQuantity: ordersQuantity){
            QuantitySold quantitySold = new QuantitySold(saucerOrdersQuantity.getQuantity(), date);
            int position = Restaurant.getInstance().getMenu().findSaucerByName(saucerOrdersQuantity.getSaucerName());
            Restaurant.getInstance().getMenu().getSaucers().get(position).addQuantitySold(quantitySold);
        }

        Restaurant.getInstance().getMenu().saveSaucers();
    }
}


