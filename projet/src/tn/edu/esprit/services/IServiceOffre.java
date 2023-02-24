/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.services;

import java.util.List;
import tn.edu.esprit.entities.Offre;

/**
 *
 * @author Donia
 */
public interface IServiceOffre {
    void ajouterOffre (Offre offre);
    void modifierOffre (Offre offre);
    void supprimerOffre (int id);
    Offre chercherOffreParId(int id);
    
    List<Offre> afficherToutOffre(int refUtilisateur ,int idAnnonce);
}
