/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;



import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
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
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import tn.edu.esprit.entities.Evenement;
import tn.edu.esprit.services.ServiceEvenement;
import tn.edu.esprit.util.Utility;

/**
 * FXML Controller class
 *
 * @author Ghazoua
 */
public class Ajouter1Controller implements Initializable {

    /**
     * Initializes the controller class.
  
     */
    
    @FXML
    private TextField matricule;
    
    @FXML
    private TextField libelle;

    @FXML
    private TextField lieu;

    @FXML
    private TextField nbrPlaceMax;

    @FXML
    private Button btnAjouter;
    
    @FXML
    private Button btnAcceuil;

    @FXML
    private Button btnRetourEvenement;

    @FXML
    private Button btnRetourReservation;

    @FXML
    private DatePicker date;

    @FXML
    private ImageView img;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

         
    }  
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
     @FXML
    public void AjouterEvenement(ActionEvent event) throws IOException {
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
           ServiceEvenement se = new ServiceEvenement();
           Evenement e = new Evenement (matricule.getText(),libelle.getText(),getFormattedDateFromDatePicker(date),lieu.getText(),nbrPlaceMax.getText(),Utility.utilisateur.getIdUtilisateur());
           se.ajouter(e);
           //se.SendSms();
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
           alert.setTitle("Evenement ajoutée avec succée");
           alert.setHeaderText(null);
           alert.setContentText("Evenement ajoutée avec succée");
           alert.showAndWait();
       }
         System.out.println(getFormattedDateFromDatePicker(date));
    }

    
    @FXML
    private void RetourEv(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Afficher.fxml"));
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

