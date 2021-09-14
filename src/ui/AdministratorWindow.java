package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

/**
 * This class controls the window that it allows manage the program's module
 * @author David Molta
 * @version 1.0
 */
public class AdministratorWindow extends Stage {

    private MenuItem addEmployeeItem, showListEmployeesItem, changePasswordItem;
    private EmployeesList employeesList;
    private AddEmployee addEmployee;

    public AdministratorWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AdministratorWindow.fxml"));
            Parent root = loader.load();

            addEmployeeItem = (MenuItem) loader.getNamespace().get("addEmployeeItem");
            showListEmployeesItem = (MenuItem) loader.getNamespace().get("showListEmployeesItem");
            changePasswordItem = (MenuItem) loader.getNamespace().get("changePasswordItem");

            Scene scene = new Scene(root, 600, 400);
            setScene(scene);

            init();
        } catch (Exception ex){

        }
    }

    /**
     * this method execute the actions of fxml components
     */
    private void init(){
        addEmployeeItem.setOnAction(e -> {
            addEmployee = new AddEmployee();
            addEmployee.show();
        });

        showListEmployeesItem.setOnAction(e -> {
            employeesList = new EmployeesList();
            employeesList.show();
        });

        changePasswordItem.setOnAction(e -> {

        });
    }
}
