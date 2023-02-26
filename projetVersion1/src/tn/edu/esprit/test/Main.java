/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.test;


import java.sql.SQLException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



import tn.edu.esprit.entities.HistoriqueConnexion;
import tn.edu.esprit.services.HistoriqueConnexionService;

/**
 *
 * @author Donia
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ParseException {
        HistoriqueConnexionService his =new HistoriqueConnexionService();
        Date currentDate = new Date();
        System.out.println(currentDate);
        //String dateString = "25/02/2022";
       SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); // format de date
      //Date date = null;
      //try {
        // date = dateFormat.parse(dateString); // conversion de la chaîne de caractères en date
      //} catch (ParseException e) {
       //  e.printStackTrace();
      //}
      
        //HistoriqueConnexion p = new HistoriqueConnexion(new java.sql.Date(currentDate.getTime()),"mac",22, 1);
        //his.ajouter(p);
        System.out.println(his.getAllDate());
        System.out.println(his.getDateParUtilisateurEtDateActuel(new java.sql.Date(currentDate.getTime()), 22, "client"));
        System.out.println(( his.getDateParUtilisateurEtDateActuel(new java.sql.Date(currentDate.getTime()), 22, "client")).getNbConnexion());
    }
    
}
