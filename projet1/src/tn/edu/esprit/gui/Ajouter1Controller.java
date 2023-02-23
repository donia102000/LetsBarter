/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;



import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import tn.edu.esprit.entities.Evenement;
import tn.edu.esprit.services.ServiceEvenement;

/**
 * FXML Controller class
 *
 * @author Ghazoua
 */
public class Ajouter1Controller implements Initializable {

    /**
     * Initializes the controller class.
  
     */
    
    @FXML
    private TextField libelle;

    @FXML
    private TextField lieu;

    @FXML
    private TextField nbrPlaceMax;

    @FXML
    private Button btnAjouter;
    
    @FXML
    private Button btnRetour;

    @FXML
    private DatePicker date;

    @FXML
    private ImageView img;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         
    }  
     @FXML
    public void AjouterEvenement(ActionEvent event) throws IOException {
       if ((libelle.getText().isEmpty()) || (lieu.getText().isEmpty()) || (date.getEditor().getText().isEmpty()) || (nbrPlaceMax.getText().isEmpty())){
           Alert a = new Alert(Alert.AlertType.ERROR, "Veillez remplir tous les champs!!", ButtonType.OK);
           a.showAndWait();
       }
       else{
           ServiceEvenement se = new ServiceEvenement();
           Evenement e = new Evenement (libelle.getText(),date.getEditor().getText(),lieu.getText(),Integer.parseInt(nbrPlaceMax.getText()));
           se.ajouter(e);
           System.out.println("Evenement ajoutée avec succée");
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
           alert.setTitle("Evenement ajoutée avec succée");
           alert.setHeaderText(null);
           alert.setContentText("Evenement ajoutée avec succée");
           alert.showAndWait();
           Parent root = FXMLLoader.load(getClass().getResource("../gui/Afficher.fxml"));
           Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
           Scene scene = new Scene(root);
           primaryStage.setScene(scene);
           primaryStage.show();
       }

    }
    
    @FXML
    private void Retour(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Afficher.fxml"));
        Stage mainStage = new Stage();
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    }




    
}
