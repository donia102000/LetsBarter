/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import tn.edu.esprit.entities.Organisateur;
import tn.edu.esprit.entities.Utilisateur;
import tn.edu.esprit.services.OrganisateurService;
/**
 * FXML Controller class
 *
 * @author Donia
 */
public class ModifierOrganisateurFXMLController implements Initializable {

    @FXML
    private Button btnmodifier;

    @FXML
    private TextField tfnom;

    @FXML
    private TextField tfprenom;

    @FXML
    private TextField tfCin;

    @FXML
    private TextField tfadresse;

    @FXML
    private TextField tfemail;

    @FXML
    private TextField tfmdp;

    @FXML
    private TextField tftel;

    @FXML
    private ComboBox<String> tfgenre;
    ObservableList<String> liste=FXCollections.observableArrayList("Homme","Femme","Autre");

    @FXML
    private DatePicker tfnaissance;

    @FXML
    private Label lbl;

    @FXML
    private TextField tfCinRechercher;

    @FXML
    private Button btnsupp;

    @FXML
    private Button btnrechercher;
    
    OrganisateurService service =new OrganisateurService();
    Utilisateur org = new Utilisateur();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tfgenre.setItems(liste);
    }    
    @FXML
    public void rechercherParCin(){
    org =service.chercherUtilisateurParCin(Integer.parseInt(tfCinRechercher.getText()));
    tfnom.setText(org.getNomUtilisateur());
    tfprenom.setText(org.getPrenomUtilisateur());
    tfCin.setText(String.valueOf( org.getCin()));
    tfadresse.setText(org.getAdresse());
    tfemail.setText(org.getEmail());
    tfmdp.setText(org.getMotDePasse());
    tftel.setText(String.valueOf(org.getNumTelephone()));
    tfnaissance.setPromptText(org.getDateDeNaissance());
    tfgenre.setPromptText(org.getGenre());
   }
    @FXML
    public void mofifier(){
        org.setNomUtilisateur(tfnom.getText());
        org.setPrenomUtilisateur(tfprenom.getText());
        org.setCin(Integer.parseInt(tfCin.getText()));
        org.setAdresse(tfadresse.getText());
        org.setEmail(tfemail.getText());
        org.setMotDePasse(tfmdp.getText());
        org.setNumTelephone(Integer.parseInt(tftel.getText()));
        org.setGenre(tfgenre.getValue().toString());
        org.setDateDeNaissance(tfnaissance.getValue().toString());
    service.modifierUtilisateur(org);
    
    }
    @FXML
    public void supprimer(){
        
    service.supprimerUtilisateur(Integer.parseInt(tfCinRechercher.getText()));
    clearFields();
    
    }
    public void clearFields(){
     tfnom.clear();
        tfprenom.clear();
        tfadresse.clear();
        tfemail.clear();
        tftel.clear();
        tfmdp.clear();
        tfnaissance.setValue(null);
        tfCin.clear();
        tfCinRechercher.clear();
        
    }
}
