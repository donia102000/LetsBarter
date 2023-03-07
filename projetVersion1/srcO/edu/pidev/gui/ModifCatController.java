 
package edu.pidev.gui;

import edu.pidev.entities.Categorie;
import edu.pidev.serices.ServiceCategorie;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
public class ModifCatController {
    @FXML 
    private TextField nomCategorie;
  

 
   

    @FXML
    public void modifier  (ActionEvent event) { 
        
         String NomCategorie = nomCategorie.getText()  ; 
        
        
       Categorie c = new Categorie ( ) ;  // instanciation 
          ServiceCategorie a  = new ServiceCategorie(); 
       a.modifier(c); 
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Categorie modifier avec succès!");
        alert.showAndWait();
        
    }
    
    
}
    
 