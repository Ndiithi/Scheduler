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
@ManagedBean
@RequestScoped
public class NewDatabaseConnection extends DatabaseConnection{
   
    
    private EntityManagerFactory emf;

    /**
     * Creates a new instance of CreateNewDatabaseEntry
     */
    public NewDatabaseConnection() {
    }

    public void persistDatabaseDetails() {
        System.out.println("Begin data save "+ new java.util.Date());
       emf= Persistence.createEntityManagerFactory("smsApp");
        
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            DatabaseSource database = new DatabaseSource();
            
            database.setName(databaseName);
            database.setHost(host);
            database.setPassword(password);
            database.setUser(user);

            em.persist(database);
            em.getTransaction().commit();
        } catch (Exception e) {
        //    utx.rollback();
            System.err.println(e);
        }

    }


}
