/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.awt.AWTException;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import tn.edu.esprit.entities.Annonce;
import tn.edu.esprit.entities.Favoris;
import tn.edu.esprit.services.IServiceFavoris;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class AnnoncePFXMLController implements Initializable {
    @FXML
    private Button btn_ajt;

    @FXML
    private Button btn_prop;
    private TextArea texta;
    private Stage stage;
    private Scene scene;
    private Parent root;

    
    @FXML
    private Label lb2;

    @FXML
    private Label lb3;

    @FXML
    private Label lb4;

    @FXML
    private Label lb1;

    private IServiceFavoris serviceFavoris;
    /**
     * Initializes the controller class.
     */
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
        @FXML
    void AjouterFavoris(ActionEvent event) throws IOException {
            try {
                
                IServiceFavoris sp = new IServiceFavoris();
                  Favoris f = new Favoris (lb1.getText(),lb2.getText(),lb3.getText(),lb4.getText());
        sp.ajouterAnnonceFavoris(f);
         Alert a5 = new Alert(Alert.AlertType.INFORMATION, "Annonce added !", ButtonType.OK);
                a5.showAndWait();
            } catch (Exception e) {
                 Alert a = new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK);
                a.showAndWait();
            }
       
        
        
    }
    
    
    @FXML
    void AjouterProposition() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("PropositionAchatFXML.fxml"));
        Stage mainStage = new Stage();
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    
    }

      @FXML
    void capture(ActionEvent event) throws AWTException, IOException {
        
          try {
                    Alert a5 = new Alert(Alert.AlertType.INFORMATION, "Capturée avec succées !", ButtonType.OK);
                a5.showAndWait();
                 Rectangle screen = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
          BufferedImage screenCapture = new Robot().createScreenCapture(screen);
          Graphics2D graphic = screenCapture.createGraphics();
         ImageIO.write(screenCapture, "PNG", new File ("C:\\Users\\Admin\\Documents\\NetBeansProjects\\Pidev\\src\\images\\capture.png"));
          
              
          } catch (Exception e) {
              Alert a5 = new Alert(Alert.AlertType.INFORMATION, "Failed !", ButtonType.OK);
                a5.showAndWait();
          }

    }

    
}
