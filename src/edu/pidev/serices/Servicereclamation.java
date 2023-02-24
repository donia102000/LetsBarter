package edu.pidev.serices;

import edu.pidev.entities.Reclamation;
import edu.pidev.utils.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
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
            try {
             String req = "INSERT INTO `reclamation` (`date_reclamation`,`description`, `statut`, "
                     + "`type`, `info_produit`, `nom_prenom`, `tel`, `mail`,`etat`)"
                     + " VALUES ('" +r.getDate_reclamation() + "' , "
                     + " '" + r.getStatut()+ "' , '" + r.getDescription() + "' ,'" 
                     + r.getType() + "' , '" +r.getInfo_produit()+ "' ,  '" +r.getNom_prenom()+ "' , '" +r.getTel()+ "' ,  '" 
                     +r.getMail()+ "','" + r.getEtat()+ "')"; 
                Statement st = cnx.createStatement();
                st.executeUpdate(req); 
                 System.out.println("reclamation creer!"); }
                  catch (SQLException ex) {
                System.out.println(ex.getMessage()); 
            }

            
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
            System.out.println("Réclamation cree !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

            
        } 

//    public void modifier(Reclamation r) { 
//        
//          try {
//              String req = "UPDATE  reclamation SET   `date_reclamation` = ? , `description` = ? , `statut` = ? ,"
//            + " `type` = ? , `info_produit`=? , `nom_prenom` = ? , `tel`= ? , `mail` = ?  "
//         
//             
//                     + " VALUES ('" +r.setDate_reclamation() + "' ,  '" + r.getStatut()+ "' , '"
//                     + r.getDescription() + "' ,'" + r.getType() + "' , '" +r.getInfo_produit()+ "' ,  '" +r.getNom_prenom()+ "' , '" +r.getTel()+ "' ,  '" +r.getMail()+ "')"; 
//                Statement st = cnx.createStatement();
//                st.executeUpdate(req); 
//                 System.out.println("reclamation creer!"); }
//                  catch (SQLException ex) {
//                System.out.println(ex.getMessage()); 
//            }
//        
//    } 
    
//      public void modifierReclamation(String statut, String role ) { 
//          Reclamation reclamation = null;
//        if (!role.equals("admin")) { 
//            System.out.println("Erreur : seule l'administrateur peut modifier une r�clamation !");
//            return;
//        }
//        try {
//            String req = "UPDATE `reclamation` SET `dateReclamation`='" + 
//                    "',`statut`='" + reclamation.getStatut() ; 
//            Statement st = cnx.createStatement();
//            st.executeUpdate(req);
//            System.out.println("Reclamation modifiee !"); 
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        } 
//    }

    public void supprimerReclamation(int id) {
        try {
            String req = "DELETE FROM `reclamation` WHERE `id`=" + id;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("R�clamation supprim�e !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()); 
        }
//     public void update() {
//        con = Connexion.getCon();
//        String update
//                = "UPDATE etudiant SET nom =?,prenom = ?,sexe =? where id =?" thabet maaya f req brabi nakaltha mn aand tfo ena ghalta ketebah l update
//        try {
//            st = con.prepareStatement(update);
//            st.setString(1, nom.getText());
//            st.setString(2, prenom.getText());
//            st.setString(3, sexe.getSelectionModel().getSelectedItem());
//            st.setInt(4, Integer.parseInt(id.getText()));
//            st.executeUpdate();
//            affiche();
//        } catch (SQLException ex) {
//            Logger.getLogger(FXMLDocumentController.class.getName())
//                    .log(Level.SEVERE, null, ex);
//        }
//    }
   
    }   
    
    public void modifierReclamation(Reclamation reclamation, String role) {
        if (!role.equals("admin")) {
            System.out.println("Erreur : seule l'administrateur peut modifier une réclamation !");
            return;
        }
        try {
          String req1 = "SELECT id FROM `reclamation` WHERE `nom_prenom`='" + reclamation.getNom_prenom()+ "'"; 
               Statement st = cnx.createStatement();
               ResultSet rs = st.executeQuery(req1);
               if (rs.next()) {
                   int id = rs.getInt("id");
        String req = "UPDATE `reclamation` SET `statut`='" + "reclamation traitee" +
                    "' WHERE `id`=" + + id;
            st.executeUpdate(req);
             System.out.println("Réclamation modifiée !");
               } else {
                   System.out.println("Réclamation non trouvée !");
               }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    
} 
    
    
    
    
    
    
    
    
    
    
    
    
    
     
    





























//public  void Datecourante ( ) {
//    SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//    Date date = new Date();
//    System.out.println(s.format(date));
//  }
//     
//        
   
    

