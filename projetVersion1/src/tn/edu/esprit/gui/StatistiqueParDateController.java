/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tn.edu.esprit.services.HistoriqueConnexionService;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;


/**
 * FXML Controller class
 *
 * @author Donia
 */
public class StatistiqueParDateController implements Initializable {
      @FXML
    private Button btnmodif;

    @FXML
    private Button btnajouter;

    @FXML
    private Button lblAcceuil;

    @FXML
    private Button lbldeconnexion;

    @FXML
    private Button btnretour;

    @FXML
    private Button btnmodif1;

    @FXML
    private Button btnStatistiqueParDate;

    @FXML
    private Button btnmodif11;

    
    @FXML
    private BarChart<String, Number> barChart;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       /*ObservableList<String> dates = FXCollections.observableArrayList(
                "Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet");
        ObservableList<Integer> connexions = FXCollections.observableArrayList(
                100, 120, 90, 80, 150, 200, 175);*/
        /*List<Integer> connexions = new ArrayList<>();
        connexions.add(100);
        connexions.add(120);
        connexions.add(90);
        connexions.add(80);
        connexions.add(150);
        connexions.add(200);
        connexions.add(175);*/
        HistoriqueConnexionService historique= new HistoriqueConnexionService();
        List<String> dates = new ArrayList<>();
        List<Integer> nbreTotal = new ArrayList<>();
        
        try {
            dates =historique.getAllDate();
            System.out.println(dates);
                    
                    } catch (SQLException ex) {
            Logger.getLogger(StatistiqueParDateController.class.getName()).log(Level.SEVERE, null, ex);
        }
            dates.forEach(x->{
            try {
                //System.out.println(historique.getAllNbrePointParDate(x).stream().count());
              //  System.out.println(historique.getAllNbrePointParDate(x));
                nbreTotal.add((int)(historique.getAllNbrePointParDate(x).stream().reduce(0, (a, b) -> a + b)));
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        });
        
        System.out.println(nbreTotal);
    // Création des axes
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();

        // Ajout des axes au graphique
        barChart.setAnimated(false);
        barChart.setTitle("Nombre total de connexions par date");
        barChart.getXAxis().setLabel("Date");
        barChart.getYAxis().setLabel("Nombre total de connexions");
        barChart.getData().clear();

        // Ajout des données au graphique
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Nombre total de connexions");
        for (int i = 0; i < dates.size(); i++) {
            series.getData().add(new XYChart.Data<>(dates.get(i), nbreTotal.get(i)));
        }
        barChart.getData().add(series);
    
}
    public void switchToAjouterOrganisateur(ActionEvent event) throws IOException{
    Parent root = FXMLLoader.load(getClass().getResource("../gui/AjouterOrganisateurFXML.fxml"));
                        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        Scene scene = new Scene(root);
                        primaryStage.setScene(scene);
                        primaryStage.show();}
    
    public void switchToModifSuppOrganisateur(ActionEvent event) throws IOException{
    Parent root = FXMLLoader.load(getClass().getResource("../gui/ModifierOrganisateurFXML.fxml"));
                        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        Scene scene = new Scene(root);
                        primaryStage.setScene(scene);
                        primaryStage.show();}
    
    public void deconnecter(ActionEvent event) throws IOException{
    Parent root = FXMLLoader.load(getClass().getResource("../gui/LoginFXML.fxml"));
                        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        Scene scene = new Scene(root);
                        primaryStage.setScene(scene);
                        primaryStage.show();
    
    }
     public void SwitchToListeOrg(ActionEvent event) throws IOException{
    Parent root = FXMLLoader.load(getClass().getResource("../gui/AdminAcceuiFXML.fxml"));
                        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        Scene scene = new Scene(root);
                        primaryStage.setScene(scene);
                        primaryStage.show();
    
    }
     public void SwitchToStatisqueParDate(ActionEvent event) throws IOException{
    Parent root = FXMLLoader.load(getClass().getResource("../gui/StatistiqueParDate.fxml"));
                        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        Scene scene = new Scene(root);
                        primaryStage.setScene(scene);
                        primaryStage.show();
    
}
}
