/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sahan
 */
public class Predictor {
    
    private static final Predictor instance = new Predictor();
    private ArrayList<String> prediction;

    private Predictor(){}
    
    /**
     * 
     * @return Singleton object of Predictor
     */
    public static Predictor getInstance(){
        return instance;
    }
    
    /**
     * 
     * @param eegFilePath 
     */
    public ArrayList<String> predictASD(String eegFilePath){
        String ret;
        this.prediction = new ArrayList<>();
        ProcessBuilder pb = new ProcessBuilder(
                PythonPathFinder.getPythonPath(), PythonScriptFinder.getPredictScript(), 
                EEGFile.getInstance().getFilePath(), DataFileFinder.getTrainingDataFilePath(), 
                EEGFile.getInstance().getFileName());

        try {
            Process p = pb.start();
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while((ret = in.readLine()) != null){
                prediction.add(ret.trim());
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Predictor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.prediction;
    }
}
