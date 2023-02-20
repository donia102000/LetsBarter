/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.test;

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
 * @author Donia
 */
public class NewFXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        FXMLLoader loader =new FXMLLoader(getClass().getResource("../gui/LoginFXML.fxml"));
        try {
            Parent root = loader.load();
            Scene scene =new Scene(root);//creation d'une scene 
            primaryStage.setScene(scene);
            primaryStage.setTitle("Gestion de personnes");
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
