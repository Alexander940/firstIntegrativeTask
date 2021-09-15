package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author David Molta
 * @version 1.0
 * this class has an inventory of ingredients
 */
public class IngredientsInventory implements Serializable {

    private static final long serialVersionUID = 1L;

    private ObservableList<Ingredient> ingredients;

    public IngredientsInventory() {
        ingredients = loadIngredients();
    }

    /**
     * This method add a new ingredient in the observable list
     * @param ingredient this contains the ingredient
     */
    public void addIngredient(Ingredient ingredient){
        this.ingredients.add(ingredient);
        saveIngredients();
    }

    /**
     * This return an observable list with the ingredients
     * @return this contains the observable list
     */
    public ObservableList<Ingredient> getIngredients() {
        return ingredients;
    }

    /**
     *  This method will save the ingredients
     */
    public void saveIngredients(){
        try{
            File ingredientFile = new File("ingredients.txt");
            FileOutputStream fos = new FileOutputStream(ingredientFile);
            ObjectOutputStream output = new ObjectOutputStream(fos);
            output.writeObject(new ArrayList<Ingredient>(this.ingredients));
            output.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public ObservableList<Ingredient> loadIngredients(){
        try {
            File ingredientFile = new File("ingredients.txt");
            FileInputStream fis = new FileInputStream(ingredientFile);
            ObjectInputStream ois = new ObjectInputStream(fis);
            List<Ingredient> ing = (List<Ingredient>) ois.readObject();
            ObservableList<Ingredient> i = FXCollections.observableArrayList(ing);
            return i;
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

}
