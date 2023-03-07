/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.pidev.tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import javax.mail.MessagingException;
import tn.edu.pidev.entities.Annonce;
import tn.edu.pidev.entities.Favoris;
import tn.edu.pidev.entities.MessageAPI;
import tn.edu.pidev.entities.PropositionAchat;
import tn.edu.pidev.entities.PropositionTroc;
import tn.edu.pidev.services.IService;
import tn.edu.pidev.services.IServiceMail;
import tn.edu.pidev.services.IServicePropositionAchat;
import tn.edu.pidev.services.IServicePropositionTroc;
import tn.edu.pidev.services.IServices;

/**
 *
 * @author Admin
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, FileNotFoundException, IOException, MessagingException {
        
        
    
        
        /***********************FAVORIS****************/
            IService sp = new  IService ();
        Favoris f1 = new Favoris("Mac","Electro","hello","bardo");
        Favoris f2 = new Favoris("Peugeot 208","Moyen de transport","16 rue Andalous Bardo->Tunis"," Bonne état");
      //sp.supprimer(f2);
        //sp.ajouterAnnonceFavoris(f2);
        //sp.chercherFavorisparTitre("Mac");
        sp.getAll();
        
        /*********************PropositionTROC*************/
        IServicePropositionTroc spt = new IServicePropositionTroc();
       PropositionTroc T = new PropositionTroc(20,"mmm");
        //spt.ajouterPropositionTroc(T);
        //sp.chercherFavorisparTitre("xxx");
        //sp.getAll();
         
         
         /******************PropositionAchat***********/
         IServicePropositionAchat spa = new IServicePropositionAchat ();
        PropositionAchat p1 = new PropositionAchat("poooo","kkk",1234568,5555);
      //spa.ajouterPropositionAchat(p1);
      
    /***********Message*************/
    
    IServiceMail is = new IServiceMail();
  
 
       
    }
    
}
