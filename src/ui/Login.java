package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Login extends Stage {

    //fx declarations
    private TextField idTF;
    private PasswordField passwordPF;
    private Button joinBtn;

    public Login(){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
            Parent root = loader.load();

            idTF = (TextField) loader.getNamespace().get("idTF");
            passwordPF = (PasswordField) loader.getNamespace().get("passwordPF");
            joinBtn = (Button) loader.getNamespace().get("joinBtn");

            Scene scene = new Scene(root, 600, 400);
            setScene(scene);

            init();
        } catch (Exception ex){
            ex.printStackTrace();
        }

    }

    private void init(){

    }
}
