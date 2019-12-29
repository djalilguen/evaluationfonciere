/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mba.projeta18team5.utilities;

import com.mba.projeta18team5.files.IOsJsonFiles;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

/**
 *
 * @author 1995089
 */
public class PropertyAssessments {

    public static void createPropertyAssessments(String fileIn, String fileOut)
            throws IOException {
        JSONObject jsonSource, jsonDestination = new JSONObject();
        try {
            jsonSource = IOsJsonFiles.loadJsonFile(fileIn);
            jsonDestination.clear();
            switch (validateLengthJsonObject(jsonSource)) {
                case 0:
                    jsonDestination = Terrain.getPropertyAssessment(jsonSource);
                    break;
                case -1:
                    jsonDestination.accumulate("message", "Une ou plusieurs "
                            + "Proprièté(s) manquante(s).");
                    System.out.println("Une ou plusieurs Proprièté(s) manquante"
                            + "(s)");
                    break;
                case -2:
                    jsonDestination.accumulate("message", "Le nombre de lots ne"
                            + " doit pas depasser 10.");
                    System.out.println("Le nombre de lots ne doit pas depasser "
                            + "10.");
                    break;
                case -3:
                    jsonDestination.accumulate("message", "Attention ! l'une "
                            + "des Proprièté(s) d'un element du tableau "
                            + "'lotissements' est manquante.");
                    System.out.println("Attention ! l'une des Proprièté(s) "
                            + "d'un element du tableau 'lotissements' est "
                            + "manquante.");
                    break;
                case -4:
                    jsonDestination.accumulate("message", "Attention ! l'une "
                            + "des propriètés contient un espace dans son "
                            + "nom.");
                    System.out.println("Attention ! l'une des propriètés "
                            + "contient un espace dans son nom.");
                    break;
                case -5:
                    jsonDestination.accumulate("message", "Attention ! l'une "
                            + "des propriètés contient une lettre en "
                            + "majuscule dans son nom.");
                    System.out.println("Attention ! l'une des propriètés "
                            + "contient une lettre en majuscule dans son nom.");
                    break;
                case -6:
                    jsonDestination.accumulate("message", "Attention ! Une "
                            + "propriètè d'un element du tableau 'lotissements'"
                            + " contient un espace dans son nom.");
                    break;
                case -7:
                    jsonDestination.accumulate("message", "Attention ! Une "
                            + "propriètè d'un element du tableau 'lotissements'"
                            + " contient une lettre en majuscule dans son nom.");
                    break;
            }
        } catch (JSONException e) {
            jsonDestination.accumulate("message", "Attention ! l'une des "
                    + "propriètés n'a pas de valeur. Verifier les valeurs "
                    + "de toutes les propriètés");
            System.out.println("Attention ! l'une des propriètés n'a pas de "
                    + "valeur. Verifier les valeurs de toutes les "
                    + "propriètés");
        } finally {
            IOsJsonFiles.createJsonFile(fileOut, jsonDestination);
        }
    }

    private static int validateLengthJsonObject(JSONObject source) {
        final int LENGTH = 4;//nombre de key dans le fichier json source
        final int LENGTH_PARSELLING = 10;
        final int LENGTH_ELEMENT = 5;//taille de chaque élément jsonObject du
        //tableau lotissements
        int j;

        JSONArray lotissements = source.getJSONArray("lotissements");
        JSONObject element = new JSONObject();

        if (source.size() != LENGTH) {
            return -1;
        } else {
            if (validateKeysBlank(source) != 0) {
                return -4;
            }

            if (validateKeysLower(source) != 0) {
                return -5;
            }

            if (lotissements.size() <= 0 || lotissements.size()
                    > LENGTH_PARSELLING) {
                return -2;
            } else {
                for (int i = 0; i < lotissements.size(); i++) {
                    j = i + 1;
                    element = lotissements.getJSONObject(i);
                    if (element.size() != LENGTH_ELEMENT) {
                        System.out.println("Attention ! Il manque une propriètè"
                                + " à l'élement " + j + " du tableau "
                                + "'lotissements'");
                        return -3;
                    }
                    if (validateKeysBlank(element) != 0) {
                        System.out.println("Attention ! Une propriètè de "
                                + "l'élement " + j + " du tableau "
                                + "'lotissements' contient un espace dans "
                                + "son nom");
                        return -6;
                    }

                    if (validateKeysLower(element) != 0) {
                        System.out.println("Attention ! Une propriètè de "
                                + "l'élement " + j + " du tableau "
                                + "'lotissements' contient une lettre en "
                                + "majuscule dans son nom");
                        return -7;
                    }
                }
            }
        }
        return 0;

    }

    private static boolean isUpper(String source) {
        for (int i = 0; i < source.length(); i++) {
            char ch = source.charAt(i);
            if (Character.isUpperCase(ch)) {
                return true;
            }
        }
        return false;
    }

    private static int validateKeysBlank(JSONObject source) {
        for (int i = 0; i < source.size(); i++) {
            if (source.names().get(i).toString().contains(" ")) {
                return -4;
            }
        }
        return 0;
    }

    private static int validateKeysLower(JSONObject source) {
        for (int i = 0; i < source.size(); i++) {
            if (isUpper(source.names().get(i).toString())) {
                return -5;
            }
        }
        return 0;
    }
}
