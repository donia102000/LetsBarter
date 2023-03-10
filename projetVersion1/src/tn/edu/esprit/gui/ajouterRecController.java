/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import tn.edu.esprit.entities.Reclamation;
import tn.edu.esprit.services.Servicereclamation;
import jakarta.mail.MessagingException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
/**
 * FXML Controller class
 *
 * @author Dell
 */
public class ajouterRecController implements Initializable {
@Override
    public void initialize(URL url, ResourceBundle rb) {
       
       ObservableList<String> L = FXCollections.observableArrayList("recommondation","rembourssement","Annulation","gratitude") ; 
        combo.setItems(L) ;  
    }  
   
    @FXML
    private TextField typeRec;
    @FXML
    private TextField infoProduit;
    @FXML
    private TextField name;
    @FXML
    private TextField numTel;
    @FXML
    private TextField email;

    @FXML
    private TextArea texto ; 
    @FXML
    private Button btnajouter;  
    
     @FXML
   private ComboBox combo;

    
    @FXML
    void select(ActionEvent event) {
     String s = combo.getSelectionModel().getSelectedItem().toString();  
    }


    /**
     * Initializes the controller class.
     */
      
           private boolean isValid(String email) {
        String EMAIL_PATTERN = 
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
      private boolean isvalid(String numTel){
           //String phonenumberstr = Integer.toString(num);
           if(numTel.length()!=8){
               return false;
           }
           for (int i =0; i<numTel.length();i++){
               if(!Character.isDigit(numTel.charAt(i))){
                   return false;
           }
           }
           return !"12345678".equals(numTel);
 
    }
      private boolean isValidDate(String date) {
    try {
        LocalDate.parse(date);
        return true;
    } catch (DateTimeParseException e) {
        return false;
    }
}

    @FXML
    private void ajouter(ActionEvent event) throws MessagingException {
        
               boolean test=true;

         
        if (name.getText().isEmpty()||  email.getText().isEmpty()||  texto.getText().isEmpty()|| 
                 infoProduit.getText().isEmpty() ) { 
              Alert alert1 = new Alert(AlertType.WARNING);
             alert1.setTitle("oops");
             alert1.setHeaderText(null);
             alert1.setContentText("remplir tous les champs");
             alert1.showAndWait();
              
                 }
//        else if (!isValidDate(dateRec.getText())) {
//            
//        // Affichage d'une alerte en cas de saisie de date invalide
//        Alert alert = new Alert(AlertType.ERROR);
//        alert.setTitle("Erreur de saisie");
//        alert.setHeaderText(null);
//        alert.setContentText("Veuillez saisir une date valide (format : yyyy-mm-dd)!");
//        alert.showAndWait();
//    } 
        
        else if(isValid(email.getText())==false) {
             
             Alert alert = new Alert(AlertType.ERROR);
             alert.setTitle("Invalid Email");
             alert.setHeaderText(null);
             alert.setContentText("entrer une adresse email valide");
             alert.show();
             email.requestFocus();
             email.selectAll();
              ;
          }  
        
        else  if((isvalid(numTel.getText())==false)){
             
             Alert alert1 = new Alert(AlertType.ERROR);
             alert1.setTitle("Invalid numero");
             alert1.setHeaderText(null);
             alert1.setContentText("entrer une numero valide");
             alert1.show();
             email.requestFocus();
             email.selectAll();
             return;
             
                }
        else {
//            String DateRec = dateRec.getText()  ; 
       
       String   TypeRec = (String) combo.getValue(); 
        String   InfoProduit = infoProduit.getText(); 
        
        String  Name = name.getText() ; 
        int NumTel = Integer.parseInt(numTel.getText());  
        String Email = email.getText(); 
        String EtatRec = "non traitée " ;  
        String Texto = texto.getText() ;
        
     //   Reclamation r = new Reclamation ( Texto,TypeRec, InfoProduit , Name , NumTel ,Email ,EtatRec ) ; 
    // Reclamation r = new Reclamation(TypeRec, InfoProduit, Name, NumTel, Email, EtatRec, Texto); 
    
     Reclamation r = new Reclamation ( Texto ,TypeRec, InfoProduit , Name , NumTel ,Email ,EtatRec ) ;  
        // instanciation 
        System.out.println(r.toString());
           Servicereclamation b  = new Servicereclamation();  
       
       b.ajouterRec(r); 
       String Subject ="reclamation";
       String To=Email;
       String Body="La reclamation a été ajoutée avec succès !\n un mail vous a été envoyé ";
       b.sendEmail(To, Subject,Body);
         Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("La reclamation a été ajoutée avec succès !\n un mail vous a été envoyé  " ); 
        alert.showAndWait();
        }
    } 
    
} 
