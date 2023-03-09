
package tn.edu.esprit.entities;

/**
 *
 * @author Donia
 */
public class Utilisateur {
    
    protected int idUtilisateur;
    protected String nomUtilisateur;
    protected String prenomUtilisateur;
    protected String email;
    protected String motDePasse;
    protected String genre ;
    protected String dateDeNaissance;
    protected int numTelephone;
    protected String adresse;
    protected String role;
    protected int cin;
    

    public Utilisateur() {
    }

    public Utilisateur(int idUtilisateur, String nomUtilisateur, String prenomUtilisateur, String email, String motDePasse, String genre, String dateDeNaissance, int numTelephone, String adresse, String role,int cin) {
        this.idUtilisateur = idUtilisateur;
        this.nomUtilisateur = nomUtilisateur;
        this.prenomUtilisateur = prenomUtilisateur;
        this.email = email;
        this.motDePasse = motDePasse;
        this.genre = genre;
        this.dateDeNaissance = dateDeNaissance;
        this.numTelephone = numTelephone;
        this.adresse = adresse;
        this.role = role;
        this.cin=cin;
    }

    public Utilisateur(String nomUtilisateur, String prenomUtilisateur, String email, String motDePasse, String genre, String dateDeNaissance, int numTelephone, String adresse, String role,int cin) {
        this.nomUtilisateur = nomUtilisateur;
        this.prenomUtilisateur = prenomUtilisateur;
        this.email = email;
        this.motDePasse = motDePasse;
        this.genre = genre;
        this.dateDeNaissance = dateDeNaissance;
        this.numTelephone = numTelephone;
        this.adresse = adresse;
        this.role = role;
        this.cin=cin;
    }

   

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public String getPrenomUtilisateur() {
        return prenomUtilisateur;
    }

    public void setPrenomUtilisateur(String prenomUtilisateur) {
        this.prenomUtilisateur = prenomUtilisateur;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(String dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public int getNumTelephone() {
        return numTelephone;
    }

    public void setNumTelephone(int numTelephone) {
        this.numTelephone = numTelephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    

    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + this.idUtilisateur;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Utilisateur other = (Utilisateur) obj;
        if (this.idUtilisateur != other.idUtilisateur) {
            return false;
        }
        return true;
    }

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    @Override
    public String toString() {
        return "Nom : " + nomUtilisateur + "\nPrenom : " + prenomUtilisateur + "\nE-mail : " + email +   "\nDate De Naissance : " + dateDeNaissance + "\nTelephone : " + numTelephone + "\nAdresse : " + adresse + "\nRole : " + role + "\nCin : " + cin ;
    }

   
    
    
}
