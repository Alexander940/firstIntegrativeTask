package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Restaurant;
import model.Saucer;

public class MenuList extends Stage {

    private TableView table;

    public MenuList() {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MenuList.fxml"));
            Parent root = loader.load();

            table = (TableView) loader.getNamespace().get("table");

            TableColumn<String, Saucer> nameColumn = new TableColumn<>("Name");
            TableColumn<String, Saucer> priceColumn = new TableColumn<>("Price");

            nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
            priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

            table.getColumns().addAll(nameColumn, priceColumn);
            table.setItems(Restaurant.getInstance().getMenu().getSaucers());

            Scene scene = new Scene(root, 600, 400);
            setScene(scene);

            init();
        } catch (Exception ex){

        }
    }

    private void init() {

    }
}
