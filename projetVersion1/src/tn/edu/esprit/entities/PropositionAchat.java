/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.entities;

/**
 *
 * @author Admin
 */
public class PropositionAchat {
    private int id;
    private String mail,negociation;
    private int tel;
    private float prix;
    private int idUser;

    public PropositionAchat() {
    }

    public PropositionAchat(int idUser, String mail, String negociation, int tel, float prix) {
        this.id = id;
        this.mail = mail;
        this.negociation = negociation;
        this.tel = tel;
        this.prix = prix;
        this.idUser = idUser;
    }

    public PropositionAchat(int id, int idUser ,String negociation,int tel,String mail,float prix) {
        this.id = id;
        this.mail = mail;
        this.negociation = negociation;
        this.tel = tel;
        this.prix = prix;
        this.idUser = idUser;
    }

    
    
    public PropositionAchat(String mail, String negociation, int tel, float prix) {
        this.mail = mail;
        this.negociation = negociation;
        this.tel = tel;
        this.prix = prix;
    }

    public PropositionAchat(int id,String negociation, int tel, String mail,  float prix) {
        this.id = id;
        this.mail = mail;
        this.negociation = negociation;
        this.tel = tel;
        this.prix = prix;
    }

    public PropositionAchat(String mail, String negociation, float prix) {
        this.mail = mail;
        this.negociation = negociation;
        this.prix = prix;
    }

    public PropositionAchat(int id,String mail, int tel) {
        this.mail = mail;
        this.tel = tel;
    }

    public PropositionAchat(String mail, int tel) {
        this.mail = mail;
        this.tel = tel;
    }

    


    public int getId() {
        return id;
    }

    public String getMail() {
        return mail;
    }

    public String getNegociation() {
        return negociation;
    }

    public int getTel() {
        return tel;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }
    
    

    public void setId(int id) {
        this.id = id;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setNegociation(String negociation) {
        this.negociation = negociation;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
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
        final PropositionAchat other = (PropositionAchat) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PropositionAchat " + "\nNegociation" +" "+ negociation + " " + ",\nPrix d'achat proposé"+" " + prix + " ";
    }

  
    
    
    
    
}
