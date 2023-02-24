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
import tn.edu.esprit.entities.Offre;
import tn.edu.esprit.entities.Organisateur;
import tn.edu.esprit.services.InscriptionService;
import tn.edu.esprit.services.LoginService;
import tn.edu.esprit.services.OffreService;
import tn.edu.esprit.services.OrganisateurService;
import tn.edu.esprit.verification.VerifierChamps;
import tn.esprit.utils.MyConnection;


/**
 *
 * @author Donia
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        
        
       //Client cl =new Client("fati", "bargohhhhhhhhhui", "huuj@hbhb.com", "motDePasse", "homme", "dateDeNaissance", 20508874, "adresse", "client", 10);
        //System.out.println(cl);
        //Organisateur org = new Organisateur(25,"amal", "prenomUtilisateur", "email", "motDePasse", "genre", "dateDeNaissance", 0, "adresse", "role", 124789);
       MyConnection.getInstance();
       
    
       InscriptionService inscr = new InscriptionService();
        OrganisateurService ser = new OrganisateurService();
        //ser.modifierUtilisateur(org);
        //ser.supprimerUtilisateur(org.getIdUtilisateur());
       //inscr.inscrire(cl);
       //ser.ajouterUtilisateur(org);
        /*System.out.println(ser.chercherUtilisateurParId(24));
        System.out.println(ser.chercherUtilisateurParCin(0));
        ser.afficherToutUtilisateur().stream().forEach(x->System.out.println(x));
        LoginService login = new LoginService();
        System.out.println(   login.findUserbyEmail("hhhhssksyzszdjf","motDePasse"));
        System.out.println("///////////////////////");
        System.out.println(login.findUserbyEmail("huuj@hbhb.com","motDePasse"));
        String mdp ="20509980";
        String c="45888881258";
        System.out.println(VerifierChamps.isValidPassword(mdp));
        System.out.println(VerifierChamps.isEmailAdress(mdp));
        System.out.println(VerifierChamps.stringTest(mdp));
         System.out.println("hhhhhhhhhh"+VerifierChamps.isTelephoneValide(c));
        System.out.println("ggggggggggggg");
         System.out.println(inscr.chercherUtilisateurParCin(78459645,"gggg@hhhh.ffggggggggggggggg"));*/
        
        OffreService serv =new OffreService();
        Offre o = new Offre(24,22, "21/04/2020", "25/10/2023", 28);
        serv.ajouterOffre(o);
        //serv.supprimerOffre(3);
        

    }
    
    

   
    
}
