/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.GestionAnnonce.services;

import edu.GestionAnnonce.utils.DataSource;
import edu.GestionAnnonce.entities.Annonce;

import java.sql.Connection;
import java.sql.SQLException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author NOURHENE
 */
public class ServiceAnnonce implements IService <Annonce> {
Connection cnx = DataSource.getInstance().getCnx();
  //  @Override
  //  public void ajouter(Annonce p) {
     //   try {
      //      String req = "INSERT INTO `Annonce` (`titre`, `categorie`,`souscategorie`,`description`,`valeurobjet`,`image`,`video`,`adresse`,`tel`) VALUES ('" + p.getTitre()+ "', '" + p.getCategorie()+ "', '" + p.getSouscategorie()+ "', '" + p.getDescription()+ "', '" + p.getValeurobjet()+ "', '" + p.getImage()+ "','" + p.getVideo()+ "')";
      //      Statement st = cnx.createStatement();
       //     st.executeUpdate(req);
        //    System.out.println("annonce created !");
     //   } catch (SQLException ex) {
      //      System.out.println(ex.getMessage());
        //}
 //   }
@Override
      public void ajouter(Annonce p) {
        try {
            String req = "INSERT INTO `annonce` (`titre`, `categorie`,`souscategorie`,`description`,`valeurobjet`,`image`,`video`,`adresse`,`tel`) VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setFloat(9, p.getTel());
            ps.setString(8, p.getAdresse());
            ps.setString(7, p.getVideo());
            ps.setString(6, p.getImage());
            ps.setFloat(5, p.getValeurobjet());
            ps.setString(4, p.getDescription());
            ps.setString(3, p.getSouscategorie());
            ps.setString(2, p.getCategorie());
            ps.setString(1, p.getTitre());
           
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(int id) {
        try {
            String req = "DELETE FROM `annonce` WHERE id = " + id;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("annonce deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

   @Override
    public void modifier(Annonce p) {
        try {
           //  String req = "UPDATE `annonce` SET `titre` = '" + p.getTitre() + "', `Categorie` = '" + p.getCategorie() + "' WHERE `annonce`.`id` = " + p.getId();
            String req = "UPDATE `annonce` SET `titre` = '" + p.getTitre()+ "', `categorie` = '" + p.getCategorie()+ "',`souscategorie` = '" + p.getSouscategorie()+ "', `description` = '" + p.getDescription()+ "',`valeurobjet` = '" + p.getValeurobjet()+ "',`image` = '" + p.getImage()+ "',`video` = '" + p.getVideo() + "'WHERE `annonce`.`id` = " + p.getId();
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("annonce updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
@Override
    public List<Annonce> getAll(int id) {
        List<Annonce> list = new ArrayList<>();
        try {
            String req = "Select * from annonce";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
          
                
         // Livreur(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getInt(9),rs.getString(10),rs.getString(11),rs.getString(12));
                Annonce p = new Annonce(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getFloat(5), rs.getString(6), rs.getString(7),rs.getString(8),rs.getInt(9));
                list.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
    
   
    }
    
    

