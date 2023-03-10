/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;
import java.util.List;
import tn.edu.esprit.entities.Annonce;
import tn.edu.esprit.entities.Avis;
import tn.edu.esprit.services.ServiceAnnonce;
import tn.edu.esprit.services.ServiceAvis;
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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import static java.lang.System.in;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author NOURHENE
 */
public class ListeAnnonceControllerController1 implements Initializable {
    @FXML private ImageView likeIcon;
    @FXML private ImageView dislikeButton;
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
    private TextArea descriptionField;
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
   
  private Annonce selectedAnnonce;
   @FXML private ImageView imageView;

    private ObservableList<Annonce> annoncesObservableList = FXCollections.observableArrayList();
  
        @FXML
    private Button buttonLike;

    @FXML
    private Button buttonDislike;
  
            private ServiceAnnonce annonceService;

     Image image;
      String url = null;
      //private File selectedFile;
      @FXML
      private Button parcourirButton;
      @FXML
      private Button btn_sort;

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
            
          String[] e=item.getImage().split("/");
           System.out.println(item.getImage());
          String fileName = "/" + e[e.length - 2] + "/" + e[e.length - 1];
          
           
          Image image=new Image(fileName);
           ImageView imageView = new ImageView();
            imageView.setImage(image);
            imageView.setFitHeight(250);
            imageView.setFitWidth(400);
    Text text=new Text(item.getAdresse());
      text.setStyle("-fx-font-weight: bold; -fx-fill:  #8B4513;"); // Définir un style pour le Text
         text.setFont(Font.font("Arial", FontWeight.BOLD, 20)); 
    Text text1=new Text(item.getTitre());
      text1.setStyle("-fx-font-weight: bold; -fx-fill:  #8B4513;"); // Définir un style pour le Text
         text1.setFont(Font.font("Arial", FontWeight.BOLD, 20)); 
    Text text2=new Text(item.getCategorie());
      text2.setStyle("-fx-font-weight: bold; -fx-fill:  #8B4513;"); // Définir un style pour le Text
         text2.setFont(Font.font("Arial", FontWeight.BOLD, 20)); 
    Text text3=new Text(item.getSouscategorie());
      text3.setStyle("-fx-font-weight: bold; -fx-fill:  #8B4513;"); // Définir un style pour le Text
         text.setFont(Font.font("Arial", FontWeight.BOLD, 20)); 
   Text text4=new Text(item.getTel());
     text4.setStyle("-fx-font-weight: bold; -fx-fill:  #8B4513;"); // Définir un style pour le Text
         text4.setFont(Font.font("Arial", FontWeight.BOLD, 20)); 
            VBox vbox = new VBox(imageView,text,text1,text2,text3,text4);
          
          
             vbox.setAlignment(Pos.CENTER);
            setGraphic(vbox);
            
        }
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
             listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                titreField.setText(newValue.getTitre());
                categorieField.setText(newValue.getCategorie());
                sousField.setText(newValue.getSouscategorie());
                descriptionField.setText(newValue.getDescription());
                valeurField.setText(newValue.getValeurobjet());
              
        
        imageField.setText(newValue.getImage());
                
              
                 adresseField.setText(newValue.getAdresse());
                telField.setText(newValue.getTel());
                 
}});
             parcourirButton.setOnAction(event -> {
    // Ouvrir une boîte de dialogue de sélection de fichiers
    
     File file = ImageChooserUtil.chooseImage();
        if (file != null) {
            Image image = new Image("file:" + file.getPath());
          
          
             Annonce produit = listView.getSelectionModel().getSelectedItem();
            imageView.setImage(image);
            produit.setImage(file.getAbsolutePath());
       imageField.setText(file.getAbsolutePath());
        }
    }
    );
             btn_sort.setOnAction(new EventHandler<ActionEvent>() {
        
         
            @Override
            public void handle(ActionEvent event) {
           
            listView.getItems().sort(Comparator.comparing(Annonce::getTitre));
              listView.getSelectionModel().clearSelection();
   
           }
        });
             
         updateButton.setOnAction(event -> {
        Annonce produit = listView.getSelectionModel().getSelectedItem();
        if (produit != null) {
            produit.setTitre((titreField.getText()));
              produit.setCategorie((categorieField.getText()));
                produit.setSouscategorie((sousField.getText()));
                  produit.setDescription((descriptionField.getText()));
           
                          produit.setAdresse((adresseField.getText()));
                        
                          produit.setTel((telField.getText()));
                          
                        //  System.out.println(imageField);
                       //    produit.setImage("file:"+(imageField.getText()).replace("/", ""));
                       produit.setImage(imageView.getImage().impl_getUrl());
                         //  System.out.println(imageField);
                           
                          
         ServiceAnnonce.modifier(produit);
            annoncesObservableList.set(listView.getSelectionModel().getSelectedIndex(), produit);
            listView.getSelectionModel().clearSelection();
           // String filePath = imageField.getText();
           // String filePathWithSlashes = filePath.replaceAll(" ", "/");
//String finalPath = "file:" + filePathWithSlashes;
    
  
             listView.refresh();
    //     String[] parts = selectedAnnonce.getImage().split("/");
    //    String fileName = parts[parts.length-2] + "/" + parts[parts.length-1];
    //  Image image = new Image(getClass().getResource("/images/" + fileName).toExternalForm());
      
              
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
    //  public void Retour(ActionEvent event) throws IOException{
   // Parent root = FXMLLoader.load(getClass().getResource("../gui/ListeAnnonceController.fxml"));
     //                   Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
       //                 Scene scene = new Scene(root);
         //               primaryStage.setScene(scene);
           //             primaryStage.show();}
   
    @FXML
     void search (ActionEvent event){
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
      public void switchToR(ActionEvent event) throws IOException{
    Parent root = FXMLLoader.load(getClass().getResource("../gui/ListeAnnonceController.fxml"));
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
   
  @FXML
     void onAddImage(ActionEvent event) {
        File file = ImageChooserUtil.chooseImage();
        if (file != null) {
            Image image = new Image("file:" + file.getPath());
            imageView.setImage(image);
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
     
    
