package sample;

/*
 * @Author: Ihor Shevchenko
 * @Date: 22.08.2018
 * @Version: 1.0.0
 * */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        //Call the launch() method for JavaFX Application
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Include fxml file
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        //Set the title of our window
        primaryStage.setTitle("Calculator");
        //Create our window and using scene
        primaryStage.setScene(new Scene(root, 350, 350));
        //Set visible of our window
        primaryStage.show();
        //Off resizeble
        primaryStage.setResizable(false);
    }
}
