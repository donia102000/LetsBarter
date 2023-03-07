/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.GestionAnnonce.services;

import edu.GestionAnnonce.entities.Annonce;
import java.util.List;
import edu.GestionAnnonce.entities.Avis;

/**
 *
 * @author NOURHENE
 * @param <T>
 */
public interface IService <T>{
    public void ajouter(T p);
    public void supprimer(int id);
    public void modifier(T p);
    public List<T> getAll();
 public void updateProduit(Annonce p);
 public void supprimerAvis(int id_avis);
    Annonce chercherAnnonceParId(int id);
     public void modifier(Annonce annonce);
     public void ajouter(Avis a);
       public void modifierAvis(Avis avis);
        public void ajouterCommentaire(Avis avis);
         public void ajouterAvis(Avis f);
}
