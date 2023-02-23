/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.GestionAnnonce.services;

import edu.GestionAnnonce.entities.Commentaire;
import edu.GestionAnnonce.utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author NOURHENE
 */
public class ServiceCommentaire implements IServiceCommentaire<Commentaire> {
Connection cnx = DataSource.getInstance().getCnx();
    @Override
    public void ajouter(Commentaire c) {
       try {
            String req = "INSERT INTO `commentaire` (`commentaire`) VALUES (?)";
            PreparedStatement ps = cnx.prepareStatement(req);
        
            ps.setString(1, c.getCommentaire());
           
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifier(Commentaire c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Commentaire> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
