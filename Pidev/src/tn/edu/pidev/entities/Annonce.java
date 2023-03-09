/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.pidev.entities;

import tn.edu.pidev.utils.Connexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.util.logging.Logger;
import static javax.swing.DropMode.ON;

/**
 *
 * @author Admin
 */
public class Annonce {
 
    private int idannonce;
    private String titre;
    private String categorie;
    private String souscategorie;
    private String descprition;
    private double prix;
    private String adresse;
    private int tel;

    public Annonce() {
    }
    private static final Logger LOG = Logger.getLogger(Annonce.class.getName());

    public Annonce(int idannonce, String titre, String categorie, String souscategorie, String descprition, double prix, String adresse, int tel) {
        this.idannonce = idannonce;
        this.titre = titre;
        this.categorie = categorie;
        this.souscategorie = souscategorie;
        this.descprition = descprition;
        this.prix = prix;
        this.adresse = adresse;
        this.tel = tel;
    }

    public Annonce(String titre, String categorie, String souscategorie, String descprition, double prix, String adresse, int tel) {
        this.titre = titre;
        this.categorie = categorie;
        this.souscategorie = souscategorie;
        this.descprition = descprition;
        this.prix = prix;
        this.adresse = adresse;
        this.tel = tel;
    }

    public Annonce(int idannonce, String titre, String categorie, String descprition, String adresse) {
        this.idannonce = idannonce;
        this.titre = titre;
        this.categorie = categorie;
        this.descprition = descprition;
        this.adresse = adresse;
    }

    public Annonce(String titre, String categorie, String descprition, String adresse) {
        this.titre = titre;
        this.categorie = categorie;
        this.descprition = descprition;
        this.adresse = adresse;
    }

    


  
    
    

    public int getIdannonce() {
        return idannonce;
    }



    public String getTitre() {
        return titre;
    }

    public String getCategorie() {
        return categorie;
    }

    public String getSouscategorie() {
        return souscategorie;
    }

    public String getDescprition() {
        return descprition;
    }

    public double getPrix() {
        return prix;
    }

    public String getAdresse() {
        return adresse;
    }

    public int getTel() {
        return tel;
    }

    public void setIdannonce(int idannonce) {
        this.idannonce = idannonce;
    }



    
    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setSouscategorie(String souscategorie) {
        this.souscategorie = souscategorie;
    }

    public void setDescprition(String descprition) {
        this.descprition = descprition;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Annonce other = (Annonce) obj;
        if (!Objects.equals(this.idannonce, other.idannonce)) {
            return false;
        }
        return true;
    }

    void add(Annonce annonce) {
        annonce.add(this);
    }
    
   
    
    
}
