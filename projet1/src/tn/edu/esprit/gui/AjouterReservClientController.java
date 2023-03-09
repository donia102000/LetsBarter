/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tn.edu.esprit.entities.Evenement;
import tn.edu.esprit.entities.Reservation;
import tn.edu.esprit.services.ServiceEvenement;
import tn.edu.esprit.services.ServiceReservation;


/**
 * FXML Controller class
 *
 * @author Ghazoua
 */
public class AjouterReservClientController implements Initializable {
    
    @FXML
    private Button btnReserver;
        
    @FXML
    private Button btnAnnuler;
    
    @FXML
    private Button btnAcceuil;

    @FXML
    private Button btnSupprimer;
    
    @FXML
    private TextField nbrPlace;

    @FXML
    private ListView<Evenement> list_evenement;
    
     @FXML
    ObservableList<Evenement> items = FXCollections.observableArrayList();
    @FXML
    ServiceEvenement se = new ServiceEvenement();
    ServiceReservation sr = new ServiceReservation();
    
 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<Evenement> evenementObservableList = FXCollections.observableArrayList(se.afficher());     
        list_evenement.setItems(evenementObservableList);
    }   
    
    @FXML
    public void AjouterReservation(ActionEvent event) throws IOException {
        
           Evenement evenementSelectionnee = list_evenement.getSelectionModel().getSelectedItem();
           if (evenementSelectionnee != null && !nbrPlace.getText().isEmpty()) {
            Reservation reservation = new Reservation();
            reservation.setNbrPace(Integer.parseInt(nbrPlace.getText()));
            reservation.setEvenement(evenementSelectionnee);
            int nbreplaceMax;
            nbreplaceMax= se.selectionneeNbrPlaceM(evenementSelectionnee.getId_evenement());
             
        
        
         int nbreplace;
       nbreplace=  sr.afficherParNbrPlace(evenementSelectionnee.getId_evenement()).stream().reduce(0, (a, b) -> a + b);
         System.out.println(nbreplace);
         int diff =nbreplace+Integer.parseInt(nbrPlace.getText());
         if(diff<=nbreplaceMax){
            sr.ajouter(reservation);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Réservation ajoutée avec succée");
            alert.setHeaderText(null);
            alert.setContentText("Réservation ajoutée avec succée");
            alert.showAndWait();}
         
        
           else{
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Nombre place complet");
            alert.setHeaderText(null);
            alert.setContentText("Nombre place complet");
            alert.showAndWait();
           }
           }
    }
    
  
     
    
}
