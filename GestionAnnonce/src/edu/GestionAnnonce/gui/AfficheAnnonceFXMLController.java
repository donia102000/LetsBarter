/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.GestionAnnonce.gui;

import edu.GestionAnnonce.entities.Annonce;
import edu.GestionAnnonce.services.ServiceAnnonce;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author NOURHENE
 */
public class AfficheAnnonceFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
   @FXML
    private Label lTitre;
  @FXML
    private Label lCategorie;
   @FXML
     private Label lSousc;
    @FXML
      private Label  lDesc;
    private Label  lValeur;
     @FXML
    private Label                     lImage;
      @FXML
    private Label lVideo;
       @FXML
    private Label lAdresse;
        @FXML
    private Label lTel;
         @FXML
    private String nom;
          

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    // ps.setFloat(9, p.getTel());
      //      ps.setString(8, p.getAdresse());
        //    ps.setString(7, p.getVideo());
          //  ps.setString(6, p.getImage());
            //ps.setFloat(5, p.getValeurobjet());
           // ps.setString(4, p.getDescription());
          //  ps.setString(3, p.getSouscategorie());
         //   ps.setString(2, p.getCategorie());
        //    ps.setString(1, p.getTitre());

   

    

    void setLSouscategorie(String souscategorie) {
        this.lSousc.setText(souscategorie);
    }

    void setLDescription(String description) {
      this.lDesc.setText(description);
    }

    void setLValeurobjet(String valeurobjet) {
        this.lValeur.setText(valeurobjet);
       
    }

    void setLImage(String image) {
        this.lImage.setText(image);
    }

    void setLVideo(String video) {
        this.lVideo.setText(video);
    }

    void setAdresse(String adresse) {
        this.lAdresse.setText(adresse);
    }

    void setTel(String tel) {
       this.lTel.setText(tel);
    }

    void setLText(String titre) {
       this.lTitre.setText(titre);
    }

    void setLCategorie(String categorie) {
         this.lCategorie.setText(categorie);
    }

    void setLTitre(String Titre) {
       this.lTitre.setText(Titre);
    }

    


   
    
}
