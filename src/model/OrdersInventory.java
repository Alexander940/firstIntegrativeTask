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

<<<<<<< HEAD
    /**
     * Method to add an order to the ObservableList of Order
     * @param uID The uId of the order
     * @param price The total price of the Order
     * @param date The Date that the user selected
     */
    public void addOrder(String uID,double price,String date){
        Order order = new Order(uID,OrderStatus.PENDING,date,price,new ArrayList<SaucerOrdersQuantity>(this.ordersQuantity));
=======
    public void addOrder(String uID, double price, String date) {
        Order order = new Order(uID, OrderStatus.PENDING, date, price, new ArrayList<SaucerOrdersQuantity>(this.ordersQuantity));
>>>>>>> b96cefe1893c4ba18e5a82af511d5798fcdd3916
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

<<<<<<< HEAD
    /**
     * Method to have control of the saucers with each quantity
     * @param name The name of the Saucer
     * @param quantity The amount of the saucer
     */
    public void addSaucer(String name, int quantity){
=======
    public void addSaucer(String name, int quantity) {
>>>>>>> b96cefe1893c4ba18e5a82af511d5798fcdd3916
        SaucerOrdersQuantity orderQuantity = new SaucerOrdersQuantity(name, quantity);
        ordersQuantity.add(orderQuantity);
    }

    public ObservableList<SaucerOrdersQuantity> getOrdersQuantity() {
        return ordersQuantity;
    }

<<<<<<< HEAD
    /**
     * Method to calculate the total price of an oder
     * @return The total price
     */
    public double calculatePrice(){
=======
    public double calculatePrice() {
>>>>>>> b96cefe1893c4ba18e5a82af511d5798fcdd3916
        double price;
        double totalPrice = 0;
        for (int i = 0; i < ordersQuantity.size(); i++) {
            price = (ordersQuantity.get(i).getQuantity()) * (Restaurant.getInstance().getMenu().getPrice(ordersQuantity.get(i).getSaucerName()));
            totalPrice += price;
        }
        return totalPrice;
    }

<<<<<<< HEAD
    /**
     * Method to save the orders
     * @return True of false depending on the save success
     */
    private boolean saveOrder(){
        try{
=======
    private boolean saveOrder() {
        try {
>>>>>>> b96cefe1893c4ba18e5a82af511d5798fcdd3916
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

<<<<<<< HEAD
    /**
     * Method to load the orders that were saved
     * @return An observableList with all the orders
     */
    private ObservableList<Order> loadOrders(){
=======
    private ObservableList<Order> loadOrders() {
>>>>>>> b96cefe1893c4ba18e5a82af511d5798fcdd3916
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

<<<<<<< HEAD
    /**
     * Method to change the status of an Order
     * @param uid The uId of the Order
     * @param status The new status of the order
     */
    public void changeStatus(String uid,String status){
=======
    public void changeStatus(String uid, String status) {
>>>>>>> b96cefe1893c4ba18e5a82af511d5798fcdd3916

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

<<<<<<< HEAD
    public void assignOrderEmployee(String name){
=======
    }

    /**
     * This method assign an order to employee did it
     * @param name This is employee's name
     */
    public void assignOrderEmployee(String name, double quantitySold){
>>>>>>> b96cefe1893c4ba18e5a82af511d5798fcdd3916
        int position = Restaurant.getInstance().getEmployeesInventory().findEmployeeByName(name);
        Restaurant.getInstance().getEmployeesInventory().getEmployees().get(position).addOrder();
<<<<<<< HEAD

=======
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
>>>>>>> b96cefe1893c4ba18e5a82af511d5798fcdd3916
    }
}


