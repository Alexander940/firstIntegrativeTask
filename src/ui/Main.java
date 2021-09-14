package ui;

import javafx.application.Application;
import javafx.stage.Stage;
import model.Restaurant;

public class Main extends Application {

    public static Restaurant restaurant = new Restaurant();
    Login login;

    public static void main(String [] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        login = new Login();
        login.show();
    }
}
