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
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;
/**
 *
 * @author mspace-developer
 */
@Stateless
public class DatabaseManagerBean implements DatabaseManager{
    @PersistenceContext(unitName = "smsApp")
    EntityManagerFactory emf;
    
    @Resource
    UserTransaction utx;
    @Override
    public void updateDatabaseEntry(DatabaseSource dbSource) {
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteDatabaseEntry(DatabaseSource dbSource) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean createDatabaseEntry(DatabaseSource dbSource) {
        Boolean isPersistSuccessful=false;
        EntityManager em=emf.createEntityManager();
        try{
            utx.begin();
            em.persist(em);
            utx.commit();
            em.close();
            isPersistSuccessful=true;
        }catch(Exception e){
            isPersistSuccessful=false;
        }
        
        return isPersistSuccessful;
    }

    @Override
    public List<DatabaseSource> getDatabaseSourceList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
