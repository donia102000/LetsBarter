
package tn.edu.esprit.entities;

/**
 *
 * @author Donia
 */
public class Admin extends Utilisateur{

    public Admin() {
    }

    public Admin(int idUtilisateur, String nomUtilisateur, String prenomUtilisateur, String email, String motDePasse, String genre, String dateDeNaissance, int numTelephone, String adresse, String role, int cin) {
        super(idUtilisateur, nomUtilisateur, prenomUtilisateur, email, motDePasse, genre, dateDeNaissance, numTelephone, adresse, role, cin);
    }

    public Admin(String nomUtilisateur, String prenomUtilisateur, String email, String motDePasse, String genre, String dateDeNaissance, int numTelephone, String adresse, String role, int cin) {
        super(nomUtilisateur, prenomUtilisateur, email, motDePasse, genre, dateDeNaissance, numTelephone, adresse, role, cin);
    }

    
    
    
   

    
    

   

    

   

    

    
    
    
}
