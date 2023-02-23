/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.GestionAnnonce.gui;

import edu.GestionAnnonce.entities.Annonce;
import edu.GestionAnnonce.services.ServiceAnnonce;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author NOURHENE
 */
public class ModifierAnnonceController implements Initializable {
 @FXML
    private TextField tftitre;
  @FXML
    private TextField tfcategorie;
   @FXML
    private TextField tfsouscategorie;
    @FXML
    private TextField tfdescription;
     @FXML
    private TextField tfvaleur;
      @FXML
    private TextField tfImage;
       @FXML
    private TextField tfvideo;
        @FXML
    private TextField tfadresse;
         @FXML
    private TextField tftel;
         @FXML
          private Button btnmodifier;
          @FXML
    private Button btnrechercher;
          @FXML
          private TextField tfrechercher;
          @FXML
          ServiceAnnonce service = new ServiceAnnonce();
          @FXML
          Annonce annonce = new Annonce();
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
 @FXML
    public void rechercherParId(){
    annonce =service.chercherAnnonceParId(Integer.parseInt(tfrechercher.getText()));
    tftitre.setText(annonce.getTitre());
    tfcategorie.setText(annonce.getCategorie());
    tfsouscategorie.setText(annonce.getSouscategorie());
    tfdescription.setText(annonce.getDescription());
    tfvaleur.setText(annonce.getValeurobjet());
    tfImage.setText(annonce.getImage());
    tfvideo.setText(annonce.getVideo());
    tfadresse.setText(annonce.getAdresse());
     tftel.setText(annonce.getTel());
  
   }
 @FXML
    public void modifier(){
        annonce.setTitre(tftitre.getText());
        annonce.setCategorie(tfcategorie.getText());
        annonce.setSouscategorie(tfsouscategorie.getText());
        annonce.setDescription(tfdescription.getText());
        annonce.setValeurobjet(tfvaleur.getText());
        annonce.setImage(tfImage.getText());
        annonce.setVideo(tfvideo.getText());
        annonce.setAdresse(tfadresse.getText());
        annonce.setTel(tftel.getText());
    service.modifier(annonce);
    
    }    
    @FXML
    public void supprimer(){
        
    service.supprimer(Integer.parseInt(tfrechercher.getText()));
   clearFields();
    
    }
      public void clearFields(){
     tftitre.clear();
        tfcategorie.clear();
        tfsouscategorie.clear();
        tfdescription.clear();
        tfvaleur.clear();
        tfImage.clear();
        tfvideo.clear();
        tfadresse.clear();
        tftel.clear();
        
    }
    
}
