package tn.edu.esprit.gui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tn.edu.esprit.entities.Evenement;
import tn.edu.esprit.services.ServiceEvenement;

/**
 * FXML Controller class
 *
 * @author Ghazoua
 */
public class AfficherController implements Initializable {
    
    @FXML
    private Button btnAjouter;

    @FXML
    private Button btnSupprimer;

    @FXML
    private Button btnModifier;
    
    @FXML
    private Button btnRechercher;
    
    @FXML
    private Button btnAcceuil;

    @FXML
    private Button btnTrie;

    @FXML
    private Button btnRetourReservation;
    
    @FXML
    private TextField matricule;

    @FXML
    private TextField libelle;

    @FXML
    private TextField lieu;

    @FXML
    private TextField nbrPlaceMax;

    @FXML
    private DatePicker date;
    
    @FXML
    private TextField chercher;

    @FXML
    private ListView<Evenement> list_evenement;
    
    @FXML
    private final ServiceEvenement ServiceEvenement = new ServiceEvenement();
    
    private ObservableList<Evenement> evenementObservableList = FXCollections.observableArrayList();
    
    
    @FXML
    ServiceEvenement se = new ServiceEvenement();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<Evenement> evenementObservableList = FXCollections.observableArrayList(se.afficher());     
        list_evenement.setItems(evenementObservableList);
        
        
        
        list_evenement.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                matricule.setText(newValue.getMatricule());
                libelle.setText(newValue.getLibelle());
                date.setPromptText(newValue.getDate());
                lieu.setText(newValue.getLieu());
                nbrPlaceMax.setText(newValue.getNbrPlaceMax());
                
}
});
        
        btnModifier.setOnAction(event -> {
        Evenement evenement = list_evenement.getSelectionModel().getSelectedItem();
        if(evenement != null){
            
            evenement.setMatricule((matricule.getText()));
            evenement.setLibelle((libelle.getText()));
            evenement.setDate(date.getValue().toString());
            evenement.setLieu((lieu.getText()));
            evenement.setNbrPlaceMax((nbrPlaceMax.getText()));
            ServiceEvenement.modifier(evenement);
            evenementObservableList.set(list_evenement.getSelectionModel().getSelectedIndex(), evenement);
            list_evenement.getSelectionModel().clearSelection();
            matricule.clear();
            libelle.clear();
            date.getEditor().clear();
            lieu.clear();
            nbrPlaceMax.clear();
        }
       });
        
         btnTrie.setOnAction(new EventHandler<ActionEvent>() {
        
         
            @Override
            public void handle(ActionEvent event) {
           
            list_evenement.getItems().sort(Comparator.comparing(Evenement::getLibelle));
            list_evenement.getSelectionModel().clearSelection();
          }});

        
        
       }
    
    
     @FXML
    private void RechercherEvenement (ActionEvent event){
        String title = chercher.getText();
        List<Evenement> result = ServiceEvenement.findEvenementByLibelle(title);
        list_evenement.getItems().setAll(result);
        chercher.clear();
    }
    
//    @FXML
//    private void Rechercher(ActionEvent event) throws IOException{
//        if (chercher.getText().isEmpty()) {
//            Alert a = new Alert(Alert.AlertType.ERROR, "Veillez donner l'id de l'évènement!!", ButtonType.OK);
//           a.showAndWait();
//        }
//        else {
//             Evenement env=se.rechercher(Integer.parseInt(chercher.getText()));
//             if(env == null){
//                Alert a = new Alert(Alert.AlertType.ERROR, "Aucun évènement trouvé!!", ButtonType.OK);
//                a.showAndWait();
//             }
//             else {
//                 matricule.setText(String.valueOf(env.getMatricule()));
//                 libelle.setText(env.getLibelle());
//                 date.setPromptText(env.getDate());
//                 lieu.setText(env.getLieu());
//                 nbrPlaceMax.setText(String.valueOf(env.getNbrPlaceMax()));
//             }
//                
//             }
//    }
    
    @FXML
    private void Supprimer(ActionEvent event) throws IOException {
        
        Evenement evenement = list_evenement.getSelectionModel().getSelectedItem();
        if (evenement != null) {
             //   System.out.println(produit.getId());
             se.supprimer(evenement.getId_evenement());
             list_evenement.getItems().remove(evenement);
        } 
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Suppression avec succée");
        alert.setHeaderText(null);
        alert.setContentText("Suppression avec succée");
        alert.showAndWait();
       
       }
    
//    @FXML
//    private void Modifier1(ActionEvent event) throws IOException {
//        
//        Evenement evenement = list_evenement.getSelectionModel().getSelectedItem();
//        if(evenement != null){
//            
//            evenement.setMatricule(Integer.parseInt(matricule.getText()));
//            evenement.setLibelle(libelle.getText());
//            evenement.setDate(date.getValue().toString());
//            evenement.setLieu(lieu.getText());
//            evenement.setNbrPlaceMax(Integer.parseInt(nbrPlaceMax.getText()));
//            matricule.setText(String.valueOf(evenement.getNbrPlaceMax()));
//            libelle.setText(evenement.getLibelle());
//            date.setPromptText(evenement.getDate());
//            lieu.setText(evenement.getLieu());
//            nbrPlaceMax.setText(String.valueOf(evenement.getNbrPlaceMax()));
//            se.modifier(evenement);
//            evenementObservableList.set(list_evenement.getSelectionModel().getSelectedIndex(), evenement);
//            list_evenement.getSelectionModel().clearSelection();
//            
//        }
//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle("Modification avec succée");
//        alert.setHeaderText(null);
//        alert.setContentText("Modification avec succée");
//        alert.showAndWait();
//       
//       }
    
    @FXML
    private void goToAjoutPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Ajouter1.fxml"));
        Stage mainStage = new Stage();
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    }
    
    @FXML
    private void RetourReserv(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ReservationOrganisateur.fxml"));
        Stage mainStage = new Stage();
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    }
    
    
}
