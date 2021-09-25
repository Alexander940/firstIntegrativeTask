package model;

import java.io.Serializable;

public class SaucerOrdersQuantity implements Serializable {
    private static final long serialVersionUID = 1L;
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
