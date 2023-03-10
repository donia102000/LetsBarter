/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Properties;
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
import tn.edu.esprit.entities.Favoris;
import tn.edu.esprit.entities.PropositionAchat;
import tn.edu.esprit.entities.PropositionTroc;
import tn.edu.esprit.services.IServiceFavoris;
import tn.edu.esprit.services.IServicePropositionAchat;
import tn.edu.esprit.services.IServicePropositionTroc;
import tn.edu.esprit.util.Connexion;
import java.util.regex.*;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.VBox;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import tn.edu.esprit.util.Utility;



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
 @FXML
    private TextField lb_tel2;

    @FXML
    private TextField lb_mail2;

    @FXML
    private DatePicker  date;
   private Connexion cn = Connexion.getInstance();
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[a-zA-Z0-9]{1,20}@[a-zA-Z0-9]{1,20}.[a-zA-Z]{2,3}$");
    private static final Pattern PHONE_PATTERN = Pattern.compile("\\d{3}-\\d{3}-\\d{4}");
   IServicePropositionTroc spt = new IServicePropositionTroc();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
         /***************Proposition Troc Image********************/
     btn_ajtp.setOnAction(event ->  {
            if  ( des.getText().isEmpty()  || lb_mail2.getText().isEmpty() || lb1.getText().isEmpty() || date.getEditor().getText().isEmpty()) {
                 Alert a = new Alert(Alert.AlertType.ERROR, "Remplir champs vides", ButtonType.OK);
                 a.showAndWait();
             }
             
         /*/    else if (lb_tel2.getText().length() >=8){
                 Alert a = new Alert(Alert.AlertType.ERROR, "iccorect numéro", ButtonType.OK);
                 a.showAndWait();
             }*/
            
            
             else {
            
             try {
                 
             String description = des.getText();
             String image = imgpreview.getImage().impl_getUrl().replace("file:/", "");
             String nomannonce = lb1.getText();
             Integer tel = new  Integer (String.valueOf(lb_tel2.getText()));
             String adresse = lb_mail2.getText();
           //Get the selected date from the DatePicker object and format it into a string that is compatible with the MySQL DATE data type 
             LocalDate localDate = date.getValue();
             String datev = localDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
             
             PropositionTroc p = new PropositionTroc(Utility.utilisateur.getIdUtilisateur(),description,image,nomannonce,tel,adresse,datev);//à changer 
                 spt.ajouterPropositionTroc(p);
                 sendEmail(lb_mail2.getText());
                 Alert a = new Alert(Alert.AlertType.INFORMATION, "Proposition ajoutée avec succées", ButtonType.OK);
                 a.showAndWait();
                 des.clear();
                 lb_tel2.clear();
                 lb_mail2.clear();
                 date.setValue(null);
                 
                 
             } catch (SQLException ex) {
                 Alert a = new Alert(Alert.AlertType.ERROR, "Proposition non ajoutée", ButtonType.OK);
                 a.showAndWait();
             }  catch (MessagingException ex) {
                    Logger.getLogger(PropositionFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                }
         
         
             }
            
            
            
     });
          /***************Proposition Achat********************/
     
        validateButton.setOnAction(event -> {
    if (tf_mail.getText().isEmpty() || tf_tel.getText().isEmpty() || textng.getText().isEmpty()) {
        // Afficher un message d'erreur si les champs ne sont pas remplis
            Alert a = new Alert(Alert.AlertType.ERROR, "Remplir champs vide", ButtonType.OK);
            a.showAndWait();
    } else if (tf_tel.getText().length() > 8) {
        // Afficher un message d'erreur si le mot de passe est trop court

             Alert a = new Alert(Alert.AlertType.ERROR, "Numéro doit étre à 8 chiffres", ButtonType.OK);
            a.showAndWait();
            tf_tel.clear();
    }
    

    
    else if  (!tf_mail.getText().matches("^[a-zA-Z0-9]{1,20}@[a-zA-Z0-9]{1,20}.[a-zA-Z]{2,3}$")) {
           Alert a = new Alert(Alert.AlertType.ERROR, "iccorect mail", ButtonType.OK);
            a.showAndWait();
            tf_mail.clear();
    
    }
    
    
    else {
        // Les valeurs sont valides, procéder à la validation suivante ou enregistrer les valeurs
             try {
                  IServicePropositionAchat spa = new IServicePropositionAchat ();
                PropositionAchat p = new PropositionAchat(Utility.utilisateur.getIdUtilisateur(),tf_mail.getText(),textng.getText(),Integer.parseInt(tf_tel.getText()),Float.parseFloat(prixp.getText()));// le 1 va etre changé par donia
                spa.ajouterPropositionAchat(p);
                sendEmail(tf_mail.getText());
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Proposition envoyée !", ButtonType.OK);
                a.showAndWait();   
                
                    tf_mail.clear();
                   tf_tel.clear();
                   textng.clear();
                  prixp.clear();
               } catch (SQLException ex) {
                Alert a = new Alert(Alert.AlertType.ERROR, ex.getMessage(), ButtonType.OK);
                a.showAndWait();
            } catch (MessagingException ex) {
            Logger.getLogger(PropositionFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

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

   
    public static void sendEmail(String recipient) throws MessagingException {
   String username = "doniabenmessaoud3010@gmail.com";
        String password = "xfqygpnlpzvvjvdh";
    // Setup mail server properties
    Properties props = new Properties();
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "587");

    // Get the Session object
    Session session = Session.getInstance(props, new javax.mail.Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
        }
    });
    
    
        try {
              // Create a new email message
    Message message = new MimeMessage(session);
    message.setFrom(new InternetAddress(username));
    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
    message.setSubject("Nouvelle proposition ajoutée");
    message.setText("Bonjour,veuillez me contacter si ma proposition vous interesse");
    
    
    
    System.out.println("Email sent successfully");

    // Send the email
    Transport.send(message);
            
        } catch (MessagingException e) {
            
            System.out.println("erreur"+e.getMessage());
        }

  
}

}
