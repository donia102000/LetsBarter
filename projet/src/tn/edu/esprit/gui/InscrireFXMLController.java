/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tn.edu.esprit.entities.Client;
import tn.edu.esprit.services.InscriptionService;

/**
 * FXML Controller class
 *
 * @author Donia
 */
public class InscrireFXMLController implements Initializable {




    @FXML
    private Button btnInscrire;

    @FXML
    private TextField tfnom;

    @FXML
    private TextField tfprenom;

    @FXML
    private TextField tfadresse;

    @FXML
    private TextField tfemail;

    @FXML
    private TextField tfmdp;

    @FXML
    private TextField tftel;
    
     @FXML
    private TextField tfCin;

    @FXML
    private ComboBox<String> tfgenre;
    ObservableList<String> liste=FXCollections.observableArrayList("Homme","Femme","Autre");

    @FXML
    private DatePicker tfnaissance;

    @FXML
    private Label lbl;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tfgenre.setItems(liste);
    }    
    
    InscriptionService ins = new InscriptionService() ;
   
    @FXML
    private void Inscription (ActionEvent event) throws IOException {
     
        if((event.getSource() == btnInscrire) && 
                !(tfnom.getText().isEmpty()) &&!(tfprenom.getText().isEmpty()) && 
                !(tfadresse.getText().isEmpty()) && !(tfemail.getText().isEmpty()) && 
                !(tfgenre.getPromptText().isEmpty())&& !(tftel.getText().isEmpty())  &&
                !(tfnaissance.getEditor().getText().isEmpty()) && !(tfCin.getText().isEmpty())&&!(tfmdp.getText().isEmpty())){
            
            Client c = new Client (tfnom.getText(),tfprenom.getText(), tfemail.getText(), tfmdp.getText(), tfgenre.getValue(), tfnaissance.getEditor().getText(),Integer.parseInt(tftel.getText()), tfadresse.getText(),"client", 0,Integer.parseInt(tfCin.getText()));
           
            
            ins.inscrire(c);
            
            lbl.setText("Votre compte est ajouté avec succés");
            clearFields();
            Parent root = FXMLLoader.load(getClass().getResource("../gui/LoginFXML.fxml"));
                        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        Scene scene = new Scene(root);
                        primaryStage.setScene(scene);
                        primaryStage.show();
           
            
}
        else {
        lbl.setText("please inter the necessity information!");
        }
        
        
    }
    private void clearFields(){
       
        
        tfnom.clear();
        tfprenom.clear();
        tfadresse.clear();
        tfemail.clear();
        tftel.clear();
        tfgenre.setValue(null);
        tfmdp.clear();
        tfnaissance.setValue(null);
        
    }
}