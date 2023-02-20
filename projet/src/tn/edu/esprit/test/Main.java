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
import tn.edu.esprit.services.InscriptionService;
import tn.edu.esprit.services.LoginService;
import tn.esprit.utils.MyConnection;
//comment

/**
 *
 * @author Donia
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        
        
       Client cl =new Client("fati", "bargohhhhhhhhhui", "huuj@hbhb.com", "motDePasse", "homme", "dateDeNaissance", 20508874, "adresse", "client", 10);
        //System.out.println(cl);
       MyConnection.getInstance();
       
    
       InscriptionService inscr = new InscriptionService();
       inscr.inscrire(cl);
        LoginService login = new LoginService();
        System.out.println(   login.findUserbyEmail("hhhhssksyzszdjf","motDePasse"));
        System.out.println("///////////////////////");
        System.out.println(login.findUserbyEmail("huuj@hbhb.com","motDePasse"));

       


    }
    
    

   
    
}
