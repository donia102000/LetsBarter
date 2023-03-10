package tn.edu.esprit.gui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import javafx.scene.Node;
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
import static tn.edu.esprit.gui.Ajouter1Controller.isValidMatricule;
import static tn.edu.esprit.gui.Ajouter1Controller.stringTest;
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
    
    private String getFormattedDateFromDatePicker(DatePicker datePicker) {
        //Get the selected date
        LocalDate selectedDate = datePicker.getValue();
        //Create DateTimeFormatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //Convert LocalDate to formatted String
     return selectedDate.format(formatter);
    }
    
    public static boolean stringTest (String Nom){


        for (int i = 0; i < Nom.length(); i++) {
            char ch = Nom.charAt(i);
         if (!(ch >= 'a' && ch <= 'z'|| ch >= 'A' && ch <= 'Z'))
         {
            return false;
         }
        }
        return  true;
     }
    
    public static boolean isValidMatricule(String matricule) {
    // Vérifier la longueur minimale du mot de passe
    if (matricule.length() != 8) {
        return false;
    }

    // Vérifier s'il y a au moins un chiffre dans le mot de passe
    boolean containsDigit = false;
    for (int i = 0; i < matricule.length(); i++) {
        if (Character.isDigit(matricule.charAt(i))) {
            containsDigit = true;
            break;
        }
    }
    if (!containsDigit) {
        return false;
    }

    // Vérifier s'il y a au moins une lettre majuscule dans le mot de passe
    boolean containsUpperCase = false;
    for (int i = 0; i < matricule.length(); i++) {
        if (Character.isUpperCase(matricule.charAt(i))) {
            containsUpperCase = true;
            break;
        }
    }
    if (!containsUpperCase) {
        return false;
    }

    // Vérifier s'il y a au moins une lettre minuscule dans le mot de passe
    boolean containsLowerCase = false;
    for (int i = 0; i < matricule.length(); i++) {
        if (Character.isLowerCase(matricule.charAt(i))) {
            containsLowerCase = true;
            break;
        }
    }
    if (!containsLowerCase) {
        return false;
    }

    // Si toutes les vérifications sont réussies, retourner true
    return true;
}
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
            if((matricule.getText().isEmpty()) || (libelle.getText().isEmpty()) || (lieu.getText().isEmpty()) || (date.getEditor().getText().isEmpty()) || (nbrPlaceMax.getText().isEmpty())){
                Alert a = new Alert(Alert.AlertType.ERROR, "Veillez remplir tous les champs!!", ButtonType.OK);
                a.showAndWait();
            }
            else if(!isValidMatricule(matricule.getText())){
                Alert a = new Alert(Alert.AlertType.ERROR, "Matricule invalide", ButtonType.OK);
                a.showAndWait();
                matricule.clear();
            }
        
            else if(!stringTest(libelle.getText())){
                Alert a = new Alert(Alert.AlertType.ERROR, "Libelle doit contenir que des lettres", ButtonType.OK);
                a.showAndWait();
                libelle.clear();
            }
            else if(!stringTest(lieu.getText())){
                Alert a = new Alert(Alert.AlertType.ERROR, "Lieu doit contenir que de lettres", ButtonType.OK);
                a.showAndWait();
                lieu.clear();
            }
            else if(!nbrPlaceMax.getText().matches("[0-9]+")){
                Alert a = new Alert(Alert.AlertType.ERROR, "Nombre de place max doit contenir que des chiffres ", ButtonType.OK);
                a.showAndWait();
                nbrPlaceMax.clear();
            } 
            
           
                else{
                ServiceEvenement.modifier(evenement);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Evènement modifiée avec succée");
                alert.setHeaderText(null);
                alert.setContentText("Evènement modifiée avec succée");
                alert.showAndWait();
                evenementObservableList.set(list_evenement.getSelectionModel().getSelectedIndex(), evenement);
                list_evenement.getSelectionModel().clearSelection();
                matricule.clear();
                libelle.clear();
                date.getEditor().clear();
                lieu.clear();
                nbrPlaceMax.clear();
                        }
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
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        Scene scene = new Scene(root);
                        primaryStage.setScene(scene);
                        primaryStage.show();
    }
    
    @FXML
    private void RetourReserv(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ReservationOrganisateur.fxml"));
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        Scene scene = new Scene(root);
                        primaryStage.setScene(scene);
                        primaryStage.show();
    }
    
    
}
