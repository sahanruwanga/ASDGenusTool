/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

/**
 *
 * @author Sahan
 */
public class EEGSignal {
    private String noOfChannels;
    private String signalDuration;
    private String channelNames;
    private String recordDate;

    public EEGSignal(String noOfChannels, String signalDuration, String channelNames, String recordDate) {
        this.noOfChannels = noOfChannels;
        this.signalDuration = signalDuration;
        this.channelNames = channelNames;
        this.recordDate = recordDate;
    }

    /**
     * @return the noOfChannels
     */
    public String getNoOfChannels() {
        return noOfChannels;
    }

    /**
     * @param noOfChannels the noOfChannels to set
     */
    public void setNoOfChannels(String noOfChannels) {
        this.noOfChannels = noOfChannels;
    }

    /**
     * @return the signalDuration
     */
    public String getSignalDuration() {
        return signalDuration;
    }

    /**
     * @param signalDuration the signalDuration to set
     */
    public void setSignalDuration(String signalDuration) {
        this.signalDuration = signalDuration;
    }

    /**
     * @return the channelNames
     */
    public String getChannelNames() {
        return channelNames;
    }

    /**
     * @param channelNames the channelNames to set
     */
    public void setChannelNames(String channelNames) {
        this.channelNames = channelNames;
    }

    /**
     * @return the recordDate
     */
    public String getRecordDate() {
        return recordDate;
    }

    /**
     * @param recordDate the recordDate to set
     */
    public void setRecordDate(String recordDate) {
        this.recordDate = recordDate;
    }
    
    
}
