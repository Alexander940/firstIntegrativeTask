package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Restaurant;
import sun.rmi.runtime.Log;

public class AddIngredientSaucer extends Stage {

    private MenuButton ingredientMB;
    private TextField cuantityTF;
    private Button addBtn;

    public AddIngredientSaucer() {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddIngredientSaucer.fxml"));
            Parent root = loader.load();

            ingredientMB = (MenuButton) loader.getNamespace().get("ingredientMB");
            cuantityTF = (TextField) loader.getNamespace().get("cuantityTF");
            addBtn = (Button) loader.getNamespace().get("addBtn");

            ingredientMB.getItems().addAll(Restaurant.getInstance().getMenu().getItems());

            Scene scene = new Scene(root, 300, 200);
            setScene(scene);



            init();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void init() {
        addBtn.setOnAction(e -> {
            Restaurant.getInstance().getMenu().addIngredient(ingredientMB.getText(), cuantityTF.getText());
            AddSaucer addSaucer = new AddSaucer();
            addSaucer.show();
            this.close();
        });

        for(MenuItem mi : Restaurant.getInstance().getMenu().getItems()){
            mi.setOnAction(event->{
                ingredientMB.setText(mi.getText());
            });
        }
    }
}
