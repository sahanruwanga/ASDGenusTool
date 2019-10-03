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
public class PythonScriptFinder {
    static String currentPath = System.getProperty("user.dir");
    
    public static String getPredictScript(){
        return Paths.get(currentPath).toString() + "/src/PythonScripts/predict.py";
    }
    
    public static String getHeadLocationPlotScript(){
        return Paths.get(currentPath).toString() + "/src/PythonScripts/plot_head_locations.py";
    }
    
    public static String getEEGSignalPlotScript(){
        return Paths.get(currentPath).toString() + "/src/PythonScripts/plot_eeg_signal.py";
    }
}
