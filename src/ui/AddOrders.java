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


    Button addSaucerCombo,addOrder;
    TableView table;
    DatePicker datePicker;

    public AddOrders(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddOrders.fxml"));
            Parent root = loader.load();
            addSaucerCombo = (Button) loader.getNamespace().get("addSaucerCombo");
            table = (TableView) loader.getNamespace().get("table");
            addOrder = (Button) loader.getNamespace().get("addOrder");
            datePicker = (DatePicker) loader.getNamespace().get("datePicker");
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
        addSaucerCombo.setOnAction(event -> {
            AddOrderSaucer addOrderSaucer = new AddOrderSaucer();
            addOrderSaucer.show();

        });

        addOrder.setOnAction(event -> {
            String uId = UUID.randomUUID().toString();
            LocalDate dates = datePicker.getValue();
            double price = Restaurant.getInstance().getOrdersInventory().calculatePrice();
            Restaurant.getInstance().getOrdersInventory().addOrder(uId,price,dates.toString());
        });
    }
}
