package com.datastructures.efdress;

import javafx.application.Application;
// import javafx.fxml.FXMLLoader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//me
import javafx.scene.layout.StackPane;


import java.io.IOException;

public class Main extends Application {



    public String addItem(StackPane root){
return "None for now";
    }
    @Override

    public void start(Stage stage) throws IOException {
        // Scene new item (type)
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        Scene scene = new Scene(root,1280,720);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
/*

        grid2.add(new Label("What kind of item is it?"), 0, 0);
        grid2.add(addItemC2, 1, 0);
        grid2.add(prevSceneB, 1, 1);
        Group root2 = (Group)newItScene2.getRoot();
        root2.getChildren().add(grid2);


        // Scene new Item (Body part)

        final ComboBox addItemC1 = new ComboBox();
        addItemC1.getItems().addAll(
                "Upper Body (Tops, coats/jackets, etc.)",
                "Lower Body (Trousers, skirts, etc.)",
                "Upper & lower body (dress, jumpsuit, etc.)",
                "Footwear",
                "Headwear",
                "Accesory"
        );
        addItemC1.setOnAction((event) -> {
            addItemC2.getItems().clear();
            int selectedIndex1 = addItemC1.getSelectionModel().getSelectedIndex();
            Object selectedItem = addItemC1.getSelectionModel().getSelectedItem();
            System.out.println("Selection made: [" + selectedIndex1 + "] " + selectedItem);
            System.out.println("   ComboBox.getValue(): " + addItemC1.getValue());
            switch (selectedIndex1){
                case 0:
                    addItemC2.getItems().addAll(
                            "Coat",
                            "Jacket",
                            "Vest",
                            "Shirt",
                            "T-shirt",
                            "Other type of top"
                    );
                    break;

                case 1:
                    addItemC2.getItems().addAll(
                            "Trouser",
                            "Skirt",
                            "Short",
                            "Jeans",
                            "Other type of pants"
                    );
                    break;


                case 2:
                    addItemC2.getItems().addAll(
                            "Dress",
                            "Overall",
                            "Swimsuit",
                            "Jumpsuit"
                    );
                    break;

                case 3:
                    addItemC2.getItems().addAll(
                            "Boots",
                            "Sneakers",
                            "Sandals",
                            "Other dress Shoes"
                    );
                    break;
                case 4:
                    addItemC2.getItems().addAll(
                            "Caps",
                            "Beanies",
                            "Other hats"
                    );
                    break;
            }




            stage.setScene(newItScene2);
        });

        Scene newItScene1= new Scene(new Group(), 500, 400);

        EventHandler<ActionEvent> gobackEvent = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                addItemC2.getItems().clear();
                stage.setScene(newItScene2);

            }
        };

        // when button is pressed
      *//*  prevSceneB.setOnAction(gobackEvent);
        prevSceneB.setOnAction(e -> stage.setScene(newItScene1));
        GridPane grid1 = new GridPane();
        grid1.setVgap(4);
        grid1.setHgap(10);
        grid1.setPadding(new Insets(5, 5, 5, 5));
        grid1.add(new Label("What kind of item is it?"), 0, 0);
        grid1.add(addItemC1, 1, 0);
        Group root1 = (Group)newItScene1.getRoot();
        root1.getChildren().add(grid1);

        //Main Scene
        //Label label2= new Label("This is the second scene");
        Button addItemb= new Button("Add Item");
        addItemb.setOnAction(e -> stage.setScene(newItScene1));
        VBox layout2= new VBox(20);
        layout2.getChildren().addAll(addItemb);
        Scene mainScene= new Scene(layout2,500,400);
*/

    }

    public static void main(String[] args) {
        launch(args);
    }
}
