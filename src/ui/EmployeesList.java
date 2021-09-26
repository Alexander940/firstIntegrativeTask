package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Employee;

import javafx.scene.control.TableColumn;
import model.Restaurant;

/**
 * This class controls the window that it shows the employee's list
 * @author Alexander Echeverry
 * @version 1.0
 */
public class EmployeesList extends Stage {

    private TableView<Employee> table;

    public EmployeesList() {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("EmployeesList.fxml"));
            Parent root = loader.load();

            table = (TableView) loader.getNamespace().get("table");

            TableColumn<Employee, String> usernameColum = new TableColumn("Username");
            TableColumn<Employee, String> idColum = new TableColumn("ID");
            TableColumn<Employee, String> dateOfBirthColum = new TableColumn("Date of birth");
            TableColumn<Employee, String> passwordColum = new TableColumn("Password");
            TableColumn<Employee, String> adminColum = new TableColumn("Is admin");

            usernameColum.setCellValueFactory(new PropertyValueFactory<>("name"));
            idColum.setCellValueFactory(new PropertyValueFactory<>("id"));
            dateOfBirthColum.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));
            passwordColum.setCellValueFactory(new PropertyValueFactory<>("password"));
            adminColum.setCellValueFactory(new PropertyValueFactory<>("administrator"));

            usernameColum.setMaxWidth(120);
            usernameColum.setMinWidth(120);
            idColum.setMaxWidth(120);
            idColum.setMinWidth(120);
            dateOfBirthColum.setMaxWidth(120);
            dateOfBirthColum.setMinWidth(120);
            passwordColum.setMaxWidth(120);
            passwordColum.setMinWidth(120);
            adminColum.setMaxWidth(120);
            adminColum.setMinWidth(120);

            table.getColumns().addAll(usernameColum, idColum, dateOfBirthColum, passwordColum, adminColum);
            table.setItems(Restaurant.getInstance().getEmployeesInventory().getEmployees());

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

    }

}
