/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.pidev.tests;

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
 * @author Admin
 */
public class ClassFXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        
          // FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/MessageFXML.fxml"));
        //FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/AnnonceFXML.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/ClientFXML.fxml"));
          //FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/ListeProposition.fxml"));
       //FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/PropositionAchatFXML.fxml"));
        //FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/ListFavorisFXML.fxml"));
  //FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/MailFXML.fxml"));

        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Gestion des personnes");
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
