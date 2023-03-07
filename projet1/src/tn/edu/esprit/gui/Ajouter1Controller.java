/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;



import java.io.IOException;
import java.net.URL;
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
     @FXML
    public void AjouterEvenement(ActionEvent event) throws IOException {
        if((matricule.getText().isEmpty()) || (libelle.getText().isEmpty()) || (lieu.getText().isEmpty()) || (date.getEditor().getText().isEmpty()) || (nbrPlaceMax.getText().isEmpty())){
           Alert a = new Alert(Alert.AlertType.ERROR, "Veillez remplir tous les champs!!", ButtonType.OK);
           a.showAndWait();
        }
        else if(!matricule.getText().matches("^[a-zA-Z]{2,3}[a-zA-Z]$") && matricule.getText().length() > 8){
            Alert a = new Alert(Alert.AlertType.ERROR, "Matricule doit étre de 8 chiffres et lettres", ButtonType.OK);
            a.showAndWait();
            matricule.clear();
        }
        else if(!libelle.getText().matches("^[a-zA-Z0-9]$") && libelle.getText().length() > 10){
            Alert a = new Alert(Alert.AlertType.ERROR, "Libelle doit étre de 10 chiffres et lettres", ButtonType.OK);
            a.showAndWait();
            libelle.clear();
        }
        else if(!lieu.getText().matches("^[a-zA-Z]$")){
            Alert a = new Alert(Alert.AlertType.ERROR, "Lieu doit contenir que de lettres", ButtonType.OK);
            a.showAndWait();
            lieu.clear();
        }
        else if(!nbrPlaceMax.getText().matches("^[0-9]$")){
            Alert a = new Alert(Alert.AlertType.ERROR, "Nombre de place max doit contenir que des chiffres ", ButtonType.OK);
            a.showAndWait();
            nbrPlaceMax.clear();
        }
//       if((){
//           Alert a = new Alert(Alert.AlertType.ERROR, "Matricule doit contenir que des chiffres!!", ButtonType.OK);
//           a.showAndWait();  
//       }
//       if(matricule.getText().length() !=8){
//           Alert a = new Alert(Alert.AlertType.ERROR, "Matricule doit étre de 8 chiffres!!", ButtonType.OK);
//           a.showAndWait();  
//       }
        else{
           ServiceEvenement se = new ServiceEvenement();
           Evenement e = new Evenement (matricule.getText(),libelle.getText(),date.getEditor().getText(),lieu.getText(),nbrPlaceMax.getText());
           se.ajouter(e);
           //se.SendSms();
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
           alert.setTitle("Evenement ajoutée avec succée");
           alert.setHeaderText(null);
           alert.setContentText("Evenement ajoutée avec succée");
           alert.showAndWait();
       }

    }

    
    @FXML
    private void RetourEv(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Afficher.fxml"));
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

