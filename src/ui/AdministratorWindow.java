package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AdministratorWindow extends Stage {
    Button inventoryGO,personalGO,orderGO,menuGO;
    public AdministratorWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminitratorWindow.fxml"));
            Parent root = loader.load();
            inventoryGO = (Button) loader.getNamespace().get("inventoryGO");
            personalGO = (Button) loader.getNamespace().get("personalGO");
            orderGO = (Button) loader.getNamespace().get("orderGO");
            menuGO = (Button) loader.getNamespace().get("menuGO");
            Scene scene = new Scene(root, 600, 400);
            setScene(scene);

            init();
        } catch (Exception ex){

        }
    }

    private void init(){
        inventoryGO.setOnAction(event -> {

        });
        personalGO.setOnAction(event -> {

        });
        orderGO.setOnAction(event -> {

        });
        menuGO.setOnAction(event -> {

        });
    }
}
