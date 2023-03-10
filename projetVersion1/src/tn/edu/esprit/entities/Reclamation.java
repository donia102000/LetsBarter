/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.entities;

import java.sql.Date;
import javafx.util.converter.LongStringConverter;

/**
 *
 * @author Dell
 */
public class Reclamation { 
    
    
    private  int id ; 
private Date date_reclamation; 
    private  String  texto; 
    private String type ; //rembrourssement , recommondation , compensation, reparation 
    private  String info_produit ; // des informations sur le produit ou le service qui fait l'objet de la réclamation, telles que la marque, le modèle, le numéro de série ou le numéro de commande.
    private String nom_prenom; 
    private  int tel ; 
    private  String email ;  
    private String etat ; 

  
    //texto, type, info_produit, nom_prenom, tel, mail ,etat

    public Reclamation(String texto, String type, String info_produit, String nom_prenom, int tel, String email, String etat) {
        this.texto = texto;
        this.type = type;
        this.info_produit = info_produit;
        this.nom_prenom = nom_prenom;
        this.tel = tel;
        this.email = email;
        this.etat = etat;
    }
    


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate_reclamation() {
        return date_reclamation;
    }

    public void setDate_reclamation(Date date_reclamation) {
        this.date_reclamation = date_reclamation;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

   
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInfo_produit() {
        return info_produit;
    }

    public void setInfo_produit(String info_produit) {
        this.info_produit = info_produit;
    }

    public String getNom_prenom() {
        return nom_prenom;
    }

    public void setNom_prenom(String nom_prenom) {
        this.nom_prenom = nom_prenom;
    }

  

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Reclamation() {
    } 

   

    public Reclamation(String texto, String info_produit, String nom_prenom, int tel, String email, String etat) {
        this.texto=texto; 
        this.info_produit = info_produit;
        this.nom_prenom = nom_prenom;
        this.tel = tel;
        this.email = email;
        this.etat = etat;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public Reclamation(String etat) {
        this.etat = etat;
    } 
    

 
    public Reclamation(String TypeRec, String InfoProduit, String Name, int NumTel, String Email, String EtatRec, String texto) {
      this.texto=this.texto; 
        this.type = type;
        this.info_produit = info_produit;
        this.nom_prenom = nom_prenom;
        this.tel = tel;
        this.email = email;
        this.etat = etat;
    }

    public Reclamation(int id,Date date_reclamation, String texto, String type, String info_produit, String nom_prenom, int tel, String email, String etat) {
        this.id = id;
        this.date_reclamation = date_reclamation;
        this.texto = texto;
        this.type = type;
        this.info_produit = info_produit;
        this.nom_prenom = nom_prenom;
        this.tel = tel;
        this.email = email;
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "id=" + id + ", date_reclamation=" + date_reclamation + ", texto=" + texto + ", type=" + type + ", info_produit=" + info_produit + ", nom_prenom=" + nom_prenom + ", tel=" + tel + ", email=" + email + ", etat=" + etat + '}';
    }

   
    

    

  



}

