/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.GestionAnnonce.gui;

import edu.GestionAnnonce.entities.Avis;
import edu.GestionAnnonce.services.ServiceAnnonce;
import edu.GestionAnnonce.services.ServiceAvis;
import edu.GestionAnnonce.tests.gui2;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author NOURHENE
 */
public class AjouterAvisController implements Initializable {
    @FXML
    private TextField champRecherche;
 @FXML
    private TextArea text;
  @FXML
    private Button bt;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     @FXML
    private void enregistrer_aviss(ActionEvent event){
       
   
         
           ServiceAnnonce ff = new ServiceAnnonce();
                   System.out.println(gui2.aa);
     //   Avis chh = new Avis(Integer.parseInt(gui2.ann.getId()),text.getText());
       
   //AvisCours hh1= new AvisCours(1,6,11,NewFXMain.vv.getIdCour(),"aggfaaaaaaaaaaaaaaaaaa");
     //   ff.ajouter(chh);
}}
