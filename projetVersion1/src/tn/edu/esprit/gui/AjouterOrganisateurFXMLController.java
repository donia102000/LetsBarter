/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
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

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import tn.edu.esprit.entities.Client;
import tn.edu.esprit.entities.Organisateur;
import tn.edu.esprit.services.UtilisateurService;
import tn.edu.esprit.util.MyConnector;
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
    private ImageView idbtn;
      @FXML
    private ImageView imageView;
 @FXML
    private ComboBox<String> tfgenre;
 @FXML
    private Button chercherImgBtn;
 @FXML
    private PasswordField tfverifmdp;
    ObservableList<String> liste=FXCollections.observableArrayList("Homme","Femme");
   

   @FXML
    private Button ajouterImgbtn;

    @FXML
    private Label lbl;
    UtilisateurService ins = new UtilisateurService() ;
    String url;
    Image image;
    byte[] imageData;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         tfgenre.setItems(liste);
    }    
   
    @FXML
    void ajouter(ActionEvent event) throws SQLException {
        if((tfnom.getText().isEmpty()) ||(tfprenom.getText().isEmpty()) || 
                (tfadresse.getText().isEmpty()) || (tfemail.getText().isEmpty()) ||
                (tfgenre.getPromptText().isEmpty())|| (tftel.getText().isEmpty())  ||
                (tfCin.getText().isEmpty())||(tfmdp.getText().isEmpty()) ||(tfverifmdp.getText().isEmpty())||imageView.getImage()==null){
        
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
        else if((event.getSource() == btnajouter) && 
                !(tfnom.getText().isEmpty()) &&!(tfprenom.getText().isEmpty()) && 
                !(tfadresse.getText().isEmpty()) && !(tfemail.getText().isEmpty()) && 
                 !(tftel.getText().isEmpty())  &&
                  !(tfCin.getText().isEmpty())&&!(tfmdp.getText().isEmpty()) && tfverifmdp.getText().equals(tfmdp.getText())){
            image = imageView.getImage();
//String url = null;
if (image != null) {
    url = image.impl_getUrl();
    if (url!=null &&url.startsWith("file:")) {
        url = url.substring(5);
    }
}
// Récupération des données de l'image
imageData = null;
if (url != null) {
    try {
        File file = new File(url);
        imageData = Files.readAllBytes(file.toPath());
    } catch (IOException e) {
        e.printStackTrace();
    }
}
            
                
            Organisateur c = new Organisateur (tfnom.getText(),tfprenom.getText(), tfemail.getText(), tfmdp.getText(),tfgenre.getValue(),Integer.parseInt(tftel.getText()), tfadresse.getText(),"organisateur",Integer.parseInt(tfCin.getText()),imageData);
            System.out.println("bnj");
            if (ins.chercherUtilisateurParCinMail(Integer.parseInt(tfCin.getText()) ,tfemail.getText())){
                lbl.setText(" Organisateur existe déja ! ");
            }
            else if(!ins.chercherUtilisateurParCinMail(Integer.parseInt(tfCin.getText()) ,tfemail.getText())){
            ins.ajouter(c);
            
            lbl.setText("Organisateur ajouté avec succés");
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
        
        tfCin.clear();
        tfverifmdp.clear();
        
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
      public void SwitchToAcceuil (ActionEvent event) throws IOException{
    Parent root = FXMLLoader.load(getClass().getResource("../gui/AdminAcceuilOfficielFXML.fxml"));
                        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        Scene scene = new Scene(root);
                        primaryStage.setScene(scene);
                        primaryStage.show();}
    @FXML
    private void clickbtn(MouseEvent event) {

        if (event.getSource() == idbtn) {

            try {

                
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                //stage.setMaximized(true);
                stage.close();
                Scene scene = new Scene(FXMLLoader.load(getClass().getResource("AdminAcceuiFXML.fxml")));
                stage.setScene(scene);
                stage.show();

            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
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
            Image image = new Image(selectedFile.toURI().toString());
            imageView.setImage(image);
            
        }
    }
    
    
    
    @FXML
    private void addImage() throws IOException, SQLException {
       
Image image = imageView.getImage();
String url = null;
if (image != null) {
    url = image.impl_getUrl();
    if (url.startsWith("file:")) {
        url = url.substring(5);
    }
}
// Récupération des données de l'image
byte[] imageData = null;
if (url != null) {
    try {
        File file = new File(url);
        imageData = Files.readAllBytes(file.toPath());
    } catch (IOException e) {
        e.printStackTrace();
    }
}
            
                ins.ajouterImg(imageData);
            
        }
    @FXML
    public void recupImage() throws SQLException  {
    byte[] imageData =ins.recupererImg();
    // Conversion des données de l'image en un objet Image
InputStream in = new ByteArrayInputStream(imageData);
Image image = new Image(in);

// Création de l'objet ImageView

imageView.setImage(image);
    }
}
