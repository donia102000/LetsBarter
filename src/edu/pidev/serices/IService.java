/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pidev.serices;

import java.util.List;

/**
 *
 * @author Dell
 */
public interface IService  <  C>
        {
   
    public void ajouter(C c ); 
  
    public void modifier(C c ); 
 
    
	    public void supprimer( C c );

	    public C trouverParId(int id);

	    public List<C> trouverTous();
}
