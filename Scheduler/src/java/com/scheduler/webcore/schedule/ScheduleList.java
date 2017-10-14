/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scheduler.webcore.schedule;

import com.scheduler.schedule.Schedule;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIParameter;
import javax.faces.event.ActionEvent;

/**
 *
 * @author Duncan
 */
@Named
@RequestScoped
public class ScheduleList {
    @EJB
    private ScheduleManagerBean smb;
private List<Schedule> scheduleList;
private Schedule schedule;
    /**
     * Creates a new instance of ScheduleList
     */
    public ScheduleList() {
    }

    public List<Schedule> getScheduleList() {
        scheduleList=smb.getScheduleList();
        return scheduleList;
    }
    public void deleteSchedule(){
    }
public void deleteSchedule(ActionEvent event){
        UIParameter scheudleIdObj=(UIParameter) event.getComponent().findComponent("scheduleid");
        Long scheudleId=Long.parseLong(scheudleIdObj.getValue().toString());
        
        smb.deleteSchedule(scheudleId);
    }
    public void setScheduleList(List<Schedule> scheduleList) {
        this.scheduleList = scheduleList;
    }

    public ScheduleManagerBean getSmb() {
        return smb;
    }

    public void setSmb(ScheduleManagerBean smb) {
        this.smb = smb;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
    
    
}
