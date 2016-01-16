/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scheduler.webcore;

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
public class CreateNewDatabaseEntry {

    private String host;
    @NotNull
    @javax.validation.constraints.Digits(integer = 2, fraction = 2)
    private String user;
    private String password;
    private String databaseName;

    
    
    private EntityManagerFactory emf;

    /**
     * Creates a new instance of CreateNewDatabaseEntry
     */
    public CreateNewDatabaseEntry() {
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

    public EntityManagerFactory getEmf() {
        return emf;
    }

    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

}
