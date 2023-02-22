package edu.pidev.serices;

import edu.pidev.entities.Reclamation;
import edu.pidev.utils.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
 
/**
 *
 * @author Dell
 */
public class Servicereclamation implements IService1 <Reclamation>  {  
        Connection cnx;

    public Servicereclamation(){ 
    cnx = DataSource.getInstance().getCnx();
    } 
    
    @Override
    public void ajouter (Reclamation r ) {  
//            try {
//             String req = "INSERT INTO `reclamation` (`date_reclamation`,`description`, `statut`, "
//                     + "`type`, `info_produit`, `nom_prenom`, `tel`, `mail`,`etat`)"
//                     + " VALUES ('" +r.getDate_reclamation() + "' , "
//                     + " '" + r.getStatut()+ "' , '" + r.getDescription() + "' ,'" 
//                     + r.getType() + "' , '" +r.getInfo_produit()+ "' ,  '" +r.getNom_prenom()+ "' , '" +r.getTel()+ "' ,  '" 
//                     +r.getMail()+ "','" + r.getEtat()+ "')"; 
//                Statement st = cnx.createStatement();
//                st.executeUpdate(req); 
//                 System.out.println("reclamation creer!"); }
//                  catch (SQLException ex) {
//                System.out.println(ex.getMessage()); 
//            }

            
       try {
            String req = "INSERT INTO `reclamation` (`date_reclamation`, `description`, `statut`,"
            + " `type`, `info_produit`, `nom_prenom`, `tel`, `mail`) VALUES " 
            + "('" + r.getDate_reclamation()+ "',  '" + r.getStatut() +
            "', '" + r.getDescription() + "', '" +
            r.getType() + "', '" + r. getInfo_produit()
            + "', '" + r.getNom_prenom()+ "', '" + 
            r.getTel() + "', '" +
            r.getMail() + "')";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Réclamation créée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

            
        } 

    public void modifier(Reclamation r) { 
        
          try {
             String req = "UPDATE INTO `reclamation` (`date_reclamation`,`description`, `statut`, `type`, `info_produit`, `nom_prenom`, `tel`, `mail`) VALUES ('" +r.getDate_reclamation() + "' ,  '" + r.getStatut()+ "' , '" + r.getDescription() + "' ,'" + r.getType() + "' , '" +r.getInfo_produit()+ "' ,  '" +r.getNom_prenom()+ "' , '" +r.getTel()+ "' ,  '" +r.getMail()+ "')"; 
                Statement st = cnx.createStatement();
                st.executeUpdate(req); 
                 System.out.println("reclamation creer!"); }
                  catch (SQLException ex) {
                System.out.println(ex.getMessage()); 
            }
        
    } 
    
      public void modifierReclamation(Reclamation reclamation, String role) {
        if (!role.equals("admin")) {
            System.out.println("Erreur : seule l'administrateur peut modifier une r�clamation !");
            return;
        }
        try {
            String req = "UPDATE `reclamation` SET `dateReclamation`='" +
        reclamation.getDate_reclamation()
                    + "',`description`='" + reclamation.getDescription() +
                    "',`statut`='" + reclamation.getStatut()
                    + "',`type`='" + reclamation.getType() + 
                    "',`infoProduit`='" + reclamation.getInfo_produit() 
                    + "',`nomPrenom`='" + reclamation.getNom_prenom()+ 
                    "',`tel`='" + reclamation.getTel()
                    + "',`mail`='" + reclamation.getMail() +  
                    "' WHERE `id`=" + reclamation.getId();
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Reclamation modifiee !"); 
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

//    public void supprimerReclamation(int id) {
//        try {
//            String req = "DELETE FROM `reclamation` WHERE `id`=" + id;
//            Statement st = cnx.createStatement();
//            st.executeUpdate(req);
//            System.out.println("R�clamation supprim�e !");
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }

   
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
     
    





























//public  void Datecourante ( ) {
//    SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//    Date date = new Date();
//    System.out.println(s.format(date));
//  }
//     
//        
   
    

