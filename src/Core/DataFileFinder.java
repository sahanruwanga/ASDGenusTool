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
public class DataFileFinder {
    
    public static String getTrainingDataFilePath(){
        String currentPath = System.getProperty("user.dir");
        return Paths.get(currentPath).toString() + "/src/Resources/features_with_cfs.csv";
    }
}
