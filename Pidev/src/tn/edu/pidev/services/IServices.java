/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.pidev.services;

import java.sql.SQLException;
import java.util.List;
import tn.edu.pidev.entities.Annonce;
import tn.edu.pidev.entities.Favoris;
import tn.edu.pidev.entities.PropositionTroc;

/**
 *
 * @author Admin
 */
public interface IServices <T> {

        public void supprimer(T p) throws SQLException;
        
        
        public void ajouterPropositionTroc(T p) throws SQLException;
        
        
      
        
        
         public void ajouterPropositionAchat(T p) throws SQLException;
         
         
      public void ajouterAnnonceFavoris(T p);
      
      
       public List<T> getAll() throws SQLException;
    
  
       

    
}
