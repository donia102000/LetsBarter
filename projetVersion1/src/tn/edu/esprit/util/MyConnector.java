/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Donia
 */
public class MyConnector {
   final static String URL ="jdbc:mysql://127.0.0.1:3306/projet";
          final static String LOGIN ="root";
          final static String PWD ="";
          static MyConnector instance = null;
          private Connection cnx ;
          
          private MyConnector() {
          
              try {
                  cnx = DriverManager.getConnection(URL,LOGIN,PWD);
                  System.out.println("connexion etablie");
              } catch (SQLException ex) {
                  System.out.println(ex.getMessage());
                  
              }
          
         }
          
          public static MyConnector getInstance(){
          if(instance==null)
              instance = new  MyConnector();
          return instance;
          }
          
          public Connection getConnection() {
        return cnx;
    }
           
}
