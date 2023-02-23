/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.entities;

/**
 *
 * @author Ghazoua
 */
public class Reservation {
    private int id_reservation;
    private int nbrPace;
    private int id_client;
    private int id_evenement;

    public Reservation() {
    }

    public Reservation(int id_reservation, int nbrPace, int id_client, int id_evenement) {
        this.id_reservation = id_reservation;
        this.nbrPace = nbrPace;
        this.id_client=id_client;
        this.id_evenement=id_evenement;
    }

    public Reservation(int id_reservation, int nbrPace) {
        this.id_reservation = id_reservation;
        this.nbrPace = nbrPace;
    }
    

    public Reservation(int nbrPace) {
        this.nbrPace = nbrPace;
    }
    

    public int getId_reservation() {
        return id_reservation;
    }

    public int getNbrPace() {
        return nbrPace;
    }

    public int getId_client() {
        return id_client;
    }

    public int getId_evenement() {
        return id_evenement;
    }

    public void setId_reservation(int id_reservation) {
        this.id_reservation = id_reservation;
    }

    public void setNbrPace(int nbrPace) {
        this.nbrPace = nbrPace;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public void setId_evenement(int id_evenement) {
        this.id_evenement = id_evenement;
    }

  
    
}
