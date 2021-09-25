package ui;

import com.sun.org.apache.xpath.internal.operations.Or;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.*;

import java.time.LocalDate;
import java.util.Date;
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
            // Declarar columnas
            TableColumn<Saucer,String> nameColumn = new TableColumn<>("COMBO");
            TableColumn<Saucer,String> priceColumn  = new TableColumn<>("PRICE");
            //
            nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
            priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
            //
            table.getColumns().addAll(nameColumn,priceColumn);

            table.setItems(FXCollections.observableArrayList(Restaurant.getInstance().getOrder().getSaucers()));

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
            Order order = new Order(uId, OrderStatus.PENDING,dates.toString());
            Restaurant.getInstance().getOrder().addOrder(order);
        });
    }



}
