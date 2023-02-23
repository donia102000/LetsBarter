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
        //Utilisateur user1 = inscrit().getId()
        try {
            String req = "INSERT INTO `evenement` (`libelle`,`date`, `lieu`, `nbrPlaceMax`) VALUES ('" + e.getLibelle()+ "', '" +e.getDate()+ "','" + e.getLieu()+ "','" + e.getNbrPlaceMax()+ "')";
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

    @Override
    public void modifier(Evenement e) {
        try {
            String req = "UPDATE `evenement` SET `libelle` = '" +e.getLibelle()+ "',`date` = '" +e.getDate()+ "', `lieu` = '" +e.getLieu()+ "', `nbrPlaceMax` = '" +e.getNbrPlaceMax()+ "' WHERE `evenement`.`idEvenement` = " +e.getId_evenement();
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
                Evenement e = new Evenement(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6));
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
                e = new Evenement(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return e;
    }
}

