package model;




import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.Serializable;
import java.util.ArrayList;


public class Order implements Serializable {

    String uId;
    OrderStatus state;
    String date;
    double price;
    ArrayList<OrdersQuantity> ordersQuantity;

    public Order(String uId, OrderStatus state, String date, double price, ArrayList<OrdersQuantity> ordersQuantity) {
        this.uId = uId;
        this.state = state;
        this.date = date;
        this.price = price;
        this.ordersQuantity = ordersQuantity;
    }

    public void setState(OrderStatus state) {
        this.state = state;
    }

    public String getuId() {
        return uId;
    }

    public ArrayList<OrdersQuantity> getOrdersQuantity() {
        return ordersQuantity;
    }
}



