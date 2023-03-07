/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.pidev.gui;

import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import javafx.scene.image.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;
import tn.edu.pidev.entities.Favoris;
import tn.edu.pidev.entities.PropositionAchat;
import tn.edu.pidev.entities.PropositionTroc;
import tn.edu.pidev.services.IService;
import tn.edu.pidev.services.IServicePropositionAchat;
import tn.edu.pidev.services.IServicePropositionTroc;
import tn.edu.pidev.utils.Connexion;
import java.util.regex.*;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


/**
 * FXML Controller class
 *
 * @author Admin
 */
public class PropositionFXMLController implements Initializable {
@FXML 
    private Button btn_ajtp;

    @FXML
    private Button btn_img;
  @FXML
    private TextField prixp;

    @FXML
    private TextArea textng;


       @FXML
    private ImageView img1;

          @FXML
    private TextField tfchercher;
          
                  @FXML
    private AnchorPane main;
                  
                    @FXML
    private Label file_path;
  
                         @FXML
    private ImageView imgpreview;
      @FXML
        private File selectedImageFile;
        @FXML
private AnchorPane imageContainer;
 private FileInputStream fis;

    
        @FXML
    private TextField tf_tel;

    @FXML
    private TextField tf_mail;
 @FXML
 Button validateButton;
        
@FXML
private Label lb1;
 @FXML
 private TextArea des;
 @FXML
 private Label label;
   private Connexion cn = Connexion.getInstance();
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[a-zA-Z0-9]{1,20}@[a-zA-Z0-9]{1,20}.[a-zA-Z]{2,3}$");
    private static final Pattern PHONE_PATTERN = Pattern.compile("\\d{3}-\\d{3}-\\d{4}");
   IServicePropositionTroc spt = new IServicePropositionTroc();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
         /***************Proposition Troc Image********************/
     btn_ajtp.setOnAction((ActionEvent event) -> {
  
    String description = des.getText();
   
    String image = imgpreview.getImage().impl_getUrl().replace("file:/", "");
  
     
    String nomannonce = lb1.getText();
    
    PropositionTroc p = new PropositionTroc(description, image,nomannonce);
         try {
             spt.ajouterPropositionTroc(p);
                Alert a = new Alert(Alert.AlertType.ERROR, "Proposition ajoutée avec succées", ButtonType.OK);
            a.showAndWait();
         } catch (SQLException ex) {
             Alert a = new Alert(Alert.AlertType.ERROR, "Proposition non ajoutée", ButtonType.OK);
            a.showAndWait();
         }
           
     });
          /***************Proposition Achat********************/
     
        validateButton.setOnAction(event -> {
    if (tf_mail.getText().isEmpty() || tf_tel.getText().isEmpty() || textng.getText().isEmpty()) {
        // Afficher un message d'erreur si les champs ne sont pas remplis
            Alert a = new Alert(Alert.AlertType.ERROR, "Remplir champs vide", ButtonType.OK);
            a.showAndWait();
    } else if (tf_tel.getText().length() < 8) {
        // Afficher un message d'erreur si le mot de passe est trop court

             Alert a = new Alert(Alert.AlertType.ERROR, "Numéro doit étre à 8 chiffres", ButtonType.OK);
            a.showAndWait();
    }
    

    
    else if  (!tf_mail.getText().matches("^[a-zA-Z0-9]{1,20}@[a-zA-Z0-9]{1,20}.[a-zA-Z]{2,3}$")) {
           Alert a = new Alert(Alert.AlertType.ERROR, "iccorect mail", ButtonType.OK);
            a.showAndWait();
    
    }
    
    
    else {
        // Les valeurs sont valides, procéder à la validation suivante ou enregistrer les valeurs
             try {
                  IServicePropositionAchat spa = new IServicePropositionAchat ();
                PropositionAchat p = new PropositionAchat(tf_mail.getText(),textng.getText(),Integer.parseInt(tf_tel.getText()),Float.parseFloat(prixp.getText()));
                spa.ajouterPropositionAchat(p);
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Proposition envoyée !", ButtonType.OK);
                a.showAndWait();   
               } catch (SQLException ex) {
                Alert a = new Alert(Alert.AlertType.ERROR, ex.getMessage(), ButtonType.OK);
                a.showAndWait();
            }
    }
    
    tf_mail.clear();
    //tf_tel.clear();
    textng.clear();
});
        
        
        
    }
    
    
    @FXML
     void onAddImage(ActionEvent event) {
        File file = ImageChooserUtil.chooseImage();
        if (file != null) {
            Image image = new Image("file:" + file.getPath());
            imgpreview.setImage(image);
        }
    }
  

   
       @FXML
    void rechercherParTitre(ActionEvent event) {
      //Favoris favoris =sp.chercherFavorisparTitre(String.(tfchercher.getText()));
    

    }



}
