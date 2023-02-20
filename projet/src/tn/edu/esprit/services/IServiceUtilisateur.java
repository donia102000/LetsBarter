/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.services;

import java.util.List;
import tn.edu.esprit.entities.Utilisateur;

/**
 *
 * @author Donia
 */
public interface IServiceUtilisateur {
    void ajouterUtilisateur (Utilisateur user);
    void modifierUtilisateur (Utilisateur user);
    void supprimerUtilisateur (int id);
    Utilisateur chercherUtilisateurParId(int id);
    Utilisateur chercherUtilisateurParCin(int cin);
    List<Utilisateur> afficherToutUtilisateur();
}
