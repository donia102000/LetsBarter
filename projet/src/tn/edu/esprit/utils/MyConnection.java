
package tn.esprit.utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Donia
 */
public class MyConnection {
   
          final static String URL ="jdbc:mysql://127.0.0.1:3306/projet";
          final static String LOGIN ="root";
          final static String PWD ="";
          static MyConnection instance = null;
          private Connection cnx ;
          
          private MyConnection() {
          
              try {
                  cnx = DriverManager.getConnection(URL,LOGIN, PWD);
                  System.out.println("connexion etablie");
              } catch (SQLException ex) {
                  System.out.println("pas de connexion");
                  
              }
          
         }
          
          public static MyConnection getInstance(){
          if(instance==null)
              instance = new  MyConnection();
          return instance;
          }
          
          public Connection getConnection() {
        return cnx;
    }
          
          
}
