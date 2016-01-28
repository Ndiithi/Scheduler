/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scheduler.webcore.database;

import com.scheduler.database.DatabaseSource;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.transaction.UserTransaction;

/**
 *
 * @author mspace-developer
 */
@Stateless
public class DatabaseManagerBean {

    @PersistenceContext
    EntityManager em;

    public void updateDatabaseEntry(DatabaseSource dbSource) {

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void deleteDatabaseEntry(DatabaseSource dbSource) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Boolean createDatabaseEntry(DatabaseSource dbSource) {
        Boolean isPersistSuccessful;

        try {

            em.persist(dbSource);
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

    public Boolean createDatabaseEntry(String user, String host, String password, String databaseName) {
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
