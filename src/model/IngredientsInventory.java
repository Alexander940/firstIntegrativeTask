package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.sql.SQLOutput;
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
            File ingredientFile = new File("src/data/ingredients.txt");
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
            File ingredientFile = new File("src/data/ingredients.txt");
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
        for(int i=0;i<ingredients.size();i++){
            if(ingredients.get(i).getName().equalsIgnoreCase(ingredientName)){
                ingredients.get(i).increaseQuantity(amount);

                return true;
            }
        }

        return false;
    }


    /**
     * This method will decrease an ingredient by an amount registered by the user
     * @param ingredientName the name of the ingredient
     * @param amount the amount that will be decreased
     * @return
     */
    public boolean decreaseIngredient(String ingredientName, double amount ){
        boolean condition= false;

        for(int i=0;i<ingredients.size();i++){

            if(ingredients.get(i).getName().equals(ingredientName)){

                if(ingredients.get(i).getQuantity()-amount<0){
                    break;
                }else if(ingredients.get(i).getQuantity()-amount ==0){
                    ingredients.remove(ingredients.get(i));
                    condition=true;
                    break;
                }else {
                    ingredients.get(i).setQuantity((ingredients.get(i).getQuantity())-amount);
                    condition=true;
                    break;
                }

            }
        }

        return condition;
    }

    /**
     * This method will delete an ingredient
     * @param ingredientName the name of the ingredient that will be deleted
     * @return
     */
    public boolean deleteIngredient(String ingredientName){
        boolean condition= false;
        for(int i=0;i<ingredients.size();i++){
            if(ingredients.get(i).getName().equals(ingredientName)){
                ingredients.remove(ingredients.get(i));
                condition =true;
                break;
            }
        }

        return condition;
    }

    /**
     * This method will help to check if there are enough ingredients to create the combo
     * @param ingredientName The name of the ingredient to search
     * @param amount The amount of the ingredient
     * @return
     */
    public boolean verIngredient(String ingredientName,double amount){

        for(int i=0;i<ingredients.size();i++){
            if(ingredients.get(i).getName().equals(ingredientName)){
                if(ingredients.get(i).getQuantity()-amount<0){
                    return false;

                }else if(ingredients.get(i).getQuantity()-amount>0){


                }else if(ingredients.get(i).getQuantity()-amount==0){

                }
           }
        }

        return true;

    }

    public void decreaseVerIngredient(String ingredientName, double amount){
        double newQuantity;

        for(int i=0;i<ingredients.size();i++){
            if(ingredients.get(i).getName().equals(ingredientName)){

                newQuantity = ingredients.get(i).getQuantity() - amount;

                ingredients.get(i).setQuantity(newQuantity);
            }
        }

    }
}


