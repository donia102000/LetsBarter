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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tn.edu.esprit.entities.Organisateur;
import tn.edu.esprit.entities.Utilisateur;
import tn.edu.esprit.services.OrganisateurService;
import tn.edu.esprit.verification.VerifierChamps;
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
    

    @FXML
    private Button btnmodif;

    @FXML
    private Button btnajouter1;

    @FXML
    private Button lblAcceuil;

    @FXML
    private Button lbldeconnexion;

    @FXML
    private Button btnretour;

    @FXML
    private Button btnmodif1;
    
    OrganisateurService service =new OrganisateurService();
    Utilisateur org = new Utilisateur();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tfgenre.setItems(liste);
    }    
    @FXML
    public void rechercherParCin(){
        if(tfCinRechercher.getText().isEmpty()){
            lbl.setText("vous devez entrer le cin");
        }
        else if(VerifierChamps.isTelephoneValide(tfCinRechercher.getText())==false){
        lbl.setText("Champs invalide !");
        }
        else
        {
    org =service.chercherUtilisateurParCin(Integer.parseInt(tfCinRechercher.getText()));
            System.out.println(org);
            if(org.getNomUtilisateur()==null){
                lbl.setText("Organisateur introuvable");
                clearFields();
            }
            else{
    lbl.setText("");
    tfnom.setText(org.getNomUtilisateur());
    tfprenom.setText(org.getPrenomUtilisateur());
    tfCin.setText(String.valueOf( org.getCin()));
    tfadresse.setText(org.getAdresse());
    tfemail.setText(org.getEmail());
    tfmdp.setText(org.getMotDePasse());
    tftel.setText(String.valueOf(org.getNumTelephone()));
    tfnaissance.setPromptText(org.getDateDeNaissance());
    tfgenre.setPromptText(org.getGenre());
                }}}
   
    @FXML
    public void mofifier(){
        if((tfnom.getText().isEmpty()) ||(tfprenom.getText().isEmpty()) || 
                (tfadresse.getText().isEmpty()) || (tfemail.getText().isEmpty()) ||
                (tfgenre.getPromptText().isEmpty())|| (tftel.getText().isEmpty())  ||
                (tfnaissance.getEditor().getText().isEmpty()) || (tfCin.getText().isEmpty())||(tfmdp.getText().isEmpty())){
        
            lbl.setText("Vous devez remplir les champs");
        }
        else if(!VerifierChamps.stringTest(tfnom.getText()) || 
             !VerifierChamps.stringTest(tfprenom.getText()) || 
              !VerifierChamps.isTelephoneValide(tftel.getText()) ||
             !VerifierChamps.stringTest(tfadresse.getText())||
             !VerifierChamps.isTelephoneValide(tfCin.getText())||
             !VerifierChamps.isEmailAdress(tfemail.getText()) ||
             !VerifierChamps.isValidPassword(tfmdp.getText())  
             )
     {
         
     lbl.setText("Champs invalides ! ");
     }
        else{
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
    lbl.setText("");
        }
    }
    @FXML
    public void supprimer(){
        if(tfCinRechercher.getText().isEmpty()){
        lbl.setText("vous devez entrer le cin de l'organisateur ");}
        else{
    service.supprimerUtilisateur(Integer.parseInt(tfCinRechercher.getText()));
    clearFields();
        lbl.setText("");
        }
    
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
    public void SwitchToListeOrg(ActionEvent event) throws IOException{
    Parent root = FXMLLoader.load(getClass().getResource("../gui/AdminAcceuiFXML.fxml"));
                        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        Scene scene = new Scene(root);
                        primaryStage.setScene(scene);
                        primaryStage.show();
    
    }
     public void switchToAjouterOrganisateur(ActionEvent event) throws IOException{
    Parent root = FXMLLoader.load(getClass().getResource("../gui/AjouterOrganisateurFXML.fxml"));
                        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        Scene scene = new Scene(root);
                        primaryStage.setScene(scene);
                        primaryStage.show();}
    
    public void switchToModifSuppOrganisateur(ActionEvent event) throws IOException{
    Parent root = FXMLLoader.load(getClass().getResource("../gui/ModifierOrganisateurFXML.fxml"));
                        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        Scene scene = new Scene(root);
                        primaryStage.setScene(scene);
                        primaryStage.show();}
    
    public void deconnecter(ActionEvent event) throws IOException{
    Parent root = FXMLLoader.load(getClass().getResource("../gui/LoginFXML.fxml"));
                        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        Scene scene = new Scene(root);
                        primaryStage.setScene(scene);
                        primaryStage.show();
    
    }
}
