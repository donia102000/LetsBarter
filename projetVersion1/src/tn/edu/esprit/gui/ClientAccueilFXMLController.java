/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import static sun.security.jgss.GSSUtil.login;
import tn.edu.esprit.entities.Utilisateur;


/**
 * FXML Controller class
 *
 * @author Donia
 */
public class ClientAccueilFXMLController implements Initializable {
 
 
    /**
     * Initializes the controller class.
     */
    @FXML
    private Button lblAcceuil;


    @FXML
    private Button lbldeconnexion;

    @FXML
    private Button btnretour;
    @FXML
    private Button btnprofil;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
   public void deconnecter(ActionEvent event) throws IOException{
        
    Parent root = FXMLLoader.load(getClass().getResource("../gui/LoginFXML.fxml"));
                        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        Scene scene = new Scene(root);
                        primaryStage.setScene(scene);
                        primaryStage.show();
    
    }
   public void SwitchToProfil(ActionEvent event) throws IOException{
    Parent root = FXMLLoader.load(getClass().getResource("../gui/ClientProfilFXML.fxml"));
                        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        Scene scene = new Scene(root);
                        primaryStage.setScene(scene);
                        primaryStage.show();
     }
   
     public void SwitchToAcceuil (ActionEvent event) throws IOException{
    Parent root = FXMLLoader.load(getClass().getResource("../gui/ClientAccueilFXML.fxml"));
                        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        Scene scene = new Scene(root);
                        primaryStage.setScene(scene);
                        primaryStage.show();
     }
}
