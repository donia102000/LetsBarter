/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pidev.serices;

import edu.pidev.entities.Reclamation;

/**
 *
 * @author Dell
 */
public interface IService1  <Reclamation >{ 
    
    public void ajouter ( Reclamation r) ; 
    public void  modifierReclamation (Reclamation  reclamation , String role ) ;   
//    public void supprimerReclamation (int id ) ;  
//     public void modifier(Reclamation r) ; 
    
}  
