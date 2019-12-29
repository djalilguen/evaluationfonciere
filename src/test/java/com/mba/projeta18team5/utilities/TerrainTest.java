/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mba.projeta18team5.utilities;

import com.mba.projeta18team5.files.IOsJsonFiles;
import java.io.IOException;
import net.sf.json.JSONObject;
import net.sf.json.test.JSONAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 1995045
 */
public class TerrainTest {

    public TerrainTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getSchoolTax method, of class Terrain.
     */
    @Test
    public void testGetSchoolTax() {
        System.out.println("getSchoolTax");
        double value = 1000;
        double expResult = 12;
        double result = Terrain.getSchoolTax(value);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getMunicipalTax method, of class Terrain.
     */
    @Test
    public void testGetMunicipalTax() {
        System.out.println("getMunicipalTax");
        double value = 1000;
        double expResult = 25;
        double result = Terrain.getMunicipalTax(value);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of roundUpAmount method, of class Terrain.
     */
    @Test
    public void testRoundUpAmount() {
        System.out.println("roundUpAmount");
        double value = 1000;
        double expResult = 1000.0;
        double result = Terrain.roundUpAmount(value);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void testRoundUpAmount1() {
        System.out.println("roundUpAmount");
        double value = 1000.01;
        double expResult = 1000.05;
        double result = Terrain.roundUpAmount(value);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void testRoundUpAmount2() {
        System.out.println("roundUpAmount");
        double value = 1000.02;
        double expResult = 1000.05;
        double result = Terrain.roundUpAmount(value);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testRoundUpAmount3() {
        System.out.println("roundUpAmount");
        double value = 1000.03;
        double expResult = 1000.05;
        double result = Terrain.roundUpAmount(value);
        assertEquals(expResult, result, 0.0);
    }
    
     @Test
    public void testRoundUpAmount4() {
        System.out.println("roundUpAmount");
        double value = 1000.04;
        double expResult = 1000.05;
        double result = Terrain.roundUpAmount(value);
        assertEquals(expResult, result, 0.0);
    }
    /**
     * Test of getPropertyAssessment method, of class Terrain.
     */
    @Test
    public void testGetPropertyAssessment() throws IOException {
        System.out.println("getPropertyAssessment");
        JSONObject terrain = new JSONObject();
        terrain = IOsJsonFiles.loadJsonFile("json/terrains.json");
        JSONObject expResult = new JSONObject();
        JSONObject result = new JSONObject();
        result = Terrain.getPropertyAssessment(terrain);
        expResult = IOsJsonFiles.loadJsonFile("json/expResults.json");
        JSONAssert.assertEquals(expResult, result);
    }
    
    
    
    @Test
    public void testGetPropertyAssessment2() throws IOException {
        System.out.println("getPropertyAssessment2 erreur sur le type terrain ");
        JSONObject terrain = new JSONObject();
        terrain = IOsJsonFiles.loadJsonFile("json/typeTest.json");
        JSONObject expResult = new JSONObject();
        JSONObject result = new JSONObject();
        result = Terrain.getPropertyAssessment(terrain);
        expResult = IOsJsonFiles.loadJsonFile("json/typeResultsTest.json");
        JSONAssert.assertEquals(expResult, result);
    }
    
    @Test
    public void testGetPropertyAssessment3() throws IOException {
        System.out.println("getPropertyAssessment3 erreur sur le prix minimum ");
        JSONObject terrain = new JSONObject();
        terrain = IOsJsonFiles.loadJsonFile("json/priceMinTest.json");
        JSONObject expResult = new JSONObject();
        JSONObject result = new JSONObject();
        result = Terrain.getPropertyAssessment(terrain);
        expResult = IOsJsonFiles.loadJsonFile("json/priceMinResultsTest.json");
        JSONAssert.assertEquals(expResult, result);
    }
    
    @Test
    public void testGetPropertyAssessment4() throws IOException {
        System.out.println("getPropertyAssessment4 erreur sur le prix maximum ");
        JSONObject terrain = new JSONObject();
        terrain = IOsJsonFiles.loadJsonFile("json/priceMaxTest.json");
        JSONObject expResult = new JSONObject();
        JSONObject result = new JSONObject();
        result = Terrain.getPropertyAssessment(terrain);
        expResult = IOsJsonFiles.loadJsonFile("json/priceMaxResultsTest.json");
        JSONAssert.assertEquals(expResult, result);
    }
    
    @Test
    public void testGetPropertyAssessment5() throws IOException {
        System.out.println("getPropertyAssessment5 erreur sur la superficie ");
        JSONObject terrain = new JSONObject();
        terrain = IOsJsonFiles.loadJsonFile("json/superficieTest.json");
        JSONObject expResult = new JSONObject();
        JSONObject result = new JSONObject();
        result = Terrain.getPropertyAssessment(terrain);
        expResult = IOsJsonFiles.loadJsonFile("json/superficieResultsTest.json");
        JSONAssert.assertEquals(expResult, result);
    }
    
    @Test
    public void testGetPropertyAssessment6() throws IOException {
        Terrain t = new Terrain();
        System.out.println("getPropertyAssessment5 erreur sur la date ");
        JSONObject terrain = new JSONObject();
        terrain = IOsJsonFiles.loadJsonFile("json/dateTest.json");
        JSONObject expResult = new JSONObject();
        JSONObject result = new JSONObject();
        result = Terrain.getPropertyAssessment(terrain);
        System.out.println(result.toString());
        expResult = IOsJsonFiles.loadJsonFile("json/dateResultsTest.json");
        JSONAssert.assertEquals(expResult, result);
    }
    
    @Test
    public void testGetPropertyAssessment7() throws IOException {
        System.out.println("getPropertyAssessment7 erreur sur la superficie2 ");
        JSONObject terrain = new JSONObject();
        terrain = IOsJsonFiles.loadJsonFile("json/superficieTest2.json");
        JSONObject expResult = new JSONObject();
        JSONObject result = new JSONObject();
        result = Terrain.getPropertyAssessment(terrain);
        expResult = IOsJsonFiles.loadJsonFile("json/superficieResultsTest.json");
        System.out.println(result.toString());
        JSONAssert.assertEquals(expResult, result);
    }
    
    

    /**
     * Test of getPriceFromString method, of class Terrain.
     */
    @Test
    public void testGetPriceFromString() {
        System.out.println("getPriceFromString");
        String value = "1000 $";
        double expResult = 1000.0;
        double result = Terrain.getPriceFromString(value);
        assertEquals(expResult, result, 0.0);
    }

}
