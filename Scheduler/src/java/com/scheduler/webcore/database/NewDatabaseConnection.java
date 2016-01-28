/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scheduler.webcore.database;

import com.scheduler.database.DatabaseSource;
import javax.ejb.EJB;

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
@ManagedBean
@RequestScoped
public class NewDatabaseConnection extends DatabaseConnection {

    @EJB
    DatabaseManagerBean dbManager;

    /**
     * Creates a new instance of CreateNewDatabaseEntry
     */
    public NewDatabaseConnection() {
    }

    public void persistDatabaseDetails() {
        
        DatabaseSource database = new DatabaseSource();
        
        database.setNameSc(databaseName);
        database.setHostSc(host);
        database.setPasswordSc(password);
        database.setUserSc(user);
        
        
        dbManager.createDatabaseEntry(database);
    }

}
