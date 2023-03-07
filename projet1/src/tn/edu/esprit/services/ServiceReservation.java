/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import tn.edu.esprit.entities.Reservation;
import tn.edu.esprit.utils.DataBase1;

/**
 *
 * @author Ghazoua
 */
public class ServiceReservation implements IService <Reservation>{
    Connection cnx = DataBase1.getInstance().getCnx();

    @Override
    public void ajouter(Reservation r) {
        try {
            String req = "INSERT INTO `reservation` (`nbrPlace`,`idUtilisateur`,`idEvenement`) VALUES ('"+r.getNbrPace()+"','"+r.getId_client()+"','"+r.getEvenement().getId_evenement()+"')";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Reservation created !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(int id) {
        try {
            String req = "DELETE FROM `reservation` WHERE `idReservation`= " + id;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Reservation deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    @Override
    public List<Reservation> afficher() {
        List<Reservation> list = new ArrayList<>();
        try {
            String req = "Select * from `reservation`";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Reservation r = new Reservation(rs.getInt("idReservation"),rs.getInt("nbrPlace"),rs.getInt("idUtilisateur"),rs.getInt("idEvenement"));
                list.add(r);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
    
    public List<Reservation> afficherParEvenement(int idEvent) {
        List<Reservation> list = new ArrayList<>();
        try {
            String req = "Select * from `reservation` WHERE `idEvenement` ="+idEvent;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Reservation r = new Reservation(rs.getInt("idReservation"),rs.getInt("nbrPlace"),rs.getInt("idUtilisateur"),rs.getInt("idEvenement"));
                list.add(r);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

 

    @Override
    public void modifier(Reservation t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Reservation rechercher(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


   
}
