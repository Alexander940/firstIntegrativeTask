package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Restaurant;

public class ChangePassword extends Stage {

    private TextField idTF, currentPasswordTF, newPasswordTF;
    private Button changeBtn;

    public ChangePassword() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ChangePassword.fxml"));
            Parent root = loader.load();

            idTF = (TextField) loader.getNamespace().get("idTF");
            currentPasswordTF = (TextField) loader.getNamespace().get("currentPasswordTF");
            newPasswordTF = (TextField) loader.getNamespace().get("newPasswordTF");
            changeBtn = (Button) loader.getNamespace().get("changeBtn");

            Scene scene = new Scene(root, 600, 400);
            setScene(scene);

            init();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    /**
     * this method execute the actions of fxml components
     */
    private void init() {
        changeBtn.setOnAction(e -> {
            if(Restaurant.getInstance().getEmployeesInventory().comparePassword(currentPasswordTF.getText(), idTF.getText())){
                Restaurant.getInstance().getEmployeesInventory().changePassword(idTF.getText(), newPasswordTF.getText());
                confirmationAlert("Congratulations", "The password was successfully changed", ":)");
            } else {
                errorAlert("Error", "The employee or passwors are wrong", "Ooops");
            }
        });
    }

    /**
     * This method shows an alert
     * @param title this contains alert's title
     * @param header this contains alert's header
     * @param contentText this contains alert's content text
     */
    private void confirmationAlert(String title, String header, String contentText){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(contentText);

        alert.showAndWait();
    }

    /**
     * This method shows an alert
     * @param title this contains alert's title
     * @param header this contains alert's header
     * @param contentText this contains alert's content text
     */
    private void errorAlert(String title, String header, String contentText){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(contentText);

        alert.showAndWait();
    }

}
