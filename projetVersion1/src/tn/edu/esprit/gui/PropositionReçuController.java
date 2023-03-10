/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import tn.edu.esprit.entities.PropositionAchat;
import tn.edu.esprit.entities.PropositionTroc;
import tn.edu.esprit.entities.Utilisateur;
import tn.edu.esprit.services.IServicePropositionAchat;
import tn.edu.esprit.services.IServicePropositionReçu;
import tn.edu.esprit.services.IServicePropositionTroc;
import tn.edu.esprit.util.Utility;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class PropositionReçuController implements Initializable {

    @FXML
    private ListView<PropositionTroc>listv33;
        @FXML
    private ListView<Utilisateur> listvC;
        
         @FXML
    private ListView<PropositionAchat> listvA;
         
             @FXML
    private ListView<Utilisateur> listAI;
         
    @FXML
   private final IServicePropositionTroc spt = new IServicePropositionTroc();
    
      @FXML
   private final IServicePropositionReçu spr = new IServicePropositionReçu ();
      
      private ObservableList<PropositionTroc> propObservableList = FXCollections.observableArrayList();
      
       private ObservableList<PropositionAchat> achatObservableList = FXCollections.observableArrayList();

   
    @FXML
    IServicePropositionReçu pr = new IServicePropositionReçu();

    @FXML
    IServicePropositionTroc pt = new IServicePropositionTroc();
    
     @FXML
    IServicePropositionAchat pa = new IServicePropositionAchat();
 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        // ObservableList<Utilisateur>userObservableList = FXCollections.observableArrayList(spt.getAllIdProp());     
        //listvC.setItems(userObservableList);
        
        /*************proposition troc reçu**************/
        ObservableList<PropositionTroc> propObservableList = FXCollections.observableArrayList(spt.getAllParMail(Utility.utilisateur.getEmail()));
    
          listv33.setItems(propObservableList);
            /**************PROPOSITION ACHAT RECU********************/
              ObservableList<PropositionAchat> achatObservableList = FXCollections.observableArrayList(pa.getAllParMailA(Utility.utilisateur.getEmail()));
             listvA.setItems(achatObservableList);
        
        
     
      
            
    }    

    
    
       @FXML
    void AfficherContact(ActionEvent event) {
        
    //    PropositionTroc evenementSelectionnee = listv33.getSelectionModel().getSelectedItem();
     //      if (evenementSelectionnee != null) {
      //      ObservableList<PropositionTroc> reservationObservableList = FXCollections.observableArrayList(spt.getAllIdProp(evenementSelectionnee.getId()));     
     //       listvC.setItems(reservationObservableList);
     
     
     
      PropositionTroc propositionSelectionnee = listv33.getSelectionModel().getSelectedItem();
     

           System.out.println(propositionSelectionnee.getId());
           propositionSelectionnee.getId();
         if (propositionSelectionnee != null) {
      ObservableList<Utilisateur> propObservableList = FXCollections.observableArrayList(spt.getAllIdProp(propositionSelectionnee.getId()));     
  listvC.setItems(propObservableList);
         
           }
     
              

    }
    
    
    
        @FXML
    void AfficherDetails(ActionEvent event) {
    PropositionAchat propositionSelectionnee = listvA.getSelectionModel().getSelectedItem();
     

           System.out.println(propositionSelectionnee.getId());
           propositionSelectionnee.getId();
         if (propositionSelectionnee != null) {
      ObservableList<Utilisateur> propObservableList = FXCollections.observableArrayList(pa.getAllIdProp(propositionSelectionnee.getId()));     
  listAI.setItems(propObservableList);
         
           }
    }
}


