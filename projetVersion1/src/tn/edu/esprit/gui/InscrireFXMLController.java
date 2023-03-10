/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tn.edu.esprit.entities.Client;
import tn.edu.esprit.services.UtilisateurService;

import tn.edu.esprit.verification.VerifierChamps;

/**
 * FXML Controller class
 *
 * @author Donia
 */
public class InscrireFXMLController implements Initializable {




    @FXML
    private Button btnInscrire;

    @FXML
    private TextField tfnom;

    @FXML
    private TextField tfprenom;

    @FXML
    private TextField tfadresse;

    @FXML
    private TextField tfemail;

    @FXML
    private TextField tfmdp;

    @FXML
    private TextField tftel;
    
     @FXML
    private TextField tfCin;
    @FXML
    private PasswordField tfverifmdp;
    @FXML
    private ComboBox<String> tfgenre;
    ObservableList<String> liste=FXCollections.observableArrayList("Homme","Femme");

    

    @FXML
    private Label lbl;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tfgenre.setItems(liste);
    }    
    
    UtilisateurService ins = new UtilisateurService() ;
   
    @FXML
    private void Inscription (ActionEvent event) throws IOException, SQLException {
        
        if((tfnom.getText().isEmpty()) ||(tfprenom.getText().isEmpty()) || 
                (tfadresse.getText().isEmpty()) || (tfemail.getText().isEmpty()) ||
                (tfgenre.getPromptText().isEmpty())|| (tftel.getText().isEmpty())  ||
                 (tfCin.getText().isEmpty())||(tfmdp.getText().isEmpty())||(tfverifmdp.getText().isEmpty()) ){
        
            lbl.setText("Vous deviez remplir les champs");
        }
        
        else if(!VerifierChamps.stringTest(tfnom.getText()) || 
             !VerifierChamps.stringTest(tfprenom.getText()) || 
              !VerifierChamps.isTelephoneValide(tftel.getText()) ||
             !VerifierChamps.stringTest(tfadresse.getText())||
             !VerifierChamps.isTelephoneValide(tfCin.getText())||
             !VerifierChamps.isEmailAdress(tfemail.getText()) ||
             !VerifierChamps.isValidPassword(tfmdp.getText()) ||
             !VerifierChamps.isValidPassword(tfverifmdp.getText())||
             !tfverifmdp.getText().equals(tfmdp.getText())
             )
     {
         
     lbl.setText("Champs invalides ! ");
     }
      else  if((event.getSource() == btnInscrire) && 
                !(tfnom.getText().isEmpty()) &&!(tfprenom.getText().isEmpty()) && 
                !(tfadresse.getText().isEmpty()) && !(tfemail.getText().isEmpty()) && 
                !(tfgenre.getPromptText().isEmpty())&& !(tftel.getText().isEmpty())  &&
                !(tfCin.getText().isEmpty())&&!(tfmdp.getText().isEmpty())&& tfverifmdp.getText().equals(tfmdp.getText())){
            
            Client c = new Client (tfnom.getText(),tfprenom.getText(), tfemail.getText(), tfmdp.getText(), tfgenre.getValue(),Integer.parseInt(tftel.getText()), tfadresse.getText(),"client",Integer.parseInt(tfCin.getText()),0);
           
            if (ins.chercherUtilisateurParCinMail(Integer.parseInt(tfCin.getText()) ,tfemail.getText())){
                lbl.setText("Votre compte existe d??ja ! ");
            }
            else if(!ins.chercherUtilisateurParCinMail(Integer.parseInt(tfCin.getText()) ,tfemail.getText()))
            {ins.inscrire(c);
            
            lbl.setText("Votre compte est ajout?? avec succ??s");
            clearFields();
            Parent root = FXMLLoader.load(getClass().getResource("../gui/LoginFXML.fxml"));
                        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        Scene scene = new Scene(root);
                        primaryStage.setScene(scene);
                        primaryStage.show();
           
           }
}
        else {
        lbl.setText("champs invalides ! ");
        }
        
        
    }
    private void clearFields(){
       
        
        tfnom.clear();
        tfprenom.clear();
        tfadresse.clear();
        tfemail.clear();
        tftel.clear();
        tfgenre.setValue(null);
        tfmdp.clear();
        tfverifmdp.clear();
        tfCin.clear();
        
    }
}