package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ChangePassword extends Stage {

    public ChangePassword() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ChangePassword.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root, 600, 400);
            setScene(scene);

            init();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private void init() {

    }
}
