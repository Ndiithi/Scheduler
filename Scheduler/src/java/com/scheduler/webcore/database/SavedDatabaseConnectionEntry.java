/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scheduler.webcore.database;

import com.scheduler.database.DatabaseSource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author towers
 */
@ManagedBean
@RequestScoped
public class SavedDatabaseConnectionEntry{

    @EJB
    private DatabaseManagerBean dbManager;
    
    private List<DatabaseSource> databaseEntries;
    /**
     * Creates a new instance of SavedDatabaseConnection
     */
    public SavedDatabaseConnectionEntry() {
    }
    
    public void updateDatabaseEntryDetails(){
        
    }
    
    
    public void deleteDatabaseEntryDetails(){
    
    }

    public List<DatabaseSource> getDatabaseEntries() {
        databaseEntries=dbManager.getDatabaseSourceList();
        return databaseEntries;
    }

    public void setDatabaseEntries(List<DatabaseSource> databaseEntries) {
        this.databaseEntries = databaseEntries;
    }
    
}
