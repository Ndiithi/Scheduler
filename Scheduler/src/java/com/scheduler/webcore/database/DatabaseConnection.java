/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scheduler.webcore.database;


import com.scheduler.database.DatabaseSource;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.constraints.NotNull;


/**
 *
 * @author towers
 */
@RequestScoped
public class DatabaseConnection {
    @NotNull
     String host;
    @NotNull
     String user;
    @NotNull
     String password;
    @NotNull
     String databaseName;
    
    
    

    /**
     * Creates a new instance of CreateNewDatabaseEntry
     */
    public DatabaseConnection() {
    }

    public void persistDatabaseDetails() {
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
