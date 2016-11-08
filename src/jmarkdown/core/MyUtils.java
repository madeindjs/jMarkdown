/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmarkdown.core;

import java.io.File;

/**
 *
 * @author rousseaua
 */
public class MyUtils {

    /**
     * Get extension's file from a String
     * @param filename
     * @return extension in lower case 
     */
    public static String getExtension(String filename) {
        String ext = null;
        int i = filename.lastIndexOf('.');

        if (i > 0 &&  i < filename.length() - 1) {
            ext = filename.substring(i+1).toLowerCase();
        }
        return ext;
    }
    
    /**
     * Get extension's file from a java.io.File
     * @param file
     * @return extension in lower case 
     */
    public static String getExtension(File file) {
        return MyUtils.getExtension(file.getName());
    }

}
