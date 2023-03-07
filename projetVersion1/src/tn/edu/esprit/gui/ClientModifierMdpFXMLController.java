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
import tn.edu.esprit.services.UtilisateurService;
import tn.edu.esprit.util.Utility;
import tn.edu.esprit.verification.VerifierChamps;

/**
 * FXML Controller class
 *
 * @author Donia
 */
public class ClientModifierMdpFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button btnmodif;

    @FXML
    private Button btnajouter;

    @FXML
    private Button lblAcceuil;

    @FXML
    private Button lbldeconnexion;

    @FXML
    private Button btnretour;

    @FXML
    private Button btnmodif1;

    @FXML
    private Button btnStatistiqueParDate;

    @FXML
    private Button btnmodif11;

    @FXML
    private Button btnprofil;

    @FXML
    private Button modifInfobtn;

    @FXML
    private Button modMdpbtn;

    @FXML
    private TextField tfmdp;

    @FXML
    private TextField tfmdpverif;

    @FXML
    private Button btnmodifier;

    @FXML
    private Label lbl;
UtilisateurService service =new UtilisateurService();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    public void mofifier() throws SQLException{
        if((tfmdp.getText().isEmpty()) ||(tfmdpverif.getText().isEmpty()) ){
        
            lbl.setText("Vous devez remplir les champs");
        }
        else if(!VerifierChamps.isValidPassword(tfmdp.getText()) || 
             !VerifierChamps.isValidPassword(tfmdpverif.getText())|| !tfmdpverif.getText().equals(tfmdp.getText())  )  
             
     {
         
     lbl.setText("Champs invalides ! ");
     }
        else{
        Utility.utilisateur.setMotDePasse(tfmdp.getText());
        
            System.out.println(Utility.utilisateur);
    service.modifierMdp(Utility.utilisateur);
    
    lbl.setText("");
        }
    }
    public void deconnecter(ActionEvent event) throws IOException{
    Parent root = FXMLLoader.load(getClass().getResource("../gui/LoginFXML.fxml"));
                        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        Scene scene = new Scene(root);
                        primaryStage.setScene(scene);
                        primaryStage.show();
    
    }
    public void SwitchToProfil(ActionEvent event) throws IOException{
    Parent root = FXMLLoader.load(getClass().getResource("../gui/ClientProfilFXML.fxml"));
                        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        Scene scene = new Scene(root);
                        primaryStage.setScene(scene);
                        primaryStage.show();
     }
    public void switchToModifierInfo(ActionEvent event) throws IOException{
    Parent root = FXMLLoader.load(getClass().getResource("../gui/ClientModifierInfoProfilFXML.fxml"));
                        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        Scene scene = new Scene(root);
                        primaryStage.setScene(scene);
                        primaryStage.show();
     }
     public void switchToModifierMdp (ActionEvent event) throws IOException{
    Parent root = FXMLLoader.load(getClass().getResource("../gui/ClientModifierMdpFXML.fxml"));
                        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        Scene scene = new Scene(root);
                        primaryStage.setScene(scene);
                        primaryStage.show();
     }
     public void SwitchToAcceuil (ActionEvent event) throws IOException{
    Parent root = FXMLLoader.load(getClass().getResource("../gui/ClientAcceuilFXML.fxml"));
                        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        Scene scene = new Scene(root);
                        primaryStage.setScene(scene);
                        primaryStage.show();}

}
