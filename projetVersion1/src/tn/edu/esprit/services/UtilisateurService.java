/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.services;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;
import tn.edu.esprit.entities.Admin;
import tn.edu.esprit.entities.Client;
import tn.edu.esprit.entities.Organisateur;
import tn.edu.esprit.entities.Utilisateur;
import tn.edu.esprit.util.MyConnector;



/**
 *
 * @author Donia
 */
public class UtilisateurService implements IService<Utilisateur>{
    HistoriqueConnexionService historique = new HistoriqueConnexionService();
    Connection connection;
     PreparedStatement pst;
     PreparedStatement pstCompte;
     
      public UtilisateurService(){
    connection = MyConnector.getInstance().getConnection();
    
    }
    @Override
    public void ajouter(Utilisateur p) throws SQLException {
        String role="admin";
        
        if( (p instanceof Client)){
        role ="client";
        
        }
        else if (p instanceof Admin){
        role ="admin";
        }
        else if(p instanceof Organisateur){
        role ="organisateur";
        }
        String requete1 ="INSERT INTO `utilisateur` (`nomUtilisateur`, `prenomUtilisateur`, `email`, `motDePasse`, `genre`, `numTelephone`, `adresse`, `role`, `nbPoint`,`cin`,`image`) VALUES (?, ?, ?, ?,?, ?, ?,?,?,?,?) ";
        
    try {
             pst =connection.prepareStatement(requete1);
             pst.setString(1,p.getNomUtilisateur());
            pst.setString(2,p.getPrenomUtilisateur());
            pst.setString(3,p.getEmail());
            pst.setString(4,p.getMotDePasse());
            pst.setString(5,p.getGenre());

            pst.setInt(6,p.getNumTelephone());
            pst.setString(7,p.getAdresse());
            pst.setString(8,role);
            pst.setInt(9,0);
            pst.setInt(10,p.getCin());
            pst.setBytes(11,p.getImage());
            pst.executeUpdate();
            
           
            System.out.println("compte ajouté");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
      
    }
public void modifierMdp (Utilisateur p) throws SQLException {
    /*String role="admin";
        
        if( (p instanceof Client)){
        role ="client";
        }
        else if (p instanceof Admin){
        role ="admin";
        }
        else if(p instanceof Organisateur){
        role ="organisateur";
        }*/
    String requete = "UPDATE `utilisateur` SET `motDePasse`=? WHERE `email`=? AND `cin`=? ";
        try {
           pst = connection.prepareStatement(requete);
           
            pst.setString(1,p.getMotDePasse());
            //pst.setString(2,role);
            pst.setString(2,p.getEmail());
            pst.setInt(3,p.getCin());
            
            pst.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
}
    @Override
    public void modifier(Utilisateur p) throws SQLException {
        /*String role="admin";
        
        if( (p instanceof Client)){
        role ="client";
        }
        else if (p instanceof Admin){
        role ="admin";
        }
        else if(p instanceof Organisateur){
        role ="organisateur";
        }*/
        String requete = "UPDATE `utilisateur` SET `nomUtilisateur`= ?,`prenomUtilisateur`=?,`email`=?,`genre`=?,`numTelephone`=?,`adresse`=?,`role`=?,`nbPoint`=?,`cin`=?,`image`=? WHERE `idUtilisateur`=?";
        try {
           pst = connection.prepareStatement(requete);
           
            pst.setString(1,p.getNomUtilisateur());
            pst.setString(2,p.getPrenomUtilisateur());
            pst.setString(3,p.getEmail());
            //pst.setString(4,p.getMotDePasse());
            pst.setString(4,p.getGenre());
            
            pst.setInt(5,p.getNumTelephone());
            pst.setString(6,p.getAdresse());
            pst.setString(7,p.getRole());
            pst.setInt(8, 0);
            pst.setInt(9, p.getCin());
             pst.setBytes(10, p.getImage());
            pst.setInt(11, p.getIdUtilisateur());
           
            pst.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
    }

    @Override
    public void supprimer(int cin) throws SQLException {
        
        String requete = "DELETE FROM `utilisateur` WHERE `cin`=? ";
        try {
            pst = connection.prepareStatement(requete);
            
            pst.setInt(1,cin);
            pst.executeUpdate();
            System.out.println("Organisateur supprimée");
    }
          catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
        
        
    }

    @Override
    public List<Utilisateur> getAll() throws SQLException {
List<Utilisateur> liste = new ArrayList();
       
       String requete = "SELECT * FROM `utilisateur` WHERE `role`=? ";
        try {
            
            pst = connection.prepareStatement(requete);
            pst.setString(1, "organisateur");
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
                  
                  org.setNumTelephone(resultat.getInt("numTelephone"));
                  org.setAdresse(resultat.getString("adresse"));
                  org.setCin(resultat.getInt("cin"));
                  org.setImage(resultat.getBytes("image"));

                liste.add(org);
            }
            return liste;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots " + ex.getMessage());
            return null;
        }
       
    }        
public Utilisateur chercherUtilisateurParCin(int cin) {
         Utilisateur p = new Utilisateur();
         String role="admin";
        
        if( (p instanceof Client)){
        role ="client";
        }
        else if (p instanceof Admin){
        role ="admin";
        }
        else if(p instanceof Organisateur){
        role ="organisateur";}
        String requete = "SELECT * FROM `utilisateur` WHERE cin =? ";
        try {
            pst = connection.prepareStatement(requete);
            pst.setInt(1, cin);
            //pst.setString(2,role);
            ResultSet resultat = pst.executeQuery();
            while (resultat.next()) {
                p.setIdUtilisateur(resultat.getInt(1));
                  p.setNomUtilisateur(resultat.getString("nomUtilisateur"));
                  p.setPrenomUtilisateur(resultat.getString("prenomUtilisateur"));
                  p.setEmail(resultat.getString("email"));
                  p.setMotDePasse(resultat.getString("motDePasse"));
                  p.setGenre(resultat.getString("genre"));
                  p.setRole(resultat.getString("role"));
                  
                  p.setNumTelephone(resultat.getInt("numTelephone"));
                  p.setAdresse(resultat.getString("adresse"));
                  p.setCin(resultat.getInt("cin"));
            }
            return p;

        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot " + ex.getMessage());
            return null;
        }
    }

public boolean chercherUtilisateurParCinMail(int cin,String email) throws SQLException {
        Utilisateur u= new Utilisateur();
        String role="admin";
        
        if( (u instanceof Client)){
        role ="client";
        }
        else if (u  instanceof Admin){
        role ="admin";
        }
        else if(u instanceof Organisateur){
        role ="organisateur";
        }
        String requete = "SELECT * FROM `utilisateur` WHERE cin=? AND email=? ";
        
            pst = connection.prepareStatement(requete);
            pst.setInt(1, cin);
            pst.setString(2, email);
            //pst.setString(3,role);
            ResultSet resultat = pst.executeQuery();
            while (resultat.next()) {
                if (email.equals(resultat.getString("email"))== true || cin==resultat.getInt("cin")) 
                u.setIdUtilisateur(resultat.getInt(1));
                  u.setNomUtilisateur(resultat.getString("nomUtilisateur"));
                  u.setPrenomUtilisateur(resultat.getString("prenomUtilisateur"));
                  u.setEmail(resultat.getString("email"));
                  u.setMotDePasse(resultat.getString("motDePasse"));
                  u.setGenre(resultat.getString("genre"));
                  u.setRole(resultat.getString("role"));
                  u.setNumTelephone(resultat.getInt("numTelephone"));
                  u.setAdresse(resultat.getString("adresse"));
                  u.setCin(resultat.getInt("cin"));
                
            
            return true;

   }
            return false;
        }

public void inscrire(Utilisateur user){
    
    String requete1 ="INSERT INTO `utilisateur` (`nomUtilisateur`, `prenomUtilisateur`, `email`, `motDePasse`, `genre`, `numTelephone`, `adresse`, `role`, `nbPoint`,`cin`,`image`) VALUES (?, ?, ?, ?, ?, ?, ?,?,?,?,?) ";
   
        try {
             pst =connection.prepareStatement(requete1);
             pst.setString(1,user.getNomUtilisateur());
            pst.setString(2,user.getPrenomUtilisateur());
            pst.setString(3,user.getEmail());
            pst.setString(4,user.getMotDePasse());
            pst.setString(5,user.getGenre());
            pst.setInt(6,user.getNumTelephone());
            pst.setString(7,user.getAdresse());
            pst.setString(8,"client");
            pst.setInt(9,0);
            pst.setInt(10, user.getCin());
            pst.setBytes(11,new byte[0]);
            pst.executeUpdate();
            
           
            System.out.println("compte ajouté");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public  Utilisateur findUserbyEmail (String email,String motDePasse) throws SQLException{
        Utilisateur user =new Utilisateur();
        String hashedPwd;
    // String requete =" select * from utilisateur where email=? AND motDePasse=? ";
     String requete =" select * from utilisateur where email=? ";
           pst = connection.prepareStatement(requete);
            
            pst.setString(1, email);
            //pst.setString(2, motDePasse);
            ResultSet resultat = pst.executeQuery();
            
                
                 
           while(resultat.next()){
             
              hashedPwd =resultat.getString("motDePasse");

              if(BCrypt.checkpw(motDePasse,hashedPwd)){   
              
             if ((email.equals(resultat.getString("email"))==true) ) 
                
                  user.setIdUtilisateur(resultat.getInt(1));
                  user.setNomUtilisateur(resultat.getString("nomUtilisateur"));
                  user.setPrenomUtilisateur(resultat.getString("prenomUtilisateur"));
                  user.setEmail(resultat.getString("email"));
                  user.setMotDePasse(resultat.getString("motDePasse"));
                  user.setGenre(resultat.getString("genre"));
                  user.setRole(resultat.getString("role"));
                  
                  user.setNumTelephone(resultat.getInt("numTelephone"));
                  user.setAdresse(resultat.getString("adresse"));
                  user.setCin(resultat.getInt("cin"));
                  user.setImage(resultat.getBytes("image"));
                  
              
                   return user;   
              }
           

        }
        return null;
     
   
    }
    public void ajouterImg(byte[] imageData) throws SQLException {
        
        String requete1 ="INSERT INTO `utilisateur` (`nomUtilisateur`, `prenomUtilisateur`, `email`, `motDePasse`, `genre`, `numTelephone`, `adresse`, `role`, `nbPoint`,`cin`,`image`) VALUES (?, ?, ?, ?, ?, ?, ?,?,?,?,?) ";
        
    try {
             pst =connection.prepareStatement(requete1);
             
             
             
            
           
             pst.setString(1,"hhh");
            pst.setString(2,"dddd");
            pst.setString(3,"ddd");
            pst.setString(4,"dddddd");
            pst.setString(5,"dddddd");
            pst.setInt(6,0);
            pst.setString(7,"ddd");
            pst.setString(8,"client");
            pst.setInt(9,0);
            pst.setInt(10,0);
            pst.setBytes(11,imageData);
            pst.executeUpdate();
            
           
            System.out.println("compte ajouté");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
      
    }
    public byte[] recupererImg() throws SQLException {
        
        byte[] imageData;
        String requete = "SELECT image FROM `utilisateur` WHERE idUtilisateur=? ";
        
            pst = connection.prepareStatement(requete);
            pst.setInt(1, 66);
            
            //pst.setString(3,role);
            ResultSet resultat = pst.executeQuery();
            while (resultat.next()) {
                
               
                  imageData=(resultat.getBytes("image"));
                
            
            return imageData;

   }
            return null;
        }

    }

