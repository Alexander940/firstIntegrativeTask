package model;




import java.io.Serializable;
import java.util.ArrayList;


public class Order implements Serializable {

    String uId;
    OrderStatus state;
    String date;

    ArrayList<ArrayList<String>> saucers;


    public Order(String uId,OrderStatus state,String date){
        this.date = date;
        this.state = state;
        this.uId = uId;
        saucers = new ArrayList<>();
    }
    public void setState(OrderStatus state) {
        this.state = state;
    }

    public String getuId() {
        return uId;
    }
}



