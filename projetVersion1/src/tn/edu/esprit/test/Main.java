/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.test;


import java.sql.SQLException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import org.mindrot.jbcrypt.BCrypt;



import tn.edu.esprit.entities.HistoriqueConnexion;
import tn.edu.esprit.entities.Utilisateur;
import tn.edu.esprit.services.HistoriqueConnexionService;
import tn.edu.esprit.services.UtilisateurService;

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
       Utilisateur u =new Utilisateur("nomUtilisateur", "prenomUtilisateur", "donia", "helloo", "genre", 0, "adresse", "admin", 0);
        UtilisateurService ser = new UtilisateurService();
      //ser.ajouter(u);
       // System.out.println(ser.findUserbyEmail("donia", "hello"));
        //System.out.println(BCrypt.checkpw("motDePasse","$2a$12$k/fORz0x589nnsXa/oRVy.Jj/Ar8k18iH34ga3itJK1RrKsr7ARZy"));
        ser.modifierMdp(u);
        System.out.println(ser.findUserbyEmail("donia", "hello")+"kkkkkkk");
    }
    
}
