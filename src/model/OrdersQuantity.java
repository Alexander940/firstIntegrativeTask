package model;

public class OrdersQuantity {

    private String orderName;
    private int quantity;

    public OrdersQuantity(String orderName, int quantity) {
        this.orderName = orderName;
        this.quantity = quantity;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
