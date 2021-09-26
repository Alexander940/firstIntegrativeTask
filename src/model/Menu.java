package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.MenuItem;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This method contains the logic of a menu
 * @author Alexander Echeverry
 * @version 1.0
 */

public class Menu implements Serializable{

    private static final long serialVersionUID = 1L;

    private ObservableList<MenuItem> items;
    private ObservableList<Saucer> saucers;
    private ObservableList<Ingredient> ingredients;

    public Menu() {
        items = FXCollections.observableArrayList();
        saucers = loadSaucers();
        ingredients = FXCollections.observableArrayList();
    }

    /**
     * This method add a saucer's instance in array list saucers
     * @param name This is saucer's name
     * @param sPrice This is saucer's price in type String
     */
    public void addSaucer(String name, String sPrice){
        double price = Double.parseDouble(sPrice);
        Saucer saucer = new Saucer(name, price, new ArrayList<Ingredient>(this.ingredients));
        saucers.add(saucer);
        saveSaucers();
        ingredients.clear();
    }

    /**
     * This method add an ingredient to the saucer or increase the quantity of this ingredient if already exists
     * @param name This is ingredient's name
     * @param sQuantity this is ingredient's quantity in type String
     */
    public void addIngredient(String name, String sQuantity){
        int positionIngredient = findIngredientByName(name);
        double quantity = Double.parseDouble(sQuantity);

        if(positionIngredient != -1){
            quantity += ingredients.get(positionIngredient).getQuantity();
            Ingredient ingredient = new Ingredient(ingredients.get(positionIngredient).getName(), quantity);
            ingredients.remove(positionIngredient);
            ingredients.add(ingredient);
        } else {
            Ingredient ingredient = new Ingredient(name, quantity);
            ingredients.add(ingredient);
        }
    }

    /**
     * This method finds an ingredient by his name
     * @param name This is ingredient's name
     * @return The position of the ingredient
     */
    private int findIngredientByName(String name){
        for(int i = 0; i < ingredients.size(); i++){
            if(ingredients.get(i).getName().equals(name)){
                return i;
            }
        }

        return -1;
    }

    /**
     * This method load the saucers from file saucers.txt
     * @return An observable list with the saucers
     */
    private ObservableList<Saucer> loadSaucers(){
        try {
            File file = new File("src/data/saucers.txt");
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream input = new ObjectInputStream(fis);
            List<Saucer> list = (List<Saucer>) input.readObject();
            ObservableList<Saucer> saucers = FXCollections.observableArrayList(list);

            return saucers;
        } catch (Exception ex){
            ex.printStackTrace();

            return null;
        }
    }

    /**
     * This method save the saucers from observable list saucers
     * @return This returns a verification if the saucer was successfully saved
     */
    private boolean saveSaucers(){
        try{
            File file = new File("src/data/saucers.txt");
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream output = new ObjectOutputStream(fos);
            output.writeObject(new ArrayList<Saucer>(this.saucers));
            output.close();

            return true;
        } catch (Exception ex){
            ex.printStackTrace();

            return false;
        }
    }


    /**
     * This method is to verify if there are enough ingredients to add the combo
     * @param saucerName The name of the saucer
     * @param saucerQuantity The quantity of combos that the user wanted
     * @return Returns a true or false depending on the verification // False no space // True there's space
     */
    public boolean verIngredients(String saucerName,int saucerQuantity) {

        String name;
        double amount;
        for (int i = 0; i < saucers.size(); i++) {

            if (saucers.get(i).getName().equals(saucerName)) {

                for (int b = 0; b < saucers.get(i).getIngredients().size(); b++) {
                    name = saucers.get(i).getIngredients().get(b).getName();
                    amount = saucerQuantity * (saucers.get(i).getIngredients().get(b).getQuantity());

                    if (!Restaurant.getInstance().getIngredientsInventory().verIngredient(name, amount)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public ObservableList<MenuItem> getItems(){
        if(items.isEmpty()) {
            for (Ingredient ingredient : Restaurant.getInstance().getIngredientsInventory().getIngredients()) {
                items.add(new MenuItem(ingredient.getName()));
            }
        } else {
            ObservableList<Ingredient> observableIngredients = Restaurant.getInstance().getIngredientsInventory().getIngredients();
            for(int i = items.size(); i < Restaurant.getInstance().getIngredientsInventory().getIngredients().size(); i++){
                items.add(new MenuItem(observableIngredients.get(i).getName()));
            }
        }
        return items;
    }

    public ObservableList<Saucer> getSaucers() {
        return saucers;
    }

    public ObservableList<Ingredient> getIngredients() {
        return ingredients;
    }

    /**
     * This method finds a saucer by his name
     * @param name This is the name of saucer for searching
     * @return The position the saucer found in the observable list saucer. If the saucer isn't found return -1
     */
    private int findSaucerByName(String name){
        for(int i = 0; i < saucers.size(); i++){
            if(saucers.get(i).getName().equals(name)){
                return i;
            }
        }

        return -1;
    }

    /**
     * This method verify if a saucer exists
     * @param name This is saucer's name for searching
     * @return True if there is a saucer with this name in the observable list saucers or false in the other case
     */
    public boolean saucerExist(String name){
        if(findSaucerByName(name) != -1){
            return true;
        }

        return false;
    }

    public double getPrice(String saucerName){
        int posSaucer = findSaucerByName(saucerName);

        return saucers.get(posSaucer).getPrice();
    }

    public void delVerIngredients(String saucerName,int saucerQuantity) {
        String name;
        double amount;
        for (int i = 0; i < saucers.size(); i++) {

            if (saucers.get(i).getName().equals(saucerName)) {

                for (int b = 0; b < saucers.get(i).getIngredients().size(); b++) {
                    name = saucers.get(i).getIngredients().get(b).getName();

                    amount = saucerQuantity * (saucers.get(i).getIngredients().get(b).getQuantity());

                    Restaurant.getInstance().getIngredientsInventory().decreaseVerIngredient(name,amount);
                }
            }
        }


    }
}
