package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.MenuItem;

import java.util.ArrayList;

public class OrdersInventory {

    private ObservableList<Order> orders;
    private ArrayList<Saucer> saucers;
    private ObservableList<MenuItem> menuItems;
    private ObservableList<MenuItem> menuOrderItems;
    private ObservableList<OrdersQuantity> ordersQuantity;

    public OrdersInventory(){
        orders = FXCollections.observableArrayList();
        menuItems = FXCollections.observableArrayList();
        saucers = new ArrayList<>();
        menuOrderItems = FXCollections.observableArrayList();
        ordersQuantity = FXCollections.observableArrayList();
    }



    public ObservableList<MenuItem> getItems(){
        if(menuItems.isEmpty()) {
            for (Saucer saucer : Restaurant.getInstance().getMenu().getSaucers()) {

                menuItems.add(new MenuItem(saucer.getName()));
            }
        }else{

            for(int i=menuItems.size();i<Restaurant.getInstance().getMenu().getSaucers().size();i++){
                menuItems.add(new MenuItem(Restaurant.getInstance().getMenu().getSaucers().get(i).getName()));
            }

        }
        return menuItems;
    }

    /**
     * Method to autogenerate the menu items of the Orders with the respective UUID
     * @return the ObservableList with all the MenuItems
     */
    public ObservableList<MenuItem> getOrderItems(){
        if(menuOrderItems.isEmpty()){
            for(Order order :  orders){
                menuOrderItems.add(new MenuItem(order.getuId()));

            }
        }else{
            for(int i=menuOrderItems.size();i<orders.size();i++){
                menuOrderItems.add(new MenuItem(orders.get(i).getuId()));
            }
        }
        return menuOrderItems;
    }


    public void addOrder(String uID,double price,String date){
        Order order = new Order(uID,OrderStatus.PENDING,date,price,new ArrayList<OrdersQuantity>(this.ordersQuantity));
        orders.add(order);
    }

    public ObservableList<Order> getOrders() {
        return orders;
    }

    public void addSaucer(String name, int quantity){
        OrdersQuantity orderQuantity = new OrdersQuantity(name, quantity);
        ordersQuantity.add(orderQuantity);
    }

    public ObservableList<OrdersQuantity> getOrdersQuantity() {
        return ordersQuantity;
    }
}


