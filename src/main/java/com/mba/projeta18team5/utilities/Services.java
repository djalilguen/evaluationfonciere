/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mba.projeta18team5.utilities;

/**
 * getAmountServices return -1 if parameters are not valides 
 * if numServices not in [0,5] return -1
 * @author 1995156
 * @version 2.0
 * @since 2019-11-24
 */
public class Services {

    private static final int SERVICES_BASE = 2;
    private static final double MAX_PRICESERVICE = 5000;
    private static final double AREA_LIMIT1 = 500;
    private static final double AREA_LIMIT2 = 10000;
    private static final double PRICE_SERVICE1 = 500;
    private static final double PRICE_SERVICE2 = 1000;
    private static final double PRICE_SERVICE3 = 1500;
    private static final int MIN__NUM_SERVICE =0;
    private static final int MAX_NUM_SERVICE =5;
    private static final int [] VAIDE_TYPE_TERRAIN = new int[] {0,1,2};
    private static final int MIN_AREA =0;
    private static final int MAX_AREA =50000;
    

    // getAmountServices return -1 if parameters are not valides
    public static double getAmountServices(int typeTerrain, int numServices,
            double area) {
        double amountService = -1;
        if (validateArea(area) && validateTypeTerrain(typeTerrain) &&validateNumServices(numServices)){
        amountService = (numServices + SERVICES_BASE)
                * getPriceService(typeTerrain, area);

        if (amountService > MAX_PRICESERVICE) {
            amountService = MAX_PRICESERVICE;
        }
        }
        return (double) Math.round(amountService * 100) / 100;
    }

    private static double getPriceService(int typeTerrain, double area) {

        double priceService = 0;

        //corps de methode
        switch (typeTerrain) {
            case 1:
                if (area > AREA_LIMIT1 && area <= AREA_LIMIT2) {
                    priceService = PRICE_SERVICE1;
                } else if (area > AREA_LIMIT2) {
                    priceService = PRICE_SERVICE2;
                }
                break;
            case 2:
                if (area <= AREA_LIMIT1) {
                    priceService = PRICE_SERVICE1;
                } else {
                    priceService = PRICE_SERVICE3;
                }
                break;
            default:
                break;
        }

        return (double) Math.round(priceService * 100) / 100;
    }
    /**
     *
     * 
     */
    public static boolean validateArea(double area) {
        boolean valide = false;
        if (area > MIN_AREA && area <= MAX_AREA ) {
            valide = true;
        }
        return valide;
    }
     public static boolean validateTypeTerrain(int typeTerrain) {
        boolean valide = false;
      for (int i=0;i<VAIDE_TYPE_TERRAIN.length;i++){
          if(typeTerrain == VAIDE_TYPE_TERRAIN[i]){
              valide =true;}
      }
        return valide;
    }
      public static boolean validateNumServices(int numServices) {
        boolean valide = false;
        if (numServices >= MIN__NUM_SERVICE && numServices<= MAX_NUM_SERVICE) {
            valide = true;
        }
        return valide;
    }
}
