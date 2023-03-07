/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.pidev.entities;

import java.util.List;

/**
 *
 * @author Admin
 */
public class Favoris {
    private int id;
   private String description;
   private String title;
    private String categorie;
     private String adresse;
    private List<Annonce> annonces;

    public Favoris() {
    }

    public Favoris(int id, String description, String title) {
        this.id = id;
        this.description = description;
        this.title = title;
    }

    public Favoris(int id, String title, String description,  String categorie, String adresse) {
        this.id = id;
        this.description = description;
        this.title = title;
        this.categorie = categorie;
        this.adresse = adresse;
    }

    public Favoris( String title , String description, String categorie, String adresse) {
        this.description = description;
        this.title = title;
        this.categorie = categorie;
        this.adresse = adresse;
    }

    public String getTitle() {
        return title;
    }

    
    
        public String getCategorie() {
        return categorie;
    }

    public String getAdresse() {
        return adresse;
    }
    
    

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

   
 

    public List<Annonce> getAnnonces() {
        return annonces;
    }

    public void setAnnonces(List<Annonce> annonces) {
        this.annonces = annonces;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }



    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Favoris other = (Favoris) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  "Annonce " + title + "Description  " + description +", categorie=" + categorie + ", adresse=" + adresse +  " ";
    }

   
   
    
}
