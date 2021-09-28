package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Ingredient;
import model.Restaurant;

import java.io.File;
import java.io.FileInputStream;

public class AddSaucer extends Stage {

    private TableView table;
    private Button addIngredientBtn, addSaucerBtn, getOutBtn;
    private TextField nameTF, priceTF;

    public AddSaucer() {
        try {
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddSaucer.fxml"));
            Parent root = loader.load();

            table = (TableView) loader.getNamespace().get("table");
            addIngredientBtn = (Button) loader.getNamespace().get("addIngredientBtn");
            addSaucerBtn = (Button) loader.getNamespace().get("addSaucerBtn");
            getOutBtn = (Button) loader.getNamespace().get("getOutBtn");
            nameTF = (TextField) loader.getNamespace().get("nameTF");
            priceTF = (TextField) loader.getNamespace().get("priceTF");

            TableColumn<String, Ingredient> nameColum = new TableColumn<>("Name");
            TableColumn<String, Ingredient> cuantityColum = new TableColumn<>("Cuantity");

            nameColum.setCellValueFactory(new PropertyValueFactory<>("name"));
            cuantityColum.setCellValueFactory(new PropertyValueFactory<>("quantity"));

            table.getColumns().addAll(nameColum, cuantityColum);
            table.setItems(Restaurant.getInstance().getMenu().getIngredients());

            Scene scene = new Scene(root, 600, 400);
            setScene(scene);

            init();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private void init(){
        setImageBtn();

        addIngredientBtn.setOnAction(e -> {
            AddIngredientSaucer addIngredientSaucer = new AddIngredientSaucer();
            addIngredientSaucer.show();
        });

        addSaucerBtn.setOnAction(e -> {
            if(verifyFields()) {
                if(!Restaurant.getInstance().getMenu().saucerExist(nameTF.getText())){
                    Restaurant.getInstance().getMenu().addSaucer(nameTF.getText(), priceTF.getText());
                    AdministratorWindow administrator = new AdministratorWindow();
                    administrator.show();
                    this.close();
                } else {
                    errorAlert("Error", "This saucer's name already exists", "Ooops");
                }
            } else {
                errorAlert("Error", "You should fill all fields", "Ooops");
            }
        });

        getOutBtn.setOnAction(e -> {
            AdministratorWindow administratorWindow = new AdministratorWindow();
            administratorWindow.show();
            this.close();
        });
    }

    /**
     * This method verify if the all data requested is already put
     * @return True if the all data is put or false in the another case
     */
    private boolean verifyFields(){
        if(Restaurant.getInstance().getMenu().getIngredients().isEmpty()){
            return false;
        } else if(nameTF.getText().equals("")){
            return false;
        } else if(priceTF.getText().equals("")){
            return false;
        }

        return true;
    }

    /**
     * This method shows an alert
     * @param title this contains alert's title
     * @param header this contains alert's header
     * @param contentText this contains alert's content text
     */
    private void errorAlert(String title, String header, String contentText){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(contentText);

        alert.showAndWait();
    }

    private void setImageBtn(){
        try {
            File file = new File("src/img/flechaAtras.jpg");
            FileInputStream input = new FileInputStream(file);
            Image imageFlecha = new Image(input, 36,24, true, true);

            getOutBtn.setGraphic(new ImageView(imageFlecha));
        } catch (Exception e){

        }
    }
}
