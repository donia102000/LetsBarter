/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.pidev.gui;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import static javafx.scene.input.KeyCode.R;
import javafx.stage.Stage;
import tn.edu.pidev.entities.Favoris;
import tn.edu.pidev.services.IService;

/**
 * FXML Controller class
 *
 * @author Admin
 */




public class ListeFavorisController implements Initializable {

    @FXML
    private ListView<Favoris> listview;
    
    ObservableList <Favoris> list = FXCollections.observableArrayList();
    
     ObservableList <Favoris> list2 = FXCollections.observableArrayList();
    
    @FXML
    private final IService Service = new IService();
    


    
    @FXML 
    TextField searchBox;
    
    
    @FXML
            Button btn_sort;
    
    
      ArrayList <Favoris> words = new ArrayList<>();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       
        ObservableList<Favoris> list;
        try {
            list = FXCollections.observableArrayList(Service.getAll());
            listview.setItems(list);
        } catch (SQLException ex) {
            Logger.getLogger(ListeFavorisController.class.getName()).log(Level.SEVERE, null, ex);
        }
   
     btn_sort.setOnAction(new EventHandler<ActionEvent>() {
        
         
            @Override
            public void handle(ActionEvent event) {
           
            listview.getItems().sort(Comparator.comparing(Favoris::getTitle));
              listview.getSelectionModel().clearSelection();
   
           }
        });
     
     


        // TODO
    }    
        @FXML
    void back(ActionEvent event) throws IOException {
      Parent root = FXMLLoader.load(getClass().getResource("AnnonceFXML.fxml"));
        Stage mainStage = new Stage();
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    }
    

    
        @FXML
    void supprimerFavoris(ActionEvent event) throws SQLException {
      /*Favoris f = listview.getSelectionModel().getSelectedItem();
            if (f != null) {
             //   System.out.println(produit.getId());
                 Service.supprimer(f.getId());
                    listview.getItems().remove(f);*/
                    
        Favoris f = listview.getSelectionModel().getSelectedItem();
        if (f != null) {
              System.out.println(f.getId());
             Service.supprimer(f);
             listview.getItems().remove(f);
        } 
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Suppression avec succée");          
                    
                    
    }
    
   @FXML
   void cherhcerFavoris(ActionEvent event) throws SQLException{
     String title = searchBox.getText();
     IService sp = new  IService ();
     List<Favoris> result = sp.findFavorisByTitre(title);
     listview.getItems().setAll(result);
  

   }
   
   
    
}

    
    
    



    

    

