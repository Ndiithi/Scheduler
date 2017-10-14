/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scheduler.webcore.schedulerdatabase;

import com.scheduler.schedulerdatabase.DatabaseSource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.component.UIParameter;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author Duncan
 */
@ManagedBean
@RequestScoped
public class SavedDatabaseConnectionEntry{

    @EJB
    private DatabaseManager dbManager;
    private DatabaseSource dbSource=new DatabaseSource();
    private List<DatabaseSource> databaseEntries;
    /**
     * Creates a new instance of SavedDatabaseConnection
     */
    public SavedDatabaseConnectionEntry() {
    }
    
    public void updateDatabaseEntryDetails(){
        dbManager.updateDatabaseSoureEntry(dbSource.getId(),
                dbSource.getDatabasenameSc(),
                dbSource.getHostSc(),
                dbSource.getUserSc(),
                dbSource.getPasswordSc());
        
    }
    
    
    public void deleteDatabaseEntryDetails(ActionEvent event){
        UIParameter datasourceId=(UIParameter) event.getComponent().findComponent("datasourceid");
        Integer dbSourceId=Integer.parseInt(datasourceId.getValue().toString());
        
        dbManager.deleteDatabaseSoureEntry(dbSourceId);
    }

    public List<DatabaseSource> getDatabaseEntries() {
        databaseEntries=dbManager.getDatabaseSourceList();
        return databaseEntries;
    }

    public void setDatabaseEntries(List<DatabaseSource> databaseEntries) {
        this.databaseEntries = databaseEntries;
    }

    public DatabaseSource getDbSource() {
        return dbSource;
    }

    public void setDbSource(DatabaseSource dbSource) {
        this.dbSource = dbSource;
    }

    
    
}
