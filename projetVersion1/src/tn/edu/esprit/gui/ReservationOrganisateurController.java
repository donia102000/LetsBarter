/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.io.IOException;
import java.net.URL;
import java.util.Comparator;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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
public class ReservationOrganisateurController implements Initializable {
    
    @FXML
    private TextField chercher;

    @FXML
    private Button btnAfficher;
    
    @FXML
    private Button btnAcceuil;

    @FXML
    private Button btnRetourEvenement;

    @FXML
    private Button btnTrie;
    
    @FXML
    private ListView<Reservation> list_reservation;
    
    @FXML
    private ListView<Evenement> list_evenement;
    
    @FXML
    private final ServiceReservation ServiceReservation = new ServiceReservation();
    
    @FXML
    private final ServiceEvenement ServiceEvenement = new ServiceEvenement();
    
    private ObservableList<Reservation> reservationObservableList = FXCollections.observableArrayList();
    
    private ObservableList<Evenement> evenementObservableList = FXCollections.observableArrayList();
    
    @FXML
    ServiceReservation sr = new ServiceReservation();

    @FXML
    ServiceEvenement se = new ServiceEvenement();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<Reservation> reservationObservableList = FXCollections.observableArrayList(sr.afficher());     
        list_reservation.setItems(reservationObservableList);
        ObservableList<Evenement> evenementObservableList = FXCollections.observableArrayList(se.afficher());     
        list_evenement.setItems(evenementObservableList);
        
        
        btnTrie.setOnAction(new EventHandler<ActionEvent>() {
        
         
            @Override
            public void handle(ActionEvent event) {
           
            list_reservation.getItems().sort(Comparator.comparing(Reservation::getNbrPace));
            list_reservation.getSelectionModel().clearSelection();
          }});
            
    }    
    
    @FXML
    public void AffichageReservationParEvent(ActionEvent event) throws IOException {
        
           Evenement evenementSelectionnee = list_evenement.getSelectionModel().getSelectedItem();
           if (evenementSelectionnee != null) {
            ObservableList<Reservation> reservationObservableList = FXCollections.observableArrayList(sr.afficherParEvenement(evenementSelectionnee.getId_evenement()));     
            list_reservation.setItems(reservationObservableList);
           }
    }
    
    
    @FXML
    private void RetourEv(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Afficher.fxml"));
        
                        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        Scene scene = new Scene(root);
                        primaryStage.setScene(scene);
                        primaryStage.show();
       
    }
    
    
    
}
