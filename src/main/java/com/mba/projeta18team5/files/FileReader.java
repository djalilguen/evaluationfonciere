/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mba.projeta18team5.files;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author 1995089
 */
public class FileReader {

    public static String loadFileIntoString(String filePath) throws
            FileNotFoundException, IOException {
        return IOUtils.toString(new FileInputStream(filePath), "UTF-8");
    }
}
