/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.entities;

import java.util.Objects;

/**
 *
 * @author Ghazoua
 */
public class Evenement {
    private int id_evenement;
    private String libelle;
    private String date;
    private String lieu;
    private int nbrPlaceMax;
    private int id_client;

    public Evenement() {
    }

    public Evenement(int id_evenement, String libelle, String date, String lieu, int nbrPlaceMax, int id_client) {
        this.id_evenement = id_evenement;
        this.libelle = libelle;
        this.date = date;
        this.lieu = lieu;
        this.nbrPlaceMax = nbrPlaceMax;
        this.id_client = id_client;
    }

    public Evenement(String libelle, String date, String lieu, int nbrPlaceMax, int id_client) {
        this.libelle = libelle;
        this.date = date;
        this.lieu = lieu;
        this.nbrPlaceMax = nbrPlaceMax;
        this.id_client = id_client;
    }
    public Evenement(String libelle, String date, String lieu, int nbrPlaceMax) {
        this.libelle = libelle;
        this.date = date;
        this.lieu = lieu;
        this.nbrPlaceMax = nbrPlaceMax;
    }
    public int getId_evenement() {
        return id_evenement;
    }

    public String getLibelle() {
        return libelle;
    }

    public String getDate() {
        return date;
    }

    public String getLieu() {
        return lieu;
    }

    public int getNbrPlaceMax() {
        return nbrPlaceMax;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_evenement(int id_evenement) {
        this.id_evenement = id_evenement;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public void setNbrPlaceMax(int nbrPlaceMax) {
        this.nbrPlaceMax = nbrPlaceMax;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.id_evenement;
        hash = 89 * hash + Objects.hashCode(this.libelle);
        hash = 89 * hash + Objects.hashCode(this.date);
        hash = 89 * hash + Objects.hashCode(this.lieu);
        hash = 89 * hash + this.nbrPlaceMax;
        hash = 89 * hash + this.id_client;
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
        final Evenement other = (Evenement) obj;
        if (this.id_evenement != other.id_evenement) {
            return false;
        }
        if (this.nbrPlaceMax != other.nbrPlaceMax) {
            return false;
        }
        if (this.id_client != other.id_client) {
            return false;
        }
        if (!Objects.equals(this.libelle, other.libelle)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.lieu, other.lieu)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Evenement{" + "id_evenement=" + id_evenement + ", libelle=" + libelle + ", date=" + date + ", lieu=" + lieu + ", nbrPlaceMax=" + nbrPlaceMax + ", id_client=" + id_client + '}';
    }

 
}
