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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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
public class ModifierController implements Initializable {
    @FXML
    private ImageView img;

    @FXML
    private TextField libelle;

    @FXML
    private DatePicker date;

    @FXML
    private TextField lieu;

    @FXML
    private TextField nbrPlaceMax;
    
    @FXML
    private TextField chercher;

    @FXML
    private Button btnModifier;

    @FXML
    private Button btnRetour;
    
    ServiceEvenement se = new ServiceEvenement();
    Evenement evenement = new Evenement();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    @FXML
    private void modifier(ActionEvent event) throws IOException{
        evenement.setLibelle(libelle.getText());
        evenement.setDate(date.getValue().toString());
        evenement.setLieu(lieu.getText());
        evenement.setNbrPlaceMax(Integer.parseInt(nbrPlaceMax.getText()));
        se.modifier(evenement);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Modification avec succée");
        alert.setHeaderText(null);
        alert.setContentText("Modification avec succée");
        alert.showAndWait();
    
    }    
    @FXML
    private void RechercherParId(ActionEvent event) throws IOException{
          
          evenement =se.rechercher(Integer.parseInt(chercher.getText()));
          libelle.setText(evenement.getLibelle());
          date.setPromptText(evenement.getLibelle());
          lieu.setText(evenement.getLieu());
          nbrPlaceMax.setText(String.valueOf(evenement.getNbrPlaceMax()));
   }
    
    @FXML
    private void Retour(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Afficher.fxml"));
        Stage mainStage = new Stage();
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    }

    
    }
