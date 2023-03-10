/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.util;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Admin
 */
public class Connexion {
    
    private static Connexion instance;
    
    private Connection cnx;
    
    private final String USER = "root";
    private final String PASSWORD = "";
    private final String URL = "jdbc:mysql://localhost:3306/projet";
    
        private Connexion () {
             
            try {
                Class.forName("com.mysql.jdbc.Driver");
                 cnx = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("DB Connected !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
    
        
            public static Connexion getInstance() {
        if(instance == null)
            instance = new Connexion();
        return instance;
    }
            
               public Connection getCnx() {
        return cnx;
    }
    
}
