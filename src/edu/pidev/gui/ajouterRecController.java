/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pidev.gui;

import edu.pidev.entities.Categorie;
import edu.pidev.entities.Reclamation;
import edu.pidev.serices.ServiceCategorie;
import edu.pidev.serices.Servicereclamation;
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
 * @author Dell
 */
public class ajouterRecController implements Initializable {

    @FXML
    private TextField dateRec;
    @FXML
    private TextField statutRec;
    @FXML
    private TextField typeRec;
    @FXML
    private TextField infoProduit;
    @FXML
    private TextField name;
    @FXML
    private TextField numTel;
    @FXML
    private TextField email;
    @FXML
    private TextField etatRec;
    @FXML
    private TextArea descriptionRec;
    @FXML
    private Button btnajouter;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouter(ActionEvent event) { 
        
        
        String DateRec = dateRec.getText()  ; 
        String StatutRec  = statutRec.getText() ;
        String   TypeRec = typeRec.getText() ; 
        String   InfoProduit = infoProduit.getText(); 
        
        String  Name = name.getText() ; 
        String NumTel = numTel.getText(); 
        String Email = email.getText(); 
        String EtatRec = etatRec.getText() ; 
        String Description = descriptionRec.getText() ; 
                        
        
        Reclamation r = new Reclamation (DateRec , StatutRec ,TypeRec , InfoProduit , Name , NumTel ,Email ,EtatRec , Description  ) ;  // instanciation   
          Servicereclamation b  = new Servicereclamation(); 
       
       b.ajouter(r);    
        
    }
    
}
