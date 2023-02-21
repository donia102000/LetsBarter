/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.gui;

import java.awt.Button;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;


/**
 * FXML Controller class
 *
 * @author Ghazoua
 */
public class FXMLController implements Initializable {

    @FXML
    private TextArea txtEvenement;

    @FXML
    private TextArea txtLibelle;

    @FXML
    private TextArea txtDate;

    @FXML
    private TextArea txtLieu;

    @FXML
    private TextArea txtNbrPMax;

    @FXML
    private TextArea txtOrganisateur;

    @FXML
    private Button btnAjouter;

    @FXML
    private Button btnSupprimer;

    @FXML
    private Button btnModifier;

    @FXML
    private Button btnAfficher;

    @FXML
    void Afficher(ActionEvent event) {

    }

    @FXML
    void Ajouter(ActionEvent event) {

    }

    @FXML
    void Modifier(ActionEvent event) {

    }

    @FXML
    void Supprimer(ActionEvent event) {

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
