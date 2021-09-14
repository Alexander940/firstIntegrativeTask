package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.Serializable;

public class IngredientsInventory implements Serializable {

    private static final long serialVersionUID = 1L;

    private ObservableList<Ingredient> ingredients;

    public IngredientsInventory() {
        ingredients = FXCollections.observableArrayList();
    }

    public void addIngredient(Ingredient ingredient){
        this.ingredients.add(ingredient);
    }

    public ObservableList<Ingredient> getIngredients() {
        return ingredients;
    }

}
