/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.GestionAnnonce.entities;

/**
 *
 * @author NOURHENE
 */
public class Avis {
    int id_avis;
    String commentaire;

    int id_user;
    int id_annonce;
    private Annonce annonce;
      private int islike;
    private int dislike;

    public Avis() {
        this.islike = 0;
        this.dislike = 0;
    }

    public int getIslike() {
        return islike;
    }

    public void setIslike(int islike) {
        this.islike = islike;
    }

    public void incrementLike() {
        this.islike++;
    }

    public void incrementDislike() {
        this.dislike++;
    }

    

    public int getDislike() {
        return dislike;
    }

    public Avis(int id_avis, int id_annonce,String commentaire) {
        this.id_avis = id_avis;
        this.commentaire = commentaire;
     
        this.id_annonce = id_annonce;
    }

   

 

    @Override
    public String toString() {
        return "Avis{" + "id_avis=" + id_avis + ", commentaire=" + commentaire  + ", id_annonce=" + id_annonce + '}';
    }
  

    

   

  

  

 

    

  
   

    public Avis(int id_avis, String commentaire, Annonce annonce) {
        this.id_avis = id_avis;
        this.commentaire = commentaire;
        this.annonce = annonce;
    }

    public Annonce getAnnonce() {
        return annonce;
    }

    public void setAnnonce(Annonce annonce) {
        this.annonce = annonce;
    }

    public Avis(String commentaire, int id_user, int id_annonce) {
        this.commentaire = commentaire;
      
        this.id_user = id_user;
        this.id_annonce = id_annonce;
    }

    

    public Avis(String commentaire, int id_annonce) {
        this.commentaire = commentaire;
        this.id_annonce = id_annonce;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_annonce() {
        return id_annonce;
    }

    public void setId_annonce(int id_annonce) {
        this.id_annonce = id_annonce;
    }

    public int getId_avis() {
        return id_avis;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public Avis(int id_avis, String commentaire, int jaime, int id_user, int id_annonce) {
        this.id_avis = id_avis;
        this.commentaire = commentaire;
     
        this.id_user = id_user;
        this.id_annonce = id_annonce;
    }

  

   

    public void setId_avis(int id_avis) {
        this.id_avis = id_avis;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

   

   

    
    
    
    
}
