/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.services;

import tn.edu.esprit.entities.Categorie;
import tn.edu.esprit.util.MyConnector;
import java.sql.Connection; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;  

/**
 *
 * @author Dell 
 */
    public class ServiceCategorie implements  IService <Categorie > {  


        Connection cnx;

        public ServiceCategorie(){

        cnx = MyConnector.getInstance().getConnection();
        }
        @Override
        public void ajouter(Categorie c) {
            try {
                String req = "INSERT INTO `categorie` (`nomCategorie`) VALUES ('" + c.getNomCategorie() + "')";  
                Statement st = cnx.createStatement();
                st.executeUpdate(req);
                System.out.println("categorie  creer!");
            } catch (SQLException ex) { 
                System.out.println(ex.getMessage());
            }
        }   


        @Override
            public void modifier(Categorie c) {

                  try {
                            String req1 = "SELECT id FROM `categorie` WHERE `NomCategorie`='" + c.getNomCategorie() + "'";
                         Statement st = cnx.createStatement();
                         ResultSet rs = st.executeQuery(req1);
                         if (rs.next()) {
                             int id = rs.getInt("id");

                                     String req = "UPDATE `categorie` SET `nomCategorie` = '" + c.getNomCategorie() +
                                          "' WHERE `id` = " +id;
                                     st.executeUpdate(req);
                                     System.out.println("Categorie modifiée !");
                         } 
                         else {
                             System.out.println("categorie on non trouvée !");
                         }
                 } catch (SQLException ex) { 
         System.out.println(ex.getMessage());
   } } 

// public void supprimer(int id ) { 
    //        try {
    //            String req = "DELETE FROM `categorie` WHERE id = " + id ;
    //            Statement st = cnx.createStatement();
    //            st.executeUpdate(req);
    //            System.out.println("categorie deleted !");
    //        } catch (SQLException ex) {
    //            System.out.println(ex.getMessage());
    //        } 


        public void supprimer(Categorie c) {
            try {
               String req1 = "SELECT id FROM `categorie` WHERE `NomCategorie`='" + c.getNomCategorie() + "'";
               Statement st = cnx.createStatement();
               ResultSet rs = st.executeQuery(req1);
               if (rs.next()) {
                   int id = rs.getInt("id");
                String req = "DELETE FROM `categorie` WHERE `id` = "+id;
                st.executeUpdate(req);             
                 System.out.println("Categorie supprimée !");
               }
               else {
                     System.out.println("categorie  non trouvée !");
                 }
            } catch (SQLException ex) { 
                System.out.println(ex.getMessage());
            }
        }








        
        public Categorie trouverParId(int id) { 

              Categorie categorie = null;
            try {
                String req = "SELECT * FROM `categorie` WHERE `id` = " + id;
                Statement st = cnx.createStatement();
                ResultSet rs = st.executeQuery(req);
                if (rs.next()) {
                    categorie = new Categorie(rs.getInt("id"), rs.getString("nomCategorie") ) ; 
                }
            } catch (SQLException ex) { 
                System.out.println(ex.getMessage());
            }
            return categorie;
        }  


        public List<Categorie> trouverTous() {

            List<Categorie> categories = new ArrayList<>();
            try { 
                String req = "SELECT * FROM `categorie`";
                Statement st = cnx.createStatement();
                ResultSet rs = st.executeQuery(req);
                while (rs.next()) {
                    Categorie categorie = new Categorie(rs.getInt("id"), rs.getString("nomCategorie")); 

                    categories.add(categorie);
                }
            } catch (SQLException ex) { 
                System.out.println(ex.getMessage());
            }
            return categories;
        }

    @Override
    public void supprimer(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Categorie> getAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }



















