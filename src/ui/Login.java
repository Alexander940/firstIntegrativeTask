package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;

/**
 * This class controls the initial window
 * @author Alexander Echeverry
 * @version 1.0
 */
public class Login extends Stage {

    //fx declarations
    private TextField idTF;
    private PasswordField passwordPF;
    private Button joinBtn;
    private ImageView imageView;

    private AdministratorWindow administratorWindow;

    public Login(){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
            Parent root = loader.load();

            idTF = (TextField) loader.getNamespace().get("idTF");
            passwordPF = (PasswordField) loader.getNamespace().get("passwordPF");
            joinBtn = (Button) loader.getNamespace().get("joinBtn");
            imageView = (ImageView) loader.getNamespace().get("imageView");

            File file = new File("src/img/loginImage.jpg");
            FileInputStream input = new FileInputStream(file);
            Image image = new Image(input);
            imageView.setImage(image);

            Scene scene = new Scene(root, 600, 400);
            setScene(scene);

            init();
        } catch (Exception ex){
            ex.printStackTrace();
        }

    }

    /**
     * this method execute the actions of fxml components
     */
    private void init(){
        joinBtn.setOnAction(event->{
            administratorWindow = new AdministratorWindow();
            administratorWindow.show();
            this.close();
        });

    }
}
