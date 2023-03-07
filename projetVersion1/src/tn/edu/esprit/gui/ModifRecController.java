/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import tn.edu.esprit.entities.Categorie;
import tn.edu.esprit.entities.SousCategorie;
import tn.edu.esprit.services.ServiceCategorie;
import tn.edu.esprit.services.ServiceSousCategorie;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class ModifRecController implements Initializable {

    @FXML
    private TextField idRec;
    @FXML
    private Button btntrouver;

    /** 
     * Initializes the controller class.
     */ 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void trouverParId(ActionEvent event) {  
        
        
        
         ServiceSousCategorie serviceSousCat  = new ServiceSousCategorie();
List<SousCategorie> Souscategories = serviceSousCat.trouverTous(); 
  

        // ajouter les données dans la table
        ObservableList<SousCategorie> categoriesObservableList = FXCollections.observableArrayList(Souscategories);
//      SouscategorieTable.setItems(categoriesObservableList);
////
////       
//       libelleColumn.setCellValueFactory(new PropertyValueFactory<>("nomCategorie")); //c attaché aux colonnes du tableau 
//        
    }

    }
    

