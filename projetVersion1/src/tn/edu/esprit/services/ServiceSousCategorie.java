/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.services;


import tn.edu.esprit.entities.Reclamation;
import tn.edu.esprit.entities.SousCategorie;
import tn.edu.esprit.util.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *   
 * @author Dell
 */
public   class ServiceSousCategorie implements IService <SousCategorie> {
     
    
      Connection cnx = DataSource.getInstance().getCnx();

       DataSource instance = DataSource.getInstance(); 

  
        
 

  
    public void ajouter(SousCategorie sc) {
       /*  try {
            String req = "INSERT INTO `sous_categorie` ( `libelle`, `idCategorie`) VALUES (" + sc.getLibelle() + ","+sc.getId()+")";  
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Sous-categorie creer !");
        } catch (SQLException ex) { 
            System.out.println(ex.getMessage());
        }*/
         
         
                        String requete2 = "INSERT INTO sous_categorie (libelle,idCategorie)"
                       + "VALUES(?,?)";
              try{
               PreparedStatement pst = new DataSource().getCnx().prepareStatement(requete2);
                    pst.setString(1, sc.getLibelle());
                    pst.setInt(2, sc.getIdCategorie());



                  pst.executeUpdate();
                  System.out.println("votre sous-categorie est ajouté");
                  
            } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    
    }
    }

    public void modifier(SousCategorie sc) {
       try {
            String req = "UPDATE `sous_categorie` SET `libelle` = '" + sc.getLibelle() ; 
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("libelle modifie !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void supprimer(SousCategorie sc) {
        try {
            String req = "DELETE FROM `sous_categorie` WHERE `id` = " + sc.getId();
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Sous-categorie supprim�e !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public SousCategorie trouverParId(int id) {
       SousCategorie sc = null;
        try {
            String req = "SELECT * FROM `sous_categorie` WHERE `id` = " + id;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            if (rs.next()) {
                sc = new SousCategorie(rs.getInt("id"), rs.getString("libelle"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return sc;  
    }

   
    public List<SousCategorie> trouverTous() {
        List<SousCategorie> sousCategories = new ArrayList<>();
        try {
            String req = "SELECT * FROM `sous_categorie`";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                SousCategorie sc = new SousCategorie(rs.getInt("id"), 
                		rs.getString("libelle"));                                            
                sousCategories.add(sc); 
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return sousCategories; 
    } 

   
    public void modifierReclamation(Reclamation reclamation, String role) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void supprimer(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SousCategorie> getAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }


  
   