/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.entities;

import java.io.File;
import java.util.Base64;
import javafx.scene.image.Image;

/**
 *
 * @author NOURHENE
 */
public class Annonce {
     int id;
    String titre;
    String categorie;
    String souscategorie;
    String description;
    String valeurobjet;
 String image;
  
    String adresse;
    String tel;
    public Client client; 
    boolean estAimee;
private Avis avis;
  public Annonce annonce;
 int idUtilisateur;
public Annonce(Avis avis) {
        this.avis = avis;
    }

    public Annonce(String titre, String categorie, String souscategorie, String description, String valeurobjet, String image, String adresse, String tel, int idUtilisateur) {
        this.titre = titre;
        this.categorie = categorie;
        this.souscategorie = souscategorie;
        this.description = description;
        this.valeurobjet = valeurobjet;
        this.image = image;
        this.adresse = adresse;
        this.tel = tel;
        this.idUtilisateur = idUtilisateur;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public Annonce(int id, String titre, String categorie, String souscategorie, String description, String valeurobjet, String image, String adresse, String tel, Client client) {
        this.id = id;
        this.titre = titre;
        this.categorie = categorie;
        this.souscategorie = souscategorie;
        this.description = description;
        this.valeurobjet = valeurobjet;
        this.image = image;
        this.adresse = adresse;
        this.tel = tel;
        this.client = client;
    }

    public Annonce(String titre, String categorie, String souscategorie, String description, String valeurobjet, String image, String adresse, String tel) {
         this.titre = titre;
        this.categorie = categorie;
        this.souscategorie = souscategorie;
        this.description = description;
        this.valeurobjet = valeurobjet;
        this.image = image;
     
        this.adresse = adresse;
        this.tel = tel;
    }

    public Annonce(int id, String titre, String categorie, String souscategorie, String description, String valeurobjet, String image, String adresse, String tel) {
        this.id = id;
        this.titre = titre;
        this.categorie = categorie;
        this.souscategorie = souscategorie;
        this.description = description;
        this.valeurobjet = valeurobjet;
        this.image = image;
        this.adresse = adresse;
        this.tel = tel;
    }

    public Annonce(String titre, String categorie, String description, String valeurobjet, String image, String adresse, String tel) {
         this.titre = titre;
        this.categorie = categorie;
      
        this.description = description;
        this.valeurobjet = valeurobjet;
        this.image = image;
     
        this.adresse = adresse;
        this.tel = tel;
    }
    public String getImage() {
        return image;
    }
     public Annonce getAnnonce() {
        return annonce;
    }

    public boolean estAimee() {
        return estAimee;
    }

    public void setAimee(boolean estAimee) {
        this.estAimee = estAimee;
    }

    @Override
    public String toString() {
        return "Annonce{" + "id=" + id + ", titre=" + titre + ", categorie=" + categorie + ", souscategorie=" + souscategorie + ", description=" + description + ", valeurobjet=" + valeurobjet + ", image=" + image + ", adresse=" + adresse + ", tel=" + tel + '}';
    }

  

   

    

    

    public Annonce(int id, String titre, String description, String image) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.image = image;
    }
 
    public Annonce() {
    }

   

    

    public Annonce(int id, String categorie, String souscategorie, String description, String valeurobjet, String image, String adresse, String tel) {
        this.id = id;
        this.categorie = categorie;
        this.souscategorie = souscategorie;
        this.description = description;
        this.valeurobjet = valeurobjet;
        this.image = image;
        this.adresse = adresse;
        this.tel = tel;
    }

  

   

    

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getSouscategorie() {
        return souscategorie;
    }

    public void setSouscategorie(String souscategorie) {
        this.souscategorie = souscategorie;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getValeurobjet() {
        return valeurobjet;
    }

    public void setValeurobjet(String valeurobjet) {
        this.valeurobjet = valeurobjet;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

  

    public void setImage(String image) {
        this.image = image;
    }

   

   

  

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

   

   

   

   

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.id;
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
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public Annonce(int id, String titre, String categorie, String souscategorie, String description, String valeurobjet, String image, String adresse, String tel, int idUtilisateur) {
        this.id = id;
        this.titre = titre;
        this.categorie = categorie;
        this.souscategorie = souscategorie;
        this.description = description;
        this.valeurobjet = valeurobjet;
        this.image = image;
        this.adresse = adresse;
        this.tel = tel;
        this.idUtilisateur = idUtilisateur;
    }

    public void setId(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
    
}
