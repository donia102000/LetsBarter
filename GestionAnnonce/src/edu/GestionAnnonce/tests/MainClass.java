/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.GestionAnnonce.tests;

import edu.GestionAnnonce.entities.Annonce;
import edu.GestionAnnonce.entities.Avis;
import edu.GestionAnnonce.services.ServiceAnnonce;
import edu.GestionAnnonce.services.ServiceAvis;
import edu.GestionAnnonce.utils.Utilisation;
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author NOURHENE
 */
public class MainClass  extends Application{
    
  
    
    public static void main(String[] args) {
      //   Annonce m1 = new Annonce("troc","vehicule","voiture","en bon etat","55","fr","fghjk","ghjk","78");
        //    Annonce m2= new Annonce("echange","electro","vbn","bien",58,"fr","fghjvk","ghsjk",85);
                ServiceAnnonce sp = new ServiceAnnonce();
          //  sp.ajouter(new Annonce("echange","electro","vbn","bien","58","fr","fghjvk","ghsjk","85"));
        System.err.println(Utilisation.a);  
          ServiceAvis a1=new ServiceAvis();
       //  Avis a2=new Avis("28",1,1,28);
    //      a1.ajouter(a2);
     // sp.ajouter(m1);
      ServiceAnnonce ann1 = new ServiceAnnonce();
  //      System.out.println(ann1.chercherAnnonceId(m1));  
       //   sp.ajouter(m1);
  //   sp.supprimer(m1);
    //   sp.modifier(m1);
    
     }

    @Override
    public void start(Stage primaryStage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
    

