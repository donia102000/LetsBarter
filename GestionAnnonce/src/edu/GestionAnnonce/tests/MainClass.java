/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.GestionAnnonce.tests;

import edu.GestionAnnonce.entities.Annonce;
import edu.GestionAnnonce.services.ServiceAnnonce;
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author NOURHENE
 */
public class MainClass  extends Application{
    
    @Override
    public void start(Stage primaryStage) throws IOException {
      Parent root = FXMLLoader.load(getClass().getResource("../gui/AjouterAnnonce.fxml"));
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
    
   //  public static void main(String[] args) {
      //   Annonce m1 = new Annonce("troc","vehicule","voiture","en bon etat",55,"fr","fghjk","ghjk",78);
        //    Annonce m2= new Annonce("echange","electro","vbn","bien",58,"fr","fghjvk","ghsjk",85);
           //     ServiceAnnonce sp = new ServiceAnnonce();
           //  sp.ajouter(new Annonce("echange","electro","vbn","bien",58,"fr","fghjvk","ghsjk",85));
        
          
       //   sp.ajouter(m2);
       //   sp.ajouter(m1);
       //  sp.supprimer(4);
    //   sp.modifier(m1);
     }
     
    

