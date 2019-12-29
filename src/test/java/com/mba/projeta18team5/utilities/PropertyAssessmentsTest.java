/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mba.projeta18team5.utilities;

import com.mba.projeta18team5.files.IOsJsonFiles;
import com.mba.projeta18team5.utilities.PropertyAssessments;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.json.test.JSONAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Admin
 */
public class PropertyAssessmentsTest {

    public PropertyAssessmentsTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of createPropertyAssessments method, of class PropertyAssessments.
     */
    @Test
    public void testCreatePropertyAssessments() {
        System.out.println("createPropertyAssessments");
        //cas ou le fichier d'entrée est valide
        
        String fileIn = "json/testFileInOK.json";
        String fileOut = "json/testFileOutOK.json";
        try {
            PropertyAssessments.createPropertyAssessments(fileIn, fileOut);
            JSONAssert.assertEquals(IOsJsonFiles.loadJsonFile("json/"
                    + "expTestFileInOK.json"),
                    IOsJsonFiles.loadJsonFile(fileOut));

        } catch (IOException ex) {
            Logger.getLogger(PropertyAssessmentsTest.class.getName())
                    .log(Level.SEVERE, null, ex);
        }

        //cas1 où le nombre de clés de l'objet json principal est erroné
        
        String fileErrorCase1 = "json/testFileInErrorlength.json";
        String errorOutCase1 = "json/testFileOutErrorLength.json";
        try {
            PropertyAssessments.createPropertyAssessments(fileErrorCase1,
                    errorOutCase1);
            JSONAssert.assertEquals(IOsJsonFiles.loadJsonFile("json/"
                    + "expTestFileInErrorLength.json"),
                    IOsJsonFiles.loadJsonFile(errorOutCase1));
        } catch (IOException ex) {
            Logger.getLogger(PropertyAssessmentsTest.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        
        //cas2 où le nombre de lots dépasse 10
        
        String fileErrorCase2 = "json/testFileInErrorNumParselling.json";
        String errorOutCase2 = "json/testFileOutErrorNumParselling.json";
        try {
            PropertyAssessments.createPropertyAssessments(fileErrorCase2,
                    errorOutCase2);
            JSONAssert.assertEquals(IOsJsonFiles.loadJsonFile("json/"
                    + "expTestFileInErrorNumParselling.json"),
                    IOsJsonFiles.loadJsonFile(errorOutCase2));
        } catch (IOException ex) {
            Logger.getLogger(PropertyAssessmentsTest.class.getName())
                    .log(Level.SEVERE, null, ex);
        }

        //cas3 où une proprièté possède un espace dans son titre
        String fileErrorCase3 = "json/testFileInErrorBlankKey.json";
        String errorOutCase3 = "json/testFileOutErrorBlankKey.json";
        try {
            PropertyAssessments.createPropertyAssessments(fileErrorCase3,
                    errorOutCase3);
            JSONAssert.assertEquals(IOsJsonFiles.loadJsonFile("json/"
                    + "expTestFileInErrorBlankKey.json"),
                    IOsJsonFiles.loadJsonFile(errorOutCase3));
        } catch (IOException ex) {
            Logger.getLogger(PropertyAssessmentsTest.class.getName())
                    .log(Level.SEVERE, null, ex);
        }

        //cas4 où une proprièté possède une lettre en majuscule dans son titre
        
        String fileErrorCase4 = "json/testFileInErrorUpperCase.json";
        String errorOutCase4 = "json/testFileOutErrorUpperCase.json";
        try {
            PropertyAssessments.createPropertyAssessments(fileErrorCase4,
                    errorOutCase4);
            JSONAssert.assertEquals(IOsJsonFiles.loadJsonFile("json/"
                    + "expTestFileInErrorUpperCase.json"),
                    IOsJsonFiles.loadJsonFile(errorOutCase4));
        } catch (IOException ex) {
            Logger.getLogger(PropertyAssessmentsTest.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        
        //cas5 où une proprièté d'une element du tableau lotissements 
        //possède un espace dans son titre
        String fileErrorCase5 = "json/testFileInErrorBlankKeyLot.json";
        String errorOutCase5 = "json/testFileOutErrorBlankKeyLot.json";
        try {
            PropertyAssessments.createPropertyAssessments(fileErrorCase5,
                    errorOutCase5);
            JSONAssert.assertEquals(IOsJsonFiles.loadJsonFile("json/"
                    + "expTestFileInErrorBlankKeyLot.json"),
                    IOsJsonFiles.loadJsonFile(errorOutCase5));
        } catch (IOException ex) {
            Logger.getLogger(PropertyAssessmentsTest.class.getName())
                    .log(Level.SEVERE, null, ex);
        }

        //cas6 où une proprièté d'un element du tableau lotissements 
        //possède une lettre en majuscule dans son titre
        
        String fileErrorCase6 = "json/testFileInErrorUpperCaseLot.json";
        String errorOutCase6 = "json/testFileOutErrorUpperCaseLot.json";
        try {
            PropertyAssessments.createPropertyAssessments(fileErrorCase6,
                    errorOutCase6);
            JSONAssert.assertEquals(IOsJsonFiles.loadJsonFile("json/"
                    + "expTestFileInErrorUpperCaseLot.json"),
                    IOsJsonFiles.loadJsonFile(errorOutCase6));
        } catch (IOException ex) {
            Logger.getLogger(PropertyAssessmentsTest.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }
}
