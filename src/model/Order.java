package model;

import java.util.ArrayList;

public class Order {
    String uId;
    String state;
    String date;
    ArrayList<ArrayList<String>> saucers;

    public Order(String uId,String state,String date){
        this.date = date;
        this.state = state;
        this.uId = uId;
    }

    public void setState(String state) {
        this.state = state;
    }

}
