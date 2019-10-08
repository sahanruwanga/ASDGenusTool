/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import java.nio.file.Paths;

/**
 *
 * @author Sahan
 */
public class HelpDocumentFinder {
    
    public static String getAboutToolFilePath(){
        String currentPath = System.getProperty("user.dir"); 
        return Paths.get(currentPath).toString() + "/src/Resources/ASDGenus Documentation.pdf";
    }
    
    public static String getQuickStartFilePath(){
        String currentPath = System.getProperty("user.dir");
        return Paths.get(currentPath).toString() + "/src/Resources/Quick Start Guide.pdf";
    }
}
