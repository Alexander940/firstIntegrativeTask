package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.MenuItem;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class Menu {

    private ObservableList<MenuItem> items;
    private ObservableList<Saucer> saucers;
    private ArrayList<Ingredient> ingredients;

    public Menu() {
        items = FXCollections.observableArrayList();
        saucers = FXCollections.observableArrayList();
        ingredients = new ArrayList<>();
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

    /**
     * This method add a saucer's instance in array list saucers
     * @param name This is saucer's name
     * @param sPrice This is saucer's price in type String
     */
    public void addSaucer(String name, String sPrice){
        double price = Double.parseDouble(sPrice);
        Saucer saucer = new Saucer(name, price, ingredients);
        saucers.add(saucer);
        ingredients.clear();
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
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
            ingredients.get(positionIngredient).increaseQuantity(quantity);
        } else {
            Ingredient ingredient = new Ingredient(name, quantity);
            System.out.println(positionIngredient);
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

    private ObservableList<Employee> loadSaucers(){
        try {
            File file = new File("saucers.txt");
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream input = new ObjectInputStream(fis);
            List<Employee> list = (List<Employee>) input.readObject();
            ObservableList<Employee> employees = FXCollections.observableArrayList(list);

            return employees;
        } catch (Exception ex){
            ex.printStackTrace();

            return null;
        }
    }
}
