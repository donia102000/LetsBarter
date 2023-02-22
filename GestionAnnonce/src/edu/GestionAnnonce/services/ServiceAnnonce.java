/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.GestionAnnonce.services;

import edu.GestionAnnonce.utils.DataSource;
import edu.GestionAnnonce.entities.Annonce;
import java.net.URL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.css.StyleOrigin.USER;
import static javax.management.remote.JMXConnectorFactory.connect;



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
            ps.setString(9, p.getTel());
            ps.setString(8, p.getAdresse());
            ps.setString(7, p.getVideo());
            ps.setString(6, p.getImage());
            ps.setString(5, p.getValeurobjet());
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
      //    //  String req = "UPDATE `annonce` SET `titre` = '" + p.getTitre() + "', `Categorie` = '" + p.getCategorie() + "' WHERE `annonce`.`id` = " + p.getId();
          String req = "UPDATE `annonce` SET `titre` = '" + p.getTitre()+ "', `categorie` = '" + p.getCategorie()+ "',`souscategorie` = '" + p.getSouscategorie()+ "', `description` = '" + p.getDescription()+ "',`valeurobjet` = '" + p.getValeurobjet()+ "',`image` = '" + p.getImage()+ "',`video` = '" + p.getVideo() + "'WHERE `annonce`.`id` = " + p.getId();
        Statement st = cnx.createStatement();
          st.executeUpdate(req);
         System.out.println("annonce updated !");
     } catch (SQLException ex) {
         System.out.println(ex.getMessage());
      }
        
 }
    public Annonce getProductById(int id) {
    Annonce annonce = null;
    try {
     
      
        String req = "SELECT * FROM annonce WHERE id=?";
         PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            String titre = rs.getString("titre");
            String categorie = rs.getString("categorie");
            String souscategorie = rs.getString("souscategorie");
            String description = rs.getString("description");
            String valeur = rs.getString("valeur");
            String image= rs.getString("image");
            String video = rs.getString("video");
             String adresse = rs.getString("adresse");
              String tel = rs.getString("tel");
            
            annonce = new Annonce(titre, categorie, souscategorie, description, valeur, image, video, adresse, tel);
        }
        cnx.close();
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    return annonce;
}
//@Override
  //  public void modifier(Annonce annonce) {
 //   try {
       
   //     String query = "UPDATE `annonce` SET `titre`=?, `categorie`=?, `souscategorie`=?, `description`=? , `valeurobjet`=? , `image`=? , `video`=? , `adresse`=? , `tel`=? WHERE `id`=?";
       // String requete = "UPDATE `utilisateur` SET `nomUtilisateur`= ?,`prenomUtilisateur`=?,`email`=?,`motDePasse`=?,`genre`=?,`dateDeNaissance`=?,`numTelephone`=?,`adresse`=?,`role`=?,`nbPoint`=?,`cin`=? WHERE `idUtilisateur`=?";
     //   PreparedStatement ps = cnx.prepareStatement(query);
    //    ps.setString(1, annonce.getTitre());
    //    ps.setString(2, annonce.getCategorie());
    //    ps.setString(3, annonce.getSouscategorie());
    //    ps.setString(4, annonce.getDescription());
    //      ps.setString(5, annonce.getValeurobjet());
      //    ps.setString(6, annonce.getImage());
      //      ps.setString(7, annonce.getVideo());
       //       ps.setString(8, annonce.getAdresse());
         //        ps.setString(9, annonce.getTel());
       // ps.executeUpdate();
      //  cnx.close();
  //  } catch (SQLException ex) {
    //    System.out.println(ex.getMessage());
   // }
   // }
    
  
    public void modifierrr(Annonce annonce) {
    
       String query = "UPDATE `annonce` SET `titre`= ?,`categorie`=?,`souscategorie`=?,`description`=?,`valeurobjet`=?,`image`=?,`video`=?,`adresse`=?,`tel`=? WHERE id=?";
        try {
          PreparedStatement ps = cnx.prepareStatement(query);
          
      ps.setString(1, annonce.getTitre());
        
    ps.setString(2, annonce.getCategorie());
       ps.setString(3, annonce.getSouscategorie());
        ps.setString(4, annonce.getDescription());
         ps.setString(5, annonce.getValeurobjet());
         ps.setString(6, annonce.getImage());
           ps.setString(7, annonce.getVideo());
             ps.setString(8, annonce.getAdresse());
                ps.setString(9, annonce.getTel());
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
    }


@Override
      public Annonce chercherAnnonceParId(int id) {
       Annonce annonce = new Annonce();
       String requete = "SELECT * FROM `annonce` WHERE id=?";
       try {
         //  ps = cnx.prepareStatement(requete);
            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                annonce.setId(resultat.getInt(1));
                  annonce.setTitre(resultat.getString("titre"));
                  annonce.setCategorie(resultat.getString("categorie"));
                 annonce.setSouscategorie(resultat.getString("souscategorie"));
                  annonce.setDescription(resultat.getString("description"));
                  annonce.setValeurobjet(resultat.getString("valeurobjet"));
                  annonce.setImage(resultat.getString("image"));
                  annonce.setVideo(resultat.getString("video"));
                  annonce.setAdresse(resultat.getString("adresse"));
                  annonce.setTel(resultat.getString("tel"));
                          }
           return annonce;

      } catch (SQLException ex) {
       System.out.println("erreur lors de la recherche du depot " + ex.getMessage());
 return null;          
// //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
     } 
       
       
   

}




    @Override
    public List<Annonce> getAll() {
       List<Annonce> list = new ArrayList<>();
        try {
            String req = "Select * from annonce";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Annonce t = new Annonce(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),rs.getString(8),rs.getString(9));
                list.add(t);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
        
    }
    
   
    }
    
    

