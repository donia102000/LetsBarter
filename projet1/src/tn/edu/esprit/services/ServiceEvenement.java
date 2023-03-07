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
import tn.edu.esprit.utils.DataBase1;


/**
 *
 * @author Ghazoua
 */
public class ServiceEvenement implements IService <Evenement>{
    Connection cnx = DataBase1.getInstance().getCnx();

    @Override
    public void ajouter(Evenement e) {
        
        try {
            String req = "INSERT INTO `evenement` (`matricule`,`libelle`,`date`, `lieu`, `nbrPlaceMax`) VALUES ('" + e.getMatricule()+ "','" + e.getLibelle()+ "','" + e.getDate()+ "','" + e.getLieu()+ "','" + e.getNbrPlaceMax()+ "')";
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
    
    public static final String ACCOUNT_SID = "AC5f06b27f454b1f253ae4bbd9c04e77e1";
    public static final String AUTH_TOKEN = "39e42a0fdce8c4b20884c98c7cd0e973";
        
    public void SendSms(){
    
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message msg = Message.creator(
                new PhoneNumber("+21658310822"),
                new PhoneNumber("+12764444527"),
                ("Un nouveau évènement a étè ajouté \n Consulter notre plateforme pour plus de détails"))
                .create();
        System.out.println(msg.getSid());
        
        }
    
    public void notifierClient() {
        String k = "SELECT * FROM utilisateur where `role` ="+"client";
        try{
            Statement st = cnx.createStatement();
         ResultSet rs = st.executeQuery(k);
         while(rs.next()){
             SendSms();
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

    @Override
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

    @Override
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


    public List<Evenement> findEvenementByLibelle(String libelle){
        ServiceEvenement se = new ServiceEvenement();
        List<Evenement> result = se.afficher().stream().filter((p)->p.getLibelle().toUpperCase().contains(libelle.toUpperCase())).collect(Collectors.toList());
        return result;
  
    }
    
    

}
