package ui;

import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Ingredient;
import model.Restaurant;

public class AddSaucer extends Stage {

    private TableView table;
    private Button addIngredientBtn, addSaucerBtn;
    private TextField nameTF, priceTF;

    public AddSaucer() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddSaucer.fxml"));
            Parent root = loader.load();

            table = (TableView) loader.getNamespace().get("table");
            addIngredientBtn = (Button) loader.getNamespace().get("addIngredientBtn");

            TableColumn<String, Ingredient> nameColum = new TableColumn<>("Name");
            TableColumn<String, Ingredient> cuantityColum = new TableColumn<>("Cuantity");

            nameColum.setCellValueFactory(new PropertyValueFactory<>("name"));
            cuantityColum.setCellValueFactory(new PropertyValueFactory<>("quantity"));

            table.getColumns().addAll(nameColum, cuantityColum);
            table.setItems(FXCollections.observableArrayList(Restaurant.getInstance().getMenu().getIngredients()));

            Scene scene = new Scene(root, 600, 400);
            setScene(scene);

            init();
        } catch (Exception ex){

        }
    }

    private void init(){
        addIngredientBtn.setOnAction(e -> {
            AddIngredientSaucer addIngredientSaucer = new AddIngredientSaucer();
            addIngredientSaucer.show();
            this.close();
        });

        addSaucerBtn.setOnAction(e -> {
            Restaurant.getInstance().getMenu().addSaucer(nameTF.getText(), priceTF.getText());
            AdministratorWindow administratorWindow = new AdministratorWindow();
            administratorWindow.show();
            this.close();
        });
    }


}
