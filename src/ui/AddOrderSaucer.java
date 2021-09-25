package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Restaurant;


public class AddOrderSaucer extends Stage {
    private Button addOrderSaucer;
    private MenuButton menuBtnCombo;
    private TextField quantityTF;

    public AddOrderSaucer(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddOrderSaucer.fxml"));
            Parent root = loader.load();
            addOrderSaucer = (Button) loader.getNamespace().get("addOrderSaucer");
            menuBtnCombo = (MenuButton) loader.getNamespace().get("menuBtnCombo");
            menuBtnCombo.getItems().addAll(Restaurant.getInstance().getOrdersInventory().getItems());
            quantityTF = (TextField) loader.getNamespace().get("quantityTF");
            Scene scene = new Scene(root,406,284);
            setScene(scene);
            init();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private void init() {

        for (MenuItem mItem : Restaurant.getInstance().getOrdersInventory().getItems()) {
            mItem.setOnAction(event -> {
                menuBtnCombo.setText(mItem.getText());
            });

        }

        addOrderSaucer.setOnAction(event -> {


            int amount = Integer.parseInt(quantityTF.getText());
            String saucerName = menuBtnCombo.getText();
            if(Restaurant.getInstance().getMenu().verIngredients(saucerName,amount)){

                Restaurant.getInstance().getOrdersInventory().addNameSaucer(saucerName);
                Restaurant.getInstance().getOrdersInventory().addQuantitySaucer(amount);



                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Addition completed");
                alert.setHeaderText(null);
                alert.setContentText("There were enough ingredients to add the combo!");

                alert.showAndWait();
            }else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Can't add a combo");
                alert.setHeaderText("Not enough ingredients");
                alert.setContentText("Verify your entrance");

                alert.showAndWait();

            }



        });

    }
}
