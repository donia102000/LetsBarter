/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.pidev.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class AdminAcceuiFXMLController implements Initializable {
  @FXML
    private ListView<?> listView;

    @FXML
    private Label lblprenom;

    @FXML
    private Label lblnom;

    @FXML
    private Label lblcontact;

    @FXML
    private Label lbladresse;

    @FXML
    private Label lbltel;

    @FXML
    private Label lblgenre;

    @FXML
    private Label lblanniver;

    @FXML
    private Button btnmodif;

    @FXML
    private Button btnajouter;

    @FXML
    private Button lblAcceuil;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
       @FXML
    void AfficherListeFavoris(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ListFavorisFXML.fxml"));
        Stage mainStage = new Stage();
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    }

    
     @FXML
    void AfficherPropositions(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("ListeProposition.fxml"));
        Stage mainStage = new Stage();
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    }
}
