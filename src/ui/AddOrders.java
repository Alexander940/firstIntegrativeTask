package ui;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.*;

import java.time.LocalDate;

import java.util.UUID;

/**
 *  this class is a controller of window to add an order
 *  @author David Molta =)
 *  @version 1.0
 */
public class AddOrders extends Stage {


    private Button addSaucerCombo,addOrder;
    private TableView table;
    private DatePicker datePicker;
<<<<<<< HEAD
    private MenuButton employeesMenuBtn;

=======
    private TextField employeeNameTF;
>>>>>>> b96cefe1893c4ba18e5a82af511d5798fcdd3916

    public AddOrders(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddOrders.fxml"));
            Parent root = loader.load();

            addSaucerCombo = (Button) loader.getNamespace().get("addSaucerCombo");
            table = (TableView) loader.getNamespace().get("table");
            addOrder = (Button) loader.getNamespace().get("addOrder");
            datePicker = (DatePicker) loader.getNamespace().get("datePicker");
            employeeNameTF = (TextField) loader.getNamespace().get("employeeNameTF");
            //nameSaucerTable
            TableColumn<SaucerOrdersQuantity,String> nameSaucerColumn = new TableColumn<>("Name");
            TableColumn<SaucerOrdersQuantity,String> quantitySaucerColumn = new TableColumn<>("Quantity");

            nameSaucerColumn.setCellValueFactory(new PropertyValueFactory("saucerName"));
            quantitySaucerColumn.setCellValueFactory(new PropertyValueFactory("quantity"));

            nameSaucerColumn.setMinWidth(100);
            quantitySaucerColumn.setMinWidth(100);
            nameSaucerColumn.setMaxWidth(100);
            quantitySaucerColumn.setMaxWidth(100);

            table.getColumns().addAll(nameSaucerColumn ,quantitySaucerColumn);
            table.setItems(Restaurant.getInstance().getOrdersInventory().getOrdersQuantity());

            Scene scene = new Scene(root, 600, 400);
            setScene(scene);

            init();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private void init() {
<<<<<<< HEAD

        for(MenuItem mI: Restaurant.getInstance().getEmployeesInventory().getItems()){
            mI.setOnAction(e -> {
                employeesMenuBtn.setText(mI.getText());
            });
        }

=======
>>>>>>> b96cefe1893c4ba18e5a82af511d5798fcdd3916
        addSaucerCombo.setOnAction(event -> {
            AddOrderSaucer addOrderSaucer = new AddOrderSaucer();
            addOrderSaucer.show();

        });

        addOrder.setOnAction(event -> {
            if(verificationFields()) {
                if (Restaurant.getInstance().getEmployeesInventory().employeeExist("", employeeNameTF.getText())) {
                    String uId = UUID.randomUUID().toString();
                    LocalDate dates = datePicker.getValue();
                    double price = Restaurant.getInstance().getOrdersInventory().calculatePrice();
                    Restaurant.getInstance().getOrdersInventory().assignOrderEmployee(employeeNameTF.getText(), price);
                    Restaurant.getInstance().getOrdersInventory().assignOrderSaucer(dates.toString());
                    Restaurant.getInstance().getOrdersInventory().addOrder(uId, price, dates.toString());
                } else {
                    errorAlert("Error", "This employe doesn't exists", "Ooops");
                }
            } else {
                errorAlert("Error", "You should fill all fields", "Ooops");
            }
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
     * This method verify if the fields are fill
     * @return True if the all fields are fill or false in the other case
     */
    private boolean verificationFields(){
        if(Restaurant.getInstance().getOrdersInventory().getOrdersQuantity().isEmpty()){
            return false;
        } else if(datePicker.getValue().toString().equals("")){
            return false;
        } else if(employeeNameTF.getText().equals("")){
            return false;
        }

        return true;
    }
}
