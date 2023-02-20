 
package tn.edu.esprit.services;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import tn.edu.esprit.entities.Utilisateur;
import tn.esprit.utils.MyConnection;


/**
 *
 * @author Donia
 */
public class LoginService {
    
    Connection connection;
     PreparedStatement pst;
     
     public LoginService(){
    connection = MyConnection.getInstance().getConnection();
    
    }
     Utilisateur user =new Utilisateur();
    public  Utilisateur findUserbyEmail (String email,String motDePasse) throws SQLException{
        
     String requete =" select * from utilisateur where email=? AND motDePasse=? ";
     PreparedStatement     ps;
     
           ps = connection.prepareStatement(requete);
            
            ps.setString(1, email);
            ps.setString(2, motDePasse);
            ResultSet resultat = ps.executeQuery();
            while(resultat.next()){
     
              if (email.equals(resultat.getString("email"))==true && motDePasse.equals(resultat.getString("motDePasse")) )
                
                  user.setIdUtilisateur(resultat.getInt(1));
                  user.setNomUtilisateur(resultat.getString("nomUtilisateur"));
                  user.setPrenomUtilisateur(resultat.getString("prenomUtilisateur"));
                  user.setEmail(resultat.getString("email"));
                  user.setMotDePasse(resultat.getString("motDePasse"));
                  user.setGenre(resultat.getString("genre"));
                  user.setRole(resultat.getString("role"));
                  user.setDateDeNaissance(resultat.getString("dateDeNaissance"));
                  user.setNumTelephone(resultat.getInt("numTelephone"));
                  user.setAdresse(resultat.getString("adresse"));
                  user.setCin(resultat.getInt("cin"));
                  
                  
                  
                   return user;   
              
            

        }
        return null;
     
   
    }
    public  int idUtilisateur() {
    
    return user.getIdUtilisateur();
    }
     
    
    
     
}
