package model;

import java.util.ArrayList;

/**
 * This class contains the attributes and methods of a saucer
 * @author Alexander Echeverry
 * @version 1.0
 */
public class Saucer {

    private String name;
    private double price;
    private ArrayList<Ingredient> ingredients;

    public Saucer(String name, double price) {
        this.name = name;
        this.price = price;
        ingredients = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        String output;

        output = "name: " + name + "\n" +
                 "price: " + price + "\n";

        return output;
    }
}
