/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pidev.entities;

import java.awt.Image;
import java.util.ArrayList;
import javafx.scene.control.TextField;

/**
 *

    */
   public class Categorie { 


     public  int idCat ; 
       public  String nomCategorie ; 

      

       private ArrayList<SousCategorie> sousCategories;

   //     public Image logo ; 

       public Categorie() {
           sousCategories = new ArrayList<SousCategorie>();
       } 

    public Categorie(int idCat, String nomCategorie, ArrayList<SousCategorie> sousCategories) {
        this.idCat = idCat;
        this.nomCategorie = nomCategorie;
        this.sousCategories = sousCategories;
    } 

    public Categorie(int idCat, String nomCategorie) {
        this.idCat = idCat;
        this.nomCategorie = nomCategorie;
    }

    public Categorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }
     
    

    public int getIdCat() {
        return idCat;
    }

    public String getNomCategorie() {
        return nomCategorie;
    }

    public ArrayList<SousCategorie> getSousCategories() {
        return sousCategories;
    }

    public void setIdCat(int idCat) {
        this.idCat = idCat;
    }

    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }

    public void setSousCategories(ArrayList<SousCategorie> sousCategories) {
        this.sousCategories = sousCategories;
    }

    @Override
    public String toString() {
        return "Categorie{" + "idCat=" + idCat + ", nomCategorie=" + nomCategorie + ", sousCategories=" + sousCategories + '}';
    }



    
       

   }













