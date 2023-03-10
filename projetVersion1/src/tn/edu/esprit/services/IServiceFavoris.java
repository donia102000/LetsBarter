/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.services;

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
import tn.edu.esprit.util.MyConnector;
import tn.edu.esprit.entities.Annonce;
import tn.edu.esprit.entities.Favoris;
import tn.edu.esprit.entities.PropositionAchat;
import tn.edu.esprit.entities.PropositionTroc;
import tn.edu.esprit.util.Connexion;


/**
 *
 * @author Admin
 */
public class IServiceFavoris implements IService <Favoris>{
        private Connexion cn = Connexion.getInstance();

    @Override
    public void supprimer(int id) throws SQLException {

          
          String req = "DELETE FROM favoris WHERE id = "+id;
              
               Statement st = cn.getCnx().createStatement();
               //ResultSet rs = st.executeQuery(req);
  
                st.executeUpdate(req);             
          
    }



    
      @Override
    public List<Favoris> getAll() throws SQLException {
      List<Favoris> list = new ArrayList<>();
        
        String req = "Select * from favoris";
        Statement st = cn.getCnx().createStatement();
        ResultSet rs = st.executeQuery(req);
         while (rs.next()) {
                
        Favoris f = new Favoris (rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
        list.add(f);
         }
            return list; 
    }



  
    
        
    public void ajouterPropositionAchat(Favoris p) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public void ajouterPropositionTroc(Favoris p) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<Favoris> findFavorisByTitre(String title) throws SQLException{
        IServiceFavoris sp = new  IServiceFavoris ();
        List<Favoris> result = sp.getAll().stream().filter((p)->p.getTitle().toUpperCase().contains(title.toUpperCase())).collect(Collectors.toList());
        return result;
  
    }

    
    public void ajouterAnnonceFavoris(Favoris p) {
         
            try {
           String req = "INSERT INTO favoris(idannonce,title,description,categorie,adresse) SELECT idannonce,titre,description,categorie,adresse FROM annonce  WHERE idannonce = '?'";
                   //"INSERT INTO favoris (title,description,categorie,adresse) select an.titre,an.description,an.categorie,an.adresse from annonce an inner join favoris fs on an.idannonce = fs.idannonce WHERE fs.idannonce IS NULL;";
            PreparedStatement st;
                st = cn.getCnx().prepareStatement(req);
           //st.setInt(1,p.getId());
            //st.setInt(1,p.getIdannonce());
            //st.setString(1,p.getTitle());
            //st.setString(2,p.getDescription());
            //st.setString(3,p.getCategorie());
            //st.setString(4,p.getAdresse());
            
            st.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(IServiceFavoris.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

   
    public List<PropositionTroc> getAllParMail(String adresse) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public List<PropositionAchat> getAllParMailA(String adresse) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ajouter(Favoris p) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifier(Favoris p) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
    



