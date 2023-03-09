/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import tn.edu.esprit.entities.Annonce;
import tn.edu.esprit.entities.Avis;
import tn.edu.esprit.services.ServiceAnnonce;
import tn.edu.esprit.services.ServiceAvis;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author NOURHENE
 */
public class ListeListeController implements Initializable {
@FXML private ImageView likeIcon;
    @FXML private ImageView dislikeIcon;
    @FXML
    private final ServiceAnnonce ServiceAnnonce = new ServiceAnnonce();
 private ServiceAvis commentaireService = new ServiceAvis();
 @FXML
    private ListView<Annonce> listView;
         @FXML
    private TextArea commentaireTextArea;
         
 @FXML
    private TextField recherche;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<Annonce> annoncesObservableList = ServiceAnnonce.getAll();
      
      
          
      for(Annonce a:annoncesObservableList){
       
      listView.getItems().add(a);
      
      }
  listView.setCellFactory(param->new ListCell<Annonce>() {
   @Override
    protected void updateItem(Annonce item, boolean empty) {
      super.updateItem(item, empty);
        
        if (empty || item == null) {
            setText(null);
            setGraphic(null);
        } else {
            
          String[] e=item.getImage().split("/");
           System.out.println(item.getImage());
          String fileName = "/" + e[e.length - 2] + "/" + e[e.length - 1];
          
           
          Image image=new Image(fileName);
           ImageView imageView = new ImageView();
            imageView.setImage(image);
            imageView.setFitHeight(250);
            imageView.setFitWidth(400);
    Text text=new Text(item.getAdresse());
    Text text1=new Text(item.getTitre());
    Text text2=new Text(item.getCategorie());
    Text text3=new Text(item.getSouscategorie());
   Text text4=new Text(item.getTel());
            VBox vbox = new VBox(imageView,text,text1,text2,text3,text4);
            setGraphic(vbox);
            
        }
    }
    
    
  });
  FontAwesomeIconView thumbsUpIcon = new FontAwesomeIconView(FontAwesomeIcon.THUMBS_UP);
    thumbsUpIcon.setSize("2em");
    likeIcon.setImage(thumbsUpIcon.snapshot(null, null));
    
    FontAwesomeIconView thumbsDownIcon = new FontAwesomeIconView(FontAwesomeIcon.THUMBS_DOWN);
    thumbsDownIcon.setSize("2em");
    dislikeIcon.setImage(thumbsDownIcon.snapshot(null, null));
  likeIcon.setOnMouseClicked(event -> {
            Annonce annonce = listView.getSelectionModel().getSelectedItem();
            if (annonce != null) {
                ServiceAnnonce.incrementLike(annonce);
            }
        });

        dislikeIcon.setOnMouseClicked(event -> {
            Annonce annonce = listView.getSelectionModel().getSelectedItem();
            if (annonce != null) {
                ServiceAnnonce.incrementDislike(annonce);
            }
        });
  
    }
@FXML
    public void annulerCommentaire() {
        commentaireTextArea.clear();
    }
@FXML
    public void enregistrerCommentaire() {
        Annonce annonceSelectionnee = listView.getSelectionModel().getSelectedItem();
        if (annonceSelectionnee != null && !commentaireTextArea.getText().isEmpty()) {
            Avis commentaire = new Avis();
            commentaire.setAnnonce(annonceSelectionnee);
          
            commentaire.setCommentaire(commentaireTextArea.getText());
            
            commentaireService.ajouterCommentaire(commentaire);
             TrayNotification tray = new TrayNotification();
        AnimationType type = AnimationType.POPUP;
        tray.setAnimationType(type);
        tray.setTitle("Notification");
        tray.setMessage("Avis bien ajouté");
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndDismiss(Duration.millis(3000));

       
            commentaireTextArea.clear();
        }
    }
    
 @FXML
     void search (ActionEvent event){
        String title = recherche.getText();
        List<Annonce> result = ServiceAnnonce.findForumByTitle(title);
        listView.getItems().setAll(result);
    }
    
    
}
