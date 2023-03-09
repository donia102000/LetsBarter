/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.test;

import tn.edu.esprit.entities.Annonce;
import tn.edu.esprit.entities.Avis;
import tn.edu.esprit.entities.Utilisateur;
import tn.edu.esprit.gui.ListeAnnonceControllerController;
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
     public static Annonce ann = new Annonce();
     public static Avis aa=new Avis();
     public static Utilisateur user = new Utilisateur();
    @Override
    public void start(Stage primaryStage) throws IOException {
 //Parent root = FXMLLoader.load(getClass().getResource("../gui/AjouterAnnonce.fxml"));
Parent root = FXMLLoader.load(getClass().getResource("../gui/ListeAnnonceController.fxml"));
//Parent root = FXMLLoader.load(getClass().getResource("../gui/ListeAnnonceController_1.fxml"));
 // Parent root = FXMLLoader.load(getClass().getResource("../gui/ModifierAnnonce.fxml"));
//Parent root = FXMLLoader.load(getClass().getResource("../gui/Reating.fxml"));
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Let's Barter");
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
