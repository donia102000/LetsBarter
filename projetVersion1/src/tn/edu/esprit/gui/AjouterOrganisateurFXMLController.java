/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tn.edu.esprit.entities.Client;
import tn.edu.esprit.entities.Organisateur;
import tn.edu.esprit.services.UtilisateurService;
import tn.edu.esprit.verification.VerifierChamps;




/**
 * FXML Controller class
 *
 * @author Donia
 */
public class AjouterOrganisateurFXMLController implements Initializable {

     @FXML
    private Button btnajouter;

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
    ObservableList<String> liste=FXCollections.observableArrayList("Homme","Femme");
   

    @FXML
    private DatePicker tfnaissance;

    @FXML
    private Label lbl;
    UtilisateurService ins = new UtilisateurService() ;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         tfgenre.setItems(liste);
    }    
   
    @FXML
    void ajouter(ActionEvent event) throws SQLException {
        if((tfnom.getText().isEmpty()) ||(tfprenom.getText().isEmpty()) || 
                (tfadresse.getText().isEmpty()) || (tfemail.getText().isEmpty()) ||
                (tfgenre.getPromptText().isEmpty())|| (tftel.getText().isEmpty())  ||
                (tfnaissance.getEditor().getText().isEmpty()) || (tfCin.getText().isEmpty())||(tfmdp.getText().isEmpty())){
        
            lbl.setText("Vous deviez remplir les champs");
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
        else if((event.getSource() == btnajouter) && 
                !(tfnom.getText().isEmpty()) &&!(tfprenom.getText().isEmpty()) && 
                !(tfadresse.getText().isEmpty()) && !(tfemail.getText().isEmpty()) && 
                 !(tftel.getText().isEmpty())  &&
                !(tfnaissance.getEditor().getText().isEmpty()) && !(tfCin.getText().isEmpty())&&!(tfmdp.getText().isEmpty())){
            
            Organisateur c = new Organisateur (tfnom.getText(),tfprenom.getText(), tfemail.getText(), tfmdp.getText(),tfgenre.getValue(), tfnaissance.getEditor().getText(),Integer.parseInt(tftel.getText()), tfadresse.getText(),"organisateur",Integer.parseInt(tfCin.getText()));
           
            if (ins.chercherUtilisateurParCinMail(Integer.parseInt(tfCin.getText()) ,tfemail.getText())){
                lbl.setText("Votre compte existe déja ! ");
            }
            else if(!ins.chercherUtilisateurParCinMail(Integer.parseInt(tfCin.getText()) ,tfemail.getText())){
            ins.ajouter(c);
            
            lbl.setText("Votre compte est ajouté avec succés");
            clearFields();
            
            }   
            
}
        
        
        
    }
    private void clearFields(){
       
        
        tfnom.clear();
        tfprenom.clear();
        tfadresse.clear();
        tfemail.clear();
        tftel.clear();
        tfmdp.clear();
        tfnaissance.setValue(null);
        tfCin.clear();
        
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
