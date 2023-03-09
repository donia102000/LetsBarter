/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import tn.edu.esprit.entities.Annonce;

/**
 *
 * @author NOURHENE
 */
public class AnnonceSelectionnee {
       private Annonce annonce;
    private boolean estAimee;

    public AnnonceSelectionnee(Annonce annonce, boolean estAimee) {
        this.annonce = annonce;
        this.estAimee = estAimee;
    }

    public Annonce getAnnonce() {
        return annonce;
    }

    public boolean estAimee() {
        return estAimee;
    }

    public void setAimee(boolean estAimee) {
        this.estAimee = estAimee;
    }
}
