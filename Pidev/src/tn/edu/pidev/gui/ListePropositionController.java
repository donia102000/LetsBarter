/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.pidev.gui;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import tn.edu.pidev.entities.Favoris;
import tn.edu.pidev.entities.PropositionAchat;
import tn.edu.pidev.entities.PropositionTroc;
import tn.edu.pidev.services.IServicePropositionAchat;
import tn.edu.pidev.services.IServicePropositionTroc;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class ListePropositionController implements Initializable {
    @FXML
    private ListView<PropositionTroc> listv1;

    @FXML
    private ListView<PropositionAchat> listv2;
    
     ObservableList <PropositionTroc> list = FXCollections.observableArrayList();
     ObservableList <PropositionAchat> list2 = FXCollections.observableArrayList();
    
    @FXML
             private final IServicePropositionTroc spt = new IServicePropositionTroc();
    @FXML
     private final  IServicePropositionAchat spa = new IServicePropositionAchat ();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)  {
        try {
            List<PropositionTroc> annoncesObservableList = spt.getAll();
            for(PropositionTroc a:annoncesObservableList){
                listv1.getItems().add(a);
            }
            
            
            listv1.setCellFactory(param->new ListCell<PropositionTroc>() {
                @Override
                protected void updateItem(PropositionTroc item, boolean empty) {
                    super.updateItem(item, empty);
                    
                    if (empty || item == null) {
                        setText(null);
                        setGraphic(null);
                    } else {
                        
                        String[]e=item.getImage().split("/");
                        String fileName = "/" + e[e.length - 2] + "/" + e[e.length - 1];
                        
                        System.out.println(fileName);
                        Image image=new Image(fileName);
                        ImageView imageView = new ImageView();
                        imageView.setImage(image);
                        imageView.setFitHeight(80);
                        imageView.setFitWidth(80);
                        Text text=new Text(item.getDescription());
                         Text text1=new Text(item.getNomannonce());
                        VBox vbox = new VBox(imageView,text,text1);
                        setGraphic(vbox);
                        
                    }
                }
                
            });   } catch (SQLException ex) {
            Logger.getLogger(ListePropositionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        
          ObservableList<PropositionAchat> list2;
        try {
           List<PropositionAchat> annoncesObservableList = spa.getAll();
            for(PropositionAchat a:annoncesObservableList){
                listv2.getItems().add(a);
            }
        
        
             listv2.setCellFactory(param->new ListCell<PropositionAchat>() {
                @Override
                protected void updateItem(PropositionAchat item, boolean empty) {
                    super.updateItem(item, empty);
                    
                    if (empty || item == null) {
                        setText(null);
                        setGraphic(null);
                    } else {
                        
                        //String[]e=item.getImage().split("/");
                        //String fileName = "/" + e[e.length - 2] + "/" + e[e.length - 1];
                        
                        //System.out.println(fileName);
                       /* Image image=new Image(fileName);
                        ImageView imageView = new ImageView();
                        imageView.setImage(image);
                        imageView.setFitHeight(80);
                        imageView.setFitWidth(80);*/
                        Text text=new Text(item.getMail());
                         Text text1=new Text(item.getNegociation());
                          //Text text2=new Text(Float.parseFloat(item.getPrix()));
                          //Text  text3=new Int(item.getTel());
                   
                        VBox vbox = new VBox(text1,text);
                        setGraphic(vbox);
                        
                    }
                }
                
            }); 
        
        
        
        
        } catch (SQLException ex) {
            Logger.getLogger(ListeFavorisController.class.getName()).log(Level.SEVERE, null, ex);
        }
    


}
}  