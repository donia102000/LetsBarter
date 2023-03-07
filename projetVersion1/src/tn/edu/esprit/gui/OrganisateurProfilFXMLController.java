/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import tn.edu.esprit.util.Utility;

/**
 * FXML Controller class
 *
 * @author Donia
 */
public class OrganisateurProfilFXMLController implements Initializable {
@FXML
    private Label lblprenom;

    @FXML
    private Label lblnom;

    @FXML
    private Label lblcontact;

    @FXML
    private Label lbladresse;

    @FXML
    private Label lbltel;

    @FXML
    private Label lblgenre;

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
    private Label lblCin;
     @FXML
    private ImageView imageView;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        // TODO
        lblnom.setText(Utility.utilisateur.getNomUtilisateur());
       lblprenom.setText(Utility.utilisateur.getPrenomUtilisateur());
       lblgenre.setText(Utility.utilisateur.getGenre());
       lbladresse.setText(Utility.utilisateur.getAdresse());
       lblcontact.setText(Utility.utilisateur.getEmail());
       lbltel.setText(String.valueOf( Utility.utilisateur.getNumTelephone()));
       lblCin.setText(String.valueOf( Utility.utilisateur.getCin()));
       byte[] imageData =Utility.utilisateur.getImage();
    // Conversion des données de l'image en un objet Image
      InputStream in = new ByteArrayInputStream(imageData);
      Image image = new Image(in);
       imageView.setImage(image);
    }    
    public void deconnecter(ActionEvent event) throws IOException{
    Parent root = FXMLLoader.load(getClass().getResource("../gui/LoginFXML.fxml"));
                        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        Scene scene = new Scene(root);
                        primaryStage.setScene(scene);
                        primaryStage.show();
    
    }
    public void SwitchToProfil(ActionEvent event) throws IOException{
    Parent root = FXMLLoader.load(getClass().getResource("../gui/OrganisateurProfilFXML.fxml"));
                        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        Scene scene = new Scene(root);
                        primaryStage.setScene(scene);
                        primaryStage.show();
     }
    public void switchToModifierInfo(ActionEvent event) throws IOException{
    Parent root = FXMLLoader.load(getClass().getResource("../gui/OrganisateurModifierInfoProfilFXML.fxml"));
                        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        Scene scene = new Scene(root);
                        primaryStage.setScene(scene);
                        primaryStage.show();
     }
     public void switchToModifierMdp (ActionEvent event) throws IOException{
    Parent root = FXMLLoader.load(getClass().getResource("../gui/OrganisateurModifierMdpFXML.fxml"));
                        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        Scene scene = new Scene(root);
                        primaryStage.setScene(scene);
                        primaryStage.show();
     }
     public void SwitchToAcceuil (ActionEvent event) throws IOException{
    Parent root = FXMLLoader.load(getClass().getResource("../gui/OrganisateurAcceuilFXML.fxml"));
                        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        Scene scene = new Scene(root);
                        primaryStage.setScene(scene);
                        primaryStage.show();}

}
