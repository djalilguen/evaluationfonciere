/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mba.projeta18team5.utilities;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 1995089
 */
public class PassageRightsTest {

    public PassageRightsTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getValue method, of class PassageRights.
     */
    @Test
    public void testGetValue() {
        System.out.println("getValue");
        
        double valueParcelling,expResult;
        int numPassageRights=0, typeTerrain = 0;
        
        //cas valueParcelling < 0
        valueParcelling = -10;
        expResult = 0;
        double result = PassageRights.getValue(typeTerrain, numPassageRights, 
                valueParcelling);
        assertEquals(expResult, result, 0.0);

        //cas numPassageRights < 0
        numPassageRights = -1;
        valueParcelling = 1000;
        expResult = 0;
        result = PassageRights.getValue(typeTerrain, numPassageRights,
                valueParcelling);
        assertEquals(expResult, result, 0.0);

        //cas valueParcelling > 0 && numPassageRights = 0
        numPassageRights = 0;
        valueParcelling = 1000;
        expResult = 500;
        result = PassageRights.getValue(typeTerrain, numPassageRights,
                valueParcelling);
        assertEquals(expResult, result, 0.0);
        
        //cas valueParcelling > 0 && numPassageRights = 0 && typeTerrain=1
        typeTerrain=1;
        numPassageRights = 2;
        valueParcelling = 1000;
        expResult = 300;
        result = PassageRights.getValue(typeTerrain, numPassageRights,
                valueParcelling);
        assertEquals(expResult, result, 0.0);
        
        //cas valueParcelling > 0 && numPassageRights > 0 && typeTerrain=2
        typeTerrain=2;
        numPassageRights = 1;
        valueParcelling = 1000;
        expResult = 350;
        result = PassageRights.getValue(typeTerrain, numPassageRights,
                valueParcelling);
        assertEquals(expResult, result, 0.0);

        //cas type terrain > 3
        numPassageRights = 2;
        valueParcelling = 1000;
        typeTerrain = 4;
        expResult = 0;
        result = PassageRights.getValue(typeTerrain, numPassageRights, 
                valueParcelling);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of validateNumPassagesRights method, of class PassageRights.
     */
    @Test
    public void testValidateNumPassagesRights() {
        System.out.println("validateNumPassagesRights");
        //cas 1 passageRights = 0
        int passageRights = 0;
        boolean expResult = true;
        boolean result = PassageRights.validateNumPassagesRights(passageRights);
        assertEquals(expResult, result);
        
        //cas 2 passageRights = 10
        passageRights = 10;
        expResult = true;
        result = PassageRights.validateNumPassagesRights(passageRights);
        assertEquals(expResult, result);
        
        //cas 1 passageRights = 5
        passageRights = 5;
        expResult = true;
        result = PassageRights.validateNumPassagesRights(passageRights);
        assertEquals(expResult, result);
        
        //cas 1 passageRights = -1
        passageRights = -1;
        expResult = false;
        result = PassageRights.validateNumPassagesRights(passageRights);
        assertEquals(expResult, result);
        
        //cas 1 passageRights = 11
        passageRights = 11;
        expResult = false;
        result = PassageRights.validateNumPassagesRights(passageRights);
        assertEquals(expResult, result);
        
    }

}
