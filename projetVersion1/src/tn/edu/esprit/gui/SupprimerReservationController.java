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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import tn.edu.esprit.entities.Evenement;
import tn.edu.esprit.entities.Reservation;
import tn.edu.esprit.services.ServiceEvenement;
import tn.edu.esprit.services.ServiceReservation;
import tn.edu.esprit.util.Utility;

/**
 * FXML Controller class
 *
 * @author Ghazoua
 */
public class SupprimerReservationController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button btnAcceuil;

    @FXML
    private ListView<Reservation> list_reservation;
    
    @FXML
    private final ServiceReservation ServiceReservation = new ServiceReservation();
    
    private ObservableList<Reservation> reservationObservableList = FXCollections.observableArrayList();
    
    @FXML
    ServiceReservation sr = new ServiceReservation();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<Reservation> reservationObservableList = FXCollections.observableArrayList(sr.afficherParClient(Utility.utilisateur.getIdUtilisateur()));     
        list_reservation.setItems(reservationObservableList);
    }    
    
    @FXML
    private void Supprimer(ActionEvent event) throws IOException {
        
        Reservation reservation = list_reservation.getSelectionModel().getSelectedItem();
        if (reservation != null) {
             //   System.out.println(produit.getId());
             sr.supprimer(reservation.getId_reservation());
             list_reservation.getItems().remove(reservation);
        } 
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Suppression avec succée");
        alert.setHeaderText(null);
        alert.setContentText("Suppression avec succée");
        alert.showAndWait();
       
       }
    
}
