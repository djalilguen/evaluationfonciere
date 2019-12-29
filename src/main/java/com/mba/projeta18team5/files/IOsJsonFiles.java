/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mba.projeta18team5.files;

import com.mba.projeta18team5.control.FileWriter;
import java.io.IOException;
import net.sf.json.JSONObject;

/**
 *
 * @author 1995045
 */
public class IOsJsonFiles {

    public static JSONObject loadJsonFile(String fileName) throws IOException  {

        String myJSON = FileReader.loadFileIntoString(fileName);

        JSONObject mainObject = JSONObject.fromObject(myJSON);

        return mainObject;

    }

    public static void createJsonFile(String fileName, JSONObject mainObject) 
            throws IOException {
        
        FileWriter.saveStringIntoFile(fileName, mainObject.toString());
        
      
    }

}
