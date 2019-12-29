/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mba.projeta18team5.utilities;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 *
 * @author 1995045
 */
public class Terrain {

    private static final double RATE_SCHOOL = 0.012;
    private static final double RATE_MUNICIPAL = 0.025;
    private static final double VALUE_LANDED = 733.77;//valeur fonciere de base

    public static double getSchoolTax(double value) {

        double schoolTax = 0;
        if (value >= 0) {
            schoolTax = (double) Math.round((value * RATE_SCHOOL) * 100) / 100;
        }

        return roundUpAmount(schoolTax);
    }

    public static double getMunicipalTax(double value) {

        double tax = 0;
        if (value >= 0) {
            tax = (double) Math.round((value * RATE_MUNICIPAL) * 100) / 100;
        }

        return roundUpAmount(tax);
    }

    public static double roundUpAmount(double value) {
        int absolu = (int) Math.round(value * 100) / 100;
        double decimal = (double) Math.round((value - absolu) * 100);

        int rest = (int) decimal % 5;

        switch (rest) {
            case 0:
                decimal = decimal / 100;
                break;
            case 1:
                decimal = (decimal + 4) / 100;
                break;
            case 2:
                decimal = (decimal + 3) / 100;
                break;
            case 3:
                decimal = (decimal + 2) / 100;
                break;
            case 4:
                decimal = (decimal + 1) / 100;
                break;
            default:
                break;
        }
        value = absolu + decimal;

        return value;
    }

    public static JSONObject getPropertyAssessment(JSONObject terrain) {

        int typeTerrain, numPassages, numServices;
        double priceMin, priceMax, area, valueParcelling,
                schoolTax, municipalTax, totalLandValue = VALUE_LANDED;
        String description, date_measurement;
        JSONArray sourcesArray = terrain.getJSONArray("lotissements");
        JSONObject parceSource = new JSONObject();
        JSONObject parceResult = new JSONObject();
        JSONArray resultsArray = new JSONArray();
        JSONObject result = new JSONObject();

        if (!validateValueTypeTerrain(terrain.getString("type_terrain"))) {
            return createJsonError(-17);

        }

        typeTerrain = terrain.getInt("type_terrain");
        /*  
        if (validateTypeTerrain(typeTerrain) == -1) {
            return createJsonError(-11);
        }
         */
        if (!isCurrencyType(terrain.getString("prix_m2_min"))) {
            return createJsonError(-18);
        }
        priceMin = getPriceFromString(validateDecimalChar(terrain.getString("prix_m2_min")));
    
        if (!isCurrencyType(terrain.getString("prix_m2_max"))) {
            return createJsonError(-19);
        }
        priceMax = getPriceFromString(validateDecimalChar(terrain.getString("prix_m2_max")));
      

        if (priceMin >= priceMax) {
            return createJsonError(-15);
        }

        if (Parcelling.validateParcelingsArray(terrain) != 0) {
            return createJsonError(Parcelling.validateParcelingsArray(terrain));
        }

        for (int i = 0; i < sourcesArray.size(); i++) {
            parceSource = sourcesArray.getJSONObject(i);
            description = parceSource.getString("description");
            numPassages = parceSource.getInt("nombre_droits_passage");
            numServices = parceSource.getInt("nombre_services");
            area = parceSource.getDouble("superficie");
            date_measurement = parceSource.getString("date_mesure");
            parceResult.accumulate("description", description);

            if (!validateDate(date_measurement)) {
                return createJsonError(-16);
            }

            valueParcelling = Parcelling.getValueLanded(typeTerrain, numPassages,
                    numServices, priceMin, priceMax, area);
            totalLandValue = totalLandValue + valueParcelling;
            parceResult.accumulate("valeur_par_lot", validateDecimalChar(parseValue(valueParcelling)));
            resultsArray.add(parceResult);
            parceResult = new JSONObject();

        }

        totalLandValue = roundUpAmount(totalLandValue);
        result.accumulate("valeur_fonciere_totale", validateDecimalChar(parseValue(totalLandValue)));
        schoolTax = getSchoolTax(totalLandValue);
        result.accumulate("taxe_scolaire", validateDecimalChar(parseValue(schoolTax)));
        municipalTax = getMunicipalTax(totalLandValue);
        result.accumulate("taxe_municipale", validateDecimalChar(parseValue(municipalTax)));
        result.accumulate("lotissements", resultsArray);
        return result;
    }

    public static double getPriceFromString(String value) {

        return Double.valueOf(value.substring(0, (value.length() - 2)));

    }

    private static String parseValue(double value) {
        return String.format("%.2f", value) + " $";
    }

    public static String validateDecimalChar(String value) {

        if (value.indexOf(',') != -1) {
            value = value.replace(',', '.');
        }

        return value;
    }

    /* 
    public static int validateTypeTerrain(int typeTerrain) {
        if (typeTerrain == 0 || typeTerrain == 1 || typeTerrain == 2) {
            return 1;
        }
        return -1;
    }
     */
    public static boolean validateValueTypeTerrain(String value) {

        return value.matches("[0-2]");
    }

    public static boolean validateDate(String value) {

        return value.matches("\\d{4}-\\d{2}-\\d{2}");
    }

    public static JSONObject createJsonError(int codeErreur) {
        JSONObject erreur = new JSONObject();
        erreur.accumulate("message", Errors.getErrorMessage(codeErreur));

        return erreur;
    }

    public static boolean isCurrencyType(String value) {
        String regex = "\\d+([,.]\\d\\d)\\s\\$?";
        return java.util.regex.Pattern.matches(regex, value);
    }

}
