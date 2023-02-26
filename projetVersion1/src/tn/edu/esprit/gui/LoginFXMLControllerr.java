/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tn.edu.esprit.entities.HistoriqueConnexion;
import tn.edu.esprit.entities.Utilisateur;
import tn.edu.esprit.services.HistoriqueConnexionService;
import tn.edu.esprit.services.UtilisateurService;

import tn.edu.esprit.verification.VerifierChamps;

/**
 * FXML Controller class
 *
 * @author Donia
 */
public class LoginFXMLControllerr implements Initializable {

    @FXML
    private TextField email;
    @FXML
    private TextField motDePasse;
    @FXML
    private Button connexion;
    @FXML
    private Button inscrire;
    @FXML
    private Label loginMessage;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    Utilisateur user = new Utilisateur();
    @FXML 
    void ConnexionFunction (ActionEvent event) throws IOException {
        UtilisateurService login =new UtilisateurService();
        HistoriqueConnexionService historisque = new HistoriqueConnexionService();
        HistoriqueConnexion hisCnx = new HistoriqueConnexion();
        String email = this.email.getText();
        String motDepass = motDePasse.getText();
    
    if(email.equals("") || motDepass.equals(""))
        {
            loginMessage.setText("Vous deviez remplir les champs !");
        }
    else if(VerifierChamps.isEmailAdress(email)==false || VerifierChamps.isValidPassword(motDepass)==false)
    {
     loginMessage.setText("Champs invalides !");
    }
    else
    {
            try {
               user= login.findUserbyEmail(email, motDepass);
               if(user != null){
                   this.loginMessage.setText("");
                   System.err.println("kkkkkkkkkkkkkkkkk");
                if(user.getRole().equals("admin")){
                    
                    System.out.println(user.getIdUtilisateur());
                    Parent root = FXMLLoader.load(getClass().getResource("../gui/AdminAcceuiFXML.fxml"));
                        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        Scene scene = new Scene(root);
                        primaryStage.setScene(scene);
                        primaryStage.show();
                    
                
                }
                else if(user.getRole().equals("client")){
                //test de la date 
                int nbreTentativeConnexion;
                Date currentDate = new Date();
                 SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                 
                if(historisque.getDateParUtilisateurEtDateActuel(new java.sql.Date(currentDate.getTime()), user.getIdUtilisateur(),user.getRole()).getDateConnexion()== null){
                    hisCnx.setDateConnexion(new java.sql.Date(currentDate.getTime()));
                    hisCnx.setIdUtilisateur(user.getIdUtilisateur());
                    hisCnx.setSysExploitation("linux");
                    hisCnx.setNbConnexion(1);
                    historisque.ajouter(hisCnx);
                    System.out.println("hello");
                }
                else if (historisque.getDateParUtilisateurEtDateActuel(new java.sql.Date(currentDate.getTime()), user.getIdUtilisateur(),user.getRole()).getDateConnexion()!= null){
               HistoriqueConnexion his = new HistoriqueConnexion();
                    his.setIdHistorique(historisque.getDateParUtilisateurEtDateActuel(new java.sql.Date(currentDate.getTime()), user.getIdUtilisateur(),user.getRole()).getIdHistorique());
                his.setDateConnexion(new java.sql.Date(currentDate.getTime()));
                his.setIdUtilisateur(user.getIdUtilisateur());
                his.setSysExploitation("mac");
                nbreTentativeConnexion = historisque.getDateParUtilisateurEtDateActuel(new java.sql.Date(currentDate.getTime()), user.getIdUtilisateur(),user.getRole()).getNbConnexion();
                his.setNbConnexion(nbreTentativeConnexion+1);
                    System.out.println("hi"+nbreTentativeConnexion);
                    
                   
             historisque.modifier(his);
             System.out.println("hiiiii"+historisque.getDateParUtilisateurEtDateActuel(new java.sql.Date(currentDate.getTime()), user.getIdUtilisateur(),user.getRole()));
                }
                    System.out.println("client");
                    System.err.println(user.getIdUtilisateur());
                    Parent root = FXMLLoader.load(getClass().getResource("../gui/ClientAccueilFXML.fxml"));
                        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        Scene scene = new Scene(root);
                        primaryStage.setScene(scene);
                        primaryStage.show();
                    
                }
                
                else if(user.getRole().equals("organisateur")){
                    System.out.println("organisateur");
                }
              /*  else if(user.equals(null)){
                
                loginMessage.setText("Utilisateur introuvable");
                }*/
               }
              else {
                   this.email.setText("");
                   this.motDePasse.setText("");
               loginMessage.setText("Utilisateur introuvable");
               }
                
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                loginMessage.setText("Utilisateur introuvable");
            }
            
    
    
    }
    
    }
    @FXML
    void inscrireFunction (ActionEvent event) throws IOException{
    
    Parent root = FXMLLoader.load(getClass().getResource("../gui/InscrireFXML.fxml"));
                        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        Scene scene = new Scene(root);
                        primaryStage.setScene(scene);
                        primaryStage.show();
    }
      
    
     public  int idUtilisateur() {
    
    return user.getIdUtilisateur();
    }
}
