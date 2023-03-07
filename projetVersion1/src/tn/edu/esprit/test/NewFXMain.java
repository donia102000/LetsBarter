/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Donia
 */
public class NewFXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        FXMLLoader loader =new FXMLLoader(getClass().getResource("../gui/LoginFXML.fxml"));
        try {
            Parent root = loader.load();
            // Ajouter le logo

            Scene scene =new Scene(root);//creation d'une scene 
            primaryStage.setScene(scene);
            primaryStage.setTitle("Let's Barter");
            InputStream stream = new FileInputStream("C:\\Users\\Donia\\Documents\\NetBeansProjects\\projetVersion1\\src\\tn\\edu\\esprit\\Images\\Mon projet.png");
            Image img = new Image(stream);
            primaryStage.getIcons().add( img);
            primaryStage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
