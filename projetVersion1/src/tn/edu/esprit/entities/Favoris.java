/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.entities;

import java.util.List;

/**
 *
 * @author Admin
 */
public class Favoris {
    private int id,idannonce;
   private String description;
   private String title;
    private String categorie;
     private String adresse;
    private List<Annonce> annonces;

    public Favoris() {
    }

    public Favoris(int id, int idannonce) {
        this.id = id;
        this.idannonce = idannonce;
    }
    
    

    public Favoris(int id, String description, String title) {
        this.id = id;
        this.description = description;
        this.title = title;
    }

    public Favoris(int idannonce) {
        this.idannonce = idannonce;
    }
    
    

    public Favoris(int idannonce, String description, String title, String categorie, String adresse) {
   
        this.idannonce = idannonce;
        this.description = description;
        this.title = title;
        this.categorie = categorie;
        this.adresse = adresse;
        this.annonces = annonces;
    }

    public Favoris(int id, int idannonce,  String title, String description,String categorie, String adresse) {
        this.id = id;
        this.idannonce = idannonce;
        this.description = description;
        this.title = title;
        this.categorie = categorie;
        this.adresse = adresse;
        this.annonces = annonces;
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

    public int getIdannonce() {
        return idannonce;
    }

    public void setIdannonce(int idannonce) {
        this.idannonce = idannonce;
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
        return  "Titre de l'annonce" + title + " Description" + description +  "Adresse" + adresse + '}';
    }


   
   
    
}
