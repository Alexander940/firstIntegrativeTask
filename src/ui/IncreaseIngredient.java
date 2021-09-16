package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
/**
 * This class controls the window that increases the ingredient
 * @author David Molta
 * @version 1.0
 */
public class IncreaseIngredient extends Stage {

    TextField ingredientName,amountAdd;
    Button addBtn;
    public IncreaseIngredient(){


        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("IncreaseIngredient.fxml"));
            Parent root = loader.load();

            ingredientName = (TextField) loader.getNamespace().get("ingredientName");
            amountAdd = (TextField) loader.getNamespace().get("amountAdd");
            addBtn = (Button) loader.getNamespace().get("addBtn");

            Scene scene = new Scene(root,412,258);
            setScene(scene);
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void init(){

        addBtn.setOnAction(event -> {
            String ingName = ingredientName.getText();
            Double amount = Double.parseDouble(amountAdd.getText());
            boolean centinel = false;
            if(amount<=0){
                centinel=true;
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning ");
                alert.setHeaderText("Addition was not successful");
                alert.setContentText("The amount must be greater than 0");

                alert.showAndWait();
            }
            if(!centinel && Main.restaurant.getIngredientsInventory().increaseIngredient(ingName,amount)){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText("Addition successful");
                alert.setContentText("The ingredient was successfully added");

                alert.showAndWait();
                Main.restaurant.getIngredientsInventory().saveIngredients();
            }else if(!centinel){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning ");
                alert.setHeaderText("Addition was not successful");
                alert.setContentText("The name of the ingredient was not found");

                alert.showAndWait();
            }

        });

    }



}

