/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mba.projeta18team5.utilities;

import com.mba.projeta18team5.files.FileReader;
import java.io.IOException;
//import org.json.JSONArray;
//import org.json.JSONObject;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class ParcellingTest {
    
    public ParcellingTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getValue method, of class Parcelling.
     */
    @Test
    public void testGetValue() throws IOException {
        System.out.println("getValue");
        int indice=1; // pour reperer la ligne dans json array
        int typeTerrain = 0;
        double priceMax = 0.0;
        double priceMin = 0.0;
        double area = 0.0;
        double expResult = 0.0;
        double result;
        
        String json =FileReader.loadFileIntoString("json/parcelingTest.json");
        JSONObject singleObject;

       JSONArray array =JSONArray.fromObject(json);

        for (int i=0;i<array.size();i++){
            indice++;
            singleObject = array.getJSONObject(i);
            typeTerrain=singleObject.getInt("typeTerrain");
            area = singleObject.getDouble("superficie");
            priceMin = singleObject.getDouble("prixMin");
            priceMax = singleObject.getDouble("prixMax");
            expResult = singleObject.getDouble("getValue");
            result = Parcelling.getValue(typeTerrain,priceMax,priceMin,area);//(typeTerrain, priceMax, priceMin, area);
            System.out.println("Line "+indice+": expected: "+expResult +" Result: "+result);
            assertEquals(expResult, result, 0.00);
        }
        
        
        
    }

    /**
     * Test of getValueLanded method, of class Parcelling.
     */
    @Test
    public void testGetValueLanded() throws IOException {
        System.out.println("getValueLanded");
        int indice=1; // pour reperer la ligne dans json array
        int typeTerrain = 0;
        double priceMax = 0.0;
        double priceMin = 0.0;
        double area = 0.0;
        int nbPassages;
        int nbServices;
        double value ; //a supprimer
        double expResult = 0.0;
        double result;

        String json =FileReader.loadFileIntoString("json/parcelingTest.json");
        JSONObject singleObject;

       JSONArray array =JSONArray.fromObject(json);

        for (int i=0;i<array.size();i++){
            indice++;
            singleObject = array.getJSONObject(i);
            typeTerrain=singleObject.getInt("typeTerrain");
            area = singleObject.getDouble("superficie");
            priceMin = singleObject.getDouble("prixMin");
            priceMax = singleObject.getDouble("prixMax");
            nbPassages = singleObject.getInt("nbPassages");
            nbServices = singleObject.getInt("nbServices");;
            expResult = singleObject.getDouble("ValueLanded");
            value = singleObject.getDouble("getValue"); // asupprimer
            result = Parcelling.getValueLanded(typeTerrain, nbPassages, nbServices, priceMin, priceMax, area);
            System.out.println("Expected passages: "+singleObject.getDouble("droitspassages"));
            System.out.println("result passages: "+PassageRights.getValue(typeTerrain, nbPassages, value));
            System.out.println("Line "+indice+": expected: "+expResult +" Result: "+result);
            assertEquals(expResult, result, 0);
        }
    }

    /**
     * Test of validateParcelingsDescriptions method, of class Parcelling.
     * test terrains valide (descriptions)
     */
    @Test
    public void testValidateParcelingsDescriptions() throws IOException {
        System.out.println("validateParcelingsDescriptions ------ valide");
        String json =FileReader.loadFileIntoString("jsonTest/terrainsValide.json");
        JSONObject mainObject = JSONObject.fromObject(json);
        int expResult = 0;
        int result = Parcelling.validateParcelingsDescriptions(mainObject);
        System.out.println("Attedue:"+expResult +" , obtenue: "+result);
        assertEquals(expResult, result,0);
    }
    /**
     * Test of validateParcelingsDescriptions method, of class Parcelling.
     * test terrains value of descriptions is empty
     */
    @Test
    public void testValidateParcelingsDescriptionsEmpty() throws IOException {
        System.out.println("validateParcelingsDescriptions  ------- Empty Description");
        String json =FileReader.loadFileIntoString("jsonTest/terrainsdescriptionvide.json");
        JSONObject mainObject = JSONObject.fromObject(json);
        int expResult = -1;
        int result = Parcelling.validateParcelingsDescriptions(mainObject);
        System.out.println("Attedue:"+expResult +" , obtenue: "+result);
        assertEquals(expResult, result,0);
    }
    /**
     * Test of validateParcelingsDescriptions method, of class Parcelling.
     * test terrains values descriptions is duplicated
     */
    
        @Test
    public void testValidateParcelingsDescriptionsDuplicated() throws IOException {
        System.out.println("validateParcelingsDescriptions ------ Duplicated values");
        String json =FileReader.loadFileIntoString("jsonTest/terrainsdescduplique.json");
        JSONObject mainObject = JSONObject.fromObject(json);
        int expResult = -10;
        int result = Parcelling.validateParcelingsDescriptions(mainObject);
        System.out.println("Attedue:"+expResult +" , obtenue: "+result);
        assertEquals(expResult, result,0);
    }


    /**
     * Test of validateParcelingsArray method, of class Parcelling.
     */
    @Test
    public void testValidateParcelingsArray() throws IOException {
        System.out.println("validateParcelingsArray   ------ valide");
        String json =FileReader.loadFileIntoString("jsonTest/terrainsValide.json");
        JSONObject mainObject = JSONObject.fromObject(json);
        int expResult = 0;
        int result = Parcelling.validateParcelingsArray(mainObject);
        System.out.println("Attedue:"+expResult +" , obtenue: "+result);
        assertEquals(expResult, result,0);
    }
    
    /**
     * Test of validateParcelingsArray method, of class Parcelling.
     * nb services invalide
     */
    @Test
    public void testValidateParcelingsArrayServicesInvalide() throws IOException {
        System.out.println("validateParcelingsArray ------ nb services valide ");
        String json =FileReader.loadFileIntoString("jsonTest/terrainsServicesInvalide.json");
        JSONObject mainObject = JSONObject.fromObject(json);
        int expResult = -30;
        int result = Parcelling.validateParcelingsArray(mainObject);
        System.out.println("Attedue:"+expResult +" , obtenue: "+result);
        assertEquals(expResult, result,0);
    }
    
     /**
     * Test of validateParcelingsArray method, of class Parcelling.
     * nb parcing sup 10;
     */
    @Test
    public void testValidateParcelingsArraynbParceInvalide() throws IOException {
        System.out.println("validateParcelingsArray ------ nb parceling sup 10 ");
        String json =FileReader.loadFileIntoString("jsonTest/terrainsParceSup10.json");
        JSONObject mainObject = JSONObject.fromObject(json);
        int expResult = -100;
        int result = Parcelling.validateParcelingsArray(mainObject);
        System.out.println("Attedue:"+expResult +" , obtenue: "+result);
        assertEquals(expResult, result,0);
    }
    
    /**
     * Test of validateParcelingsArray method, of class Parcelling.
     * area between 0 and 50000;
     */
    @Test
    public void testValidateParcelingsArraynbAreaInvalide() throws IOException {
        System.out.println("validateParcelingsArray ------ nb parceling sup 10 ");
        String json =FileReader.loadFileIntoString("jsonTest/terrainsAreaInvalide.json");
        JSONObject mainObject = JSONObject.fromObject(json);
        int expResult = -70;
        int result = Parcelling.validateParcelingsArray(mainObject);
        System.out.println("Attedue:"+expResult +" , obtenue: "+result);
        assertEquals(expResult, result,0);
    }
    
    /**
     * Test of validateParcelingsArray method, of class Parcelling.
     * test terrains value of descriptions is empty
     */
    @Test
    public void testvalidateParcelingsArrayDescEmpty() throws IOException {
        System.out.println("validateParcelingsDescriptions  ------- Empty Description");
        String json =FileReader.loadFileIntoString("jsonTest/terrainsdescriptionvide.json");
        JSONObject mainObject = JSONObject.fromObject(json);
        int expResult = -1;
        int result = Parcelling.validateParcelingsArray(mainObject);
        System.out.println("Attedue:"+expResult +" , obtenue: "+result);
        assertEquals(expResult, result,0);
    }
    /**
     * Test of validateParcelingsDescriptions method, of class Parcelling.
     * test terrains values descriptions is duplicated
     */
    
        @Test
    public void testvalidateParcelingsArrayDescDuplicated() throws IOException {
        System.out.println("validateParcelingsDescriptions ------ Duplicated values");
        String json =FileReader.loadFileIntoString("jsonTest/terrainsdescduplique.json");
        JSONObject mainObject = JSONObject.fromObject(json);
        int expResult = -10;
        int result = Parcelling.validateParcelingsArray(mainObject);
        System.out.println("Attedue:"+expResult +" , obtenue: "+result);
        assertEquals(expResult, result,0);
    }
     @Test
    public void testvalidateParcelingsArraynbPassageincorrect() throws IOException {
        System.out.println("validateParcelingsDescriptions ------ nbPassage");
        String json =FileReader.loadFileIntoString("jsonTest/terrainsPassage.json");
        JSONObject mainObject = JSONObject.fromObject(json);
        int expResult = -50;
        int result = Parcelling.validateParcelingsArray(mainObject);
        System.out.println("Attedue:"+expResult +" , obtenue: "+result);
        assertEquals(expResult, result,0);
    }
}
