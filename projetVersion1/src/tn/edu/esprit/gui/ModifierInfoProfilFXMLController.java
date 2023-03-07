/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.sql.SQLException;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import tn.edu.esprit.services.UtilisateurService;
import tn.edu.esprit.util.Utility;
import tn.edu.esprit.verification.VerifierChamps;
/**
 * FXML Controller class
 *
 * @author Donia
 */
public class ModifierInfoProfilFXMLController implements Initializable {
  @FXML
    private ImageView imageView;

    @FXML
    private Button chercherImgBtn;
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
    private TextField tftel;

    @FXML
    private ComboBox<String> tfgenre;
ObservableList<String> liste=FXCollections.observableArrayList("Homme","Femme");
    @FXML
    private Button btnmodifier;
      
     @FXML
    private Label lbl;
    byte[] imageData;
    String url = null;
    Image image;
     UtilisateurService service =new UtilisateurService();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tfgenre.setItems(liste);
        lbl.setText("");
    tfnom.setText(Utility.utilisateur.getNomUtilisateur());
    tfprenom.setText(Utility.utilisateur.getPrenomUtilisateur());
    tfCin.setText(String.valueOf( Utility.utilisateur.getCin()));
    tfadresse.setText(Utility.utilisateur.getAdresse());
    tfemail.setText(Utility.utilisateur.getEmail());
    tftel.setText(String.valueOf(Utility.utilisateur.getNumTelephone()));
    tfgenre.setPromptText(Utility.utilisateur.getGenre());
     imageData =Utility.utilisateur.getImage();
    // Conversion des données de l'image en un objet Image
      InputStream in = new ByteArrayInputStream(imageData);
       image = new Image(in);
       imageView.setImage(image);
      
    }    public void SwitchToAcceuil (ActionEvent event) throws IOException{
    Parent root = FXMLLoader.load(getClass().getResource("../gui/AdminAcceuilOfficielFXML.fxml"));
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
     public void SwitchToListeOrg(ActionEvent event) throws IOException{
    Parent root = FXMLLoader.load(getClass().getResource("../gui/AdminAcceuiFXML.fxml"));
                        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        Scene scene = new Scene(root);
                        primaryStage.setScene(scene);
                        primaryStage.show();
    
    }
     public void SwitchToStatisqueParDate(ActionEvent event) throws IOException{
    Parent root = FXMLLoader.load(getClass().getResource("../gui/StatistiqueParDate.fxml"));
                        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        Scene scene = new Scene(root);
                        primaryStage.setScene(scene);
                        primaryStage.show();
    
                        
}
     public void SwitchToProfil(ActionEvent event) throws IOException{
    Parent root = FXMLLoader.load(getClass().getResource("../gui/ProfilFXML.fxml"));
                        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        Scene scene = new Scene(root);
                        primaryStage.setScene(scene);
                        primaryStage.show();
     }
    public void switchToModifierInfo(ActionEvent event) throws IOException{
    Parent root = FXMLLoader.load(getClass().getResource("../gui/ModifierInfoProfilFXML.fxml"));
                        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        Scene scene = new Scene(root);
                        primaryStage.setScene(scene);
                        primaryStage.show();
     }
    public void switchToModifierMdp (ActionEvent event) throws IOException{
    Parent root = FXMLLoader.load(getClass().getResource("../gui/ModifierMdpFXML.fxml"));
                        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        Scene scene = new Scene(root);
                        primaryStage.setScene(scene);
                        primaryStage.show();
     }
    @FXML
    public void mofifier() throws SQLException{
        if((tfnom.getText().isEmpty()) ||(tfprenom.getText().isEmpty()) || 
                (tfadresse.getText().isEmpty()) || (tfemail.getText().isEmpty()) ||
                (tfgenre.getPromptText().isEmpty())|| (tftel.getText().isEmpty())  ||
                 (tfCin.getText().isEmpty())){
        
            lbl.setText("Vous devez remplir les champs");
        }
        else if(!VerifierChamps.stringTest(tfnom.getText()) || 
             !VerifierChamps.stringTest(tfprenom.getText()) || 
              !VerifierChamps.isTelephoneValide(tftel.getText()) ||
             !VerifierChamps.stringTest(tfadresse.getText())||
             !VerifierChamps.isTelephoneValide(tfCin.getText())||
             !VerifierChamps.isEmailAdress(tfemail.getText()))  
             
     {
         
     lbl.setText("Champs invalides ! ");
     }
        else{
        Utility.utilisateur.setNomUtilisateur(tfnom.getText());
        Utility.utilisateur.setPrenomUtilisateur(tfprenom.getText());
        Utility.utilisateur.setCin(Integer.parseInt(tfCin.getText()));
        Utility.utilisateur.setAdresse(tfadresse.getText());
        Utility.utilisateur.setEmail(tfemail.getText());
        
        Utility.utilisateur.setNumTelephone(Integer.parseInt(tftel.getText()));
        Utility.utilisateur.setGenre(tfgenre.getValue().toString());
   image = imageView.getImage();
//String url = null;
if (image != null) {
    url = image.impl_getUrl();
    if ( url != null && url.startsWith("file:")) {
        url = url.substring(5);
    }
}
// Récupération des données de l'image

if (url != null) {
    try {
        File file = new File(url);
        imageData = Files.readAllBytes(file.toPath());
    } catch (IOException e) {
        e.printStackTrace();
    }
}
        Utility.utilisateur.setImage(imageData);
    service.modifier(Utility.utilisateur);
    lbl.setText("");
        }
    }
     @FXML
    private void chooseImage() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choisir une image");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Images", "*.png", "*.jpg", "*.gif"),
                new FileChooser.ExtensionFilter("Tous les fichiers", "*.*"));
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            image = new Image(selectedFile.toURI().toString());
            imageView.setImage(image);
            
        }
    }
}
