/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mba.projeta18team5.files;

import net.sf.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 1995045
 */
public class IOsJsonFilesTest {
    
    public IOsJsonFilesTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of loadJsonFile method, of class IOsJsonFiles.
     */
    @Test
    public void testLoadJsonFile() throws Exception {
        System.out.println("loadJsonFile");
        String fileName = "";
        JSONObject expResult = new JSONObject();
        expResult.accumulate("type_terrain", 2);
        expResult.accumulate("prix_m2_min","3.45$");
        expResult.accumulate("prix_m2_max", "7.00$");
        JSONObject result = IOsJsonFiles.loadJsonFile("json/testLoad.json");
        assertEquals(expResult.toString(), result.toString());
        // TODO review the generated test code and remove the default call to fail.
    //    fail("The test case is a prototype.");
    }

    /**
     * Test of createJsonFile method, of class IOsJsonFiles.
     */
    @Test
    public void testCreateJsonFile() throws Exception {
        System.out.println("createJsonFile");
        String fileName = "testWrite";
        JSONObject mainObject = new JSONObject();
        mainObject.accumulate("type_terrain", 2);
        mainObject.accumulate("prix_m2_min","3.45$");
        mainObject.accumulate("prix_m2_max", "7.00$");
        IOsJsonFiles.createJsonFile(fileName, mainObject);
        
    }
    
}
