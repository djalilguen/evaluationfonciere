/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mba.projeta18team5.utilities;

/**
 *
 * @author 1995089
 */
public class PassageRights {

    private static final double BASIC = 500;
    private static final double RATE_AGRICULTURAL = 0.05;
    private static final double RATE_RESIDENTIAL = 0.1;
    private static final double RATE_COMMERCIAL = 0.15;
    private static final int MIN__NUM_PASSAGE = 0;
    private static final int MAX__NUM_PASSAGE = 10;

    public static double getValue(int type, int numPassageRights,
            double valueParcelling) {

        double valuePassageRights = 0;

        if (numPassageRights >= 0 && valueParcelling > 0) {
            switch (type) {
                case 0:
                    valuePassageRights = BASIC - (numPassageRights
                            * (RATE_AGRICULTURAL * valueParcelling));
                    break;
                case 1:
                    valuePassageRights = BASIC - (numPassageRights
                            * (RATE_RESIDENTIAL * valueParcelling));
                    break;
                case 2:
                    valuePassageRights = BASIC - (numPassageRights
                            * (RATE_COMMERCIAL * valueParcelling));
                    break;
                default:
                    break;
            }
        }

        return (double) Math.round(valuePassageRights * 100) / 100;
    }

    public static boolean validateNumPassagesRights(int passageRights) {
        boolean valide = false;
        if (passageRights >= MIN__NUM_PASSAGE
                && passageRights <= MAX__NUM_PASSAGE) {
            valide = true;
        }
        return valide;
    }

}
