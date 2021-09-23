package model;

    public class Order {

    String uId;
    String state;
    String date;



    public Order(String uId,String state,String date){
        this.date = date;
        this.state = state;
        this.uId = uId;

    }

    public void setState(String state) {
        this.state = state;
    }


}
