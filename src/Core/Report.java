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
public class Report {
    
    private String name;
    private String age;
    private String gender;
    private String reportDate;
    private String asdResult;
    private String asdDescription;
    private EEGSignal eegSignal;

    public Report(String name, String age, String gender, String reportDate, String asdResult, String asdDescription, EEGSignal eegSignal) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.reportDate = reportDate;
        this.asdResult = asdResult;
        this.asdDescription = asdDescription;
        this.eegSignal = eegSignal;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the age
     */
    public String getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(String age) {
        this.age = age;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the reportDate
     */
    public String getReportDate() {
        return reportDate;
    }

    /**
     * @param reportDate the reportDate to set
     */
    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
    }

    /**
     * @return the asdResult
     */
    public String getAsdResult() {
        return asdResult;
    }

    /**
     * @param asdResult the asdResult to set
     */
    public void setAsdResult(String asdResult) {
        this.asdResult = asdResult;
    }

    /**
     * @return the asdDescription
     */
    public String getAsdDescription() {
        return asdDescription;
    }

    /**
     * @param asdDescription the asdDescription to set
     */
    public void setAsdDescription(String asdDescription) {
        this.asdDescription = asdDescription;
    }

    /**
     * @return the eegSignal
     */
    public EEGSignal getEegSignal() {
        return eegSignal;
    }

    /**
     * @param eegSignal the eegSignal to set
     */
    public void setEegSignal(EEGSignal eegSignal) {
        this.eegSignal = eegSignal;
    }
    
}
