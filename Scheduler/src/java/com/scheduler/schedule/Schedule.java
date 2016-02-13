/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scheduler.schedule;

import com.scheduler.database.DatabaseSource;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;

/**
 *
 * @author towers
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "getScheduleById",query = "Select c from Schedule c Where c.scheduleId =:id"),
        @NamedQuery(name = "getSchedules",query = "SELECT c FROM Schedule c")})
public class Schedule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long scheduleId;
    @ManyToOne(cascade = CascadeType.ALL)
    private DatabaseSource dbConnection;

    String scheduleName;
    String sqlToRun;
    String replySms;
    int frequency;
    Period freqPeriod;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date;
    
    
    public Schedule() {
    }

//    public Schedule(String scheduleName, String sqlToRun, String replySms, int frequency, Period period) {
//        this.scheduleName = scheduleName;
//        this.sqlToRun = sqlToRun;
//        this.replySms = replySms;
//        this.frequency = frequency;
//        this.freqPeriod = period;
//    }

    public String getScheduleName() {
        return scheduleName;
    }

    public void setScheduleName(String scheduleName) {
       
        this.scheduleName = scheduleName;
    }

    public String getSqlToRun() {
        return sqlToRun;
    }

    public void setSqlToRun(String sqlToRun) {
        this.sqlToRun = sqlToRun;
    }

    public String getReplySms() {
        return replySms;
    }

    public void setReplySms(String replySms) {
        this.replySms = replySms;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public Period getFreqPeriod() {
        return freqPeriod;
    }

    public void setFreqPeriod(Period freqPeriod) {
        this.freqPeriod = freqPeriod;
    }

  
    public Long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
    }
    
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (scheduleId != null ? scheduleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof Schedule)) {
            return false;
        }
        Schedule other = (Schedule) object;
        if ((this.scheduleId == null && other.scheduleId != null) || (this.scheduleId != null && !this.scheduleId.equals(other.scheduleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.scheduler.schedule.Schedule[ id=" + scheduleId + " ]";
    }

    public DatabaseSource getDbConnection() {
        return dbConnection;
    }

    public void setDbConnection(DatabaseSource dbConnection) {
        this.dbConnection = dbConnection;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
