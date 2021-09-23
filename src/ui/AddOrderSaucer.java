package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AddOrderSaucer extends Stage {
    Button addOrderSaucer;
    public AddOrderSaucer(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddOrderSaucer.fxml"));
            Parent root = loader.load();
            addOrderSaucer = (Button) loader.getNamespace().get("addOrderSaucer");
            Scene scene = new Scene(root,406,284);
            setScene(scene);
            init();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private void init() {

    }


}
