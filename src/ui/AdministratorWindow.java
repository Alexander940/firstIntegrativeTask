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
    // Menu items for the Personal module
    private MenuItem addEmployeeItem, showListEmployeesItem, changePasswordItem;
    // Menu items for the Inventory module
    private MenuItem addIngredientITEM, increaseIngredientITEM, decreaseIngredientITEM, deleteIngredientITEM, showIngredientITEM;
    private EmployeesList employeesList;
    private AddEmployee addEmployee;
    private AddIngredient addIngredient;
    private IngredientList ingredientList;
    private IncreaseIngredient increaseIngredient;
    private DecreaseIngredient decreaseIngredient;
    private DeleteIngredient deleteIngredient;

    public AdministratorWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AdministratorWindow.fxml"));
            Parent root = loader.load();
            // Fxml for the Personal module
            addEmployeeItem = (MenuItem) loader.getNamespace().get("addEmployeeItem");
            showListEmployeesItem = (MenuItem) loader.getNamespace().get("showListEmployeesItem");
            changePasswordItem = (MenuItem) loader.getNamespace().get("changePasswordItem");
            // Fxml for the Inventory module
            addIngredientITEM = (MenuItem) loader.getNamespace().get("addIngredientITEM");
            increaseIngredientITEM = (MenuItem) loader.getNamespace().get("increaseIngredientITEM");
            decreaseIngredientITEM =  (MenuItem) loader.getNamespace().get("decreaseIngredientITEM");
            deleteIngredientITEM = (MenuItem) loader.getNamespace().get("deleteIngredientITEM");
            showIngredientITEM = (MenuItem) loader.getNamespace().get("showIngredientITEM");
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
        // Action for the Inventory module
        addIngredientITEM.setOnAction(event -> {
            addIngredient = new AddIngredient();
            addIngredient.show();
        });


        showIngredientITEM.setOnAction(event -> {
        ingredientList = new IngredientList();
        ingredientList.show();
        });

        deleteIngredientITEM.setOnAction(event -> {
        deleteIngredient = new DeleteIngredient();
        deleteIngredient.show();
        });

        increaseIngredientITEM.setOnAction(event -> {
        increaseIngredient = new IncreaseIngredient();
        increaseIngredient.show();
        });

        decreaseIngredientITEM.setOnAction(event -> {
        decreaseIngredient = new DecreaseIngredient();
        decreaseIngredient.show();
        });
    }
}
