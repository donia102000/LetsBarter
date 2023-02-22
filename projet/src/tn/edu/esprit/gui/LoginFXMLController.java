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
import tn.edu.esprit.entities.Utilisateur;
import tn.edu.esprit.services.LoginService;
import tn.edu.esprit.verification.VerifierChamps;

/**
 * FXML Controller class
 *
 * @author Donia
 */
public class LoginFXMLController implements Initializable {

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
        LoginService login =new LoginService();
        
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
                if(user.getRole().equals("admin")){
                    
                    System.out.println(user.getIdUtilisateur());
                    Parent root = FXMLLoader.load(getClass().getResource("../gui/AdminAcceuiFXML.fxml"));
                        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        Scene scene = new Scene(root);
                        primaryStage.setScene(scene);
                        primaryStage.show();
                    
                
                }
                else if(user.getRole().equals("client")){
                
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
