/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Paths;

/**
 *
 * @author Sahan
 */
public class HelpDocumentFinder {
    
    public static String getHelpPdfFilePath(){
        String currentPath = System.getProperty("user.dir");
        return Paths.get(currentPath).toString() + "\\src\\Resources\\ASDGenus Documentation.pdf";
//        return Paths.get(currentPath).toString() + "\\lib\\resources\\help\\ASDGenus Documentation.pdf";
    }
}
