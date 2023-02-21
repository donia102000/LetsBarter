/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev;

import pidev.entities.Evenement;
import pidev.entities.Reservation;
import pidev.services.ServiceEvenement;
import pidev.services.ServiceReservation;



/**
 *
 * @author Ghazoua
 */
public class PiDev {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       ServiceEvenement se = new ServiceEvenement();
       ServiceReservation sr = new ServiceReservation();
       Evenement e1 = new Evenement("Ev1","04/03/2023","Ariana",1200,1);
       Evenement e2 = new Evenement("Ev2","04/03/2023","Ariana",1200,1);
       Evenement e5 = new Evenement("Ev5","24/03/2023","Tunis",1000);
       Evenement e6 = new Evenement("Ev6","26/03/2023","Ghazela",1100,1);
       Reservation r1 = new Reservation(2);
       Reservation r2 = new Reservation(5);
       Reservation r3 = new Reservation(10);
      // se.ajouter(e5);
      // se.supprimer(4);
      // System.out.println(se.afficher());
      // se.modifier(5, "Ev55","27/03/2023","Mateur",900); //l'ajout des attributs
      // System.out.println(se.rechercher(5));
      // sr.ajouter(r3);
      // sr.supprimer(3);
      // sr.modifier(2,10);
      // System.out.println(sr.afficher());
      // System.out.println(sr.rechercher(2));
      
        
    }
    
}
