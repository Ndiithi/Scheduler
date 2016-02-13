/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scheduler.webcore.schedule;

import com.scheduler.schedule.Schedule;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.validation.constraints.NotNull;

/**
 *
 * @author towers
 */
@Named
@SessionScoped
public class NewSchedule implements Serializable {
    @EJB
    ScheduleManagerBean smb;
    private Schedule schedule=new Schedule();
    @NotNull
    private Long datbaseconnId;
    private String period;
    private String timeToRun;
    /**
     * Creates a new instance of new_schedule
     */
    public NewSchedule() {
    }
   
    
    public void persistSchedule(){
        smb.createSchedule(datbaseconnId, 
                schedule.getScheduleName(), 
                schedule.getSqlToRun(), 
                schedule.getReplySms(), 
                schedule.getFrequency(), 
                period, 
                timeToRun);
    }
    
    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public Long getDatbaseconnId() {
        return datbaseconnId;
    }

    public void setDatbaseconnId(Long datbaseconnId) {
        this.datbaseconnId = datbaseconnId;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getTimeToRun() {
        return timeToRun;
    }

    public void setTimeToRun(String timeToRun) {
        this.timeToRun = timeToRun;
    }
    
}
