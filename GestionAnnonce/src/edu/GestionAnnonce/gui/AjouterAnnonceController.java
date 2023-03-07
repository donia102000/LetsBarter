/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.GestionAnnonce.gui;

import edu.GestionAnnonce.entities.Annonce;
import edu.GestionAnnonce.services.ServiceAnnonce;
import static edu.GestionAnnonce.tests.MainClass.main;
import edu.GestionAnnonce.utils.DataSource;
import edu.GestionAnnonce.utils.Utilisation;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import static jdk.nashorn.internal.objects.NativeString.length;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javax.imageio.ImageIO;


/**
 * FXML Controller class
 *
 * @author NOURHENE
 */
public class AjouterAnnonceController implements Initializable {
    
    @FXML
    private TextField tfTitre;
    @FXML
    private TextField tfCategorie;
    @FXML
     private TextField tfSousc;
    @FXML
      private TextArea  tfDesc;
    @FXML
    private TextField  tfValeur;
    
    @FXML
    private TextField tfVideo;
    @FXML
    private TextField tfAdresse;
    @FXML
    private TextField tfTel;
     @FXML
    private Button addimage;
      @FXML
    private Label file_path;
      @FXML
    private ImageView imgpreview;
        @FXML
    private AnchorPane main;
        @FXML
        private String tfImage;
        @FXML
        private File selectedImageFile;
   @FXML
private Pane imageContainer;
@FXML
private Button btn;
  @FXML
    private ImageView imageView;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
  
     ServiceAnnonce pc =new ServiceAnnonce();
    private ServiceAnnonce serviceAnnonce;
     public AjouterAnnonceController(ServiceAnnonce serviceAnnonce) {
        this.serviceAnnonce = serviceAnnonce;
    }
     public AjouterAnnonceController() {
        // Constructeur par défaut
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
      tfTel.addEventFilter(KeyEvent.KEY_TYPED, event -> {
            if (!event.getCharacter().matches("[0-9]") || tfTel.getText().length() >= 8) {
                event.consume();
            }
        });
      tfValeur.addEventFilter(KeyEvent.KEY_TYPED, event -> {
    if (!event.getCharacter().matches("[0-9]") || tfValeur.getText().equals("0")) {
        event.consume();
    }
});
      
      
       

   btn.setOnAction((ActionEvent event) -> {
    String titre = tfTitre.getText();
    String categorie = tfCategorie.getText();
    String souscategorie = tfSousc.getText();
    String description = tfDesc.getText();
    String valeurobjet = tfValeur.getText();
    String imagePath = imageView.getImage().impl_getUrl().replace("/", "");
  
    String adresse = tfAdresse.getText();
    String tel = tfTel.getText();
     if (titre.isEmpty()|categorie.isEmpty()|souscategorie.isEmpty()|description.isEmpty()|valeurobjet.isEmpty()|imagePath.isEmpty()|adresse.isEmpty()|tel.isEmpty()) {
        Alert a = new Alert(Alert.AlertType.ERROR, "Tous les champs doivent être remplis, s'il vous plaît!", ButtonType.OK);
        a.showAndWait();
        return;
    }
      if (tel.length() != 8) {
        Alert a = new Alert(Alert.AlertType.ERROR, "Le numéro de téléphone est invalide", ButtonType.OK);
        a.showAndWait();
        return;
    }
     
    Annonce annonce = new Annonce(titre, categorie, souscategorie, description, valeurobjet, imagePath, adresse, tel);
    pc.ajouter(annonce);
      System.out.println("ajout avec succee");
       Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Ajout Annonce ");
            alert.setHeaderText(null);
                alert.setContentText("Annonce ajouté !!");
            alert.showAndWait();
            tfTel.clear();
      tfSousc.clear();
      tfValeur.clear();
     tfTitre.clear();

   
      tfDesc.clear();
        tfAdresse.clear();
       tfCategorie.clear();
});}
   @FXML
     void onAddImage(ActionEvent event) {
        File file = ImageChooserUtil.chooseImage();
        if (file != null) {
            Image image = new Image("file:" + file.getPath());
            imageView.setImage(image);
        }
    }
    
      
}  
 


    
    

    /**
     *
     * @param event
     * @throws java.io.IOException
     */
  //  @FXML
