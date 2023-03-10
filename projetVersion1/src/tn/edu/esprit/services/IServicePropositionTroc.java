/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import tn.edu.esprit.entities.PropositionAchat;
import tn.edu.esprit.entities.PropositionTroc;
import tn.edu.esprit.entities.Utilisateur;
import tn.edu.esprit.util.Connexion;

/**
 *
 * @author Admin
 */
public class IServicePropositionTroc implements IService <PropositionTroc>{
private Connexion cn = Connexion.getInstance();
       private File file;
       
 private FileInputStream fis;
 

    
    public void ajouterPropositionTroc(PropositionTroc p) throws SQLException {
      String req = "INSERT INTO propositiontroc (idUser,description, image,nomannonce,tel,adresse,datev) VALUES (?,?,?,?,?,?,?)";
        PreparedStatement stmt = cn.getCnx().prepareStatement(req);
 
    //PreparedStatement stmt = cn.getCnx().prepareStatement("INSERT INTO propositiontroc (idUser,description, image,nomannonce,tel,adresse,datev) VALUES (?,?,?,?,?,?,?)");
    stmt.setInt(1,p.getIdUser()); // set the ID of the image
    stmt.setString(2,p.getDescription());
    stmt.setString(3,p.getImage());
    stmt.setString(4,p.getNomannonce());
    stmt.setInt(5,p.getTel());
    stmt.setString(6,p.getAdresse());
    stmt.setString(7,p.getDatev());
      stmt.executeUpdate();
    
        try {
          
        } catch (Exception e) {
        }
      

    }

 

    
    public void ajouterPropositionAchat(PropositionTroc p) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    public void ajouterAnnonceFavoris(PropositionTroc p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public List<PropositionTroc> getAll() throws SQLException {
            List<PropositionTroc> list = new ArrayList<>();
        
        String req = "Select * from propositiontroc";
        Statement st = cn.getCnx().createStatement();
        ResultSet rs = st.executeQuery(req);
         while (rs.next()) {
                
     PropositionTroc p = new PropositionTroc (rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getString(8));
      //PropositionTroc p = new PropositionTroc ();
 //PropositionTroc p = new PropositionTroc (rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7));
        list.add(p);
         }
            return list; 
    }

   
    public void supprimer(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public List<PropositionTroc> getAllParMail(String adresse) {
           List<PropositionTroc> list = new ArrayList<>();

        try {
            String req = "Select * from `propositiontroc` where `adresse` = '"+adresse+"'";
             
            Statement st = cn.getCnx().createStatement();
             
            ResultSet rs = st.executeQuery(req);
            System.out.println(adresse);
            while (rs.next()) {
               //PropositionTroc r = new PropositionTroc(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
               PropositionTroc r=new PropositionTroc();
               r.setId(rs.getInt(1));
               r.setIdUser(rs.getInt(2));

                r.setDescription(rs.getString(3));
               r.setAdresse(rs.getString(7));
               r.setDatev(rs.getString(8));
                r.setNomannonce(rs.getString(5));
                 r.setImage(rs.getString(4));
                 
                   r.setTel(rs.getInt(6));
               
                list.add(r);
                System.out.println(r);
            }
       return list;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots " + ex.getMessage());
            return null;
        }
 
    }
   public List<PropositionTroc> findPropositionByEmail(String adresse) throws SQLException{
        IServicePropositionTroc spt = new  IServicePropositionTroc();
        List<PropositionTroc> result = spt.getAll().stream().filter((p)->p.getAdresse().toUpperCase().contains(adresse.toUpperCase())).collect(Collectors.toList());
        return result;
  
    }

       public List<Utilisateur> getAllIdProp(int id){
           List<Utilisateur> list = new ArrayList<>();

        try {
            String req = "Select nomUtilisateur,prenomUtilisateur,email from utilisateur u join propositiontroc pt  on u.idUtilisateur=pt.idUser where `id` = '"+id+"'";
             
            Statement st = cn.getCnx().createStatement();
             
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
               //PropositionTroc r = new PropositionTroc(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
               Utilisateur r =new Utilisateur();
               r.setNomUtilisateur(rs.getString(1));
               r.setPrenomUtilisateur(rs.getString(2));
                r.setEmail(rs.getString(3));
        
               
                list.add(r);
            }
       return list;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots " + ex.getMessage());
            return null;
        }

}

   
    public List<PropositionAchat> getAllParMailA(String adresse) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ajouter(PropositionTroc p) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifier(PropositionTroc p) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
