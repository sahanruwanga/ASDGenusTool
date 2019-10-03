/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sahan
 */
public class ReportWriter {
    
    public static void saveReport(Report report, EEGSignal eegSignal){
        String currentPath = System.getProperty("user.dir");
        try {
            FileWriter file = new FileWriter(Paths.get(currentPath).toString() + "/src/Reports/" +
                    report.getName() + "_" + report.getReportDate().substring(0, 11) +".txt");
            file.write("------- Personal Details & Results -------" + "\n");
            file.write("Name - " + report.getName() + "\n");
            file.write("Age - " + report.getAge() + "\n");
            file.write("Gender - " + report.getGender() + "\n");
            file.write("Report Date - " + report.getReportDate() + "\n");
            file.write("ASD Result - " + report.getAsdResult()+ "\n");
            file.write("Result Description - " + report.getAsdDescription()+ "\n");
            file.write("------- EEG Signal Details -------" + "\n");
            file.write("Number of Channels - " + eegSignal.getNoOfChannels()+ "\n");
            file.write("Channel Names - " + eegSignal.getChannelNames()+ "\n");
            file.write("Signal Duration - " + eegSignal.getSignalDuration()+ "\n");
            file.write("Signal Recorded Date - " + eegSignal.getRecordDate());
            file.close();
        } catch (IOException ex) {
            Logger.getLogger(ReportWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
