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

    /**
     * Method to load the ingredients that were saved before
     * @return returns the observable list in order to load the data when the constructor is initializated
     */
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

    /**
     * Method to increase the number of ingredients
     * @param ingredientName The name to search the ingredient
     * @param amount the amount that will be added
     * @return
     */
    public boolean increaseIngredient(String ingredientName,double amount){
        boolean condition = false;

        for(int i=0;i<ingredients.size();i++){

            if(ingredients.get(i).getName().equals(ingredientName)){
                double amount1 = ingredients.get(i).getQuantity();
                amount += amount1;
                ingredients.get(i).setQuantity(amount);

                condition = true;
                break;
            }

        }

        return condition;

    }
}
