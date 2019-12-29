/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mba.projeta18team5.utilities;

import java.util.HashMap;

/**
 *
 * @author user
 */
public class Errors {

    private static HashMap<Integer, String> errors = new HashMap<Integer, String>();

    private static void setErrors() {
        errors.put(0, "");
        errors.put(-1, "La description d un lot ne doit pas etre vide ");
        errors.put(-10, "La description d un lot  doit etre unique dans un terrain ");
        errors.put(-11, "Le type de terrain incorecte");
        errors.put(-12, "Le type de terrain incorecte"); 
        errors.put(-13, "Le prix minimum du lot doit etre une valeur strictement positive");
        errors.put(-14, "Le prix maximum du lot doit etre une valeur strictement positive");
        errors.put(-15, "Le prix maximum du lot doit etre superieur au prix minimum");
        errors.put(-16, "le format de la date doit respecter la norme ISO 8601");
        errors.put(-17, "le type terrain doit etre une valeur numerique entre 0 et 2");
        errors.put(-18, "le prix minimum doit respecter le format numerique avec deux positions apres la virgule #.## $");
        errors.put(-19, "le prix maximum doit respecter le format numerique avec deux positions apres la virgule #,## $");
        errors.put(-30, "Le nombre de services doit etre entre 0 et 5 inclusivement");
        errors.put(-50, "Le nombre de passages doit etre entre 0 et 10 inclusivement");
        errors.put(-70, "La superficie doit etre entre 0 et 50000 inclusivement");
        errors.put(-90, "La date doit etre au format ISO 8601 ");
        errors.put(-100, "Le nombre de lots doit etre entre 1 et 10 inclusivement");
        errors.put(-200, "Le fichier d entree inexistant, veuillez verifier le chemin");
        errors.put(-220, "Impossible de creer le fichier de sortie, veillez verifier le chemin");
    }
    public static String getErrorMessage(int code){
        setErrors();
        if(errors.containsKey(code)){
          return errors.get(code);
        }
    return "Code erreur inexistant";
    }

}
