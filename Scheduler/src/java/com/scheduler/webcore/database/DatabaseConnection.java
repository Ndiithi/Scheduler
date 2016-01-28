/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scheduler.webcore.database;


import javax.validation.constraints.NotNull;


/**
 *
 * @author towers
 */

public abstract class  DatabaseConnection {
    @NotNull(message = "Host name field is required")
     String host;
    @NotNull(message = "User field is required")
     String user;
    @NotNull(message = "Password field is required")
     String password;
    @NotNull(message = "Database Name field is required")
     String databaseName;
    
    
    

    /**
     * Creates a new instance of CreateNewDatabaseEntry
     */
    public DatabaseConnection() {
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   
    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

}
