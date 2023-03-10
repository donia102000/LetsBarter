/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import tn.edu.esprit.entities.Categorie;
import tn.edu.esprit.entities.SousCategorie;
import tn.edu.esprit.services.ServiceCategorie;
import tn.edu.esprit.services.ServiceSousCategorie;
import tn.edu.esprit.util.DataSource;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class AjouterSousCatController implements Initializable {

    @FXML
    private Button btnajouter; 
    @FXML
    private TextField nomSousCat;
    @FXML
    private Button btnajouter1;
    @FXML
    private TextField libelle;
    //@FXML
    //private ComboBox<Integer> comboSc;
    @FXML
    private ComboBox<String> comboSc;
    /**
     * Initializes the controller class.
     */
    
                List<String> idl = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    

                            try {
            // TODO
            String req="select nomCategorie from categorie";
            PreparedStatement pst = DataSource.getInstance().getCnx()
                    .prepareStatement(req);
            ResultSet rss=pst.executeQuery();
            ObservableList<String> names = null;
            List<String> list = new ArrayList<>();
            while(rss.next()){
             
             list.add(rss.getString("nomCategorie"));
            
            }
            names = FXCollections
                    .observableArrayList(list);
            comboSc.setItems(names);
            
        } catch (SQLException ex) {
            Logger.getLogger(AjouterSousCatController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
        // TODO
        
    @FXML
    private void ajoutersc(ActionEvent event) { 
        

     
     try{
         
        String nomSousCatText = nomSousCat.getText();
        String idCat= comboSc.getValue();
         System.out.println(idCat);
        
               try {
            // TODO
            String req="select id from categorie where nomCategorie='"+idCat+"'";
            PreparedStatement pst = DataSource.getInstance().getCnx()
                    .prepareStatement(req);
            ResultSet rss=pst.executeQuery();
            ObservableList<String> names = null;
            while(rss.next()){
             
             idl.add(rss.getString("id"));
            
            }
            names = FXCollections
                    .observableArrayList(idl);
            comboSc.setItems(names);
            
        } catch (SQLException ex) {
            Logger.getLogger(AjouterSousCatController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      
        SousCategorie sc = new SousCategorie(nomSousCatText,Integer.parseInt(idl.get(0))); 
       ServiceSousCategorie serviceSousCategorie = new ServiceSousCategorie();  
        serviceSousCategorie.ajouter(sc);
        
        // create an alert for successful addition
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("la sous categorie est créer ave succes !");
        alert.showAndWait();
        }catch(Exception ex){
            System.out.println(ex);
            
            
        }

} 

    @FXML
    private void supprimersc(ActionEvent event) { 
        
       
//         
//          if (libelle.getText() != null && !libelle.getText().isEmpty() ){
//        String LibelleText =libelle.getText();
//      
//        
//        
//        
//        
//          ServiceSousCategorie sc = new ServiceSousCategorie();  
//        serviceSousCategorie.ajouter(sc); 
//        
//      // instanciation 
//       sc.supprimer(sc); 
//        } 
        
    }
} 
