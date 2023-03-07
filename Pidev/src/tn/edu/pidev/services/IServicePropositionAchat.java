/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.pidev.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import tn.edu.pidev.entities.PropositionAchat;
import tn.edu.pidev.utils.Connexion;

/**
 *
 * @author Admin
 */
public class IServicePropositionAchat implements IServices <PropositionAchat> {
private Connexion cn = Connexion.getInstance();


        @Override
    public void ajouterPropositionAchat(PropositionAchat p) throws SQLException {
        String req = "INSERT INTO `propositionachats` (`negociation`, `tel`, `mail`, `prixa`) VALUES (?,?,?,?)";
        PreparedStatement st = cn.getCnx().prepareStatement(req);
        st.setString(1, p.getNegociation());
        st.setInt(2, p.getTel());
        st.setString(3,p.getMail());
          st.setFloat(4,p.getPrix());
        
        st.executeUpdate();
    }

    @Override
    public void supprimer(PropositionAchat p) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ajouterPropositionTroc(PropositionAchat p) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



    @Override
    public void ajouterAnnonceFavoris(PropositionAchat p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PropositionAchat> getAll() throws SQLException {
                  List<PropositionAchat> list = new ArrayList<>();
        
        String req = "Select * from propositionachats";
        Statement st = cn.getCnx().createStatement();
        ResultSet rs = st.executeQuery(req);
         while (rs.next()) {
                
        PropositionAchat p = new PropositionAchat (rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getFloat(5));
        list.add(p);
         }
            return list; 
    }
    
}
