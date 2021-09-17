package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DeleteIngredient extends Stage {
    Button deleteBtn;
    TextField ingredientName;
    public DeleteIngredient(){

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("DeleteIngredient.fxml"));
            Parent root = loader.load();
            deleteBtn = (Button) loader.getNamespace().get("deleteBtn");
            ingredientName = (TextField) loader.getNamespace().get("ingredientName");
            Scene scene = new Scene(root,412,258);
            init();
            setScene(scene);

        }catch (Exception e){
            e.printStackTrace();
        }



    }

    public void init(){

        deleteBtn.setOnAction(event -> {
        String ingName = ingredientName.getText();
        if(Main.restaurant.getIngredientsInventory().deleteIngredient(ingName)){

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Delete successful");
            alert.setContentText("The ingredient was successfully deleted");

            alert.showAndWait();
            Main.restaurant.getIngredientsInventory().saveIngredients();

        }else{

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning ");
            alert.setHeaderText("Delete was not successful");
            alert.setContentText("Name not found");

            alert.showAndWait();

        }


        });

    }
}
