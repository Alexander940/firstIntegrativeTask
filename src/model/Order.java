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
    ArrayList<String> nameSaucer;
    ArrayList<Integer> quantitySaucer;

    public Order(String uId, OrderStatus state, String date, double price, ArrayList<String> nameSaucer, ArrayList<Integer> quantitySaucer) {
        this.uId = uId;
        this.state = state;
        this.date = date;
        this.price = price;
        this.nameSaucer = nameSaucer;
        this.quantitySaucer = quantitySaucer;
    }

    public void setState(OrderStatus state) {
        this.state = state;
    }

    public String getuId() {
        return uId;
    }


}



