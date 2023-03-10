/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import tn.edu.esprit.entities.Categorie;
import tn.edu.esprit.services.ServiceCategorie;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class SupprimerCategorieController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    @FXML 
    private TextField nomCategorie;
    @FXML
        
    public void Supprimer() {
        String nom = nomCategorie.getText();
     if (nomCategorie.getText() != null && !nomCategorie.getText().isEmpty() ){
        String nomCategorieText = nomCategorie.getText();
       
        Categorie c = new Categorie(nomCategorieText);   
        ServiceCategorie a = new ServiceCategorie(); 
Alert alert = new Alert(AlertType.CONFIRMATION);
alert.setTitle("Confirmation de suppression");
alert.setHeaderText("Voulez-vous vraiment supprimer cette catégorie ?");
alert.setContentText("Nom de la catégorie : " + nomCategorie);

Optional<ButtonType> result = alert.showAndWait();
if (result.get() == ButtonType.OK) {
    // Code pour supprimer la catégorie
    a.supprimer(c);
    Alert success = new Alert(AlertType.INFORMATION);
    success.setTitle("Suppression réussie");
    success.setHeaderText(null);
    success.setContentText("La catégorie a été supprimée avec succès.");
    success.showAndWait();
} else {
    alert.close();
}

        
       
          }
    }
    
}
