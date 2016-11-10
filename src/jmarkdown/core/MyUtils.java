/*
 * The MIT License
 *
 * Copyright 2016 rousseaua.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
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
