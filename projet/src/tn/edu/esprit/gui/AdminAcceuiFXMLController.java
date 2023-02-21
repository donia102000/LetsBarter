/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import tn.edu.esprit.entities.Organisateur;
import tn.edu.esprit.entities.Utilisateur;
import tn.edu.esprit.services.OrganisateurService;



/**
 * FXML Controller class
 *
 * @author Donia
 */
public class AdminAcceuiFXMLController implements Initializable {
 @FXML
    private Label label;
    @FXML
    private ListView<Utilisateur> listView ;
    OrganisateurService ser = new OrganisateurService();
    Utilisateur currentFood;
    
   
    
     
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     listView.getItems().addAll(ser.afficherToutUtilisateur());
     listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Utilisateur>() {
         @Override
         public void changed(ObservableValue<? extends Utilisateur> observable, Utilisateur oldValue, Utilisateur newValue) {
         currentFood =listView.getSelectionModel().getSelectedItem();
         label.setText(currentFood.getNomUtilisateur()+ "\n"+currentFood.getAdresse());
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
    
}
