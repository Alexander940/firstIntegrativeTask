package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Restaurant;

import java.io.File;
import java.io.FileInputStream;
import java.util.Collections;

/**
 * This class controls the window that it allows manage the program's module
 * @author David Molta
 * @version 1.0
 */
public class AdministratorWindow extends Stage {
    // Menu items for the Personal module
    private MenuItem addEmployeeItem, showListEmployeesItem, changePasswordItem, addSaucerItem, closeItem, employeesReportMI, saucersReportMI;
    private ImageView imageView, imageSaucer, imageSaucer2;
    // Menu items for the Inventory module
    private MenuItem addIngredientITEM, increaseIngredientITEM, decreaseIngredientITEM, deleteIngredientITEM, showIngredientITEM, showMenuMI;
    private MenuItem viewOrders,registerOrder,changeOrder;

    public AdministratorWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AdministratorWindow.fxml"));
            Parent root = loader.load();
            // Fxml for the Personal module
            addEmployeeItem = (MenuItem) loader.getNamespace().get("addEmployeeItem");
            showListEmployeesItem = (MenuItem) loader.getNamespace().get("showListEmployeesItem");
            changePasswordItem = (MenuItem) loader.getNamespace().get("changePasswordItem");
            addSaucerItem = (MenuItem) loader.getNamespace().get("addSaucerItem");
            closeItem = (MenuItem) loader.getNamespace().get("closeItem");
            showMenuMI = (MenuItem) loader.getNamespace().get("showMenuMI");
            employeesReportMI = (MenuItem) loader.getNamespace().get("employeesReportMI");
            saucersReportMI = (MenuItem) loader.getNamespace().get("saucersReportMI");
            imageView = (ImageView) loader.getNamespace().get("imageView");
            imageSaucer = (ImageView) loader.getNamespace().get("imageSaucer");
            imageSaucer2 = (ImageView) loader.getNamespace().get("imageSaucer2");
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



            init();
        } catch (Exception ex){

        }
    }

    /**
     * this method execute the actions of fxml components
     */
    private void init(){
        loadImages();

        addEmployeeItem.setOnAction(e -> {
            AddEmployee addEmployee = new AddEmployee();
            addEmployee.show();
            this.close();
        });

        showListEmployeesItem.setOnAction(e -> {
            EmployeesList employeesList = new EmployeesList();
            employeesList.show();
        });

        changePasswordItem.setOnAction(e -> {
            ChangePassword changePassword = new ChangePassword();
            changePassword.show();
            this.close();
        });
        // Action for the Inventory module
        addIngredientITEM.setOnAction(event -> {
            AddIngredient addIngredient = new AddIngredient();
            addIngredient.show();
        });

        showIngredientITEM.setOnAction(event -> {
            IngredientList ingredientList = new IngredientList();
            ingredientList.show();
            Collections.sort(Restaurant.getInstance().getIngredientsInventory().getIngredients());

        });

        deleteIngredientITEM.setOnAction(event -> {
            DeleteIngredient deleteIngredient = new DeleteIngredient();
            deleteIngredient.show();
        });

        increaseIngredientITEM.setOnAction(event -> {
            IncreaseIngredient increaseIngredient = new IncreaseIngredient();
            increaseIngredient.show();
        });

        decreaseIngredientITEM.setOnAction(event -> {
            DecreaseIngredient decreaseIngredient = new DecreaseIngredient();
            decreaseIngredient.show();
        });
        // Action for Saucer module

        addSaucerItem.setOnAction(event -> {
            AddSaucer addSaucer = new AddSaucer();
            addSaucer.show();
            this.close();
        });

        //Action for the Order module

        viewOrders.setOnAction(event -> {
            OrderList orderList = new OrderList();
            orderList.show();
            Restaurant.getInstance().getOrdersInventory().orderBySelection();
        });

        changeOrder.setOnAction(event -> {
            ChangeOrderStatus changeOrderStatus = new ChangeOrderStatus();
            changeOrderStatus.show();
        });

        registerOrder.setOnAction(event -> {
            Restaurant.getInstance().getOrdersInventory().cloneIngredients();
            AddOrders addOrders = new AddOrders();
            addOrders.show();
            this.close();
        });

        showMenuMI.setOnAction(event -> {
            MenuList menuList = new MenuList();
            menuList.show();
        });

        closeItem.setOnAction(event -> {
            Login login = new Login();
            login.show();
            this.close();
        });

        employeesReportMI.setOnAction(e -> {
            Restaurant.getInstance().generateReportEmployees();
        });

        saucersReportMI.setOnAction(event -> {
            Restaurant.getInstance().generateReportSaucers();
        });
    }

    private void loadImages(){
        try{
            File file = new File("src/img/loginImage.jpg");
            FileInputStream input = new FileInputStream(file);
            Image image = new Image(input);
            imageView.setImage(image);

            File f = new File("src/img/comida.jpg");
            FileInputStream fis = new FileInputStream(f);
            Image imageS = new Image(fis);
            imageSaucer.setImage(imageS);
            imageSaucer2.setImage(imageS);
        } catch (Exception ex){

        }
    }
}


