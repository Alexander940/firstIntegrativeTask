package model;

import java.io.Serializable;

public class QuantitySold implements Serializable {

    private static final long serialVersionUID = 1L;

    private int unitsSold;
    private String date;

    public QuantitySold(int unitsSold, String date) {
        this.unitsSold = unitsSold;
        this.date = date;
    }

    public int getUnitsSold() {
        return unitsSold;
    }

    public String getDate() {
        return date;
    }
}
