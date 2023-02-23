/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.GestionAnnonce.tests;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
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
public class MainGui extends Application{

    @Override
    public void start(Stage primaryStage) throws IOException {
    //To change body of generated methods, choose Tools | Templates.
       // FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/AfficheAnnonceFXML.fxml"));
      FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/AjouterAnnonce.fxml"));
      //"../views/AjoutPersonne.fxml"
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Annonce");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
       /**
      * @param args the command line arguments
      *   */
     public static void main(String[] args) {
        launch(args);
    }
    
}
