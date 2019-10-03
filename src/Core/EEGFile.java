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
public class EEGFile {
    
    private static final EEGFile instance = new EEGFile();
    private String fileName;
    private String filePath;
    
    private EEGFile(){}
    
    public static EEGFile getInstance(){
        return instance;
    }
    
    public void setFileName(String fileName){
        if (this.fileName == null){
            this.fileName = "";
        }
        this.fileName = fileName;
    }
    
    public String getFileName(){
        return this.fileName;
    }
    
    public void setFilePath(String filePath){
        this.filePath = filePath;
    }
    
    public String getFilePath(){
        if (this.filePath == null){
            this.filePath = "";
        }
        return this.filePath;
    }
}
