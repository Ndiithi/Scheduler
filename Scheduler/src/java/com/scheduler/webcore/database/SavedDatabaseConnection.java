/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scheduler.webcore.database;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


/**
 *
 * @author towers
 */
@ManagedBean
@RequestScoped
public class SavedDatabaseConnection extends DatabaseConnection{

    /**
     * Creates a new instance of SavedDatabaseConnection
     */
    public SavedDatabaseConnection() {
    }
    
    public void updateDetails(){
        
    }
    public String getHost() {
     System.out.println("Line host from savedDatabaseconnection");
        return host;
        
    }
}
