/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.tests;

import tn.edu.esprit.entities.Evenement;
import tn.edu.esprit.entities.Reservation;
import tn.edu.esprit.services.ServiceEvenement;
import tn.edu.esprit.services.ServiceReservation;

/**
 *
 * @author Ghazoua
 */
public class projet1 {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) {
       ServiceEvenement se = new ServiceEvenement();
       ServiceReservation sr = new ServiceReservation();
//       Evenement e1 = new Evenement("200","Event54","04/03/2023","Ariana","1200",1);
//       Evenement e2 = new Evenement("113","Ev24","04/03/2023","Ariana","1200",1);
//       Evenement e5 = new Evenement("110","Ev50","24/03/2023","Tunis","1000",1);
//       Evenement e6 = new Evenement("115","Ev68","26/03/2023","Ghazela","1100",1);
       Reservation r1 = new Reservation(5,1,1);
       Reservation r2 = new Reservation(7,6,1);
       Reservation r3 = new Reservation(1,2,8);
      // se.ajouter(e1);
      // se.supprimer(114);
      // System.out.println(se.afficher());
      // se.modifier(5, "Ev55","27/03/2023","Mateur",900); //l'ajout des attributs
     //  System.out.println(se.rechercher(113));
     //  sr.ajouter(r3);
     // sr.supprimer(10);
     // System.out.println(sr.afficherParEvenement(5));
      
        
    }
    
}
