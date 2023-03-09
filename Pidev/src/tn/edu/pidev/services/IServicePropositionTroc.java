/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.pidev.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tn.edu.pidev.entities.PropositionTroc;
import tn.edu.pidev.utils.Connexion;

/**
 *
 * @author Admin
 */
public class IServicePropositionTroc implements IServices <PropositionTroc>{
private Connexion cn = Connexion.getInstance();
       private File file;
       
 private FileInputStream fis;
 
 
    @Override
    public void supprimer(PropositionTroc p) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ajouterPropositionTroc(PropositionTroc p) throws SQLException {
     
 
    PreparedStatement stmt = cn.getCnx().prepareStatement("INSERT INTO propositiontroc (description, image,nomannonce) VALUES (?,?,?)");
    //stmt.setInt(1, 1); // set the ID of the image
    stmt.setString(1,p.getDescription());
    stmt.setString(2,p.getImage());
    stmt.setString(3,p.getNomannonce());
      stmt.executeUpdate();

    }

 

    @Override
    public void ajouterPropositionAchat(PropositionTroc p) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ajouterAnnonceFavoris(PropositionTroc p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PropositionTroc> getAll() throws SQLException {
            List<PropositionTroc> list = new ArrayList<>();
        
        String req = "Select * from propositiontroc";
        Statement st = cn.getCnx().createStatement();
        ResultSet rs = st.executeQuery(req);
         while (rs.next()) {
                
        PropositionTroc p = new PropositionTroc (rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
        list.add(p);
         }
            return list; 
    }

  


}
