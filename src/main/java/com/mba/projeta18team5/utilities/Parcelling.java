/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mba.projeta18team5.utilities;

import java.util.HashMap;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 *
 * @author 1995156
 */
public class Parcelling {
//calculer la valeur foncière du lot elle retourne -1 si les parametres 
//sont invalides

    public static double getValue(int type, double priceMax,
            double priceMin, double area) {

        double valueParcelling = -1;

        //corps de methode
        if (priceMax > 0 && priceMin > 0 && area > 0 && priceMax >= priceMin) {
            switch (type) {
                case 0:
                    valueParcelling = area * priceMin;
                    break;
                case 1:
                    valueParcelling = area * getAVGPriceParcelling(priceMax,
                            priceMin);
                    break;
                case 2:
                    valueParcelling = area * priceMax;
                    break;
                default:
                    break;
            }
        }
        return (double) Math.round(valueParcelling * 100) / 100;
    }

    private static double getAVGPriceParcelling(double priceMax,
            double priceMin) {

        double avgPrice = 0;
        avgPrice = (priceMax + priceMin) / 2;
        return avgPrice;
    }

    //calculer la valeur foncière du lot elle retourne -1 si les parametres 
    //sont invalides
    public static double getValueLanded(int typeTerrain,
            int nbPassages, int nbServices, double priceMin, double priceMax,
            double area) {

        double value = -1;
        double parcelingValue = 0;

        if (validateEntries(typeTerrain, nbPassages, nbServices, priceMin,
                priceMax, area)) {
            parcelingValue = getValue(typeTerrain, priceMax, priceMin, area);
            value = PassageRights.getValue(typeTerrain, nbPassages, parcelingValue)
                    + Services.getAmountServices(typeTerrain, nbServices, area)
                    + parcelingValue;
        }
        return value;
    }

    /**
     *
     * @param typeTerrain -- value must be in [0,1,2]
     * @param numServices -- the value must be positive (>=0)
     * @param area -- the value must be positive (>0)
     * @return
     */
    private static boolean validateEntries(int typeTerrain, int nbPassages,
            int numServices, double priceMin, double priceMax, double area) {
        boolean valide = true;
        if (!(typeTerrain == 0 || typeTerrain == 1 || typeTerrain == 2)) {
            valide = false;
        }
        if (area <= 0 || numServices < 0 || nbPassages < 0) {
            valide = false;
        }
        if (priceMin <= 0 || priceMax <= 0 || priceMax < priceMin) {
            valide = false;
        }

        return valide;
    }

    /**
     *
     * @param JSonObject
     * @return: integer value 0 if all descriptions are valides
     * -1 if empty description 
     * -10 if duplicated description
     * 
     */
    public static int validateParcelingsDescriptions(JSONObject jsonObject) {
        HashMap hash = new HashMap();
        JSONArray sourcesArray = jsonObject.getJSONArray("lotissements");
        JSONObject parceSource;
        String description;
        for (int i = 0; i < sourcesArray.size(); i++) {
            parceSource = sourcesArray.getJSONObject(i);
            description = parceSource.getString("description");
            if ("".equalsIgnoreCase(description)) {
                return -1;
            } else if (hash.containsKey(description)) {
                return -10;
            } else {
                hash.put(description, description);
            }
        }
        return 0;
    }
    
    
    /**
     *
     * @param JSonObject
     * @return: integer value 0 if Array is valide
     * -1 if empty description 
     * -10 if duplicated description
     * -30 nb service invalide
     * -50 nb Passages invalides
     * -70 area must be between 0 and 50 000;
     * -100 nb parceling more than 10
     */
    public static int validateParcelingsArray(JSONObject jsonObject) {
        HashMap hash = new HashMap();
        JSONArray sourcesArray = jsonObject.getJSONArray("lotissements");
        JSONObject parceSource;
        String description;
        int nb_Passages;
        int nb_services;
        if (sourcesArray.size() >10 || sourcesArray.size() <1){    /// a supprimmer
            return -100;
        }
        for (int i = 0; i < sourcesArray.size(); i++) {
             parceSource = sourcesArray.getJSONObject(i);
             
            if (!Services.validateNumServices(parceSource.getInt("nombre_services"))){
                return -30;
            };
            
            if (!PassageRights.validateNumPassagesRights(parceSource.getInt("nombre_droits_passage"))){ 
                return -50;
            };
            
            if (!Services.validateArea(parceSource.getInt("superficie"))){ 
                return -70;
            };
             if (!Terrain.validateDate(parceSource.getString("date_mesure"))){  
                return -90;
            };
           
            description = parceSource.getString("description");
            if ("".equalsIgnoreCase(description)) {
                return -1;
            } else if (hash.containsKey(description)) {
                return -10;
            } else {
                hash.put(description, description);
            }
        }
        return 0;
    }
}
