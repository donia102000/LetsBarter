/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pidev.gui;

import edu.pidev.entities.Categorie;
import edu.pidev.entities.SousCategorie;
import edu.pidev.serices.ServiceCategorie;
import edu.pidev.serices.ServiceSousCategorie;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class AjouterSousCatController implements Initializable {

    @FXML
    private Button btnajouter; 
    @FXML
    private TextField nomSousCat;
    @FXML
    private Button btnajouter1;
    @FXML
    private TextField libelle;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) { }
        // TODO
        
    @FXML
    private void ajoutersc(ActionEvent event) { 
        
         
        String nomSousCatText = nomSousCat.getText();
       
        SousCategorie sc = new SousCategorie(nomSousCatText);    
       ServiceSousCategorie serviceSousCategorie = new ServiceSousCategorie();  
        serviceSousCategorie.ajouter(sc);
        
        // create an alert for successful addition
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("la sous categorie est créer ave succes !");
        alert.showAndWait();
        
        
   
         

   

    
} 

    @FXML
    private void supprimersc(ActionEvent event) { 
        
       
//         
//          if (libelle.getText() != null && !libelle.getText().isEmpty() ){
//        String LibelleText =libelle.getText();
//      
//        
//        
//        
//        
//          ServiceSousCategorie sc = new ServiceSousCategorie();  
//        serviceSousCategorie.ajouter(sc); 
//        
//      // instanciation 
//       sc.supprimer(sc); 
//        } 
        
    }
} 
