package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Order;
import model.Restaurant;

public class OrderList extends Stage {

    private TableView<Order> table;

    public OrderList(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("OrderList.fxml"));
            Parent root = loader.load();

            table = (TableView) loader.getNamespace().get("table");

            // Create columns
            TableColumn<Order, String> statusColumn = new TableColumn("Status");
            TableColumn<Order, String> dateColumn = new TableColumn("Date");
            TableColumn<Order, String> priceColumn = new TableColumn("Price");
            TableColumn<Order, String> employeeNameColumn = new TableColumn("Employee name");
            // Initialize columns
            statusColumn.setCellValueFactory(new PropertyValueFactory<>("state"));
            dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
            priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
            employeeNameColumn.setCellValueFactory(new PropertyValueFactory<>("employeeName"));

            table.getColumns().addAll(statusColumn,dateColumn,priceColumn,employeeNameColumn);
            table.setItems(Restaurant.getInstance().getOrdersInventory().getOrders());

            employeeNameColumn.setMinWidth(150);
            statusColumn.setMinWidth(150);
            dateColumn.setMinWidth(150);
            priceColumn.setMinWidth(150);
            employeeNameColumn.setMaxWidth(150);
            statusColumn.setMaxWidth(150);
            dateColumn.setMaxWidth(150);
            priceColumn.setMaxWidth(150);

            Scene scene = new Scene(root,600,400);
            setScene(scene);

            init();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private void init(){

    }
}
