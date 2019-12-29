/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mba.projeta18team5.utilities;

import com.mba.projeta18team5.files.FileReader;
import java.io.IOException;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
//import org.json.JSONArray;
//import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 1995156
 */
public class ServicesTest {
    
    public ServicesTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAmountServices method, of class Services.
     */
    @Test
    public void testGetAmountServices() throws IOException{
        System.out.println("getAmountServices");
        int indice=1;
        int typeTerrain = 0;
        int numServices = 0;
        double area = 0.0;
        double expResult = 0.0;
        double result;
        String json =FileReader.loadFileIntoString("json/servicesResultsTest.json");
        JSONObject singleObject;

       JSONArray array =  JSONArray.fromObject(json); 
        for (int i=0;i<array.size();i++){
            indice++;
            singleObject = array.getJSONObject(i);
            typeTerrain=singleObject.getInt("typeTerrain");
            area = singleObject.getDouble("Superficie");
            numServices = singleObject.getInt("nbServices");
            expResult =singleObject.getDouble("montantServices");
            
            result = Services.getAmountServices(typeTerrain, numServices, area);
            System.out.println("Line "+indice+": expected: "+expResult +" Result: "+result);
            assertEquals(expResult, result, 0.00);
        }
        
    }
    
}
