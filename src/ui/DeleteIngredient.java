package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Restaurant;

public class DeleteIngredient extends Stage {
    private Button deleteBtn;
    private TextField ingredientName;
    private MenuButton ingredientsMB;
    public DeleteIngredient(){

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("DeleteIngredient.fxml"));
            Parent root = loader.load();
            deleteBtn = (Button) loader.getNamespace().get("deleteBtn");
            ingredientName = (TextField) loader.getNamespace().get("ingredientName");
            ingredientsMB = (MenuButton) loader.getNamespace().get("ingredientsMB");

            ingredientsMB.getItems().addAll(Restaurant.getInstance().getIngredientsInventory().getMenuItems());

            Scene scene = new Scene(root,412,258);
            setScene(scene);

            init();
        }catch (Exception e){
            e.printStackTrace();
        }



    }

    public void init(){
        for(MenuItem mi: Restaurant.getInstance().getIngredientsInventory().getMenuItems()){
            mi.setOnAction(e -> {
                ingredientsMB.setText(mi.getText());
            });
        }

        deleteBtn.setOnAction(event -> {
        String ingName = ingredientsMB.getText();
        if(Restaurant.getInstance().getIngredientsInventory().deleteIngredient(ingName)){

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Delete successful");
            alert.setContentText("The ingredient was successfully deleted");

            alert.showAndWait();
            Restaurant.getInstance().getIngredientsInventory().saveIngredients();

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
