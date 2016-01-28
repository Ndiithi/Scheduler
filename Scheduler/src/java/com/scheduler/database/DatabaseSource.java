/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scheduler.database;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 *
 * @author towers
 */
@Entity
public class DatabaseSource implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    @NotNull(message = "Host name is required")
    private String _hostSc;
    @NotNull
    private String _nameSc;
    @NotNull
    private String _userSc;
    @NotNull
    private String _passwordSc;
    
    public DatabaseSource(){}
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHostSc() {
        return _hostSc;
    }

    public void setHostSc(String _hostSc) {
        this._hostSc = _hostSc;
    }

    public String getNameSc() {
        return _nameSc;
    }

    public void setNameSc(String _nameSc) {
        this._nameSc = _nameSc;
    }

    public String getUserSc() {
        return _userSc;
    }

    public void setUserSc(String _userSc) {
        this._userSc = _userSc;
    }

    public String getPasswordSc() {
        return _passwordSc;
    }

    public void setPasswordSc(String _passwordSc) {
        this._passwordSc = _passwordSc;
    }

    
    
}
