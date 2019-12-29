/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mba.projeta18team5.control;

import com.mba.projeta18team5.files.IOsJsonFiles;
import com.mba.projeta18team5.utilities.PropertyAssessments;
import java.io.Console;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

/**
 *
 * @author 1995089
 */
public class Controller {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        if (args.length == 2) {
            try {
                IOsJsonFiles.loadJsonFile(args[0]);
                try {
                    IOsJsonFiles.createJsonFile(args[1],
                            IOsJsonFiles.loadJsonFile(args[0]));
                    PropertyAssessments.createPropertyAssessments(args[0],
                            args[1]);
                     System.out.println("Fichier "+args[1] + " a été crée "
                             + "correctement");

                } catch (IOException e) {
                    System.out.println("L'emplacement du fichier de sortie "
                            + args[1] + " est introuvable. Verifier le chemin.");
                }

            } catch (IOException ex) {
                System.out.println("Le fichier source " + args[0]
                        + " est introuvable. Verifier le chemin.");
            } catch (JSONException e) {
                System.out.println("Attention ! l'une des propriètés du fichier"
                        + " n'a pas de valeur. Impossible d'extraire le contenu"
                        + " du fichier.\n"
                        + "Verifier les valeurs de toutes les "
                        + "propriètés puis réessayer");
            }
        } else {
            System.out.println("le nombre des arguments doit être : 2.\n"
                    + "Le premier argument contient le fichier source et le "
                    + "deuxieme argument contient le fichier destination");
        }

    }

}
