package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Employee;

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
    private Button createBtn;

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
    private void init() {
        createBtn.setOnAction(e -> {
            if(verificationPassword(passwordPF.getText(), confirmPasswordPF.getText())) {
                String name = nameTF.getText();
                String id = idTF.getText();
                String birth = dateDP.getValue().toString();
                String password = passwordPF.getText();

                Employee employee = new Employee(name,id,birth,password);
                boolean successful = Main.restaurant.getEmployeesInventory().addEmployee(employee);

                //if the employee could be added this shows an alert saying that the employee was successfully add
                //if the employee couldn't be added this shows an alert saying that the employee wasn't successfully add
                if(successful){

                } else {

                }
            } else {

            }
        });
    }

    /**
     * this method verifies that the password and confirm password are equals
     * @param password it contains the text of password field password
     * @param confirmPassword it contains the text of password field confirmPassword
     * @return this return true if the passwords are equals or false if the passwords are different
     */
    private boolean verificationPassword(String password, String confirmPassword){
        boolean confirmation = false;

        if(password.equals(confirmPassword)){
            confirmation = true;
        }

        return confirmation;
    }
}
