package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Ingredient;


/**
 *  this class is a controller of window to add an Ingredient
 *  @author David Molta =)
 *  @version 1.0
 */

public class AddIngredient extends Stage {
    TextField ingredientName, ingredientQuantity;
    SplitMenuButton unitChooser;
    MenuItem kgUnits, gUnits, mlUnits, unitUnits;
    Button ingredientaddBtn;
    String units;



    public AddIngredient(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddIngredient.fxml"));
            Parent root = loader.load();
            ingredientName = (TextField) loader.getNamespace().get("ingredientName");
            ingredientQuantity = (TextField) loader.getNamespace().get("ingredientQuantity");
            unitChooser = (SplitMenuButton) loader.getNamespace().get("unitChooser");
            kgUnits = (MenuItem) loader.getNamespace().get("kgUnits");
            mlUnits = (MenuItem) loader.getNamespace().get("mlUnits");
            gUnits = (MenuItem) loader.getNamespace().get("gUnits");
            unitUnits = (MenuItem) loader.getNamespace().get("unitUnits");
            ingredientaddBtn = (Button) loader.getNamespace().get("ingredientaddBtn");
            Scene scene = new Scene(root,600,400);
            setScene(scene);
            init();

        }catch (Exception ex){
            ex.printStackTrace();
        }


    }

    /**
     * Method that executes all the actions on the fxml AddIngredient window
     */
    private void init() {

        ingredientaddBtn.setOnAction(event -> {
            String name = ingredientName.getText();
            Double quantity = Double.parseDouble(ingredientQuantity.getText());
            Ingredient ingredient = new Ingredient(name,units,quantity);
            System.out.println(ingredient);
            Main.restaurant.getIngredientsInventory().addIngredient(ingredient);

        });

        kgUnits.setOnAction(event -> {
            unitChooser.setText("Kg");
            units="Kg";

        });
        gUnits.setOnAction(event -> {
            unitChooser.setText("g");
            units="g";
        });
        unitUnits.setOnAction(event -> {
            unitChooser.setText("Unit");
            units="Unit";
        });
        mlUnits.setOnAction(event -> {
            unitChooser.setText("ml");
            units="ml";
        });

    }









}
