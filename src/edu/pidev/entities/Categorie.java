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


     public  int id ; 
       public  String nomCategorie ; 

       private String description ;  

       private ArrayList<SousCategorie> sousCategories;

   //     public Image logo ; 

       public Categorie() {
           sousCategories = new ArrayList<SousCategorie>();
       } 



           public Categorie(String nomCategorie , String description) {
               this.nomCategorie = nomCategorie;
               this.description = description; 
       //        this .logo = logo;  
                sousCategories = new ArrayList<SousCategorie>();


       } 

    public Categorie(int id, String nomCategorie, String description) { 
        this.id = id;
        this.nomCategorie = nomCategorie;
        this.description = description;
        
    }
  public Categorie(  String nomCategorie  ) { 
         this.nomCategorie = nomCategorie;
          
        
    }

  
            



       public int getId() {
           return id;
       }

       public String getNomCategorie() {
           return nomCategorie;
       }

       public String getDescription() {
           return description;
       } 

       public ArrayList<SousCategorie> getSousCategories() {
           return sousCategories;
       }





   //    public Image getLogo() {
   //        return logo;
   //    }

       public void setId(int id) {
           this.id = id;
       }

       public void setNomCategorie(String nomCategorie) {
           this.nomCategorie = nomCategorie;
       }

       public void setDescription(String description) {
           this.description = description;
       } 



   //    public void setLogo(Image logo) {
   //        this.logo = logo;
   //    }
   //     

       public void setSousCategories(ArrayList<SousCategorie> sousCategories) {
           this.sousCategories = sousCategories;
       }



       public void addSousCategorie(SousCategorie sousCategorie) {
           sousCategories.add(sousCategorie);
       }

       public void removeSousCategorie(SousCategorie sousCategorie) {
           sousCategories.remove(sousCategorie);
       }


   }













