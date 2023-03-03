/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.entities;

import java.sql.Date;

/**
 *
 * @author Donia
 */
public class Organisateur extends Utilisateur{

    public Organisateur() {
    }

    public Organisateur(int idUtilisateur, String nomUtilisateur, String prenomUtilisateur, String email, String motDePasse, String genre, int numTelephone, String adresse, String role, int cin) {
        super(idUtilisateur, nomUtilisateur, prenomUtilisateur, email, motDePasse, genre, numTelephone, adresse, role, cin);
    }

    public Organisateur(String nomUtilisateur, String prenomUtilisateur, String email, String motDePasse, String genre, int numTelephone, String adresse, String role, int cin) {
        super(nomUtilisateur, prenomUtilisateur, email, motDePasse, genre, numTelephone, adresse, role, cin);
    }
    
    
}
