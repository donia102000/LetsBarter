/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.services;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import tn.edu.esprit.entities.Evenement;
import tn.edu.esprit.util.MyConnector;


/**
 *
 * @author Ghazoua
 */
public class ServiceEvenement implements IService <Evenement>{
    Connection cnx = MyConnector.getInstance().getConnection();

    @Override
    public void ajouter(Evenement e) {
        
        try {
            String req = "INSERT INTO `evenement` (`matricule`,`libelle`,`date`, `lieu`, `nbrPlaceMax`,`idUtilisateur`) VALUES ('" + e.getMatricule()+ "','" + e.getLibelle()+ "','" + e.getDate()+ "','" + e.getLieu()+ "','" + e.getNbrPlaceMax()+ "','" + e.getIdUtilisateur()+ "')";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Evenement created !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    

    

    @Override
    public void supprimer(int id) {
        try {
            String req = "DELETE FROM `evenement` WHERE `idEvenement`= " + id;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Evenement deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
  
    
    public void notifierClient() {
        String k = "SELECT * FROM utilisateur where `role` ="+"client";
        try{
            Statement st = cnx.createStatement();
         ResultSet rs = st.executeQuery(k);
         while(rs.next()){
            // SendSms();
         }
        }catch(Exception e){
            System.out.print(e);
        }
        
        
    }

    @Override
    public void modifier(Evenement e) {
        try {
            String req = "UPDATE `evenement` SET `matricule` = '"+e.getMatricule()+"',`libelle` = '" +e.getLibelle()+ "',`date` = '" +e.getDate()+ "', `lieu` = '" +e.getLieu()+ "', `nbrPlaceMax` = '" +e.getNbrPlaceMax()+ "' WHERE `evenement`.`idEvenement` = " +e.getId_evenement();
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Evenement updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public List<Evenement> afficher() {
        List<Evenement> list = new ArrayList<>();
        try {
            String req = "Select * from evenement";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Evenement e = new Evenement(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7));
                list.add(e);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    
    public Evenement rechercher(int id) {
        Evenement e = null;
        try {
            String req = "Select * from `evenement` WHERE `idEvenement` = " +id;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                e = new Evenement(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return e;
    }
    
    public int selectionneeNbrPlaceM(int id) {
        
     int e=0 ;
     try{
        String req="select `nbrPlaceMax` from `evenement` where `idEvenement` = "+id;
        Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
              e= rs.getInt(1);
            }
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return e;
    }


    public List<Evenement> findEvenementByLibelle(String libelle){
        ServiceEvenement se = new ServiceEvenement();
        List<Evenement> result = se.afficher().stream().filter((p)->p.getLibelle().toUpperCase().contains(libelle.toUpperCase())).collect(Collectors.toList());
        return result;
  
    }

    @Override
    public List<Evenement> getAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}

