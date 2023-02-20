
package tn.edu.esprit.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import tn.edu.esprit.entities.Client;
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
            pst.setInt(10, client.getPoint());
            pst.setInt(11, client.getCin());
            pst.executeUpdate();
            
           
            System.out.println("compte ajouté");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
      
    }
    
}
