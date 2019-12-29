/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mba.projeta18team5.control;

import com.mba.projeta18team5.files.IOsJsonFiles;
import com.mba.projeta18team5.utilities.PropertyAssessments;
import com.mba.projeta18team5.utilities.PropertyAssessmentsTest;
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
 * @author 1995089
 */
public class ControllerTest {

    public ControllerTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class Controller.
     */
    @Test
    public void testMain() {
        System.out.println("main");

        String[] args = new String[2];
        args[0] = "json/terrains.json";
        args[1] = "json/sortieMain.json";
        Controller.main(args);
    }

    @Test
    public void testMainOneArgument() {
        System.out.println("main");

        String[] args = new String[1];
        args[0] = "json/terrains.json";

        Controller.main(args);

    }

    @Test
    public void testMainWithOutArguments() {
        System.out.println("main");

        String[] args = new String[2];
        args[0] = "";
        args[1] = "";

        Controller.main(args);

    }

    @Test
    public void testMainTerrain() {
        int indice = 1; // utiliser pour savoir quel fichier dans la boucle for
        System.out.println("main test all files");
        String[] infiles = {"1invalide","2interrainvide", "3interrain-1", "4interrain3", "5interrain3reel5",
            "6interrainexiste", "7interrainstring"};
        // ,"2interrainvide" a inserer apres validation a la position 2
        String[] outfiles = {"1outvalide", "2outterrainvide","3outterrain-1", "4outterrain3", "5outterrain3reel5",
            "6outterraininexiste", "7outterrainstring"};
        // "2outterrainvide",  a inserer apres validation a la position 2

        String[] args = new String[2];
        String inDirectory = "jsonTestMain/in/terrain/";
        String outDirectory = "jsonTestMain/out/terrain/";
        String ExpResultDirectory = "jsonTestMain/Expectout/terrain/";
        String expectResult;

        for (int i = 0; i < infiles.length; i++) {
            args[0] = inDirectory + infiles[i] + ".json";
            System.out.println(i + ") Test du fichier d entree ------- " + infiles[i]);
            args[1] = outDirectory + infiles[i] + ".json";
            expectResult = ExpResultDirectory + outfiles[i] + ".json";
            try {
                Controller.main(args);
                JSONAssert.assertEquals(IOsJsonFiles.loadJsonFile(expectResult),
                        IOsJsonFiles.loadJsonFile(args[1]));
            } catch (IOException ex) {
                Logger.getLogger(PropertyAssessmentsTest.class.getName())
                        .log(Level.SEVERE, null, ex);
            }

        }

    }

    @Test
    public void testMainPrixMin() {
        int indice = 1; // utiliser pour savoir quel fichier dans la boucle for
        System.out.println("main test all files --- Prix_Min");
        String[] infiles = {"8inprixminvide","9inprixmin-1", "10inprixminvirgule", "11inprixminsansdollar",
            "12inprixmin3j45", "13inprixminsupmax", "14inprixminchar", "15inprixmininexiste"};
        // "8inprixminvide", a inserer apres validation a la position 2
        String[] outfiles = {"8outprixminvide","9outprixmin-1", "10outprixminvirgule", "11outprixminsansdollar",
            "12outprixmin3j45", "13outprixminsupmax", "14outprixminchar", "15outprixmininexiste"};
        // "8outprixminvide",  a inserer apres validation a la position 2

        String[] args = new String[2];
        String inDirectory = "jsonTestMain/in/prixMin/";
        String outDirectory = "jsonTestMain/out/prixMin/";
        String ExpResultDirectory = "jsonTestMain/Expectout/prixMin/";
        String expectResult;

        for (int i = 0; i < infiles.length; i++) {
            args[0] = inDirectory + infiles[i] + ".json";
            System.out.println(i + ") Test du fichier d entree ------- " + infiles[i]);
            args[1] = outDirectory + infiles[i] + ".json";
            expectResult = ExpResultDirectory + outfiles[i] + ".json";
            try {
                Controller.main(args);
                JSONAssert.assertEquals(IOsJsonFiles.loadJsonFile(expectResult),
                        IOsJsonFiles.loadJsonFile(args[1]));
            } catch (IOException ex) {
                Logger.getLogger(PropertyAssessmentsTest.class.getName())
                        .log(Level.SEVERE, null, ex);
            }

        }

    }

    @Test
    public void testMainPrixMax() {
        int indice = 1; // utiliser pour savoir quel fichier dans la boucle for
        System.out.println("main test all files --- Prix_Max");
        String[] infiles = {"16inprixmaxvide","17inprixmax-1", "18inprixmaxvirgule", "19inprixmaxsansdollar",
            "20inprixmax3j45", "21inprixmaxinfmin", "22inprixmaxnchar", "23inprixmaxinexiste"};
        // "16inprixmaxvide", a inserer apres validation a la position 2
        String[] outfiles = {"16outprixmaxnvide","17outprixmax-1", "18outprixmaxvirgule", "19outprixmaxsansdollar",
            "20outprixmax3j45", "21outprixmaxinfmin", "22outprixmaxnchar", "23outprixmaxinexiste"};
        // "16outprixmaxnvide",  a inserer apres validation a la position 2

        String[] args = new String[2];
        String inDirectory = "jsonTestMain/in/prixMax/";
        String outDirectory = "jsonTestMain/out/prixMax/";
        String ExpResultDirectory = "jsonTestMain/Expectout/prixMax/";
        String expectResult;

        for (int i = 0; i < infiles.length; i++) {
            args[0] = inDirectory + infiles[i] + ".json";
            System.out.println(i + ") Test du fichier d entree ------- " + infiles[i]);
            args[1] = outDirectory + infiles[i] + ".json";
            expectResult = ExpResultDirectory + outfiles[i] + ".json";
            try {
                Controller.main(args);
                JSONAssert.assertEquals(IOsJsonFiles.loadJsonFile(expectResult),
                        IOsJsonFiles.loadJsonFile(args[1]));
            } catch (IOException ex) {
                Logger.getLogger(PropertyAssessmentsTest.class.getName())
                        .log(Level.SEVERE, null, ex);
            }

        }

    }
    
        @Test
    public void testMainDescription() {
        int indice = 1; // utiliser pour savoir quel fichier dans la boucle for
        System.out.println("main test all files --- Description");
        String[] infiles = {"1indescvide", "2indescdupl", "3indescinexiste",
            "4indescnull"};
        // "16inprixmaxvide", a inserer apres validation a la position 2
        String[] outfiles = {"1outdescvide", "2outdescdupl", "3outdescinexiste",
            "4outdescnull"};
        // "16outprixmaxnvide",  a inserer apres validation a la position 2

        String[] args = new String[2];
        String inDirectory = "jsonTestMain/in/description/";
        String outDirectory = "jsonTestMain/out/description/";
        String ExpResultDirectory = "jsonTestMain/Expectout/description/";
        String expectResult;

        for (int i = 0; i < infiles.length; i++) {
            args[0] = inDirectory + infiles[i] + ".json";
            System.out.println(i + ") Test du fichier d entree ------- " + infiles[i]);
            args[1] = outDirectory + infiles[i] + ".json";
            expectResult = ExpResultDirectory + outfiles[i] + ".json";
            try {
                Controller.main(args);
                JSONAssert.assertEquals(IOsJsonFiles.loadJsonFile(expectResult),
                        IOsJsonFiles.loadJsonFile(args[1]));
            } catch (IOException ex) {
                Logger.getLogger(PropertyAssessmentsTest.class.getName())
                        .log(Level.SEVERE, null, ex);
            }

        }

    }
}
