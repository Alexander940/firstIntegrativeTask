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
            TableColumn<Order, String> nameColumn = new TableColumn("ID");
            TableColumn<Order, String> statusColumn = new TableColumn("STATUS");
            TableColumn<Order, String> dateColumn = new TableColumn("DATE");
            TableColumn<Order, String> priceColumn = new TableColumn("PRICE");
            // Initialize columns
            nameColumn.setCellValueFactory(new PropertyValueFactory<>("uId"));
            statusColumn.setCellValueFactory(new PropertyValueFactory<>("state"));
            dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
            priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

            table.getColumns().addAll(nameColumn,statusColumn,dateColumn,priceColumn);
            table.setItems(Restaurant.getInstance().getOrdersInventory().getOrders());

            System.out.println(Restaurant.getInstance().getOrdersInventory().getOrders().get(0).getuId());

            init();

            Scene scene = new Scene(root,600,400);
            setScene(scene);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private void init(){

    }
}
