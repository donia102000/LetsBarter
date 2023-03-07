/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.entities;

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
    protected String role;
    protected int cin;

    public Utilisateur() {
    }

    public Utilisateur(String nomUtilisateur, String prenomUtilisateur, String email, String motDePasse, String genre, String dateDeNaissance, int numTelephone, String adresse, String role, int cin) {
        this.nomUtilisateur = nomUtilisateur;
        this.prenomUtilisateur = prenomUtilisateur;
        this.email = email;
        this.motDePasse = motDePasse;
        this.genre = genre;
        this.dateDeNaissance = dateDeNaissance;
        this.numTelephone = numTelephone;
        this.adresse = adresse;
        this.role = role;
        this.cin = cin;
    }

    public Utilisateur(int idUtilisateur, String nomUtilisateur, String prenomUtilisateur, String email, String motDePasse, String genre, String dateDeNaissance, int numTelephone, String adresse, String role, int cin) {
        this.idUtilisateur = idUtilisateur;
        this.nomUtilisateur = nomUtilisateur;
        this.prenomUtilisateur = prenomUtilisateur;
        this.email = email;
        this.motDePasse = motDePasse;
        this.genre = genre;
        this.dateDeNaissance = dateDeNaissance;
        this.numTelephone = numTelephone;
        this.adresse = adresse;
        this.role = role;
        this.cin = cin;
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

    public String getRole() {
        return role;
    }

    public int getCin() {
        return cin;
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

    public void setRole(String role) {
        this.role = role;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.idUtilisateur;
        hash = 17 * hash + Objects.hashCode(this.nomUtilisateur);
        hash = 17 * hash + Objects.hashCode(this.prenomUtilisateur);
        hash = 17 * hash + Objects.hashCode(this.email);
        hash = 17 * hash + Objects.hashCode(this.motDePasse);
        hash = 17 * hash + Objects.hashCode(this.genre);
        hash = 17 * hash + Objects.hashCode(this.dateDeNaissance);
        hash = 17 * hash + this.numTelephone;
        hash = 17 * hash + Objects.hashCode(this.adresse);
        hash = 17 * hash + Objects.hashCode(this.role);
        hash = 17 * hash + this.cin;
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
        if (this.cin != other.cin) {
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
        if (!Objects.equals(this.role, other.role)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "idUtilisateur=" + idUtilisateur + ", nomUtilisateur=" + nomUtilisateur + ", prenomUtilisateur=" + prenomUtilisateur + ", email=" + email + ", motDePasse=" + motDePasse + ", genre=" + genre + ", dateDeNaissance=" + dateDeNaissance + ", numTelephone=" + numTelephone + ", adresse=" + adresse + ", role=" + role + ", cin=" + cin + '}';
    }

    
}
