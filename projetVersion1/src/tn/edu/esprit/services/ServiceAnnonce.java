/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.services;

import tn.edu.esprit.util.MyConnector;
import tn.edu.esprit.entities.Annonce;
import tn.edu.esprit.entities.Avis;
import tn.edu.esprit.entities.Utilisateur;
//import tn.edu.esprit.gui.AnnonceSelectionnee;
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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;



/**
 *
 * @author NOURHENE
 */
public class ServiceAnnonce implements IService <Annonce> {
Connection cnx = MyConnector.getInstance().getConnection();
private final String USER = "root";
    private final String PWD = "";
    private final String URL = "jdbc:mysql://localhost:3306/projet";

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
         //  Utilisateur us = new Utilisateur();
        try {
            String req = "INSERT INTO `annonce` (`id_user`,`titre`, `categorie`,`souscategorie`,`description`,`valeurobjet`,`image`,`adresse`,`tel`) VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(8, p.getAdresse());
            ps.setString(9, p.getTel());
            ps.setInt(1, p.getIdUtilisateur());   
            ps.setString(7, p.getImage());
            ps.setString(6, p.getValeurobjet());
            ps.setString(5, p.getDescription());
            ps.setString(4, p.getSouscategorie());
            ps.setString(3, p.getCategorie());
            ps.setString(2, p.getTitre());
           
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     *
 
     *
     * @param id
     * @param annonce
     */
   // @Override
   // public void supprimer(Annonce annonce) {
     //   try {
       //     String req = "DELETE FROM `annonce` WHERE id = ? ";
       //     Statement st = cnx.createStatement();
       //     st.executeUpdate(req);
       //     System.out.println("annonce deleted !");
      //  } catch (SQLException ex) {
        //    System.out.println(ex.getMessage());
      //  }
   // }
    @Override
    public void supprimer(int id) {
        try {
            String req = "DELETE FROM annonce WHERE id  = "+id;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("annonce deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
   
    

    public void updateProduit(Annonce annonce) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PWD);
            PreparedStatement statement = connection.prepareStatement("UPDATE annonce SET titre = ? , categorie = ?,souscategorie = ?, description =?,valeurobjet = ? ,image =? , adresse=? , tel= ? WHERE id= ?");
          
            statement.setString(1, annonce.getTitre());
            statement.setString(2, annonce.getCategorie());
            statement.setString(3, annonce.getSouscategorie());
            statement.setString(4, annonce.getDescription());
            statement.setString(5, annonce.getValeurobjet());
        //    statement.setString(6, annonce.getImage());
           
             statement.setString(7, annonce.getAdresse());
            statement.setString(8, annonce.getTel());
             statement.setInt(9, annonce.getId());
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   @Override
   public void modifier(Annonce p) {
       try {
      //    //  String req = "UPDATE `annonce` SET `titre` = '" + p.getTitre() + "', `Categorie` = '" + p.getCategorie() + "' WHERE `annonce`.`id` = " + p.getId();
          String req = "UPDATE `annonce` SET `titre` = '" + p.getTitre()+ "', `categorie` = '" + p.getCategorie()+ "',`souscategorie` = '" + p.getSouscategorie()+ "', `description` = '" + p.getDescription()+ "',`valeurobjet` = '" + p.getValeurobjet()+  "',`image` = '" + p.getImage()+  "',`adresse` = '" + p.getAdresse()+ "',`tel` = '" + p.getTel()+ "'WHERE `annonce`.`id` = " + p.getId();
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
            
     //       annonce = new Annonce(titre, categorie, souscategorie, description, valeur, image, video, adresse, tel);
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
         
             ps.setString(8, annonce.getAdresse());
                ps.setString(9, annonce.getTel());
            ps.executeUpdate();
            System.out.println("Mise Ã  jour effectuÃ©e avec succÃ¨s");
        } catch (SQLException ex) {
            
            System.out.println("erreur lors de la mise Ã  jour " + ex.getMessage());
        }
    }



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
         //         annonce.setImage(resultat.getString("image"));
                
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
       String req = "Select * from annonce";
        try {
            
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Annonce annonce = new Annonce();
               
                annonce.setId(rs.getInt(1));
                  annonce.setTitre(rs.getString("titre"));
                  annonce.setCategorie(rs.getString("categorie"));
                 annonce.setSouscategorie(rs.getString("souscategorie"));
                  annonce.setDescription(rs.getString("description"));
                  annonce.setValeurobjet(rs.getString("valeurobjet"));
           annonce.setImage(rs.getString("image"));
                
                  annonce.setAdresse(rs.getString("adresse"));
                  annonce.setTel(rs.getString("tel"));
                list.add(annonce);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
        
    }
     public List<Annonce> findForumByTitle(String title){
        ServiceAnnonce sf = new ServiceAnnonce();
    List<Annonce> result = sf.getAll().stream().filter((p)->p.getTitre().toUpperCase().contains(title.toUpperCase())).collect(Collectors.toList());
    return result;
  
    }

   
    public void ajouter(Avis f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public int chercherAnnonceId(Annonce annonce){
        String req="select id from annonce where titre=?";
        try {
            
        int id_ann=0;
         //  ps = cnx.prepareStatement(requete);
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, annonce.getTitre());
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                id_ann=(resultat.getInt(1));
               
                          }
           return id_ann;
    
      } catch (SQLException ex) {
       System.out.println("erreur lors de la recherche du depot " + ex.getMessage());
 return 0;
    
    }
    
   
    }

   
    public void supprimerAvis(int id_avis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public void modifierAvis(Avis avis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public void ajouterCommentaire(Avis avis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
   /*
   
    public List<AnnonceSelectionnee> getAnnonces() {
        return annonces;
    }
    public ServiceAnnonce() {
        annonces = new ArrayList<>();
    }
    private List<AnnonceSelectionnee> annonces;
     public void setAimee(AnnonceSelectionnee annonceSelectionnee, boolean estAimee) {
        annonceSelectionnee.setAimee(estAimee);
    }
*/
    
    public void ajouterAvis(Avis f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     public void incrementLike(Annonce annonce) {
        try {
            PreparedStatement preparedStatement = cnx.prepareStatement("UPDATE avis SET islike = islike + 1 WHERE id_annonce = ?");
            preparedStatement.setInt(1, annonce.getId()); // remplacer "id" par l'attribut qui représente l'ID de l'annonce
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void incrementDislike(Annonce annonce) {
        try {
            PreparedStatement preparedStatement = cnx.prepareStatement("UPDATE avis SET dislike = dislike + 1 WHERE id_annonce = ?");
            preparedStatement.setInt(1, annonce.getId()); // remplacer "id" par l'attribut qui représente l'ID de l'annonce
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    

}

