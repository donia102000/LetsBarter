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
public class Utilisateur {
    protected int idUtilisateur;
    protected String nomUtilisateur;
    protected String prenomUtilisateur;
    protected String email;
    protected String motDePasse;
    protected String genre ;
    protected String dateDeNaissance;
    protected int numTelephone;
    protected String adresse;
    protected String statut;

    public Utilisateur() {
    }

    public Utilisateur(int idUtilisateur, String nomUtilisateur, String prenomUtilisateur, String email, String motDePasse, String genre, String dateDeNaissance, int numTelephone, String adresse, String statut) {
        this.idUtilisateur = idUtilisateur;
        this.nomUtilisateur = nomUtilisateur;
        this.prenomUtilisateur = prenomUtilisateur;
        this.email = email;
        this.motDePasse = motDePasse;
        this.genre = genre;
        this.dateDeNaissance = dateDeNaissance;
        this.numTelephone = numTelephone;
        this.adresse = adresse;
        this.statut = statut;
    }

    public Utilisateur(String nomUtilisateur, String prenomUtilisateur, String email, String motDePasse, String genre, String dateDeNaissance, int numTelephone, String adresse, String statut) {
        this.nomUtilisateur = nomUtilisateur;
        this.prenomUtilisateur = prenomUtilisateur;
        this.email = email;
        this.motDePasse = motDePasse;
        this.genre = genre;
        this.dateDeNaissance = dateDeNaissance;
        this.numTelephone = numTelephone;
        this.adresse = adresse;
        this.statut = statut;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public String getPrenomUtilisateur() {
        return prenomUtilisateur;
    }

    public String getEmail() {
        return email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public String getGenre() {
        return genre;
    }

    public String getDateDeNaissance() {
        return dateDeNaissance;
    }

    public int getNumTelephone() {
        return numTelephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getStatut() {
        return statut;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public void setPrenomUtilisateur(String prenomUtilisateur) {
        this.prenomUtilisateur = prenomUtilisateur;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setDateDeNaissance(String dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public void setNumTelephone(int numTelephone) {
        this.numTelephone = numTelephone;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.idUtilisateur;
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
        final Utilisateur other = (Utilisateur) obj;
        if (this.idUtilisateur != other.idUtilisateur) {
            return false;
        }
        if (this.numTelephone != other.numTelephone) {
            return false;
        }
        if (!Objects.equals(this.nomUtilisateur, other.nomUtilisateur)) {
            return false;
        }
        if (!Objects.equals(this.prenomUtilisateur, other.prenomUtilisateur)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.motDePasse, other.motDePasse)) {
            return false;
        }
        if (!Objects.equals(this.genre, other.genre)) {
            return false;
        }
        if (!Objects.equals(this.dateDeNaissance, other.dateDeNaissance)) {
            return false;
        }
        if (!Objects.equals(this.adresse, other.adresse)) {
            return false;
        }
        if (!Objects.equals(this.statut, other.statut)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "idUtilisateur=" + idUtilisateur + ", nomUtilisateur=" + nomUtilisateur + ", prenomUtilisateur=" + prenomUtilisateur + ", email=" + email + ", motDePasse=" + motDePasse + ", genre=" + genre + ", dateDeNaissance=" + dateDeNaissance + ", numTelephone=" + numTelephone + ", adresse=" + adresse + ", statut=" + statut + '}';
    }
    
    
}
