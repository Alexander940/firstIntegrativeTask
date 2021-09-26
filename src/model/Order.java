package model;




import java.io.Serializable;
import java.util.ArrayList;


public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    String uID;
    OrderStatus state;
    String date;
    double price;
    ArrayList<SaucerOrdersQuantity> ordersQuantity;

    public Order(String uID, OrderStatus state, String date, double price, ArrayList<SaucerOrdersQuantity> ordersQuantity) {
        this.uID = uID;
        this.state = state;
        this.date = date;
        this.price = price;
        this.ordersQuantity = cloneSaucerOrdersQuantity(ordersQuantity);
    }

    public void setState(OrderStatus state) {
        this.state = state;
    }

    public String getuID() {
        return uID;
    }

    public ArrayList<SaucerOrdersQuantity> getOrdersQuantity() {
        return ordersQuantity;
    }

    public OrderStatus getState() {
        return state;
    }

    public String getDate() {
        return date;
    }

    public double getPrice() {
        return price;
    }


    private ArrayList<SaucerOrdersQuantity> cloneSaucerOrdersQuantity(ArrayList<SaucerOrdersQuantity> saucerOrdersQuantity){
        ArrayList<SaucerOrdersQuantity> saucerOrder = new ArrayList<>();

        for(int i = 0 ;i < saucerOrdersQuantity.size() ;i++){

            String name = saucerOrdersQuantity.get(i).getSaucerName();
            int quantity = saucerOrdersQuantity.get(i).getQuantity();

            SaucerOrdersQuantity saucerOrdersQuantity1 = new SaucerOrdersQuantity(name,quantity);
            saucerOrder.add(saucerOrdersQuantity1);
        }

        return saucerOrder;
    }
}



