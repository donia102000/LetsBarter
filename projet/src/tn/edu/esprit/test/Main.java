/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.test;

import java.sql.Date;
import java.sql.SQLException;
import tn.edu.esprit.entities.Admin;
import tn.edu.esprit.entities.Client;
import tn.edu.esprit.entities.Organisateur;
import tn.edu.esprit.services.InscriptionService;
import tn.edu.esprit.services.LoginService;
import tn.edu.esprit.services.OrganisateurService;
import tn.esprit.utils.MyConnection;


/**
 *
 * @author Donia
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        
        
       //Client cl =new Client("fati", "bargohhhhhhhhhui", "huuj@hbhb.com", "motDePasse", "homme", "dateDeNaissance", 20508874, "adresse", "client", 10);
        //System.out.println(cl);
        Organisateur org = new Organisateur(25,"sarra", "prenomUtilisateur", "email", "motDePasse", "genre", "dateDeNaissance", 0, "adresse", "role", 124789);
       MyConnection.getInstance();
       
    
       InscriptionService inscr = new InscriptionService();
        OrganisateurService ser = new OrganisateurService();
        //ser.modifierUtilisateur(org);
        //ser.supprimerUtilisateur(org.getIdUtilisateur());
       //inscr.inscrire(cl);
        System.out.println(ser.chercherUtilisateurParId(24));
        System.out.println(ser.chercherUtilisateurParCin(0));
        ser.afficherToutUtilisateur().stream().forEach(x->System.out.println(x));
        LoginService login = new LoginService();
        System.out.println(   login.findUserbyEmail("hhhhssksyzszdjf","motDePasse"));
        System.out.println("///////////////////////");
        System.out.println(login.findUserbyEmail("huuj@hbhb.com","motDePasse"));

       


    }
    
    

   
    
}
