/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import tn.edu.esprit.entities.Categorie;
import tn.edu.esprit.services.ServiceCategorie;
 import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class AfficherController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
      @FXML
    private TableView<Categorie> categorieTable;
    @FXML
    private TableColumn<Categorie, String> nomCategorieColumn;
   
    @FXML
    private Button refreshButton; //actualiser

   
  public void afficherCategories() {
      ServiceCategorie serviceCategorie = new ServiceCategorie();
List<Categorie> categories = serviceCategorie.trouverTous();
  

        // ajouter les données dans la table
        ObservableList<Categorie> categoriesObservableList = FXCollections.observableArrayList(categories);
        categorieTable.setItems(categoriesObservableList);

       
        nomCategorieColumn.setCellValueFactory(new PropertyValueFactory<>("nomCategorie")); //c attaché aux colonnes du tableau 
   
    }

    // njibou ml base 
  


    
    @FXML
    private void handleRefreshButtonAction(ActionEvent event) { //cette methode ki sera appelé lors de la clic sur la button act
        afficherCategories();
    }

    
}
