package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.Serializable;

/**
 * @author David Molta
 * @version 1.0
 * this class has an inventory of ingredients
 */
public class IngredientsInventory implements Serializable {

    private static final long serialVersionUID = 1L;

    private ObservableList<Ingredient> ingredients;

    public IngredientsInventory() {
        ingredients = FXCollections.observableArrayList();
    }

    /**
     * This method add a new ingredient in the observable list
     * @param ingredient this contains the ingredient
     */
    public void addIngredient(Ingredient ingredient){
        this.ingredients.add(ingredient);
    }

    /**
     * This return an observable list with the ingredients
     * @return this contains the observable list
     */
    public ObservableList<Ingredient> getIngredients() {
        return ingredients;
    }

}
