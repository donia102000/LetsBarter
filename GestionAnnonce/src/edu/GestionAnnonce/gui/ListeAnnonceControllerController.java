/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.GestionAnnonce.gui;
import java.util.List;
import edu.GestionAnnonce.entities.Annonce;
import edu.GestionAnnonce.entities.Avis;
import edu.GestionAnnonce.services.ServiceAnnonce;
import edu.GestionAnnonce.services.ServiceAvis;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
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
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;

/**
 * FXML Controller class
 *
 * @author NOURHENE
 */
public class ListeAnnonceControllerController implements Initializable {
    @FXML private ImageView likeIcon;
    @FXML private ImageView dislikeIcon;
 @FXML
    private TextField recherche;
  
    @FXML
    private Button deleteButton;
     @FXML
    private TextField champRecherche;
  
  
     private Avis selectedAvis = new Avis();
  
@FXML
    private final ServiceAnnonce ServiceAnnonce = new ServiceAnnonce();

 @FXML
    private ListView<Annonce> listView;
 @FXML
    private TextField titreField;

    @FXML
    private TextField categorieField;
     @FXML
    private TextField sousField;
      @FXML
    private TextField descriptionField;
       @FXML
    private TextField valeurField;
        @FXML
    private TextField imageField;
         @FXML
    private TextField videoField;
          @FXML
    private TextField telField;
           @FXML
    private TextField adresseField;
           @FXML
    private TextArea commentaireTextArea;

    @FXML
    private Button updateButton;
    @FXML
    private Button AvisButton;
    @FXML
    private TextArea texteCommentaire;

    @FXML
    private Button boutonAjouterCommentaire;
   private ServiceAvis commentaireService = new ServiceAvis();
      @FXML private Button likeButton;
    @FXML private Button dislikeButton;
  private Annonce selectedAnnonce;
   @FXML private ImageView imageView;

    private ObservableList<Annonce> annoncesObservableList = FXCollections.observableArrayList();
  
        @FXML
    private Button buttonLike;

    @FXML
    private Button buttonDislike;
  
            private ServiceAnnonce annonceService;

    

//commentaireService.ajouterCommentaire(id, commentaire);
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
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
            
          String[]e=item.getImage().split("/");
          String fileName = "/" + e[e.length - 2] + "/" + e[e.length - 1];
          
            System.out.println(fileName);
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
  
           
        
         
       deleteButton.setOnAction(event -> {
           Annonce produit = listView.getSelectionModel().getSelectedItem();
            if (produit != null) {
             //   System.out.println(produit.getId());
                 ServiceAnnonce.supprimer(produit.getId());
                    listView.getItems().remove(produit);
                } 
            
       });
           
//       AvisButton.setOnAction(event -> {
  //         Annonce produit = listView.getSelectionModel().getSelectedItem();
    //        if (produit != null) {
             //   System.out.println(produit.getId());
      //      ServiceAnnonce.chercherAnnonceId(produit);
                  
        //        } 
            
      // });
       
         updateButton.setOnAction(event -> {
        Annonce produit = listView.getSelectionModel().getSelectedItem();
        if (produit != null) {
            produit.setTitre((titreField.getText()));
              produit.setCategorie((categorieField.getText()));
                produit.setSouscategorie((sousField.getText()));
                  produit.setDescription((descriptionField.getText()));
                    produit.setValeurobjet((valeurField.getText()));
                      produit.setImage((imageField.getText()));
                       
                          produit.setAdresse((adresseField.getText()));
                        
                          produit.setTel((telField.getText()));
            ServiceAnnonce.modifier(produit);
            annoncesObservableList.set(listView.getSelectionModel().getSelectedIndex(), produit);
            listView.getSelectionModel().clearSelection();
        }
    });
         recherche.setOnAction(event -> {
        String titreRecherche = champRecherche.getText().toLowerCase();
        List<Annonce> annoncesFiltrees = listView.getItems().stream()
                .filter(a -> a.getTitre().toLowerCase().contains(titreRecherche))
                .collect(Collectors.toCollection(ArrayList::new));
        listView.getItems().clear();
        listView.getItems().addAll(annoncesFiltrees);
    });
         
//         champRecherche.textProperty().addListener((observable, oldValue, newValue) -> {
 //          rechercherAnnonce(newValue);
   //    });
        
    }
    
    private class AnnonceListCell extends javafx.scene.control.ListCell<Annonce> {
        private ImageView imageView = new ImageView();

      
    }
   
    @FXML
    private void search (ActionEvent event){
        String title = recherche.getText();
        List<Annonce> result = ServiceAnnonce.findForumByTitle(title);
        listView.getItems().setAll(result);
    }
    
     private void rechercherAnnonce(String recherche) {
        if (recherche.isEmpty()) {
            // Affiche tous les livres si la recherche est vide
            listView.setItems(annoncesObservableList);
        } else {
            // Utilise Stream pour filtrer les livres dont le titre contient la chaîne de recherche
            ObservableList<Annonce> annoncesFiltres = annoncesObservableList.stream()
                    .filter(annonce -> annonce.getTitre().contains(recherche))
                    .collect(Collectors.toCollection(FXCollections::observableArrayList));
            listView.setItems(annoncesFiltres);
        }
    }
        public void switchToList(ActionEvent event) throws IOException{
    Parent root = FXMLLoader.load(getClass().getResource("../gui/AjouterAvis.fxml"));
                        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        Scene scene = new Scene(root);
                        primaryStage.setScene(scene);
                        primaryStage.show();}

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
   
 
  
}
    
  // private void avis(ActionEvent event) throws IOException {
    //    ServiceAnnonce.supprimer(gui2.ann.getId());
             // ConfirmeSupp.getScene().getWindow().hide();
             // Parent root = FXMLLoader.load(getClass().getResource("ListeAnnonce.fxml"));
             //   Stage mainStage = new Stage();
             //   Scene scene = new Scene(root);
             //   mainStage.setScene(scene);
               // mainStage.show();

  //  }
   

    
    
     
    
    
     
       
    /**
     *
   
     */
  //  @FXML
  //  public void affiche(ActionEvent event) {
    //      List<Annonce> annonceList = ServiceAnnonce.getAll();
     //   annonceListView.setItems(FXCollections.observableArrayList(annonceList));
       //        }
     
    
