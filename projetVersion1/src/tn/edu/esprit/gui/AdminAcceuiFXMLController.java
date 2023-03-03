/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import tn.edu.esprit.entities.Organisateur;
import tn.edu.esprit.entities.Utilisateur;
import tn.edu.esprit.services.UtilisateurService;




/**
 * FXML Controller class
 *
 * @author Donia
 */
public class AdminAcceuiFXMLController implements Initializable {
 @FXML
    private Label lblprenom;

    @FXML
    private Label lblnom;

    @FXML
    private Label lblcontact;
    @FXML
    private ListView<Utilisateur> listView ;
    UtilisateurService ser = new UtilisateurService();
    Utilisateur currentFood;
    
    @FXML
    private Label lbladresse;

    @FXML
    private Label lbltel;

    @FXML
    private Label lblgenre;

    @FXML
    private Label lblanniver;

    @FXML
    private Button btnmodif;

    @FXML
    private Button btnajouter;
    @FXML
    private Button btnretour;
    @FXML
    private Button lblAcceuil;

    @FXML
    private Button lbldeconnexion;
    
    @FXML
    private Button btnStatistiqueParDate;
    @FXML
    private Button btnprofil;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     try {
         listView.getItems().addAll(ser.getAll());
     } catch (SQLException ex) {
         Logger.getLogger(AdminAcceuiFXMLController.class.getName()).log(Level.SEVERE, null, ex);
     }
     listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Utilisateur>() {
         
         @Override
         public void changed(ObservableValue<? extends Utilisateur> observable, Utilisateur oldValue, Utilisateur newValue) {
         currentFood =listView.getSelectionModel().getSelectedItem();
         lblnom.setText(currentFood.getNomUtilisateur());
         lblprenom.setText(currentFood.getPrenomUtilisateur());
         lblcontact.setText(currentFood.getEmail());
         
         lblgenre.setText(currentFood.getGenre());
         lbladresse.setText(currentFood.getAdresse());
         lbltel.setText(String.valueOf(currentFood.getNumTelephone()));
         }
     });
    }    
    
    
         
     
     
    public void switchToAjouterOrganisateur(ActionEvent event) throws IOException{
    Parent root = FXMLLoader.load(getClass().getResource("../gui/AjouterOrganisateurFXML.fxml"));
                        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        Scene scene = new Scene(root);
                        primaryStage.setScene(scene);
                        primaryStage.show();}
    
    public void switchToModifSuppOrganisateur(ActionEvent event) throws IOException{
    Parent root = FXMLLoader.load(getClass().getResource("../gui/ModifierOrganisateurFXML.fxml"));
                        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        Scene scene = new Scene(root);
                        primaryStage.setScene(scene);
                        primaryStage.show();}
    
    public void deconnecter(ActionEvent event) throws IOException{
    Parent root = FXMLLoader.load(getClass().getResource("../gui/LoginFXML.fxml"));
                        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        Scene scene = new Scene(root);
                        primaryStage.setScene(scene);
                        primaryStage.show();
    
    }
     public void SwitchToListeOrg(ActionEvent event) throws IOException{
    Parent root = FXMLLoader.load(getClass().getResource("../gui/AdminAcceuiFXML.fxml"));
                        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        Scene scene = new Scene(root);
                        primaryStage.setScene(scene);
                        primaryStage.show();
    
    }
     public void SwitchToStatisqueParDate(ActionEvent event) throws IOException{
    Parent root = FXMLLoader.load(getClass().getResource("../gui/StatistiqueParDate.fxml"));
                        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        Scene scene = new Scene(root);
                        primaryStage.setScene(scene);
                        primaryStage.show();
    
                        
}
     public void SwitchToProfil(ActionEvent event) throws IOException{
    Parent root = FXMLLoader.load(getClass().getResource("../gui/ProfilFXML.fxml"));
                        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        Scene scene = new Scene(root);
                        primaryStage.setScene(scene);
                        primaryStage.show();
     }

}