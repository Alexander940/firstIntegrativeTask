package model;




import java.io.Serializable;
import java.util.ArrayList;


public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    String uId;
    OrderStatus state;
    String date;
    double price;
    ArrayList<SaucerOrdersQuantity> ordersQuantity;

    public Order(String uId, OrderStatus state, String date, double price, ArrayList<SaucerOrdersQuantity> ordersQuantity) {
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

    public ArrayList<SaucerOrdersQuantity> getOrdersQuantity() {
        return ordersQuantity;
    }
}



