package com.datastructures.efdress;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
public class SceneController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToCollection(ActionEvent exa) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Collection.fxml"));
        stage = (Stage)((Node)exa.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToNewArticle(ActionEvent exa) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("NewArticle.fxml"));
        stage = (Stage)((Node)exa.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToName(ActionEvent exa) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Name.fxml"));
        stage = (Stage)((Node)exa.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToMaterial(ActionEvent exa) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Material.fxml"));
        stage = (Stage)((Node)exa.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToOcasion(ActionEvent exa) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Ocasion.fxml"));
        stage = (Stage)((Node)exa.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToArticleType(ActionEvent exa) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ArticleType.fxml"));
        stage = (Stage)((Node)exa.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToAbrigo(ActionEvent exa) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Abrigo.fxml"));
        stage = (Stage)((Node)exa.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToCalzado(ActionEvent exa) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Calzado.fxml"));
        stage = (Stage)((Node)exa.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToEntero(ActionEvent exa) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Entero.fxml"));
        stage = (Stage)((Node)exa.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToPantalon(ActionEvent exa) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Pantalon.fxml"));
        stage = (Stage)((Node)exa.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToSombrero(ActionEvent exa) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Sombrero.fxml"));
        stage = (Stage)((Node)exa.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToTopHombre(ActionEvent exa) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("TopHombre.fxml"));
        stage = (Stage)((Node)exa.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToTopMujer(ActionEvent exa) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("TopMujer.fxml"));
        stage = (Stage)((Node)exa.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToDetalles(ActionEvent exa) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Detalles.fxml"));
        stage = (Stage)((Node)exa.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



}
