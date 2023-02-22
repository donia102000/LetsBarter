/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pidev.entities;

import java.sql.Date;

/**
 *
 * @author Dell
 */
public class Reclamation {
    private  int id ; 
   private  String  date_reclamation ; 
    private  String description ; 
    private  String statut ; 
    private String type ; //rembrourssement , recommondation , compensation, reparation 
    private  String info_produit ; // des informations sur le produit ou le service qui fait l'objet de la réclamation, telles que la marque, le modèle, le numéro de série ou le numéro de commande.
    private String nom_prenom; 
    private  int tel ; 
    private  String mail ;  
    private String etat ; 

    public Reclamation() {
    }

    public Reclamation(String date_reclamation, String description, String statut, String type, String info_produit, String nom_prenom, int tel, String mail, String etat) {
        this.date_reclamation = date_reclamation;
        this.description = description;
        this.statut = statut;
        this.type = type;
        this.info_produit = info_produit;
        this.nom_prenom = nom_prenom;
        this.tel = tel;
        this.mail = mail;
        this.etat = etat;
    } 

    public Reclamation(int id, String date_reclamation, String description, String statut, String type, String info_produit, String nom_prenom, int tel, String mail, String etat) {
        this.id = id;
        this.date_reclamation = date_reclamation;
        this.description = description;
        this.statut = statut;
        this.type = type;
        this.info_produit = info_produit;
        this.nom_prenom = nom_prenom;
        this.tel = tel;
        this.mail = mail;
        this.etat = etat;
    }

//    public Reclamation(String string) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    public int getId() {
        return id;
    }

    public String getDate_reclamation() {
        return date_reclamation;
    }

    public String getDescription() {
        return description;
    }

    public String getStatut() {
        return statut;
    }

    public String getType() {
        return type;
    }

    public String getInfo_produit() {
        return info_produit;
    }

    public String getNom_prenom() {
        return nom_prenom;
    }

    public int getTel() {
        return tel;
    }

    public String getMail() {
        return mail;
    }

    public String getEtat() {
        return etat;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate_reclamation(String date_reclamation) {
        this.date_reclamation = date_reclamation;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setInfo_produit(String info_produit) {
        this.info_produit = info_produit;
    }

    public void setNom_prenom(String nom_prenom) {
        this.nom_prenom = nom_prenom;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

   public Reclamation(String nomPrenom,String description) {
		super();
		this.description = description;
		this.nom_prenom = nomPrenom; 
	}
    
    

}

