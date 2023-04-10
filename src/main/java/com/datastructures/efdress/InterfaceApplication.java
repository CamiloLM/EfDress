package com.datastructures.efdress;

import javafx.application.Application;
// import javafx.fxml.FXMLLoader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

//me
import javafx.scene.layout.StackPane;


import java.io.IOException;

public class InterfaceApplication extends Application {



    public String addItem(StackPane root){
return "None for now";
    }
    @Override

    public void start(Stage stage) throws IOException {
        // Scene new item (type)
        Parent root = FXMLLoader.load(getClass().getResource("InterfaceApplication.fxml"));
        Scene scene = new Scene(root,1280,720);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        stage.setTitle("Hello!");
        stage.setScene(scene);



        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
