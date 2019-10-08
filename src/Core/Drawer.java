/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sahan
 */
public class Drawer {
    static String currentPath = System.getProperty("user.dir");
    private static final String HEAD_LOCATION_IMAGE_URI = Paths.get(currentPath).toString() + "/src/images/head_locations.png";
    private static final String EEG_SIGNAL_IMAGE_URI = Paths.get(currentPath).toString() + "/src/images/eeg_signal.png";
    private String path_for_head = "";
    private String path_for_signal = "";
    
    private static final Drawer INSTANCE = new Drawer();
    
    private Drawer(){}
    
    public static Drawer getInstance(){
        return INSTANCE;
    }
    
    public String getEEGHeadLocationImage(){
        if(!this.path_for_head.equals(EEGFile.getInstance().getFilePath())){
            this.path_for_head = EEGFile.getInstance().getFilePath();
            String ret, output;
            ProcessBuilder pb = new ProcessBuilder(PythonPathFinder.getPythonPath(), 
                    PythonScriptFinder.getHeadLocationPlotScript(), EEGFile.getInstance().getFilePath(),
                    HEAD_LOCATION_IMAGE_URI);
            try {
                Process p = pb.start();
                BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
                while((ret = in.readLine()) != null){
                    output = ret.trim();
                }
            } catch (IOException ex) {
                Logger.getLogger(Drawer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return HEAD_LOCATION_IMAGE_URI;
    }
    
    public String getEEGSignalImage(){
        if(!this.path_for_signal.equals(EEGFile.getInstance().getFilePath())){
            this.path_for_signal = EEGFile.getInstance().getFilePath();
            String ret, output;
            ProcessBuilder pb = new ProcessBuilder(PythonPathFinder.getPythonPath(), 
                    PythonScriptFinder.getEEGSignalPlotScript(),EEGFile.getInstance().getFilePath(),
                    EEG_SIGNAL_IMAGE_URI);
            try {
                Process p = pb.start();
                BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
                while((ret = in.readLine()) != null){
                    output = ret.trim();
                }
            } catch (IOException ex) {
                Logger.getLogger(Drawer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return EEG_SIGNAL_IMAGE_URI;
    }  
}
