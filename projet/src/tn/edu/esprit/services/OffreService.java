/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tn.edu.esprit.entities.Offre;
import tn.esprit.utils.MyConnection;

/**
 *
 * @author Donia
 */
public class OffreService implements IServiceOffre{

    Connection connection;
     PreparedStatement pst;
     PreparedStatement pstCompte;

    public OffreService() {
    
    connection = MyConnection.getInstance().getConnection();
    }
     
     
    
    @Override
    public void ajouterOffre(Offre offre) {
     
     String requete1 ="INSERT INTO `offre`( `refUtilisateur`, `idAnnonce`, `dateDebut`, `dateFin`, `pourcentage`) VALUES (?,?,?,?,?)";
    
    try {
             pst =connection.prepareStatement(requete1);
             pst.setInt(1,offre.getRefUtilisateur());
            pst.setInt(2,offre.getRefAnnonce());
            pst.setString(3,offre.getDateDebut());
            pst.setString(4,offre.getDateFin());
            pst.setInt(5,offre.getPourcentage());
            pst.executeUpdate();
            System.out.println("Offre ajouté");
    }
    
         catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifierOffre(Offre offre) {
     String requete1="UPDATE `offre` SET `dateDebut`=?,`dateFin`=?,`pourcentage`=? WHERE `idOffre`=?" ;  
     try {
           pst = connection.prepareStatement(requete1);
           
            pst.setString(1,offre.getDateDebut());
            pst.setString(2,offre.getDateFin());
            pst.setInt(3,offre.getPourcentage());
            pst.setInt(4,offre.getIdOffre());
            pst.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
    }

    @Override
    public void supprimerOffre(int id) {
        
        String requete = "DELETE FROM `offre` WHERE `idOffre`=? ";
        try {
            pst = connection.prepareStatement(requete);
            pst.setInt(1,id);
            pst.executeUpdate();
            System.out.println("Offre supprimée");
    }
          catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }

    @Override
    public Offre chercherOffreParId(int id) {
        Offre offre= new Offre();
        String requete = "SELECT * FROM `offre` WHERE `idOffre`=? ";
       try {
            pst = connection.prepareStatement(requete);
            pst.setInt(1, id);
            ResultSet resultat = pst.executeQuery();
            while (resultat.next()) {
                offre.setIdOffre(resultat.getInt("idOffre"));
                offre.setRefUtilisateur(resultat.getInt("refUtilisateur"));
                offre.setRefAnnonce(resultat.getInt("idAnnonce"));
                offre.setDateDebut(resultat.getString("dateDebut"));
                offre.setDateFin(resultat.getString("dateFin"));
                offre.setPourcentage(resultat.getInt("pourcentage"));
            }
            
    
       return offre;
       }
        catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot " + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Offre> afficherToutOffre(int refUtilisateur ,int idAnnonce) {
        List<Offre> listeOffre = new ArrayList();
        Offre offre = new Offre();
        String requete = "SELECT * FROM `offre` WHERE `refUtilisateur`=? and `idAnnonce`=? ";
        try {
            pst = connection.prepareStatement(requete);
            pst.setInt(1, refUtilisateur);
            pst.setInt(2,idAnnonce);
            ResultSet resultat = pst.executeQuery();
            while (resultat.next()) {
                
                offre.setIdOffre(resultat.getInt("idOffre"));
                offre.setRefUtilisateur(resultat.getInt("refUtilisateur"));
                offre.setRefAnnonce(resultat.getInt("idAnnonce"));
                offre.setDateDebut(resultat.getString("dateDebut"));
                offre.setDateFin(resultat.getString("dateFin"));
                offre.setPourcentage(resultat.getInt("pourcentage"));
                listeOffre.add(offre);
            }
            
    
       return listeOffre;
       }
        catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot " + ex.getMessage());
            return null;
        }
    }
    
}
