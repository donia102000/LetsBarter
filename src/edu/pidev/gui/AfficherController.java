/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pidev.gui;

import edu.pidev.entities.Categorie;
import edu.pidev.serices.ServiceCategorie;
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
    private TableColumn<Categorie, String> descriptionColumn;
    @FXML
    private Button refreshButton;

    // la méthode qui récupère les données et les affiche dans la table
  public void afficherCategories() {
      ServiceCategorie serviceCategorie = new ServiceCategorie();
List<Categorie> categories = serviceCategorie.trouverTous();
  

        // ajouter les données dans la table
        ObservableList<Categorie> categoriesObservableList = FXCollections.observableArrayList(categories);
        categorieTable.setItems(categoriesObservableList);

        // lier les colonnes aux propriétés de l'objet Categorie
        nomCategorieColumn.setCellValueFactory(new PropertyValueFactory<>("nomCategorie"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
    }

    // la méthode qui récupère les données depuis la base de données
  


    // la méthode qui est appelée quand on clique sur le bouton "Actualiser"
    @FXML
    private void handleRefreshButtonAction(ActionEvent event) {
        afficherCategories();
    }

    
}
