package tn.edu.esprit.services;

 import tn.edu.esprit.entities.Categorie;
import tn.edu.esprit.entities.Reclamation;
import tn.edu.esprit.util.DataSource;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet; 
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
                                                                                            
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
 
 
/**
 * 
 * @author Dell
 */
public class Servicereclamation implements IService <Reclamation>  {   
        Connection cnx; 

    public Servicereclamation(){  
    cnx = DataSource.getInstance().getCnx();
    } 
    
   
    public void ajouter (Reclamation b,String to ) {  
            
             String req = "INSERT INTO reclamation (  texto, type, info_produit, nom_prenom, tel, mail ,etat)VALUES('"
                     
                     + b.getTexto()+"','"
                     + b.getType()+"','"
                     +b.getInfo_produit()+"','"
                     + b.getNom_prenom()+"','"
                     + b.getTel()+"','"+b.getEmail()+"','"+b.getEtat()+ "')";
 
             System.out.println(req);
              try{
                 Statement st = cnx.createStatement();
                st.executeUpdate(req);

//              ste.setString(1,b.getDate_reclamation());
//            ste.setString(2,b.getDescription());
//            ste.setString(3,b.getType());
//            ste.setString(4,b.getInfo_produit());
//            ste.setString(5,b.getNom_prenom());
//            ste.setInt(6,b.getTel());
//            ste.setString(7,b.getEmail());
//              ste.setString(8,b.getEtat());
           
            System.out.println(b.toString());
                st.executeUpdate(req); 
                 System.out.println("reclamation creer!");
          String subject = "Nouvelle Reclamation";
            String body = "Bonjour,\n\n  nouvelle Reclaamtion a été ajoutée à votre Compte.\n\nCordialement,\nL'équipe de PIDEV";
                try {
                    sendEmail(to, subject, body); // Call function to send email
                } catch (jakarta.mail.MessagingException ex) {
                    Logger.getLogger(Servicereclamation.class.getName()).log(Level.SEVERE, null, ex);
                }
   
        }
         
         catch (SQLException ex) {
            System.out.println(ex);
        }   
    }

    public void sendEmail(String to, String subject, String body) throws jakarta.mail.MessagingException {
    	   //String username = "oumaima.ayari@esprit.tn";
         //  String password = "wfltxckngjuabfqe"; 
          String username = "doniabenmessaoud3010@gmail.com";
        String password = "xfqygpnlpzvvjvdh";
         Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com"); // Change this to your SMTP server host(yahoo...)
            props.put("mail.smtp.port", "587"); // Change this to your SMTP server port
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");

            Session session;
            session = Session.getInstance(props,new Authenticator() {
            protected jakarta.mail.PasswordAuthentication getPasswordAuthentication() {
                return new jakarta.mail.PasswordAuthentication(username, password);
            }
        });
        try{
            
            // Create a MimeMessage object
            
            // Create a new message
            MimeMessage message = new MimeMessage(session);
            // Set the From, To, Subject, and Text fields of the message
            message.setFrom(new InternetAddress(username));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setText(body);
            // Send the message using Transport.send
            Transport.send(message);
            System.out.println("Email sent successfully");
             } catch (jakarta.mail.MessagingException ex) {
                Logger.getLogger(Servicereclamation.class.getName()).log(Level.SEVERE, null, ex);
            }
     }
  
//            
//      



    public void supprimer(int id) { 
        try {
            String req = "DELETE FROM `reclamation` WHERE `id`=" + id;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Réclamation supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()); 
        }

   
    }   
    
    public void modifier(Reclamation reclamation, String role) { 
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
        String req = "UPDATE `reclamation` SET `etat`='" + "reclamation traitee" +
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

     public List<Reclamation> getAll() {

            List<Reclamation> reclamation = new ArrayList<>();
            try { 
                String req = "SELECT * FROM `reclamation`";
                Statement st = cnx.createStatement();
                ResultSet rs = st.executeQuery(req);
                while (rs.next()) {
                   Reclamation reclamations  = new Reclamation(rs.getInt("id"),rs.getDate("date_reclamation"), rs.getString("type"), rs.getString("info_produit"),rs.getString("nom_prenom"), rs.getString("nom_prenom"),rs.getInt("tel"),rs.getString("mail"),rs.getString("etat")) ;   
                 

                    reclamation.add(reclamations); 
                }
            } catch (SQLException ex) { 
                System.out.println(ex.getMessage());
            }
            return reclamation;
        }

    @Override
    public void ajouter(Reclamation t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifier(Reclamation t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public List<Reclamation> trouverTous() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    public void supprimer(Reclamation t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
  public void modifierEtat(Reclamation reclamation) {
    try {
        String req = "UPDATE `reclamation` SET `etat`='reclamation traitee' WHERE `id`=" + reclamation.getId();
        Statement st = cnx.createStatement();
        int result = st.executeUpdate(req);
        if (result == 1) {
            System.out.println("Réclamation modifiée avec succès !");
        } else {
            System.out.println("Erreur : la réclamation n'a pas été trouvée !");
        }
    } catch (SQLException ex) {
        System.out.println("Erreur : " + ex.getMessage());
    }
}
  public void ajouterRec(Reclamation p) {
      


               String requete2 = "INSERT INTO reclamation (texto, type, info_produit, nom_prenom, tel, mail ,etat)"
                       + "VALUES(?,?,?,?,?,?,?)";
              try{
               PreparedStatement pst = new DataSource().getCnx().prepareStatement(requete2);
                    pst.setString(1, p.getTexto());
                    pst.setString(2, p.getType());
                    pst.setString(3, p.getInfo_produit());
                    pst.setString(4, p.getNom_prenom());
                    pst.setInt(5,p.getTel());
                    pst.setString(6,p.getEmail());
                  pst.setString(7,p.getEtat());




                  pst.executeUpdate();
                  System.out.println("votre Reclamation est envoyé");
                  
            } catch (SQLException ex) {
        System.out.println(ex.getMessage());
        
    }}
; 
   
   

}



 
    
    
    
    
    
    
    
    
    
    
    
    
    
     
    





























//public  void Datecourante ( ) {
//    SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//    Date date = new Date();
//    System.out.println(s.format(date));
//  }
//     
//        
   
    