//public  void AjouterAnnonce(ActionEvent event) throws IOException {
 
  //if ( (tfTitre.getText().isEmpty() | tfCategorie.getText().isEmpty()) |tfSousc.getText().isEmpty() |tfDesc.getText().isEmpty() |tfValeur.getText().isEmpty()| tfVideo.getText().isEmpty() | tfAdresse.getText().isEmpty() | tfTel.getText().isEmpty() ) {
   //   Alert a = new Alert(Alert.AlertType.ERROR, "tout les champs doivent etre remplis SVP!!", ButtonType.OK);
   //   a.showAndWait();
 // }
  
  
  
          
 //  else  {
   //   ServiceAnnonce pc =new ServiceAnnonce();
   //   Annonce p = new Annonce(tfTitre.getText(),tfCategorie.getText(),tfSousc.getText(), tfDesc.getText(),tfValeur.getText(), file_path.getText(), tfVideo.getText(), tfAdresse.getText(), tfTel.getText());
      //     sp.ajouter(new Annonce("echange","electro","vbn","bien",58,"fr","fghjvk","ghsjk",85));
    //  System.out.println(Utilisation.a=p);   
    //  pc.ajouter(p);
    //  System.out.println("ajout avec succee");
    //   Alert alert = new Alert(Alert.AlertType.INFORMATION);
      //      alert.setTitle("Ajout Annonce ");
        //    alert.setHeaderText(null);
          //      alert.setContentText("Annonce ajouté !!");
    //        alert.showAndWait();
 // }
 



    /**
     *
     * @param event
     */
   // @FXML
  //  public void InsertImage(ActionEvent event) {
        
   //          FileChooser open = new FileChooser();
   //     Stage stage =(Stage)main.getScene().getWindow();
   //     File file = open.showOpenDialog(stage);
    //    if(file != null){
      //      String path = file.getAbsolutePath();
       //      path = path.replace("\\", "\\\\");

//            file_path.setText(path);
  //          Image image = new Image(file.toURI().toString(), 110,110,false,true);
    //        imgpreview.setImage(image);
      //  }else{
        //    System.out.println("No FILE EXIST");
        //}
    //}
//@FXML
  //  private void uploadImage() {
   //     FileChooser fileChooser = new FileChooser();
   //     fileChooser.setTitle("Select Product Image");
   //     fileChooser.getExtensionFilters().addAll(
     //           new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
   //     selectedImageFile = fileChooser.showOpenDialog(imgpreview.getScene().getWindow());
   //     if (selectedImageFile != null) {
   //         try {
            // Convertir l'image en tableau de bytes
     //      byte[] imageBytes = Files.readAllBytes(selectedImageFile.toPath());

            // Enregistrer l'image dans la base de données
       //     ImageModel imageModel = new ImageModel();
         //   imageModel.setImageBytes(imageBytes);
        //    imageModel.save();

            // Mettre à jour la vue avec la nouvelle image
       //     Image image = new Image(new ByteArrayInputStream(imageBytes));
       //     ImageView imageView = new ImageView(image);
         //   imageView.setFitWidth(100);
         //   imageView.setFitHeight(100);
         //   imageContainer.getChildren().add(imageView);

     //   } catch (IOException ex) {
       //     ex.printStackTrace();
     //   }
   // }
  //  }
    
  //    public void switchToList(ActionEvent event) throws IOException{
    //Parent root = FXMLLoader.load(getClass().getResource("../gui/ListeAnnonce.fxml"));
     //                   Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
       //                 Scene scene = new Scene(root);
         //               primaryStage.setScene(scene);
           //             primaryStage.show();}
//}
