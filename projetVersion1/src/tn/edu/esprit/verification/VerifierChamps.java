/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.verification;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Donia
 */
public class VerifierChamps {


public static boolean stringTest (String Nom){


        for (int i = 0; i < Nom.length(); i++) {
            char ch = Nom.charAt(i);
         if (!(ch >= 'a' && ch <= 'z'|| ch >= 'A' && ch <= 'Z'))
         {
            return false;
         }
        }
        return  true;
     }
public static boolean isValidPassword(String password) {
    // Vérifier la longueur minimale du mot de passe
    if (password.length() < 8) {
        return false;
    }

    // Vérifier s'il y a au moins un chiffre dans le mot de passe
    boolean containsDigit = false;
    for (int i = 0; i < password.length(); i++) {
        if (Character.isDigit(password.charAt(i))) {
            containsDigit = true;
            break;
        }
    }
    if (!containsDigit) {
        return false;
    }

    // Vérifier s'il y a au moins une lettre majuscule dans le mot de passe
    boolean containsUpperCase = false;
    for (int i = 0; i < password.length(); i++) {
        if (Character.isUpperCase(password.charAt(i))) {
            containsUpperCase = true;
            break;
        }
    }
    if (!containsUpperCase) {
        return false;
    }

    // Vérifier s'il y a au moins une lettre minuscule dans le mot de passe
    boolean containsLowerCase = false;
    for (int i = 0; i < password.length(); i++) {
        if (Character.isLowerCase(password.charAt(i))) {
            containsLowerCase = true;
            break;
        }
    }
    if (!containsLowerCase) {
        return false;
    }

    // Si toutes les vérifications sont réussies, retourner true
    return true;
}

public static boolean isEmailAdress(String email) {
        Pattern p = Pattern
                .compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}$");
        Matcher m = p.matcher(email.toUpperCase());
        return m.matches();
    }
/*public static boolean isDigit(String  tel){
boolean  x =false;
    
 
    for (int i = 0; i < tel.length(); i++) {
        if (!Character.isDigit(tel.charAt(i))) {
            x= false;}
        
        }
    return x;
}
public static  boolean  isTelephoneValide(String tel){
    boolean  x =false;
    
 
    
        if(tel.length()== 8 && VerifierChamps.isDigit(Integer.parseInt(tel))){
        x=true;
        }
    
    

 return x;
}*/

public static boolean isTelephoneValide (String phoneNumber) {
    // Vérifie que la chaîne de caractères ne contient que des chiffres
    if (!phoneNumber.matches("[0-9]+")) {
        return false;
    }

    // Vérifie que la chaîne de caractères contient exactement 8 chiffres
    if (phoneNumber.length() != 8) {
        return false;
    }

    return true;
}
}
