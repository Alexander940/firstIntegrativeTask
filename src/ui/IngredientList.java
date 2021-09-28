package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Ingredient;
import model.Restaurant;


public class IngredientList extends Stage {

    private TableView<Ingredient> tableView;

    public IngredientList(){

        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("IngredientList.fxml"));
            Parent root = loader.load();
            tableView = (TableView) loader.getNamespace().get("tableView");
            TableColumn<Ingredient,String> nameColumn = new TableColumn<>("INGREDIENT");
            TableColumn<Ingredient,String> measurementColumn = new TableColumn<>("UNIT");
            TableColumn<Ingredient,Double> quantityColumn = new TableColumn<>("QUANTITY");

            nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
            measurementColumn.setCellValueFactory(new PropertyValueFactory<>("unitOfMeasurement"));
            quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

            tableView.getColumns().addAll(nameColumn,measurementColumn,quantityColumn);
            tableView.setItems(Restaurant.getInstance().getIngredientsInventory().getIngredients());

            nameColumn.setMaxWidth(200);
            measurementColumn.setMaxWidth(200);
            quantityColumn.setMaxWidth(200);
            nameColumn.setMinWidth(200);
            measurementColumn.setMinWidth(200);
            quantityColumn.setMinWidth(200);

            Scene scene = new Scene(root,600,400);
            setScene(scene);



        }catch (Exception e){
            e.printStackTrace();
        }

    }



}
