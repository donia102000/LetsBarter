/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.GestionAnnonce.gui;

import edu.GestionAnnonce.entities.Annonce;
import edu.GestionAnnonce.services.ServiceAnnonce;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author NOURHENE
 */
public class ListeAnnonceController implements Initializable {
 @FXML
    private AnchorPane pane;
    @FXML
    private TableView<Annonce> tabannonce;
    @FXML
    private TextField tfTitre;
    @FXML
    private TextField tfCategorie;
    @FXML
     private TextField tfSousc;
    @FXML
      private TextField  tfDesc;
    @FXML
    private TextField  tfValeur;
    
    @FXML
    private TextField tfVideo;
    @FXML
    private TextField tfAdresse;
    @FXML
    private TextField tfTel;
     @FXML
    private Button btn;
      @FXML
    private Button raf;
      @FXML
    private Label file_path;
      @FXML
    private ImageView imgpreview;
      int idh;
ServiceAnnonce ps=new ServiceAnnonce();
    @FXML
    private TableColumn<Annonce, String> Titre;
    @FXML
    private TableColumn<Annonce, String> Categorie;
    @FXML
    private TableColumn<Annonce, String> SousCategorie;
    @FXML
    private TableColumn<Annonce, String> Description;
    @FXML
    private TableColumn<Annonce, String> Valeur;
    @FXML
    private TableColumn<Annonce, String> Image;
    @FXML
    private TableColumn<Annonce, String> Video;
    @FXML
    private TableColumn<Annonce, String> Adresse;
     @FXML
    private TableColumn<Annonce, String> Tel;
      @FXML
    private TableColumn<Annonce, Void> modifier;
     private  ObservableList<Annonce> Annonces = FXCollections.observableArrayList();
     private ServiceAnnonce ServiceAnnonce;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         Titre.setCellValueFactory(new PropertyValueFactory<>("Titre"));
        Categorie.setCellValueFactory(new PropertyValueFactory<>("Categorie"));
        SousCategorie.setCellValueFactory(new PropertyValueFactory<>("Souscategorie"));
        Description.setCellValueFactory(new PropertyValueFactory<>("Description"));
        Valeur.setCellValueFactory(new PropertyValueFactory<>("Valeur"));
        Image.setCellValueFactory(new PropertyValueFactory<>("Image"));
        Video.setCellValueFactory(new PropertyValueFactory<>("Video"));
        Adresse.setCellValueFactory(new PropertyValueFactory<>("Adresse"));
          Tel.setCellValueFactory(new PropertyValueFactory<>("Tel"));
          tabannonce.setItems(Annonces);
     
    }
     
    
    
     
       
    /**
     *
     * @param event
     */
    @FXML
    public void affiche(ActionEvent event) {
          List annonces= ps.getAll();
        ObservableList<Annonce> Annonces= FXCollections.observableArrayList(annonces);
        tabannonce.setItems(Annonces);
               }
     
    
    
}
