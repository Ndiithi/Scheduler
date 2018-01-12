/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scheduler.webcore.schedulerdatabase;

import com.scheduler.schedulerdatabase.DatabaseSource;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

/**
 *
 * @author Duncan
 */
@Stateless
public class DatabaseManager {

    @PersistenceContext
    EntityManager em;

    public void updateDatabaseSoureEntry(DatabaseSource dbSource) {
        DatabaseSource dbSourceInst=(DatabaseSource) em.createNamedQuery("findDatabaseSourceEntryById")
                .setParameter("id", dbSource.getId())
                .getSingleResult();
        try{
            dbSourceInst.setDatabasenameSc(dbSource.getDatabasenameSc());
            dbSourceInst.setHostSc(dbSource.getHostSc());
            dbSourceInst.setPasswordSc(dbSource.getPasswordSc());
            dbSourceInst.setUserSc(dbSource.getUserSc());
            
            em.persist(dbSourceInst);
            em.flush();
        }catch(EJBException e){
        }
        
    }
    
    public void updateDatabaseSoureEntry(int dbSourceId,String databaseName,String host,String user,String password) {
        DatabaseSource dbSourceInst=(DatabaseSource) em.createNamedQuery("findDatabaseSourceEntryById")
                .setParameter("id", dbSourceId)
                .getSingleResult();
        try{
            dbSourceInst.setDatabasenameSc(databaseName);
            dbSourceInst.setHostSc(host);
            dbSourceInst.setPasswordSc(password);
            dbSourceInst.setUserSc(user);
            
            em.persist(dbSourceInst);
            em.flush();
        }catch(EJBException e){
        }
    }

    public void deleteDatabaseSoureEntry(Integer dbSourceId) {
        try{
            Query query=em.createNamedQuery("findDatabaseSourceEntryById")
                    .setParameter("id", dbSourceId);
           DatabaseSource dbSource= (DatabaseSource) query.getSingleResult();
        em.remove(dbSource);
        }catch(EJBException e){
            
           
            throw new EJBException(e.getMessage());
        }
        
    }

    public Boolean createDatabaseSourecEntry(DatabaseSource dbSource) {
        Boolean isPersistSuccessful;
        System.out.println("createDatabaseSourecEntry()init--- "+dbSource);
        try {

            em.persist(dbSource);
            System.out.println("createDatabaseSourecEntry()persist--- "+dbSource);
            em.flush();
            isPersistSuccessful = true;
            System.out.println("Saved successfully");
        } catch (Exception e) {
            isPersistSuccessful = false;
            System.out.println(e);
            System.out.println("not saved");
        }

        return isPersistSuccessful;
    }

    public Boolean createDatabaseSourceEntry(String user, String host, String password, String databaseName) {
        Boolean isPersistSuccessful;

        try {
            DatabaseSource databaseSc = new DatabaseSource();

            databaseSc.setDatabasenameSc(databaseName);
            databaseSc.setHostSc(host);
            databaseSc.setPasswordSc(password);
            databaseSc.setUserSc(user);

            em.persist(databaseSc);
            em.flush();
            isPersistSuccessful = true;
            System.out.println("Saved successfully");
        } catch (Exception e) {
            isPersistSuccessful = false;
            System.out.println(e);
            System.out.println("not saved");
        }

        return isPersistSuccessful;
    }

    public List<DatabaseSource> getDatabaseSourceList() {
        List<DatabaseSource> databaseEntries;
        Query getDatabaseEntries=em.createQuery("Select databaseEntry from DatabaseSource databaseEntry");
        databaseEntries=getDatabaseEntries.getResultList();
        return databaseEntries;
    }

}
