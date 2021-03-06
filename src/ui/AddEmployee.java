package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Restaurant;

import java.io.FileInputStream;
import java.net.URL;

/**
 *  this class is a controller of window to add an employee
 *  @author Alexander Echeverry
 *  @version 1.0
 */

public class AddEmployee extends Stage {

    //fx components
    private TextField nameTF, idTF;
    private DatePicker dateDP;
    private PasswordField passwordPF, confirmPasswordPF;
    private Button createBtn, getOutBtn;
    private RadioButton yesRB, noRB;

    public AddEmployee() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddEmployee.fxml"));
            Parent root = loader.load();

            nameTF = (TextField) loader.getNamespace().get("nameTF");
            idTF = (TextField) loader.getNamespace().get("idTF");
            dateDP = (DatePicker) loader.getNamespace().get("dateDP");
            passwordPF = (PasswordField) loader.getNamespace().get("passwordPF");
            confirmPasswordPF = (PasswordField) loader.getNamespace().get("confirmPasswordPF");
            createBtn = (Button) loader.getNamespace().get("createBtn");
            getOutBtn = (Button) loader.getNamespace().get("getOutBtn");
            yesRB = (RadioButton) loader.getNamespace().get("yesRB");
            noRB = (RadioButton) loader.getNamespace().get("noRB");

            Scene scene = new Scene(root, 500, 450);
            setScene(scene);

            init();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    /**
     * this method execute the actions of fxml components
     */
    private void init() {
        setImageBtn();
        createBtn.setOnAction(e -> {
            if(!Restaurant.getInstance().getEmployeesInventory().employeeExist(idTF.getText(), "") && !Restaurant.getInstance().getEmployeesInventory().employeeExist("", nameTF.getText())) {
                if (verificationFields()) {
                    if (passwordPF.getText().equals(confirmPasswordPF.getText())) {
                        String name = nameTF.getText();
                        String id = idTF.getText();
                        String birth = dateDP.getValue().toString();
                        String password = passwordPF.getText();
                        boolean administrator = getValueAdministrator();

                        boolean successful = Restaurant.getInstance().getEmployeesInventory().addEmployee(name, id , birth, password, administrator);

                        //if the employee could be added this shows an alert saying that the employee was successfully add
                        //if the employee couldn't be added this shows an alert saying that the employee wasn't successfully add
                        if (successful) {
                            confirmationAlert("",
                                    "The employee was successfully add",
                                    ":)");
                            cleanTextFields();
                        } else {
                            errorAlert("Error dialog",
                                    "The employee couldn't be add",
                                    "Ooops, there was an error");
                        }
                    } else {
                        errorAlert("Error dialog",
                                "The passwords aren't equals",
                                "Ooops, there was an error");
                    }
                } else {
                    errorAlert("Error",
                            "You must fill all the fields",
                            "Ooops");
                }
            } else {
                errorAlert("Error", "This employee already exist", "Ooops");
            }
        });

        getOutBtn.setOnAction(e -> {
            AdministratorWindow administratorWindow = new AdministratorWindow();
            administratorWindow.show();
            this.close();
        });

        yesRB.setOnAction(e -> {
            noRB.selectedProperty().setValue(false);
        });

        noRB.setOnAction(e -> {
            yesRB.selectedProperty().setValue(false);
        });
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
     * This method set all text fields
     */
    private void cleanTextFields(){
        nameTF.setText("");
        idTF.setText("");
        dateDP.setValue(null);
        passwordPF.setText("");
        confirmPasswordPF.setText("");
    }

    private boolean getValueAdministrator(){
        boolean isAdmin = false;

        if(yesRB.selectedProperty().getValue()){
            isAdmin = true;
        }

        return isAdmin;
    }

    private boolean verificationFields(){
        boolean all = true;

        if(nameTF.getText().equals("")){
            all = false;
        } else if(idTF.getText().equals("")){
            all = false;
        } else if(dateDP.getValue().toString().equals("")){
            all = false;
        } else if(passwordPF.getText().equals("")){
            all = false;
        } else if(confirmPasswordPF.getText().equals("")){
            all = false;
        } else if(!yesRB.selectedProperty().getValue() && !noRB.selectedProperty().getValue()){
            all = false;
        }

        return all;
    }

    private void setImageBtn(){
        try {
            FileInputStream input = new FileInputStream("src/img/flechaAtras.jpg");
            Image imageFlecha = new Image(input, 36,24, true, true);

            getOutBtn.setGraphic(new ImageView(imageFlecha));
        } catch (Exception e){

        }
    }
}