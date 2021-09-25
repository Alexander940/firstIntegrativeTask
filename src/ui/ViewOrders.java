package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Order;
import model.OrderStatus;
import model.Restaurant;


public class ViewOrders extends Stage {

    TableView table;
    public ViewOrders(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewOrders.fxml"));
            Parent root = loader.load();
            table = (TableView) loader.getNamespace().get("table");

            // Create columns
            TableColumn<Order,String> nameColumn = new TableColumn<>("ID");
            TableColumn<Order, OrderStatus> statusColumn  = new TableColumn<>("STATUS");
            TableColumn<Order,String> dateColumn  = new TableColumn<>("DATE");
            TableColumn<Order,String> priceColumn  = new TableColumn<>("PRICE");
            // Initialize columns
            nameColumn.setCellValueFactory(new PropertyValueFactory<>("uID"));
            statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
            dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
            priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

            table.getColumns().addAll(nameColumn,statusColumn,dateColumn,priceColumn);
            table.setItems(Restaurant.getInstance().getOrder().getOrders());
            Scene scene = new Scene(root,600,400);
            setScene(scene);
        }catch (Exception ex){
            ex.printStackTrace();
        }


    }


}
