/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scheduler.webcore.schedule;

import com.scheduler.database.DatabaseSource;
import com.scheduler.schedule.Period;
import com.scheduler.schedule.Schedule;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author towers
 */
@Stateless
public class ScheduleManagerBean {

    @PersistenceContext
    EntityManager em;

    public boolean deleteSchedule(Long scheduleId) {
        Boolean isSucccesful = false;
        try {
            Query query = em.createQuery("Delete from Schedule c where c.scheduleId='" + scheduleId + "'");
            int updatedRecords = query.executeUpdate();
            if (updatedRecords > 0) {
                isSucccesful = true;
                em.flush();
                return isSucccesful;
            } else {
                return isSucccesful ;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return isSucccesful;
        }

    }

    public boolean createSchedule(Schedule schedule) {
        Boolean isSucccesful = false;
        try {
            em.persist(schedule);
            em.flush();
            isSucccesful = true;
            return isSucccesful;
        } catch (Exception e) {
            e.printStackTrace();
            return isSucccesful;
        }

    }

    public boolean createSchedule(
            Long dbConnectionId,
            String scheduleName,
            String sqlToRun,
            String replySms,
            int frequency,
            String period,
            String date) {
        try {
            
            Schedule schedule = new Schedule();
            SimpleDateFormat smf=new  SimpleDateFormat("yyyy-mm-dd");
            Date scheduleDate=smf.parse(date);
            Period schedulePeriod;
            if(period.equals("HOURLY")){
                schedulePeriod=Period.HOURLY;
            }else if(period.equals("DAILY")){
                schedulePeriod=Period.DAILY;
            }else if(period.equals("WEEKLY")){
                schedulePeriod=Period.WEEKLY;
            }else if(period.equals("MOTHLY")){
                schedulePeriod=Period.MOTHLY;
            }else if(period.equals("YEARLY")){
                schedulePeriod=Period.YEARLY;
            }else{
                throw new Exception("Unknow Schedule Period");
            }
            
            schedule.setFreqPeriod(schedulePeriod);
            schedule.setFrequency(frequency);
            schedule.setDate(scheduleDate);
            schedule.setReplySms(replySms);
            schedule.setScheduleName(scheduleName);
            schedule.setSqlToRun(sqlToRun);
            DatabaseSource dbSource = (DatabaseSource) em.createNamedQuery("findDatabaseSourceEntryById").setParameter("id", dbConnectionId).getSingleResult();
            schedule.setDbConnection(dbSource);
            em.persist(schedule);
            em.flush();
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public boolean updateSchedule(
            Long scheduleId,
            int dbConnectionId,
            String scheduleName,
            String sqlToRun,
            String replySms,
            int frequency,
            Period period) {

        Boolean isSucccesful = false;
        String jpql = "Update Schedule c set "
                + "c.scheduleName='" + scheduleName + "',"
                + " c.sqlToRun='" + sqlToRun + "',"
                + " c.replySms='" + replySms + "', "
                + "c.frequency='" + frequency + "',"
                + " c.freqPeriod='" + period + "'"
                + "where c.scheduleId='" + scheduleId + "'";
        try {
            int updatedRecords = em.createQuery(jpql).executeUpdate();
            if (updatedRecords > 0) {
                isSucccesful = true;
                return isSucccesful;
            } else {
                return isSucccesful;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return isSucccesful;
        }

    }
//    public boolean updateSchedule(Schedule schedule) {
//        try {
//            em.createQuery(null);
//            em.flush();
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }

    public List<Schedule> getScheduleList() {
        List<Schedule> allSavedSchedules;
        allSavedSchedules = em.createNamedQuery("getSchedules").getResultList();
        return allSavedSchedules;
    }

    public Schedule getSchedule(Long scheduleId) {
        Schedule schedule = (Schedule) em.createNamedQuery("getScheduleById").setParameter("id", scheduleId).getSingleResult();
        return schedule;
    }
}
