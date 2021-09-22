package model;

import java.io.Serializable;

/**
 * This class contains the attributes of methods of an ingredient
 * @author David Molta
 * @version 1.0
 */
public class Ingredient implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private String unitOfMeasurement;
    private double quantity;

    public Ingredient(String name, String unitOfMeasurement, double quantity) {
        this.name = name;
        this.unitOfMeasurement = unitOfMeasurement;
        this.quantity = quantity;
    }

    public Ingredient(String name, double quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnitOfMeasurement() {
        return unitOfMeasurement;
    }

    public void setUnitOfMeasurement(String unitOfMeasurement) {
        this.unitOfMeasurement = unitOfMeasurement;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "name='" + name + '\'' +
                ", unitOfMeasurement='" + unitOfMeasurement + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    public void increaseQuantity(double amount){
        this.quantity = this.quantity + amount;
    }
}
