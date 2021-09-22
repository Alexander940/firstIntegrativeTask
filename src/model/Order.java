package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class Order {
    String uId;
    String state;
    String date;
    Map<String,Integer> saucer;


    public Order(String uId,String state,String date,Map<String,Integer> saucer){
        this.date = date;
        this.state = state;
        this.uId = uId;
        this.saucer=saucer;

    }

    public void setState(String state) {
        this.state = state;
    }


}
