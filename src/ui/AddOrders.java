package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

/**
 *  this class is a controller of window to add an order
 *  @author David Molta =)
 *  @version 1.0
 */
public class AddOrders extends Stage {



    public AddOrders(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddOrders.fxml"));
            Parent root = loader.load();



            Scene scene = new Scene(root, 603, 526);
            setScene(scene);
            init();
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    private void init() {
    }


}
