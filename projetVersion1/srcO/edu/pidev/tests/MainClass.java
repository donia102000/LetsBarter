/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pidev.tests;

import edu.pidev.entities.Categorie;
import edu.pidev.entities.Reclamation;
import edu.pidev.serices.ServiceCategorie;
import edu.pidev.serices.Servicereclamation;
import edu.pidev.utils.DataSource;

/** 
 * 
 * @author Dell
 */
public class MainClass { 
    
     public static void main(String[] args) {
        
         DataSource.getInstance(); 
  ServiceCategorie sc  = new ServiceCategorie(); 
          Categorie c1 = new Categorie ("vehicule " ) ;    
//        Categorie c2 = new Categorie ("nourriture " , "consommable") ; 
////        Categorie c3 = new Categorie ("éléctroménager " , "maison") ; 
////        Categorie c4= new Categorie (" plantes " , "dcoratif") ; 
//        Categorie c5= new Categorie ("fournitures scolaires " ) ;    
////  Categorie c6 = new Categorie ("informatique  " , "materiels  ") ;   
//
//        Categorie c6= new Categorie ("maquillage" ) ;   
//             sc.ajouter(c1);  
//        sc.ajouter(c2);
//        sc.ajouter(c3);
//        sc.ajouter(c4);
//        sc.ajouter(c5);  
//        sc.ajouter(c6); 
//////        sc.modifier(c5); 
//             sc.supprimer(c5.id); 
//sc.ajouter(c5);
//        c5.setNomCategorie("Catégorie liée à math et aux nouvelles technologies"); 
//
//sc.modifier(c5);  
////////sc.ajouter(c6); 
//////                sc.supprimer(c1.id);   
//  sc.supprimer(c1.);   
//////       sc.supprimer(c1.id); 
////        sc.supprimer(c2.id); 
////         sc.supprimer(c2.id);  
                                                
//////         
     Servicereclamation r   = new Servicereclamation();
         Reclamation r77  =new Reclamation ("le corp de la reclamation ","rembourssement ", "voiture 207 " ,27330975,"aaaayaryouma", "etatdelareclamation") ;   
////            Reclamation r2  =new Reclamation ("lyoum ","premiere reclamation","le corp de la reclamation ","rembourssement ", "voiture 207 " , "ayariOumaima",52995971,"aaaayaryouma", "etatdelareclamation") ;   
//            Reclamation r3  =new Reclamation ("2030 "," nn reclamation","le corp de la reclamation ","rembourssement ", "voiture 207 " , "ayariOumaima",52995971,"aaaayaryouma", "etatdelareclamation") ;   
//
//     
//    
////        Reclamation r1 = new Reclamation("Titre réclamation 1", "Contenu réclamation 1");
 //r.ajouter(r1,"oumaima.ayari@esprit.tn") ;   
//// r.ajouter(r2) ;  
    r.ajouter(r77,"bonjour") ;     
//
////r.supprimerReclamation(5);   
//r.modifierReclamation(r3,"admin");  
//

     }}