
package tn.edu.esprit.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import tn.edu.esprit.entities.Client;
import tn.edu.esprit.entities.Organisateur;
import tn.edu.esprit.entities.Utilisateur;
import tn.esprit.utils.MyConnection;


/**
 *
 * @author Donia
 */
public class InscriptionService {
    
     Connection connection;
     PreparedStatement pst;
     PreparedStatement pstCompte;
     
     
    public InscriptionService(){
    connection = MyConnection.getInstance().getConnection();
    
    }
   
   public boolean chercherUtilisateurParCin(int cin,String email) throws SQLException {
         Organisateur org = new Organisateur();
        String requete = "SELECT * FROM `utilisateur` WHERE cin=? AND email=? AND role=?";
        
            pst = connection.prepareStatement(requete);
            pst.setInt(1, cin);
            pst.setString(2, email);
            pst.setString(3,"client");
            ResultSet resultat = pst.executeQuery();
            while (resultat.next()) {
                if (email.equals(resultat.getString("email"))== true || cin==resultat.getInt("cin")) 
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
                
            
            return true;

   }
            return false;
        }
    
   public void inscrire(Client client){
    
    String requete1 ="INSERT INTO `utilisateur` (`nomUtilisateur`, `prenomUtilisateur`, `email`, `motDePasse`, `genre`, `dateDeNaissance`, `numTelephone`, `adresse`, `role`, `nbPoint`,`cin`) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?,?,?) ";
   
        try {
             pst =connection.prepareStatement(requete1);
             pst.setString(1,client.getNomUtilisateur());
            pst.setString(2,client.getPrenomUtilisateur());
            pst.setString(3,client.getEmail());
            pst.setString(4,client.getMotDePasse());
            pst.setString(5,client.getGenre());
            pst.setString(6,client.getDateDeNaissance());
            pst.setInt(7,client.getNumTelephone());
            pst.setString(8,client.getAdresse());
            pst.setString(9, client.getRole());
            pst.setInt(10,0);
            pst.setInt(11, client.getCin());
            pst.executeUpdate();
            
           
            System.out.println("compte ajouté");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
      
    }
   public boolean chercherUtilisateurPareMAIL(int cin,String email) throws SQLException {
         Organisateur org = new Organisateur();
        String requete = "SELECT * FROM `utilisateur` WHERE cin=? AND email=? AND role=?";
        
            pst = connection.prepareStatement(requete);
            pst.setInt(1, cin);
            pst.setString(2, email);
            pst.setString(3,"organisateur");
            ResultSet resultat = pst.executeQuery();
            while (resultat.next()) {
                if (email.equals(resultat.getString("email"))== true || cin==resultat.getInt("cin")) 
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
                
            
            return true;

   }
            return false;
        }
    
    
}
