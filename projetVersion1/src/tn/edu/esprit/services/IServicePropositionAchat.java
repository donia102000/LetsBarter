/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import tn.edu.esprit.entities.PropositionAchat;
import tn.edu.esprit.entities.PropositionTroc;
import tn.edu.esprit.entities.Utilisateur;
import tn.edu.esprit.util.Connexion;

/**
 *
 * @author Admin
 */
public class IServicePropositionAchat implements IService <PropositionAchat> {
private Connexion cn = Connexion.getInstance();


       
    public void ajouterPropositionAchat(PropositionAchat p) throws SQLException {
      //  String req = "INSERT INTO `propositionachats` (`negociation`, `tel`, `mail`, `prixa`) select idUtilisateur from utilisateur where idUser='?'";
      String req = "INSERT INTO `propositionachats` (`idUser`,`negociation`, `tel`, `mail`, `prixa`) values (?,?,?,?,?)";
        PreparedStatement st = cn.getCnx().prepareStatement(req);
        st.setInt(1, p.getIdUser());
        st.setString(2, p.getNegociation());
        st.setInt(3, p.getTel());
        st.setString(4,p.getMail());
        st.setFloat(5,p.getPrix());
        
        st.executeUpdate();
    }

    public void supprimer(PropositionAchat p) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public void ajouterPropositionTroc(PropositionAchat p) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



    
    public void ajouterAnnonceFavoris(PropositionAchat p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public List<PropositionAchat> getAll() throws SQLException {
         List<PropositionAchat> list = new ArrayList<>();
        
        String req = "Select * from propositionachats";
        Statement st = cn.getCnx().createStatement();
        ResultSet rs = st.executeQuery(req);
         while (rs.next()) {
                
       PropositionAchat p = new PropositionAchat (rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getFloat(6));
     
        list.add(p);
         }
            return list; 
    }

   
    public void supprimer(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<PropositionAchat> afficherparMailTel(int id) throws SQLException{
    
        List<PropositionAchat> list = new ArrayList<>();
        try {
            String req = "Select * from propositionachats WHERE id ="+id;
            Statement st = cn.getCnx().createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
               PropositionAchat r = new PropositionAchat(rs.getString("mail"),rs.getInt("tel"));
                list.add(r);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    
    }

    
    public List<PropositionTroc> getAllParMail(String adresse) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    public List<PropositionAchat> getAllParMailA(String adresse) {
           List<PropositionAchat> list = new ArrayList<>();

        try {
            String req = "Select * from `propositionachats` where `mail` = '"+adresse+"'";
             
            Statement st = cn.getCnx().createStatement();
             
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
               //PropositionTroc r = new PropositionTroc(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
               PropositionAchat r=new PropositionAchat();
               r.setId(rs.getInt(1));
               r.setIdUser(rs.getInt(2));
             r.setNegociation(rs.getString(3));
              r.setTel(rs.getInt(4));
               r.setMail(rs.getString(5));
              
                r.setPrix(rs.getFloat(6));
            
               
                list.add(r);
            }
       return list;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots " + ex.getMessage());
            return null;
        }
    }
    
    
        public List<Utilisateur> getAllIdProp(int id){
           List<Utilisateur> list = new ArrayList<>();

        try {
            String req = "Select nomUtilisateur,prenomUtilisateur,email from utilisateur u join propositionachats apt  on u.idUtilisateur=apt.idUser where `id` = '"+id+"'";
             
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

    @Override
    public void ajouter(PropositionAchat p) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifier(PropositionAchat p) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
  
    
}
