/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.services;

import java.util.List;

/**
 *
 * @author Ghazoua
 */
public interface IService2 <T>{
    public void ajouter(T t);
    public void supprimer(int id);
    public void modifier(int id, int nb);
    public List<T> afficher();
    public T rechercher(int id);
}
