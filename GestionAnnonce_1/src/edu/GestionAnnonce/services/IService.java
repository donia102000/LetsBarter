/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.GestionAnnonce.services;

import edu.GestionAnnonce.entities.Annonce;
import java.util.List;

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

    Annonce chercherAnnonceParId(int id);
     public void modifier(Annonce annonce);
}