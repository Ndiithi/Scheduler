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

/**
 *
 * @author towers
 */
@Named(value = "new_schedule")
@SessionScoped
public class New_schedule implements Serializable {
    private Schedule schedule;
    /**
     * Creates a new instance of new_schedule
     */
    public New_schedule() {
    }
   
    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
    
}
