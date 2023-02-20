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
    private Label file_path;
      @FXML
    private ImageView imgpreview;
      int idh;
ServiceAnnonce ps=new ServiceAnnonce();
    @FXML
    private TableColumn<Annonce, String> titre;
    @FXML
    private TableColumn<Annonce, String> categorie;
    @FXML
    private TableColumn<Annonce, String> souscategorie;
    @FXML
    private TableColumn<Annonce, String> description;
    @FXML
    private TableColumn<Annonce, String> valeur;
    @FXML
    private TableColumn<Annonce, String> image;
    @FXML
    private TableColumn<Annonce, String> video;
    @FXML
    private TableColumn<Annonce, String> adresse;
     @FXML
    private TableColumn<Annonce, String> tel;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
     public void selectEvenement(Annonce e)
    {

       idh=e.getId();
 

        
    }
       public void refresh(){
         List Annonces = ps.getAll(idh);
         ObservableList list = FXCollections.observableArrayList(Annonces);
       tabannonce.setItems(list);
        titre.setCellValueFactory(new PropertyValueFactory<>("Titre"));
        categorie.setCellValueFactory(new PropertyValueFactory<>("Categorie"));
        souscategorie.setCellValueFactory(new PropertyValueFactory<>("Souscategorie"));
        description.setCellValueFactory(new PropertyValueFactory<>("Description"));
        valeur.setCellValueFactory(new PropertyValueFactory<>("Valeur"));
        image.setCellValueFactory(new PropertyValueFactory<>("Image"));
        video.setCellValueFactory(new PropertyValueFactory<>("Video"));
        adresse.setCellValueFactory(new PropertyValueFactory<>("Adresse"));
          tel.setCellValueFactory(new PropertyValueFactory<>("Tel"));


        ObservableList<Annonce> dataList = FXCollections.observableArrayList(Annonces);
         tabannonce.setItems(dataList);
        FilteredList<Annonce> filteredData = new FilteredList<>(dataList,b->true);
       

    }
    
}
