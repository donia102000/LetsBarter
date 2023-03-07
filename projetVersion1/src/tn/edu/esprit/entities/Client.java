/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.entities;

import java.sql.Date;

/***
 *
 * @author Donia
 */
public class Client extends Utilisateur{
private int nbPoint;
    public Client() {
    }

    public Client( int idUtilisateur, String nomUtilisateur, String prenomUtilisateur, String email, String motDePasse, String genre, int numTelephone, String adresse, String role,int cin,int nbPoint) {
        super(idUtilisateur, nomUtilisateur, prenomUtilisateur, email, motDePasse, genre, numTelephone, adresse, role,cin);
        this.nbPoint = nbPoint;
    }

    public Client(String nomUtilisateur, String prenomUtilisateur, String email, String motDePasse, String genre, int numTelephone, String adresse, String role ,int cin,int nbPoint) {
        super(nomUtilisateur, prenomUtilisateur, email, motDePasse, genre,  numTelephone, adresse, role,cin);
        this.nbPoint = nbPoint;
    }

    @Override
    public String toString() {
       return super.toString()+"Client{" + "nbPoint=" + nbPoint + '}';
    }

   

    

   

    public int getPoint() {
        return nbPoint;
    }

    public void setPoint(int point) {
        this.nbPoint = point;
    }

    public Client(String nomUtilisateur, String prenomUtilisateur, String email, String motDePasse, String genre, int numTelephone, String adresse, String role, int cin, byte[] image,int nbPoint) {
        super(nomUtilisateur, prenomUtilisateur, email, motDePasse, genre, numTelephone, adresse, role, cin, image);
        this.nbPoint = nbPoint;
    }

   
    
    
}
