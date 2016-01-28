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

/**
 *
 * @author towers
 */
@ManagedBean
@RequestScoped
public class NewDatabaseConnection{

    @EJB
    private DatabaseManagerBean dbManager;
    private DatabaseSource databaseSource=new DatabaseSource();

    /**
     * Creates a new instance of CreateNewDatabaseEntry
     */
    public NewDatabaseConnection() {
    }

    public void persistDatabaseDetails() {
        dbManager.createDatabaseEntry(databaseSource);
    }

    public DatabaseSource getDatabaseSource() {
        return databaseSource;
    }

    public void setDatabaseSource(DatabaseSource databaseSource) {
        this.databaseSource = databaseSource;
    }

}
