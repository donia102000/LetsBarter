/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.entities;

/**
 *
 * @author Dell
 */
public class SousCategorie  {   
     
 private  int id ; 
private  String libelle ; 
private int idCategorie;

    public int getIdCategorie() { 
        return idCategorie;
    }

    public SousCategorie(int id, String libelle, int idCategorie) {
        this.id = id;
        this.libelle = libelle;
        this.idCategorie = idCategorie;
    }

    public SousCategorie(String libelle, int idCategorie) {
        this.libelle = libelle;
        this.idCategorie = idCategorie;
    }



    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public SousCategorie() {
    }

    public SousCategorie(String libelle) {
        this.libelle = libelle;
    }

    public SousCategorie(int aInt, String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.//constructeur ????
    }

    public int getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

}
