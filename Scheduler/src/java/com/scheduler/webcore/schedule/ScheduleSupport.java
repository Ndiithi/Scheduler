/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scheduler.webcore.schedule;

import com.scheduler.schedulerdatabase.DatabaseSource;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Iterator;
/**
 *
 * @author towers
 */
@Named(value = "schduleSupport")
@RequestScoped
public class ScheduleSupport implements Serializable {
        @PersistenceContext
        private EntityManager em;
        private List<SelectItem> dbConn;
        
    /**
     * Creates a new instance of SchduleSupport
     */
    public ScheduleSupport() {
    }
    
    public List<DatabaseSource> fetchSavedDatabaseConnection(){
        Query query=em.createQuery("Select dbConn from DatabaseSource dbCOnn");
        List<DatabaseSource> dbConnections=query.getResultList(); 
        return dbConnections;
    }
    
    public void populateSavedDatabaseList(){
        List<DatabaseSource> dbList=fetchSavedDatabaseConnection();
        SelectItem si;
        DatabaseSource db;
        Iterator i=dbList.iterator();
        dbConn=new ArrayList();
        while(i.hasNext()){
            db=(DatabaseSource)i.next();
            String databaseName=db.getDatabasenameSc();
            String host=db.getHostSc();
            int id=db.getId();
            String passowrd=db.getPasswordSc();
            String user=db.getUserSc();
            String comString=databaseName+"~"+host+"~"+user;
            si=new SelectItem();
            si.setLabel(comString);
            si.setValue(id);
            dbConn.add(si);
        }
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public List<SelectItem> getDbConn() {
        populateSavedDatabaseList();
        return dbConn;
    }

    public void setDbConn(List<SelectItem> dbConn) {
        this.dbConn = dbConn;
    }

   
}
