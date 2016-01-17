/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scheduler.webcore.database;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author towers
 * Controls the expression language string based on the view requested
 */
@ManagedBean
@SessionScoped
public class RequestedDatabaseViewController {
    private String className;
    /**
     * Creates a new instance of RequestedDatabaseViewController
     */
    public RequestedDatabaseViewController() {
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
        System.out.println("Class  name: -------------->"+className);
    }
    
}
