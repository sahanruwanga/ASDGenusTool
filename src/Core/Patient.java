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
public class Patient {
    
    private String name;
    private String age;
    private String gender;
    private PredictResult predictResult;

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
     * @return the predictResult
     */
    public PredictResult getPredictResult() {
        return predictResult;
    }

    /**
     * @param predictResult the predictResult to set
     */
    public void setPredictResult(PredictResult predictResult) {
        this.predictResult = predictResult;
    }
}
