package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import model.Restaurant;


public class ChangeOrderStatus extends Stage {
    Button changeToPending,changeToProcess,changeToDelivered;
    MenuButton menuBtnOrders;
    public ChangeOrderStatus(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ChangeOrderStatus.fxml"));
            Parent root = loader.load();
            menuBtnOrders = (MenuButton) loader.getNamespace().get("menuBtnOrders");
            changeToPending = (Button) loader.getNamespace().get("changeToPending");
            changeToProcess = (Button) loader.getNamespace().get("changeToProcess");
            changeToDelivered = (Button) loader.getNamespace().get("changeToDelivered");
            menuBtnOrders.getItems().addAll(Restaurant.getInstance().getOrder().getOrderItems());
            Scene scene = new Scene(root,385,310);
            setScene(scene);
            init();
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    public void init(){

        for (MenuItem mItem : Restaurant.getInstance().getOrder().getOrderItems()) {
            mItem.setOnAction(event -> {
                menuBtnOrders.setText(mItem.getText());
            });

        }

    changeToDelivered.setOnAction(event -> {

    });
    changeToProcess.setOnAction(event -> {

    });

    changeToPending.setOnAction(event -> {

    });
    }


}
