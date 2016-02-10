/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scheduler.schedule;

import com.scheduler.database.DatabaseSource;
import com.scheduler.database.Period;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

/**
 *
 * @author towers
 */
@Entity
@NamedQuery(name = "",query = "")
public class Schedule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private DatabaseSource dbConnection;

    String scheduleName;
    String sqlToRun;
    String replySms;
    int frequency;
    Period period;

    public Schedule() {
    }

    public Schedule(String scheduleName, String sqlToRun, String replySms, int frequency, Period period) {
        this.scheduleName = scheduleName;
        this.sqlToRun = sqlToRun;
        this.replySms = replySms;
        this.frequency = frequency;
        this.period = period;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Schedule)) {
            return false;
        }
        Schedule other = (Schedule) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.scheduler.schedule.Schedule[ id=" + id + " ]";
    }

    public DatabaseSource getDbConnection() {
        return dbConnection;
    }

    public void setDbConnection(DatabaseSource dbConnection) {
        this.dbConnection = dbConnection;
    }

}
