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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import tn.edu.esprit.entities.Organisateur;
import tn.edu.esprit.entities.Utilisateur;
import tn.esprit.utils.MyConnection;

/**
 *
 * @author Donia
 */
public class OrganisateurService implements IServiceUtilisateur{

     Connection connection;
     PreparedStatement pst;
     PreparedStatement pstCompte;
     
      public OrganisateurService(){
    connection = MyConnection.getInstance().getConnection();
    
    }
    @Override
    public void ajouterUtilisateur(Utilisateur user) {
        Organisateur org =((Organisateur)user);
       String requete1 ="INSERT INTO `utilisateur` (`nomUtilisateur`, `prenomUtilisateur`, `email`, `motDePasse`, `genre`, `dateDeNaissance`, `numTelephone`, `adresse`, `role`, `nbPoint`,`cin`) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?,?,?) ";
   
        try {
             pst =connection.prepareStatement(requete1);
             pst.setString(1,org.getNomUtilisateur());
            pst.setString(2,org.getPrenomUtilisateur());
            pst.setString(3,org.getEmail());
            pst.setString(4,org.getMotDePasse());
            pst.setString(5,org.getGenre());
            pst.setString(6,org.getDateDeNaissance());
            pst.setInt(7,org.getNumTelephone());
            pst.setString(8,org.getAdresse());
            pst.setString(9, org.getRole());
            pst.setInt(10,0);
            pst.setInt(11, org.getCin());
            pst.executeUpdate();
            
           
            System.out.println("compte ajouté");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
      
    }
    

    @Override
    public void modifierUtilisateur(Utilisateur user) {
       Organisateur org =((Organisateur)user);
       String requete = "UPDATE `utilisateur` SET `nomUtilisateur`= ?,`prenomUtilisateur`=?,`email`=?,`motDePasse`=?,`genre`=?,`dateDeNaissance`=?,`numTelephone`=?,`adresse`=?,`role`=?,`nbPoint`=?,`cin`=? WHERE `idUtilisateur`=?";
        try {
           pst = connection.prepareStatement(requete);
           
            pst.setString(1,org.getNomUtilisateur());
            pst.setString(2,org.getPrenomUtilisateur());
            pst.setString(3,org.getEmail());
            pst.setString(4,org.getMotDePasse());
            pst.setString(5,org.getGenre());
            pst.setString(6,org.getDateDeNaissance());
            pst.setInt(7,org.getNumTelephone());
            pst.setString(8,org.getAdresse());
            pst.setString(9, org.getRole());
            pst.setInt(10, 0);
            pst.setInt(11, org.getCin());
            pst.setInt(12, org.getIdUtilisateur());
            pst.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
    }

    @Override
    public void supprimerUtilisateur(int id) {
        
        String requete = "DELETE FROM `utilisateur` WHERE `idUtilisateur`=? ";
        try {
            pst = connection.prepareStatement(requete);
            pst.setInt(1,id);
            pst.executeUpdate();
            System.out.println("Organisateur supprimée");
    }
          catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }
    @Override
    public Utilisateur chercherUtilisateurParId(int id) {
        Organisateur org = new Organisateur();
        String requete = "SELECT * FROM `utilisateur` WHERE idUtilisateur =?";
        try {
            pst = connection.prepareStatement(requete);
            pst.setInt(1, id);
            ResultSet resultat = pst.executeQuery();
            while (resultat.next()) {
                org.setIdUtilisateur(resultat.getInt(1));
                  org.setNomUtilisateur(resultat.getString("nomUtilisateur"));
                  org.setPrenomUtilisateur(resultat.getString("prenomUtilisateur"));
                  org.setEmail(resultat.getString("email"));
                  org.setMotDePasse(resultat.getString("motDePasse"));
                  org.setGenre(resultat.getString("genre"));
                  org.setRole(resultat.getString("role"));
                  org.setDateDeNaissance(resultat.getString("dateDeNaissance"));
                  org.setNumTelephone(resultat.getInt("numTelephone"));
                  org.setAdresse(resultat.getString("adresse"));
                  org.setCin(resultat.getInt("cin"));
            }
            return org;

        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot " + ex.getMessage());
            return null;
        }
    }

    @Override
    public Utilisateur chercherUtilisateurParCin(int cin) {
         Organisateur org = new Organisateur();
        String requete = "SELECT * FROM `utilisateur` WHERE cin =?";
        try {
            pst = connection.prepareStatement(requete);
            pst.setInt(1, cin);
            ResultSet resultat = pst.executeQuery();
            while (resultat.next()) {
                org.setIdUtilisateur(resultat.getInt(1));
                  org.setNomUtilisateur(resultat.getString("nomUtilisateur"));
                  org.setPrenomUtilisateur(resultat.getString("prenomUtilisateur"));
                  org.setEmail(resultat.getString("email"));
                  org.setMotDePasse(resultat.getString("motDePasse"));
                  org.setGenre(resultat.getString("genre"));
                  org.setRole(resultat.getString("role"));
                  org.setDateDeNaissance(resultat.getString("dateDeNaissance"));
                  org.setNumTelephone(resultat.getInt("numTelephone"));
                  org.setAdresse(resultat.getString("adresse"));
                  org.setCin(resultat.getInt("cin"));
            }
            return org;

        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot " + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Utilisateur> afficherToutUtilisateur() {
       List<Utilisateur> listeOrganisateurs = new ArrayList();
       String requete = "SELECT * FROM `utilisateur` WHERE `role`=? ";
        try {
            
            pst = connection.prepareStatement(requete);
            pst.setString(1, "client");
            ResultSet resultat = pst.executeQuery();
            while (resultat.next()) {
                Organisateur org = new Organisateur();
                  org.setIdUtilisateur(resultat.getInt(1));
                  org.setNomUtilisateur(resultat.getString("nomUtilisateur"));
                  org.setPrenomUtilisateur(resultat.getString("prenomUtilisateur"));
                  org.setEmail(resultat.getString("email"));
                  org.setMotDePasse(resultat.getString("motDePasse"));
                  org.setGenre(resultat.getString("genre"));
                  org.setRole(resultat.getString("role"));
                  org.setDateDeNaissance(resultat.getString("dateDeNaissance"));
                  org.setNumTelephone(resultat.getInt("numTelephone"));
                  org.setAdresse(resultat.getString("adresse"));
                  org.setCin(resultat.getInt("cin"));

                listeOrganisateurs.add(org);
            }
            return listeOrganisateurs;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots " + ex.getMessage());
            return null;
        }
       
    }
    
}
