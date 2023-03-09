/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.services;

import tn.edu.esprit.entities.Annonce;
import tn.edu.esprit.entities.Avis;
import tn.edu.esprit.util.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author NOURHENE
 */
public class ServiceAvis implements IService <Annonce> {
 
    Avis a= new Avis();
    Connection cnx = DataSource.getInstance().getCnx();
private final String USER = "root";
    private final String PWD = "";
    private final String URL = "jdbc:mysql://localhost:3306/projet";

  //    public void ajouter(Avis f) {
    //    try {
      //      String req = "INSERT INTO `avis`( `id_avis`,`id_annonce`,`commentaire`) VALUES ('"+f.getId_avis()+"','"+f.getId_annonce()+"','"+f.getCommentaire()+"')";
       //     Statement stm = cnx.createStatement();
        //    stm.executeUpdate(req);
     //       System.out.println("avis ajoute avec succes ");
    //    } catch (SQLException ex) {
      //      System.out.println(ex.getMessage());
       // }

    //}

  

    @Override
   public void ajouterCommentaire(Avis avis) {
    try {
        String req = "INSERT INTO `avis`( `id_avis`,`id_annonce`,`commentaire`,`islike`,`dislike`) VALUES (?,?,?,?,?)";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1, avis.getId_avis());
        ps.setInt(2, avis.getAnnonce().getId());
        ps.setString(3, avis.getCommentaire());
        ps.setInt(4, avis.getIslike());
       ps.setInt(5,avis.getDislike());      
    ps.executeUpdate();
        System.out.println("avis ajoute avec succes ");
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
}
   
    
   


    @Override
    public void ajouter(Annonce p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void supprimer(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifier(Annonce p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Annonce> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateProduit(Annonce p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Annonce chercherAnnonceParId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void supprimerAvis(int id_avis) {
        try {
            String req = "DELETE FROM avis WHERE id  = "+id_avis;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("avis deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifierAvis(Avis avis) {
          try {
      //    //  String req = "UPDATE `annonce` SET `titre` = '" + p.getTitre() + "', `Categorie` = '" + p.getCategorie() + "' WHERE `annonce`.`id` = " + p.getId();
          String req = "UPDATE `avis` SET `titre` = '" + avis.getCommentaire() +"'WHERE `avis`.`id_avis` = " + avis.getCommentaire();
        Statement st = cnx.createStatement();
          st.executeUpdate(req);
         System.out.println("avis updated !");
     } catch (SQLException ex) {
         System.out.println(ex.getMessage());
      }
    }

    @Override
    public void ajouter(Avis a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public int getNbLikes(int id_annonce) throws SQLException {
        String query = "SELECT nb_likes FROM avis WHERE id_annonce=?";
        PreparedStatement statement = cnx.prepareStatement(query);
        statement.setInt(1,id_annonce);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt("nb_likes");
        } else {
            return 0;
        }
    }
     public int getNbDislikes(int id_annonce) throws SQLException {
        String query = "SELECT nb_dislikes FROM avis WHERE id_annonce=?";
        PreparedStatement statement = cnx.prepareStatement(query);
        statement.setInt(1, id_annonce);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt("nb_dislikes");
        } else {
            return 0;
        }
    }

   public void ajouterLike(int id_annonce) throws SQLException {
        String query = "UPDATE avis SET nb_likes=nb_likes+1 WHERE id_annonce=?";
        PreparedStatement statement = cnx.prepareStatement(query);
        statement.setInt(1, id_annonce);
        statement.executeUpdate();
    }
   public void ajouterDislike(int id_annonce) throws SQLException {
        String query = "UPDATE avis SET nb_dislikes=nb_dislikes+1 WHERE id_annonce=?";
        PreparedStatement statement = cnx.prepareStatement(query);
        statement.setInt(1, id_annonce);
        statement.executeUpdate();
    }

    @Override
    public void ajouterAvis(Avis f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
}
