/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.pidev.entities;

/**
 *
 * @author Admin
 */
public class PropositionAchat {
    private int id;
    private String mail,negociation;
    private int tel;
    private float prix;

    public PropositionAchat() {
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
        return   "Mail=" + mail + ", Negociation=" + negociation + ", Téléphone=" + tel + ", Prix proposé=" + prix + '}';
    }
    
    
    
    
}
