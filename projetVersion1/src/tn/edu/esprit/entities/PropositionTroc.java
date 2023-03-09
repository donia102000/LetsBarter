/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.entities;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Date;
import javax.sql.rowset.serial.SerialBlob;


/**
 *
 * @author Admin
 */
public class PropositionTroc {
    private int id;
    private String description;
    private String image;
    private String nomannonce;
    private String datev;
    private int tel;
    private String adresse;
    private int idUser;
    
    
    public PropositionTroc() {
    }

    public PropositionTroc(String description, String image, String nomannonce, String datev, int tel) {
        this.description = description;
        this.image = image;
        this.nomannonce = nomannonce;
        this.datev = datev;
        this.tel = tel;
    }

    
    public PropositionTroc(String description, String image, String nomannonce, int tel, String datev, String adresse) {
      
        this.description = description;
        this.image = image;
        this.nomannonce = nomannonce;
        this.datev = datev;
        this.tel = tel;
        this.adresse = adresse;
        this.idUser = idUser;
    }

    public PropositionTroc(int id, String description, String image, String nomannonce, String datev, int tel, String adresse) {
        this.id = id;
        this.description = description;
        this.image = image;
        this.nomannonce = nomannonce;
        this.datev = datev;
        this.tel = tel;
        this.adresse = adresse;
    }
    
    
    

    public PropositionTroc( int idUser, String description, String image, String nomannonce, int tel, String adresse,String datev) {
        this.idUser = idUser;
        this.description = description;
        this.image = image;
        this.nomannonce = nomannonce;
        this.datev = datev;
        this.tel = tel;
        this.adresse = adresse;
        this.idUser = idUser;
    }

    public PropositionTroc(int id, int idUser,String description, String image, String nomannonce, int tel, String adresse,String datev) {
        this.id = id;
        this.description = description;
        this.image = image;
        this.nomannonce = nomannonce;
        this.datev = datev;
        this.tel = tel;
        this.adresse = adresse;
        this.idUser = idUser;
    }
    
    
    


  

    public PropositionTroc(String description, String image, String nomannonce) {
        this.description = description;
        this.image = image;
        this.nomannonce = nomannonce;
    }

  

    
    public PropositionTroc(int id, String description,String  image) {
        this.id = id;
        this.description = description;
        this.image = image;
    }

    public PropositionTroc(String description) {
        this.description = description;
    }



    public PropositionTroc(String description,String  image) {
        this.description = description;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setNomannonce(String nomannonce) {
        this.nomannonce = nomannonce;
    }

    public String getNomannonce() {
        return nomannonce;
    }

    public String getDatev() {
        return datev;
    }

    public int getTel() {
        return tel;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setDatev(String datev) {
        this.datev = datev;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
    
    

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String  getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public PropositionTroc(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public PropositionTroc(String description, String image, String nomannonce, int tel, String adresse) {
        this.description = description;
        this.image = image;
        this.nomannonce = nomannonce;
        this.tel = tel;
        this.adresse = adresse;
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
        final PropositionTroc other = (PropositionTroc) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Description : " + description +  ", Nomannonce : " + nomannonce + ", Date de validité : " + datev + ", Téléphone : " + tel + ", Adresse : " + adresse ;
    }

   

 


    
    
}
