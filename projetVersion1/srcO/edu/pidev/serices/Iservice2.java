/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pidev.serices;

import edu.pidev.entities.SousCategorie;
import java.util.List;


public interface Iservice2 < sousCategorie > {
    
  
    void ajouter(SousCategorie sc);
    
    void modifier(SousCategorie sc);
    
    void supprimer(SousCategorie sc);
    
    SousCategorie trouverParId(int id);
     
    List<SousCategorie> trouverTous();    
   
    
}
