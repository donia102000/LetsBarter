/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.entities;


import java.util.Objects;
import tn.edu.esprit.services.ServiceEvenement;

/**
 *
 * @author Ghazoua
 */
public class Evenement {
    private int id_evenement;
    private String matricule;
    private String libelle;
    private String date;
    private String lieu;
    private String nbrPlaceMax;
    public Organisateur organisateur;
    int idUtilisateur;
    
    ServiceEvenement se= new ServiceEvenement();

    public Evenement() {
    }

    public Evenement(int id_evenement, String matricule, String libelle, String date, String lieu, String nbrPlaceMax, Organisateur organisateur) {
        this.id_evenement = id_evenement;
        this.matricule = matricule;
        this.libelle = libelle;
        this.date = date;
        this.lieu = lieu;
        this.nbrPlaceMax = nbrPlaceMax;
        this.organisateur = organisateur;
    }

    public Evenement(int id_evenement, String matricule, String libelle, String date, String lieu, String nbrPlaceMax, int idUtilisateur) {
        this.id_evenement = id_evenement;
        this.matricule = matricule;
        this.libelle = libelle;
        this.date = date;
        this.lieu = lieu;
        this.nbrPlaceMax = nbrPlaceMax;
        this.idUtilisateur = idUtilisateur;
    }
     

    
    public Evenement(String matricule, String libelle, String date, String lieu, String nbrPlaceMax, int idUtilisateur) {
        this.matricule = matricule;
        this.libelle = libelle;
        this.date = date;
        this.lieu = lieu;
        this.nbrPlaceMax = nbrPlaceMax;
        this.idUtilisateur = idUtilisateur;
    }

    public Evenement(String matricule, String libelle, String date, String lieu, String  nbrPlaceMax, Organisateur organisateur) {
        this.matricule = matricule;
        this.libelle = libelle;
        this.date = date;
        this.lieu = lieu;
        this.nbrPlaceMax = nbrPlaceMax;
        this.organisateur = organisateur;
    }

    public Evenement(String matricule, String libelle, String date, String lieu, String nbrPlaceMax) {
        this.matricule = matricule;
        this.libelle = libelle;
        this.date = date;
        this.lieu = lieu;
        this.nbrPlaceMax = nbrPlaceMax;
    }
    
    

    public int getId_evenement() {
        return id_evenement;
    }

    public String  getMatricule() {
        return matricule;
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

    public String  getNbrPlaceMax() {
        return nbrPlaceMax;
    }

    public Organisateur getOrganisateur() {
        return organisateur;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setId_evenement(int id_evenement) {
        this.id_evenement = id_evenement;
    }

    public void setMatricule(String  matricule) {
        this.matricule = matricule;
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

    public void setNbrPlaceMax(String  nbrPlaceMax) {
        this.nbrPlaceMax = nbrPlaceMax;
    }

    public void setOrganisateur(Organisateur organisateur) {
        this.organisateur = organisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.id_evenement;
        hash = 53 * hash + Objects.hashCode(this.matricule);
        hash = 53 * hash + Objects.hashCode(this.libelle);
        hash = 53 * hash + Objects.hashCode(this.date);
        hash = 53 * hash + Objects.hashCode(this.lieu);
        hash = 53 * hash + Objects.hashCode(this.nbrPlaceMax);
        hash = 53 * hash + Objects.hashCode(this.organisateur);
        hash = 53 * hash + this.idUtilisateur;
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
        if (!Objects.equals(this.matricule, other.matricule)) {
            return false;
        }
        if (!Objects.equals(this.nbrPlaceMax, other.nbrPlaceMax)) {
            return false;
        }
        if (this.idUtilisateur != other.idUtilisateur) {
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
        if (!Objects.equals(this.organisateur, other.organisateur)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Evenement{" + "Matricule=" + matricule + ", Libelle=" + libelle + ", Date=" + date + ", Lieu=" + lieu + ", NombrePlaceMax=" + nbrPlaceMax + ", idUtilisateur=" + idUtilisateur + '}';
    }

    
}
