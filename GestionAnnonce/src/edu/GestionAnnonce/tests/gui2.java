/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.GestionAnnonce.tests;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author NOURHENE
 */
public class gui2 extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
    //  Parent root = FXMLLoader.load(getClass().getResource("../gui/AjouterAnnonce.fxml"));
   Parent root = FXMLLoader.load(getClass().getResource("../gui/ListeAnnonce.fxml"));
 // Parent root = FXMLLoader.load(getClass().getResource("../gui/ModifierAnnonce.fxml"));
 // Parent root = FXMLLoader.load(getClass().getResource("../gui/AjouterCommentaire.fxml"));
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
