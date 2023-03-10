/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import tn.edu.esprit.entities.Client;
import tn.edu.esprit.entities.Utilisateur;
import tn.edu.esprit.services.UtilisateurService;
import tn.edu.esprit.verification.VerifierChamps;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
/**
 * FXML Controller class
 *
 * @author Donia
 */
public class MotDepasseOublieFXMLController implements Initializable {

    @FXML
    private PasswordField motDePasse;

    @FXML
    private Button enregistrerBtn;

    @FXML
    private Label loginMessage;

    @FXML
    private TextField email;

    @FXML
    private TextField cin;

    @FXML
    private PasswordField verifMdp;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     UtilisateurService ins = new UtilisateurService() ;
     Utilisateur user = new Utilisateur();
    @FXML
    private void enregistrerNewMdp (ActionEvent event) throws IOException, SQLException {
        
        if((cin.getText().isEmpty()) ||(email.getText().isEmpty()) || 
                (motDePasse.getText().isEmpty()) || (verifMdp.getText().isEmpty()) ){
        
            loginMessage.setText("Vous deviez remplir les champs");
        }
        
        else if(!VerifierChamps.isTelephoneValide(cin.getText()) || 
             !VerifierChamps.isEmailAdress(email.getText()) || 
              !VerifierChamps.isValidPassword(motDePasse.getText()) ||
             !VerifierChamps.isValidPassword(verifMdp.getText())
               
             )
     {
         
     loginMessage.setText("Champs invalides ! ");
     }
      else  if((event.getSource() == enregistrerBtn) && 
                !(cin.getText().isEmpty()) &&!(email.getText().isEmpty()) && 
                !(motDePasse.getText().isEmpty()) && !(verifMdp.getText().isEmpty()) && verifMdp.getText().equals(motDePasse.getText()) ){
            
           // Client c = new Client (.getText(),tfprenom.getText(), tfemail.getText(), tfmdp.getText(), tfgenre.getValue(),Integer.parseInt(tftel.getText()), tfadresse.getText(),"client",Integer.parseInt(tfCin.getText()),0);
           
            if (!ins.chercherUtilisateurParCinMail(Integer.parseInt(cin.getText()) ,email.getText())){
                loginMessage.setText("Votre compte n'existe pas ! ");
            }
           else if (ins.chercherUtilisateurParCinMail(Integer.parseInt(cin.getText()) ,email.getText())){
               // loginMessage.setText("Votre compte existe déja ! ");
            
            user = ins.chercherUtilisateurParCin(Integer.parseInt(cin.getText()));
            user.setMotDePasse(motDePasse.getText());
                System.out.println("motdepasse"+motDePasse.getText());
            ins.modifierMdp(user);
            sendMail(email.getText());
            loginMessage.setText("Votre mot de passe est modifié avec succés");
            clearFields();
            Parent root = FXMLLoader.load(getClass().getResource("../gui/LoginFXML.fxml"));
                        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        Scene scene = new Scene(root);
                        primaryStage.setScene(scene);
                        primaryStage.show();
           
           }
}
        else {
        loginMessage.setText("champs invalides ! ");
        }
        
        
    }
    private void clearFields(){
       
        
        cin.clear();
        email.clear();
        motDePasse.clear();
        verifMdp.clear();
        
        
       
        
    }
    public static void sendMail(String recepient){
    String username = "doniabenmessaoud3010@gmail.com";
        String password = "xfqygpnlpzvvjvdh";

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties,
          new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
          });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("doniabenmessaoud3010@gmail.com"));
            message.setRecipients(
              Message.RecipientType.TO,
              InternetAddress.parse(recepient)
            );
            message.setSubject("Changement du mot de passe de l'application lets Barter ");
            message.setText("Bonjour,\n Nous vous informons que votre mot de passe de l'application let's Barter est modifié avec succés.\n Merci. ");
            
            Transport.send(message);

            System.out.println("Le message a été envoyé avec succès.");

        } catch (MessagingException e) {
            System.out.println("Une erreur s'est produite : " + e.getMessage());
        }
    }
        }
    

