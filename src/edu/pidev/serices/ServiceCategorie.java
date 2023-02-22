/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pidev.serices;

import edu.pidev.entities.Categorie;
import edu.pidev.utils.DataSource;
import java.sql.Connection; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;  

/**
 *
 * @author Dell 
 */
public class ServiceCategorie implements  IService <Categorie > {  
   

    Connection cnx;

    public ServiceCategorie(){
    
    cnx = DataSource.getInstance().getCnx();
    }
    @Override
    public void ajouter(Categorie c) {
        try {
            String req = "INSERT INTO `categorie` (`nomCategorie`, `description`) VALUES ('" + c.getNomCategorie() + "',  '" + c.getDescription() + "')"; 
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
            String req = "UPDATE `categorie` SET `nom` = '" + c.getNomCategorie() + "' WHERE `categorie`.`id` = " + c.getId();
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Categorie  updated !") ;  
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()); 
        }
    }
 public void supprimer(int id ) { 
        try {
            String req = "DELETE FROM `categorie` WHERE id = " + id ;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("categorie deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
         
        
  
        
        
        
    } 

   

    @Override
    public Categorie trouverParId(int id) { 
        
          Categorie categorie = null;
        try {
            String req = "SELECT * FROM `categorie` WHERE `id` = " + id;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            if (rs.next()) {
                categorie = new Categorie(rs.getInt("id"), rs.getString("nomCategorie"), rs.getString("description"));
            }
        } catch (SQLException ex) { 
            System.out.println(ex.getMessage());
        }
        return categorie;
    }  
    
    

        
    } 

//    @Override
//    public List<Categorie> trouverTous() {
//     List<Categorie> categories = new ArrayList<>();
//        try {
//            String req = "SELECT * FROM `categorie`";
//            Statement st = cnx.createStatement();
//            ResultSet rs = st.executeQuery(req);
//            while (rs.next()) {
//                Categorie categorie = new Categorie(rs.getInt("id"), rs.getString("nomCategorie"), rs.getString("description"));
//                categories.add(categorie);
//            }
//        } catch (SQLException ex) { 
//            System.out.println(ex.getMessage());
//        }
//        return categories;
  




















