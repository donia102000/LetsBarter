
package tn.edu.esprit.entities;

/**
 *
 * @author Donia
 */
public class Admin extends Utilisateur{

    public Admin() {
    }

    public Admin(int idUtilisateur, String nomUtilisateur, String prenomUtilisateur, String email, String motDePasse, String genre, String dateDeNaissance, int numTelephone, String adresse, String role) {
        super(idUtilisateur, nomUtilisateur, prenomUtilisateur, email, motDePasse, genre, dateDeNaissance, numTelephone, adresse, role);
    }

    public Admin(String nomUtilisateur, String prenomUtilisateur, String email, String motDePasse, String genre, String dateDeNaissance, int numTelephone, String adresse, String role) {
        super(nomUtilisateur, prenomUtilisateur, email, motDePasse, genre, dateDeNaissance, numTelephone, adresse, role);
    }
    
    
   

    
    

   

    

   

    

    
    
    
}
