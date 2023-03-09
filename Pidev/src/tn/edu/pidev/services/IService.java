/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.pidev.services;

import com.sun.org.glassfish.gmbal.Description;
import java.io.ByteArrayInputStream;
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
import java.util.stream.Collectors;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javax.sql.rowset.serial.SerialBlob;
import tn.edu.pidev.utils.Connexion;
import tn.edu.pidev.entities.Annonce;
import tn.edu.pidev.entities.Favoris;


/**
 *
 * @author Admin
 */
public class IService implements IServices <Favoris>{
        private Connexion cn = Connexion.getInstance();

    @Override
    public void supprimer(Favoris p) throws SQLException {
      try {
               String req1 = "SELECT id FROM favoris WHERE `title`='" + p.getTitle()+ "'";
               Statement st = cn.getCnx().createStatement();
               ResultSet rs = st.executeQuery(req1);
               if (rs.next()) {
                   int id = rs.getInt("id");
                String req = "DELETE FROM favoris WHERE id = "+id;
                st.executeUpdate(req);             
                 System.out.println("Favoris supprimée !");
               }
               else {
                     System.out.println("Favoris non trouvée !");
                 }
            } catch (SQLException ex) { 
                System.out.println(ex.getMessage());
            }
    }



    
      @Override
    public List<Favoris> getAll() throws SQLException {
      List<Favoris> list = new ArrayList<>();
        
        String req = "Select * from favoris";
        Statement st = cn.getCnx().createStatement();
        ResultSet rs = st.executeQuery(req);
         while (rs.next()) {
                
        Favoris f = new Favoris (rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
        list.add(f);
         }
            return list; 
    }



    @Override
    public void ajouterAnnonceFavoris(Favoris p) {
       String req = "INSERT INTO favoris (title,description,categorie,adresse) VALUES (?, ?, ?,?)";
            PreparedStatement st;
            try {
                st = cn.getCnx().prepareStatement(req);
           
            //st.setInt(1,a.getIdannonce());
            st.setString(1,p.getTitle());
            st.setString(2,p.getDescription());
            st.setString(3,p.getCategorie());
            st.setString(4,p.getAdresse());
            
            st.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(IService.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

  
    
        @Override
    public void ajouterPropositionAchat(Favoris p) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void ajouterPropositionTroc(Favoris p) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<Favoris> findFavorisByTitre(String title) throws SQLException{
        IService sp = new  IService ();
        List<Favoris> result = sp.getAll().stream().filter((p)->p.getTitle().toUpperCase().contains(title.toUpperCase())).collect(Collectors.toList());
        return result;
  
    }
}
    



