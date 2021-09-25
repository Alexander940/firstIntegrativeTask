package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.MenuItem;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Menu implements Serializable{

    private static final long serialVersionUID = 1L;

    private ObservableList<MenuItem> items;
    private ObservableList<Saucer> saucers;
    private ArrayList<Ingredient> ingredients;

    public Menu() {
        items = FXCollections.observableArrayList();
        saucers = loadSaucers();
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
        System.out.println("entro a addSacuer");
        double price = Double.parseDouble(sPrice);
        Saucer saucer = new Saucer(name, price, ingredients);
        saucers.add(saucer);
        ingredients.clear();
        saveSaucers();
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
    public boolean verIngredients(String saucerName,int saucerQuantity){
        String name;
        double amount;
        for(int i=0;i<saucers.size();i++){

            if(saucers.get(i).getName().equals(saucerName)){

                for(int b=0;b<saucers.get(i).getIngredients().size();b++){
                   name = saucers.get(i).getIngredients().get(b).getName();
                    amount = saucerQuantity*(saucers.get(i).getIngredients().get(b).getQuantity());

                    if(Restaurant.getInstance().getIngredientsInventory().verIngredient(name,amount)){

                    }else if(saucers.get(i).getIngredients().size()==0){
                        return false;
                    }

                }
            }
        }

       return true;
    }
}
