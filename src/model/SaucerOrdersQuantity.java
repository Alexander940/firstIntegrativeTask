package model;

public class SaucerOrdersQuantity {

    private String saucerName;
    private int quantity;

    public SaucerOrdersQuantity(String saucerName, int quantity) {
        this.saucerName = saucerName;
        this.quantity = quantity;
    }

    public String getSaucerName() {
        return saucerName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
