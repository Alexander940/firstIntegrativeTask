package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileInputStream;

/**
 * This class controls the window that it allows manage the program's module
 * @author David Molta
 * @version 1.0
 */
public class AdministratorWindow extends Stage {
    // Menu items for the Personal module
    private MenuItem addEmployeeItem, showListEmployeesItem, changePasswordItem, addSaucerItem;
    private ImageView imageView;
    // Menu items for the Inventory module
    private MenuItem addIngredientITEM, increaseIngredientITEM, decreaseIngredientITEM, deleteIngredientITEM, showIngredientITEM, showMenuMI;
    private EmployeesList employeesList;
    private AddEmployee addEmployee;
    private AddIngredient addIngredient;
    private IngredientList ingredientList;
    private IncreaseIngredient increaseIngredient;
    private DecreaseIngredient decreaseIngredient;
    private DeleteIngredient deleteIngredient;
    private AddSaucer addSaucer;
    private MenuItem viewOrders,registerOrder,changeOrder;
    private AddOrders addOrders;
    private ChangeOrderStatus changeOrderStatus;

    public AdministratorWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AdministratorWindow.fxml"));
            Parent root = loader.load();
            // Fxml for the Personal module
            addEmployeeItem = (MenuItem) loader.getNamespace().get("addEmployeeItem");
            showListEmployeesItem = (MenuItem) loader.getNamespace().get("showListEmployeesItem");
            changePasswordItem = (MenuItem) loader.getNamespace().get("changePasswordItem");
            addSaucerItem = (MenuItem) loader.getNamespace().get("addSaucerItem");
            showMenuMI = (MenuItem) loader.getNamespace().get("showMenuMI");
            imageView = (ImageView) loader.getNamespace().get("imageView");
            // Fxml for the Inventory module
            addIngredientITEM = (MenuItem) loader.getNamespace().get("addIngredientITEM");
            increaseIngredientITEM = (MenuItem) loader.getNamespace().get("increaseIngredientITEM");
            decreaseIngredientITEM =  (MenuItem) loader.getNamespace().get("decreaseIngredientITEM");
            deleteIngredientITEM = (MenuItem) loader.getNamespace().get("deleteIngredientITEM");
            showIngredientITEM = (MenuItem) loader.getNamespace().get("showIngredientITEM");
            // Fxml for the Orders module
            viewOrders = (MenuItem) loader.getNamespace().get("viewOrders");
            registerOrder= (MenuItem) loader.getNamespace().get("registerOrder");
            changeOrder = (MenuItem) loader.getNamespace().get("changeOrder");
            Scene scene = new Scene(root, 600, 400);
            setScene(scene);

            FileInputStream input = new FileInputStream("src/img/loginImage.jpg");
            Image image = new Image(input);
            imageView.setImage(image);

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
            this.close();
        });

        showListEmployeesItem.setOnAction(e -> {
            employeesList = new EmployeesList();
            employeesList.show();
        });

        changePasswordItem.setOnAction(e -> {
            ChangePassword changePassword = new ChangePassword();
            changePassword.show();
            this.close();
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


        addSaucerItem.setOnAction(event -> {
            addSaucer = new AddSaucer();
            addSaucer.show();
        });

        //Action for the Order module

        viewOrders.setOnAction(event -> {



        });
        changeOrder.setOnAction(event -> {
            changeOrderStatus = new ChangeOrderStatus();
            changeOrderStatus.show();
        });
        registerOrder.setOnAction(event -> {
        addOrders = new AddOrders();
        addOrders.show();
        });


        showMenuMI.setOnAction(event -> {
            MenuList menuList = new MenuList();
            menuList.show();

        });
    }
}


