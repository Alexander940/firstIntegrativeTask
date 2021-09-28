package model;

import java.io.Serializable;

public class QuantitySold implements Serializable {

    private static final long serialVersionUID = 1L;

    private int unitsSold;
    private String date;
    private double priceOrder;

    public QuantitySold(int unitsSold, String date) {
        this.unitsSold = unitsSold;
        this.date = date;
    }

    public QuantitySold(String date, double priceOrder) {
        this.unitsSold = 1;
        this.date = date;
        this.priceOrder = priceOrder;
    }

    public int getUnitsSold() {
        return unitsSold;
    }

    public String getDate() {
        return date;
    }

    public double getPriceOrder() {
        return priceOrder;
    }
}
