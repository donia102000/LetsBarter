/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pidev.gui;

import edu.pidev.entities.Categorie;
import edu.pidev.serices.ServiceCategorie;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/** 
 * FXML Controller class
 *
 * @author Dell
 */
public class CategorieController implements Initializable {
 @FXML 
    private TextField nomCategorie;
 
    @FXML 
    private TextField NomCategorie;
   
@FXML
private Button btnmodif;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
  @FXML
   private  void ajouter(ActionEvent event) { 
       
        
      
        
        String nomCategorieText = nomCategorie.getText();
       
        Categorie c = new Categorie(nomCategorieText);    
        ServiceCategorie serviceCategorie = new ServiceCategorie(); 
        serviceCategorie.ajouter(c);
        
        // create an alert for successful addition
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Categorie ajoutée avec succès!");
        alert.showAndWait();
        
    
 
    // afficher un message d'erreur ou autre traitement à votre choix
}

        
               

    public  void supprimer(ActionEvent event) { 
         
          if (nomCategorie.getText() != null && !nomCategorie.getText().isEmpty() ){
        String nomCategorieText = nomCategorie.getText();
      
        Categorie c = new Categorie(nomCategorieText);     
        ServiceCategorie a = new ServiceCategorie(); 
      // instanciation 
        a.supprimer(c); 
        }   } 
    
    
//        Favoris f = listview.getSelectionModel().getSelectedItem();
//        if (f != null) {
//              System.out.println(f.getId());
//             Service.supprimer(f);
//             listview.getItems().remove(f);
//        } 
//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle("Suppression avec succée"); 
        
  

     
     
    
@FXML
public void openModifInterface(ActionEvent event) {
    try {
        // Load the Modif.fxml file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifCat.fxml"));
        Parent root = loader.load();

        // Show the Modif.fxml interface
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

    } catch (IOException e) {
        e.printStackTrace();
    }
} 
@FXML
public void openModifInterface2(ActionEvent event) {
    try {
        // Load the Modif.fxml file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SupprimerCategorie.fxml"));
        Parent root = loader.load();

        // Show the Modif.fxml interface
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

    } catch (IOException e) {
        e.printStackTrace();
    }
} 
@FXML
public void openModifInterface3(ActionEvent event) {
    try {
        // Load the Modif.fxml file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Afficher.fxml"));
        Parent root = loader.load();

        // Show the Modif.fxml interface
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

    } catch (IOException e) {
        e.printStackTrace();
    }
}
}


    
      
         
 






    
