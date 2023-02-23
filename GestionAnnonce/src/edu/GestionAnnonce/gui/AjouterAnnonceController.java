/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.GestionAnnonce.gui;

import edu.GestionAnnonce.entities.Annonce;
import edu.GestionAnnonce.services.ServiceAnnonce;
import static edu.GestionAnnonce.tests.MainClass.main;
import edu.GestionAnnonce.utils.DataSource;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import static jdk.nashorn.internal.objects.NativeString.length;
import javafx.scene.input.KeyEvent;



/**
 * FXML Controller class
 *
 * @author NOURHENE
 */
public class AjouterAnnonceController implements Initializable {
    
    @FXML
    private TextField tfTitre;
    @FXML
    private TextField tfCategorie;
    @FXML
     private TextField tfSousc;
    @FXML
      private TextField  tfDesc;
    @FXML
    private TextField  tfValeur;
    
    @FXML
    private TextField tfVideo;
    @FXML
    private TextField tfAdresse;
    @FXML
    private TextField tfTel;
     @FXML
    private Button btn;
      @FXML
    private Label file_path;
      @FXML
    private ImageView imgpreview;
        @FXML
    private AnchorPane main;
        @FXML
        private String tfImage;
        @FXML
        private File selectedImageFile;
   

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      tfTel.addEventFilter(KeyEvent.KEY_TYPED, event -> {
            if (!event.getCharacter().matches("[0-9]") || tfTel.getText().length() >= 8) {
                event.consume();
            }
        });
    }
    
    

    /**
     *
     * @param event
     * @throws java.io.IOException
     */
    @FXML
public  void AjouterAnnonce(ActionEvent event) throws IOException {
 
  if ( (tfTitre.getText().isEmpty() | tfCategorie.getText().isEmpty()) |tfSousc.getText().isEmpty() |tfDesc.getText().isEmpty() |tfValeur.getText().isEmpty() |file_path.getText().isEmpty() | tfVideo.getText().isEmpty() | tfAdresse.getText().isEmpty() | tfTel.getText().isEmpty() | selectedImageFile == null ) {
      Alert a = new Alert(Alert.AlertType.ERROR, "tout les champs doivent etre remplis SVP!!", ButtonType.OK);
      a.showAndWait();
  }
  
  
  
          
   else  {
      ServiceAnnonce pc =new ServiceAnnonce();
      Annonce p = new Annonce(tfTitre.getText(),tfCategorie.getText(),tfSousc.getText(), tfDesc.getText(),tfValeur.getText(), file_path.getText(), tfVideo.getText(), tfAdresse.getText(), tfTel.getText());
      //     sp.ajouter(new Annonce("echange","electro","vbn","bien",58,"fr","fghjvk","ghsjk",85));
      pc.ajouter(p);
      System.out.println("ajout avec succee");
       Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Ajout Annonce ");
            alert.setHeaderText(null);
                alert.setContentText("Annonce ajouté !!");
            alert.showAndWait();
  }
 

}

    /**
     *
     * @param event
     */
   // @FXML
  //  public void InsertImage(ActionEvent event) {
        
   //          FileChooser open = new FileChooser();
   //     Stage stage =(Stage)main.getScene().getWindow();
   //     File file = open.showOpenDialog(stage);
    //    if(file != null){
      //      String path = file.getAbsolutePath();
       //      path = path.replace("\\", "\\\\");

//            file_path.setText(path);
  //          Image image = new Image(file.toURI().toString(), 110,110,false,true);
    //        imgpreview.setImage(image);
      //  }else{
        //    System.out.println("No FILE EXIST");
        //}
    //}
@FXML
    private void uploadImage() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Product Image");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
        selectedImageFile = fileChooser.showOpenDialog(imgpreview.getScene().getWindow());
        if (selectedImageFile != null) {
            Image image = new Image(selectedImageFile.toURI().toString());
            imgpreview.setImage(image);
        }
    }
}

    
