package tn.edu.esprit.gui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import tn.edu.esprit.entities.Evenement;
import tn.edu.esprit.services.ServiceEvenement;
import tn.edu.esprit.tests.projet1_FX;

/**
 * FXML Controller class
 *
 * @author Ghazoua
 */
public class AfficherController implements Initializable {
    @FXML
    private TableView<Evenement> tableau_evenement;
       @FXML
    private TableColumn<Evenement,String> libelle;

    @FXML
    private TableColumn<Evenement, String> date;

    @FXML
    private TableColumn<Evenement,String> lieu;

    @FXML
    private TableColumn<Evenement,String> nbrPlaceMax;

    @FXML
    private Button btnAjouter;

    @FXML
    private Button btnSupprimer;

    @FXML
    private Button btnModifier;
    
    @FXML
    private Button btnAfficher;
    
    private  ObservableList<Evenement> Evenements = FXCollections.observableArrayList();
    private ServiceEvenement ServiceEvenement;
    ServiceEvenement se=new ServiceEvenement();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        libelle.setCellValueFactory(new PropertyValueFactory<>("libelle"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        lieu.setCellValueFactory(new PropertyValueFactory<>("lieu"));
        nbrPlaceMax.setCellValueFactory(new PropertyValueFactory<>("nbrPlaceMax"));
        tableau_evenement.setItems(Evenements);
    }    
    
    @FXML
    void Afficher(ActionEvent event) {
        List evenements= se.afficher();
        ObservableList<Evenement> Evenements= FXCollections.observableArrayList(evenements);
        tableau_evenement.setItems(Evenements);

    }
    
    @FXML
    private void Supprimer(ActionEvent event) throws IOException {
        
        int  id = tableau_evenement.getSelectionModel().getSelectedItem().getId_evenement();
        se.supprimer(id);
        List evenements=  se.afficher();
        ObservableList<Evenement> Evenements= FXCollections.observableArrayList(evenements);
        libelle.setCellValueFactory(new PropertyValueFactory<>("libelle"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        lieu.setCellValueFactory(new PropertyValueFactory<>("lieu"));
        nbrPlaceMax.setCellValueFactory(new PropertyValueFactory<>("nbrPlaceMax"));
        tableau_evenement.setItems(Evenements);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Suppression avec succée");
        alert.setHeaderText(null);
        alert.setContentText("Suppression avec succée");
        alert.showAndWait();
    }
    @FXML
    private void goToAjoutPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Ajouter1.fxml"));
        Stage mainStage = new Stage();
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    }
    @FXML
    private void goToModifierPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Modifier.fxml"));
        Stage mainStage = new Stage();
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();

    }
    
    
}
