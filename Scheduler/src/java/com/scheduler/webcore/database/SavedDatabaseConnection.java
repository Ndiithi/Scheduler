/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scheduler.webcore.database;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.NotNull;

/**
 *
 * @author towers
 */
@ManagedBean
@ViewScoped
public class SavedDatabaseConnection extends DatabaseConnection{
    @NotNull
     String host;
    @NotNull
     String user;
    @NotNull
     String password;
    @NotNull
     String databaseName;
    /**
     * Creates a new instance of SavedDatabaseConnection
     */
    public SavedDatabaseConnection() {
    }
    
    public void updateDetails(){
        
    }
    
}
