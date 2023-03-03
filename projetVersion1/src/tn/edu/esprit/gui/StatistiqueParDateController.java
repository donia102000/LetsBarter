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
import java.io.FileOutputStream;
import com.itextpdf.text.Document;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.SnapshotParameters;
import javafx.scene.chart.BarChart;
import javafx.scene.image.WritableImage;
import java.io.FileOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;

import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import java.time.LocalDateTime;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.SnapshotParameters;
import javafx.scene.chart.BarChart;
import javafx.scene.image.WritableImage;


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
    private Button genererPdf; 
    
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
     public void generatePdfFromBarChart(BarChart<String, Number> barChart) {
    // Capture le graphique à barres sous forme d'image
    WritableImage chartImage = barChart.snapshot(new SnapshotParameters(), null);

    // Convertit l'image JavaFX en image iText
    com.itextpdf.text.Image pdfImage = null;
    try {
        pdfImage = com.itextpdf.text.Image.getInstance(SwingFXUtils.fromFXImage(chartImage, null), null);
    } catch (Exception e) {
        e.printStackTrace();
    }

    // Crée un document PDF et l'ajoute à une page
    Document pdfDoc = null;
    LocalDateTime currentDateTime = LocalDateTime.now();
        String fileName = String.format("C:\\Users\\Donia\\Documents\\NetBeansProjects\\projetVersion1\\src\\tn\\edu\\esprit\\PDF\\BarChart-%04d%02d%02d-%02d%02d%02d.pdf",
            currentDateTime.getYear(), currentDateTime.getMonthValue(), currentDateTime.getDayOfMonth(),
            currentDateTime.getHour(), currentDateTime.getMinute(), currentDateTime.getSecond());
try {
        Rectangle pageSize = new Rectangle((float)chartImage.getWidth()+100,(float)chartImage.getHeight()+100);
        pdfDoc = new Document(pageSize);
        PdfWriter writer =PdfWriter.getInstance(pdfDoc, new FileOutputStream(fileName));
        PdfHeaderFooter event = new PdfHeaderFooter();
         writer.setPageEvent(event);
        
        pdfDoc.open();
        pdfDoc.add(pdfImage);
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if (pdfDoc != null) {
            pdfDoc.close();
        }
    }
}
     public class PdfHeaderFooter extends PdfPageEventHelper {

    private Font font = new Font(Font.FontFamily.TIMES_ROMAN, 20, Font.NORMAL);

    @Override
    public void onEndPage(PdfWriter writer, Document document) {
        PdfContentByte cb = writer.getDirectContent();

        // Add header
        Phrase header = new Phrase("Let's Barter", font);
        ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, header, document.leftMargin(), document.top() + 10, 0);
        LocalDateTime currentDateTime = LocalDateTime.now();
        // Add footer
        Phrase footer = new Phrase("Page " + writer.getPageNumber(), font);
        ColumnText.showTextAligned(cb, Element.ALIGN_CENTER, footer, (document.right() - document.left()) / 2 + document.leftMargin(), document.bottom() - 10, 0);
        Phrase footer1 = new Phrase("Date de génération : " +currentDateTime, font);
        ColumnText.showTextAligned(cb, Element.ALIGN_RIGHT, footer1, document.right(), document.bottom() + 10, 0);
    }
}
    public void genererPdf(){
        
        generatePdfFromBarChart(barChart);
        
    }
     
}












