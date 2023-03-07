/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.entities;

/**
 *
 * @author Ghazoua
 */
public class Client extends Utilisateur{
    private int nbPoint;

    public Client() {
    }

    public Client(String nomUtilisateur, String prenomUtilisateur, String email, String motDePasse, String genre, String dateDeNaissance, int numTelephone, String adresse, String role, int cin,int nbPoint) {
        super(nomUtilisateur, prenomUtilisateur, email, motDePasse, genre, dateDeNaissance, numTelephone, adresse, role, cin);
        this.nbPoint = nbPoint;
    }

    public Client(int idUtilisateur, String nomUtilisateur, String prenomUtilisateur, String email, String motDePasse, String genre, String dateDeNaissance, int numTelephone, String adresse, String role, int cin, int nbPoint) {
        super(idUtilisateur, nomUtilisateur, prenomUtilisateur, email, motDePasse, genre, dateDeNaissance, numTelephone, adresse, role, cin);
        this.nbPoint = nbPoint;
    }

    @Override
    public String toString() {
        return "Client{" + "nbPoint=" + nbPoint + '}';
    }
    
}
