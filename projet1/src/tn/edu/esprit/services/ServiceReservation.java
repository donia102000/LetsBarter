/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.services;

import java.sql.Connection;
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
public class ServiceReservation implements IService2 <Reservation>{
    Connection cnx = DataBase1.getInstance().getCnx();

    @Override
    public void ajouter(Reservation r) {
         try {
            String req = "INSERT INTO `reservation` (`nbrPlace`) VALUES ('" + r.getNbrPace()+ "')";
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
    public void modifier(int id, int nbrPlace) {
        try {
            String req = "UPDATE `reservation` SET `nbrPlace` = '" +nbrPlace+ "' WHERE `reservation`.`idReservation` = " + id;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Evenement updated !");
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

    @Override
    public Reservation rechercher(int id) {
        Reservation r = null;
        try {
            String req = "Select * from `reservation` WHERE `idReservation` = " +id;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
               r = new Reservation(rs.getInt(1), rs.getInt(2),rs.getInt(3),rs.getInt(4));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return r;
    }
   
}
