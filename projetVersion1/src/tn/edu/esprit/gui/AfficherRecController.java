/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import tn.edu.esprit.entities.Reclamation;
import tn.edu.esprit.services.ServiceCategorie;
import tn.edu.esprit.services.ServiceSousCategorie;
import tn.edu.esprit.services.Servicereclamation;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Observable; 
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class AfficherRecController implements Initializable {

     @FXML
    private ListView<Reclamation> listRec;

    private  Servicereclamation servicereclamation = new Servicereclamation();  
    
    private ObservableList<Reclamation> reclamations;
    
       //  private ObservableList<Reclamation> reclamationObservableList = FXCollections.observableArrayList(); 
      
    @FXML
    private Button supprimerRec;
    @FXML
    private TextField tfSearch;
    @FXML
    private ComboBox<String> ComboEtat;
    @FXML
    private Text tfetat;
    @FXML
    private Button Modifier;
@Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        listRec.getItems().addAll(servicereclamation.getAll());
        System.out.println(servicereclamation.getAll());
       
        
        
                List<String> etats = Arrays.asList("traité", "non traité");
ComboEtat.setItems(FXCollections.observableArrayList(etats));

 listRec.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                // Set the etat of the selected item to the text field
                tfetat.setText(newValue.getEtat());
                
            }
            
        });
 
  

 
}
     

  
    @FXML
    void supprimer(ActionEvent event) { 
       
        Servicereclamation servicereclamation = new Servicereclamation();  
        
      Reclamation r  = listRec.getSelectionModel().getSelectedItem();
        if (r != null) {
              System.out.println(r.getId());
            
             servicereclamation.supprimer(r.getId());   
                     
             
             listRec.getItems().remove(r);
        } 
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Suppression avec succée");

    }  
    
//   public  void redirect (ActionEvent event)  throws IOException { 
//      try {
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("traiterRec.fxml"));
//        Parent root = loader.load();   
//        Scene scene = new Scene(root);
//        Stage stage = new Stage();
//        stage.setScene(scene);
//        stage.show();
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
//
//    }  
//    
      void redirect(ActionEvent event)  {
            try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("traiterRec.fxml"));
        Parent root = loader.load();   
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
    }
    } 
    


    @FXML
    private void SortByDate(ActionEvent event) {
           ObservableList<Reclamation> observableList = listRec.getItems();
    observableList.sort(Comparator.comparing(Reclamation::getDate_reclamation));
    listRec.setItems(observableList);
        
        
    }

    @FXML
    private void ModifierEtat(ActionEvent event) {
             // Get the selected item from the listRec
        Reclamation selectedReclamation = listRec.getSelectionModel().getSelectedItem();
        // Update the etat property of the selected item based on the value selected in the comboBox
        String newEtat = ComboEtat.getValue();
        selectedReclamation.setEtat(newEtat);
        // Call the update method on the service to save the changes
        servicereclamation.modifierEtat(selectedReclamation);
        // Show a dialog message to inform the user that the changes have been saved successfully
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Modification enregistrée");
        alert.setHeaderText(null);
        alert.setContentText("Les modifications ont été enregistrées avec succès.");
        alert.showAndWait();
        // Close the current window
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    
} 


    


 