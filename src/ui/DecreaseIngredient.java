package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DecreaseIngredient extends Stage {
    TextField ingredientName,amountSubs;
    Button decreaseBtn;
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




        });
    }
}
