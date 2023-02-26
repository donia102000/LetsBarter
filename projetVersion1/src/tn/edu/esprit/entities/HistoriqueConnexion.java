/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.entities;

import java.sql.Date;






/**
 *
 * @author Donia
 */
public class HistoriqueConnexion {
    private int idHistorique;
    private Date dateConnexion;
    private String sysExploitation;
    private int idUtilisateur;
    private int nbConnexion;

    public HistoriqueConnexion() {
    }

    public HistoriqueConnexion(int idHistorique, Date dateConnexion, String sysExploitation, int idUtilisateur, int nbConnexion) {
        this.idHistorique = idHistorique;
        this.dateConnexion = dateConnexion;
        this.sysExploitation = sysExploitation;
        this.idUtilisateur = idUtilisateur;
        this.nbConnexion = nbConnexion;
    }

    public HistoriqueConnexion(Date dateConnexion, String sysExploitation, int idUtilisateur, int nbConnexion) {
        this.dateConnexion = dateConnexion;
        this.sysExploitation = sysExploitation;
        this.idUtilisateur = idUtilisateur;
        this.nbConnexion = nbConnexion;
    }

    public int getIdHistorique() {
        return idHistorique;
    }

    public void setIdHistorique(int idHistorique) {
        this.idHistorique = idHistorique;
    }

    public Date getDateConnexion() {
        return dateConnexion;
    }

    public void setDateConnexion(Date dateConnexion) {
        this.dateConnexion = dateConnexion;
    }

    public String getSysExploitation() {
        return sysExploitation;
    }

    public void setSysExploitation(String sysExploitation) {
        this.sysExploitation = sysExploitation;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public int getNbConnexion() {
        return nbConnexion;
    }

    public void setNbConnexion(int nbConnexion) {
        this.nbConnexion = nbConnexion;
    }

    @Override
    public String toString() {
        return "HistoriqueConnexion{" + "idHistorique=" + idHistorique + ", dateConnexion=" + dateConnexion + ", sysExploitation=" + sysExploitation + ", idUtilisateur=" + idUtilisateur + ", nbConnexion=" + nbConnexion + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.idHistorique;
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
        final HistoriqueConnexion other = (HistoriqueConnexion) obj;
        if (this.idHistorique != other.idHistorique) {
            return false;
        }
        return true;
    }
    
    
}
