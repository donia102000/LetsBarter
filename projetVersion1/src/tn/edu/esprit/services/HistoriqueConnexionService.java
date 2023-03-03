/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import tn.edu.esprit.entities.HistoriqueConnexion;
import tn.edu.esprit.entities.Utilisateur;
import tn.edu.esprit.util.MyConnector;

/**
 *
 * @author Donia
 */
public class HistoriqueConnexionService implements IService<HistoriqueConnexion>{
Connection connection;
     PreparedStatement pst;
     PreparedStatement pstCompte;
     
     public HistoriqueConnexionService(){
    connection = MyConnector.getInstance().getConnection();
    }
     
    @Override
    public void ajouter(HistoriqueConnexion p) throws SQLException {
        String requete1 ="INSERT INTO `historiquedeconnexion`(`dateDeConnexion`, `systemeExploitation`, `idUtilisateur`, `nbConnexion`) VALUES (?,?,?,?)";
    try {
             pst =connection.prepareStatement(requete1);
             pst.setDate(1,p.getDateConnexion());
            pst.setString(2,p.getSysExploitation());
            pst.setInt(3,p.getUtilisateur().getIdUtilisateur());
            pst.setInt(4,p.getNbConnexion());
           
            pst.executeUpdate();
            
           
            System.out.println("histoique de connexion ajouté");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(HistoriqueConnexion p) throws SQLException {
        String requete = "UPDATE `historiquedeconnexion` SET `dateDeConnexion`=?,`systemeExploitation`=?,`idUtilisateur`=?,`nbConnexion`=? WHERE `idHistorique`=? ";
    try {
           pst = connection.prepareStatement(requete);
           
            pst.setDate(1,p.getDateConnexion());
            pst.setString(2,p.getSysExploitation());
            pst.setInt(3,p.getUtilisateur().getIdUtilisateur());
            pst.setInt(4,p.getNbConnexion());
            
            
            pst.setInt(5, p.getIdHistorique());
            pst.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
    }

    @Override
    public void supprimer(int id) throws SQLException {
        String requete = "DELETE FROM `historiquedeconnexion` WHERE `idHistorique`=? ";
        try {
            pst = connection.prepareStatement(requete);
            pst.setInt(1,id);
            pst.executeUpdate();
            System.out.println("Historique connexion supprimée");
    }
          catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }

    @Override
    public List<HistoriqueConnexion> getAll() throws SQLException {
       List<HistoriqueConnexion> liste = new ArrayList();
       String requete = "SELECT * FROM `historiquedeconnexion`";
       try {
            
            pst = connection.prepareStatement(requete);
            ResultSet resultat = pst.executeQuery();
            while (resultat.next()) {
                HistoriqueConnexion historique = new HistoriqueConnexion();
                  historique.setIdHistorique(resultat.getInt(1));
                  historique.setDateConnexion(resultat.getDate("dateDeConnexion"));
                  historique.setSysExploitation(resultat.getString("systemeExploitation"));
                  Utilisateur user = new Utilisateur();
                  user.setIdUtilisateur(resultat.getInt("idUtilisateur"));
                  historique.setUtilisateur(user);
                  historique.setNbConnexion(resultat.getInt("nbConnexion"));
                  

                liste.add(historique);
            }
            return liste;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots " + ex.getMessage());
            return null;
        }
    }
    
    public List<String> getAllDate() throws SQLException {
    List<String> listewithDuplicates = new ArrayList();
    List<String> listWithoutDuplicates = new ArrayList();
    String requete = "SELECT dateDeConnexion FROM `historiquedeconnexion`";
    try {
    pst = connection.prepareStatement(requete);
            ResultSet resultat = pst.executeQuery();
            while (resultat.next()) {
                String date = new String();
                  date =resultat.getString(1);
                  
            listewithDuplicates.add(date);
            Set<String> setWithoutDuplicates = new HashSet<String>(listewithDuplicates);
            listWithoutDuplicates = new ArrayList(setWithoutDuplicates);
            }
            return listWithoutDuplicates ;
    }
    catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots " + ex.getMessage());
            return null;
        }
    
    
    }
    public HistoriqueConnexion getDateParUtilisateurEtDateActuel(Date dateActuelle,int idUser,String role)throws SQLException
    {
    HistoriqueConnexion historique = new HistoriqueConnexion();
    String requete = "SELECT * FROM `historiquedeconnexion` JOIN utilisateur ON historiquedeconnexion.idUtilisateur = utilisateur.idUtilisateur WHERE historiquedeconnexion.dateDeConnexion=? AND utilisateur.idUtilisateur=? AND utilisateur.role=? ";
    try {
    pst = connection.prepareStatement(requete);
            
            
            pst.setDate(1,dateActuelle );
            pst.setInt(2,idUser);
            pst.setString(3, role);
            ResultSet resultat = pst.executeQuery();
            while (resultat.next()) {
                 
                  historique.setIdHistorique(resultat.getInt(1));
                  historique.setDateConnexion(resultat.getDate("dateDeConnexion"));
                  historique.setSysExploitation(resultat.getString("systemeExploitation"));
                  Utilisateur user = new Utilisateur();
                  user.setIdUtilisateur(resultat.getInt("idUtilisateur"));
                  historique.setUtilisateur(user);
                  historique.setNbConnexion(resultat.getInt("nbConnexion"));
                  

                
            }
            return historique ;
    }
    catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots " + ex.getMessage());
            return null;
        }
    
}
    public List<Integer> getAllNbrePointParDate(String date) throws SQLException {
    List<Integer> liste = new ArrayList();
    String requete = "SELECT nbConnexion  FROM `historiquedeconnexion` WHERE dateDeConnexion=?";
    try {
    pst = connection.prepareStatement(requete);
            pst.setString(1, date);
            ResultSet resultat = pst.executeQuery();
            while (resultat.next()) {
                int nbre;
                  nbre =resultat.getInt(1);
                  
            liste.add(nbre);
            
            }
            return liste ;
    }
    catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots " + ex.getMessage());
            return null;
        }
    
    
    }
    
}
