/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Callback;
import tn.edu.esprit.entities.Favoris;
import tn.edu.esprit.entities.PropositionAchat;
import tn.edu.esprit.entities.PropositionTroc;
import tn.edu.esprit.services.IServicePropositionAchat;
import tn.edu.esprit.services.IServicePropositionTroc;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class ListePropositionController implements Initializable {
    @FXML
    private ListView<PropositionTroc> listv1;
@FXML
    private ListView<PropositionTroc> listv33;
    @FXML
    private ListView<PropositionAchat> listv2;
@FXML
    private Button btn_sort1;
       
           @FXML
    private ListView<PropositionAchat> listv3;
     ObservableList <PropositionTroc> list = FXCollections.observableArrayList();
     ObservableList <PropositionAchat> list2 = FXCollections.observableArrayList();
    
    @FXML
             private final IServicePropositionTroc spt = new IServicePropositionTroc();
    @FXML
     private final  IServicePropositionAchat spa = new IServicePropositionAchat ();
    

@FXML
    private TextField text_adresse;

    @FXML
    private Button btn_adresse;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)  {
    
      List<PropositionTroc> annoncesObservableList;
        try {
            annoncesObservableList = spt.getAll();
             for(PropositionTroc a:annoncesObservableList){
                listv1.getItems().add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ListePropositionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    

 List<PropositionAchat> achatObservableList;

        try {
            achatObservableList = spa.getAll();
                         for(PropositionAchat a:achatObservableList){
                listv2.getItems().add(a);
             
             
             listv2.setCellFactory((param)->new ListCell<PropositionAchat>() {
                @Override
                protected void updateItem(PropositionAchat item, boolean empty) {
                    super.updateItem(item, empty);
                    
                    if (empty || item == null) {
                        setText(null);
                        setGraphic(null);
                    } else {
                        
                        //Text text=new Text(item.getMail())
                         Text text1=new Text(item.getNegociation());
                     Label floatLabel = new Label(String.format("%.2f", item.getPrix()));
                    // Label intLabel = new Label(String.valueOf(item.getTel()));
                    VBox vbox = new VBox(text1);
                      setGraphic(vbox);
                    }
                }
                
       }); }
        } catch (SQLException ex) {
            Logger.getLogger(ListePropositionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        btn_sort1.setOnAction(this::TrierparDATE);
 }
    
    
    
        
            @FXML
    public void AffichageReservationParMailTel(ActionEvent event) throws IOException, SQLException {
        
           PropositionAchat propositionSelectionnee = listv2.getSelectionModel().getSelectedItem();
           if (propositionSelectionnee != null) {
            ObservableList<PropositionAchat> achatObservableList = FXCollections.observableArrayList(spa.afficherparMailTel(propositionSelectionnee.getId()));     
            listv3.setItems(achatObservableList);
           }
           
           
               
             listv3.setCellFactory((param)->new ListCell<PropositionAchat>() {
                @Override
                protected void updateItem(PropositionAchat item, boolean empty) {
                    super.updateItem(item, empty);
                    
                    if (empty || item == null) {
                        setText(null);
                        setGraphic(null);
                    } else {
                        
                        //Text text=new Text(item.getMail());
                         Text text1=new Text(item.getMail());
                    // Label floatLabel = new Label(String.format("%.2f", item.getPrix()));
                     Label intLabel = new Label(String.valueOf(item.getTel()));
                    VBox vbox = new VBox(text1);
                      setGraphic(vbox);
                    }
                }
                
       }); }
    
  public void trierParDate() {
    PropositionTroc  pt = listv1.getSelectionModel().getSelectedItem();
    
    if (pt != null){
      Comparator<PropositionTroc> dateComparator = new Comparator<PropositionTroc>() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        @Override
        public int compare(PropositionTroc obj1, PropositionTroc obj2) {
          LocalDate date1 = LocalDate.parse(obj1.getDatev(), formatter);
            LocalDate date2 = LocalDate.parse(obj2.getDatev(), formatter);
            return date1.compareTo(date2);
        }
    };

    ObservableList<PropositionTroc> items = listv1.getItems();
    items.sort(dateComparator);
    
    }

  
}
  
  
    @FXML
    void TrierparDATE(ActionEvent event) {
   trierParDate();
    }
 
        @FXML
    void chercherParAdresse(ActionEvent event)throws SQLException {
      String adresse = text_adresse.getText();
     IServicePropositionTroc spt = new  IServicePropositionTroc  ();
     List<PropositionTroc> result = spt.findPropositionByEmail(adresse);
     listv1.getItems().setAll(result);
  
    }
    
    
   

}
     
    
    
    
    
        
    
   