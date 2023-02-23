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
public class Commentaire {
    String commentaire;
    int id_c;

    public Commentaire(String commentaire, int id_c) {
        this.commentaire = commentaire;
        this.id_c = id_c;
    }

    public Commentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public int getId_c() {
        return id_c;
    }

    public void setId_c(int id_c) {
        this.id_c = id_c;
    }
    
}
