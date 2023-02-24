/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.entities;

import java.util.logging.Logger;

/**
 *
 * @author Donia
 */
public class Offre {
    private int idOffre;
    private int refUtilisateur;
    private int refAnnonce;
    private String dateDebut;
    private String dateFin;
    private int pourcentage;

    public Offre() {
    }

    public Offre(int idOffre, int refUtilisateur, int refAnnonce, String dateDebut, String dateFin, int pourcentage) {
        this.idOffre = idOffre;
        this.refUtilisateur = refUtilisateur;
        this.refAnnonce = refAnnonce;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.pourcentage = pourcentage;
    }

    public Offre(int refUtilisateur, int refAnnonce, String dateDebut, String dateFin, int pourcentage) {
        this.refUtilisateur = refUtilisateur;
        this.refAnnonce = refAnnonce;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.pourcentage = pourcentage;
    }

    public int getIdOffre() {
        return idOffre;
    }

    public void setIdOffre(int idOffre) {
        this.idOffre = idOffre;
    }

    public int getRefUtilisateur() {
        return refUtilisateur;
    }

    public void setRefUtilisateur(int refUtilisateur) {
        this.refUtilisateur = refUtilisateur;
    }

    public int getRefAnnonce() {
        return refAnnonce;
    }

    public void setRefAnnonce(int refAnnonce) {
        this.refAnnonce = refAnnonce;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public int getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(int pourcentage) {
        this.pourcentage = pourcentage;
    }

    @Override
    public String toString() {
        return "Offre{" + "idOffre=" + idOffre + ", refUtilisateur=" + refUtilisateur + ", refAnnonce=" + refAnnonce + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", pourcentage=" + pourcentage + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.idOffre;
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
        final Offre other = (Offre) obj;
        if (this.idOffre != other.idOffre) {
            return false;
        }
        return true;
    }
    
    
    
    
}
