package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Restaurant;

public class DecreaseIngredient extends Stage {
    private TextField ingredientName,amountSubs;
    private Button decreaseBtn;
    public DecreaseIngredient(){

        try{

            FXMLLoader loader = new FXMLLoader(getClass().getResource("DecreaseIngredient.fxml"));
            Parent root = loader.load();
            ingredientName = (TextField) loader.getNamespace().get("ingredientName");
            amountSubs = (TextField) loader.getNamespace().get("amountSubs");
            decreaseBtn = (Button) loader.getNamespace().get("decreaseBtn");
            Scene scene = new Scene(root,412,258);
            setScene(scene);
            init();
        }catch (Exception ex){


        }
    }


    public void init(){

        decreaseBtn.setOnAction(event -> {

            String name = ingredientName.getText();
            double amount = Double.parseDouble(amountSubs.getText());
            if(Restaurant.getInstance().getIngredientsInventory().decreaseIngredient(name,amount)){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText("Subtraction successful");
                alert.setContentText("The ingredient was successfully subtracted");

                alert.showAndWait();

                Restaurant.getInstance().getIngredientsInventory().saveIngredients();

            }else {

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning ");
                alert.setHeaderText("Addition was not successful");
                alert.setContentText("Please verify the information that you entered");

                alert.showAndWait();

            }



        });
    }
}
