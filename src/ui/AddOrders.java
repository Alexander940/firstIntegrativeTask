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
    TableView nameSaucerTable;
    TableView quantitySaucerTable;
    DatePicker datePicker;

    public AddOrders(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddOrders.fxml"));
            Parent root = loader.load();
            addSaucerCombo = (Button) loader.getNamespace().get("addSaucerCombo");
            nameSaucerTable = (TableView) loader.getNamespace().get("nameSaucerTable");
            quantitySaucerTable = (TableView) loader.getNamespace().get("quantitySaucerTable");
            addOrder = (Button) loader.getNamespace().get("addOrder");
            datePicker = (DatePicker) loader.getNamespace().get("datePicker");
            //nameSaucerTable
            TableColumn<String,String> nameSaucerColumn = new TableColumn<>("NAME");
           TableColumn<Integer,String> quantitySaucerColumn = new TableColumn<>("QUANTITY");

           nameSaucerTable.getColumns().addAll(nameSaucerColumn);
           quantitySaucerTable.getColumns().addAll(quantitySaucerColumn);

            nameSaucerTable.setItems(Restaurant.getInstance().getOrdersInventory().getNameSaucer());
            quantitySaucerTable.setItems(Restaurant.getInstance().getOrdersInventory().getQuantitySaucer());




            Scene scene = new Scene(root, 603, 526);
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
            double price = 0;

            Restaurant.getInstance().getOrdersInventory().addOrder(uId,price,dates.toString());
        });
    }



}
