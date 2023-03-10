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
    private Evenement evenement;

    public Reservation() {
    }

    public Reservation(int id_reservation,int nbrPace, int id_client, int id_evenement) {
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

    public Reservation(int nbrPace, int id_client, int id_evenement) {
        this.nbrPace = nbrPace;
        this.id_client = id_client;
        this.id_evenement = id_evenement;
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

    public Evenement getEvenement() {
        return evenement;
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

    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    }

    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.id_reservation;
        hash = 59 * hash + this.nbrPace;
        hash = 59 * hash + this.id_client;
        hash = 59 * hash + this.id_evenement;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reservation other = (Reservation) obj;
        if (this.id_reservation != other.id_reservation) {
            return false;
        }
        if (this.nbrPace != other.nbrPace) {
            return false;
        }
        if (this.id_client != other.id_client) {
            return false;
        }
        if (this.id_evenement != other.id_evenement) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Reservation{" + "NombrePlace= " + nbrPace + ", idClient=" + id_client + ", idEvenement=" + id_evenement + '}';
    }

  
    
}
