/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scheduler.webcore.schedule;

import com.scheduler.databaseutilities.DatabaseConnection;
import com.scheduler.schedulerdatabase.DatabaseSource;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author towers
 */
@Named
@Dependent
public class ScheduleUtility implements Serializable {

    @PersistenceContext
    private EntityManager em;
    @Inject
    DatabaseConnection dbConn;

    /**
     * Creates a new instance of ScheduleUtility
     */
    public ScheduleUtility() {
    }

    public List<List> executeScheduleSql(Long dbConnId, String sql) {
        List<List> view = new ArrayList();
        if (sql != null) {
            List<String> columnNames = new ArrayList();
            List<List> rowsData = new ArrayList();
            try {
                ResultSet rs=this.executeSql(dbConnId, sql);
                ResultSetMetaData rsm = rs.getMetaData();

                int columnReturned = rsm.getColumnCount();
                for (int i = 1; i <= columnReturned; i++) {
                    columnNames.add(rsm.getColumnName(i));
                }

                while (rs.next()) {
                    List<String> row = new ArrayList();
                    for (int i = 1; i <= columnReturned; i++) {
                        try {
                            row.add(rs.getString(i));

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    rowsData.add(row);

                }
                view.add(columnNames);
                view.add(rowsData);

            } catch (SQLException ex) {
                Logger.getLogger(ScheduleUtility.class.getName()).log(Level.SEVERE, sql);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return view;
    }
    
    public ResultSet executeSql(Long dbConnId,String sql){
        Query query = em.createNamedQuery("findDatabaseSourceEntryById").setParameter("id", dbConnId);
                
                
                DatabaseSource dbSource = (DatabaseSource) query.getSingleResult();
                dbConn.createDatabaseConnection(dbSource.getDatabasenameSc(),
                        dbSource.getUserSc(),
                        dbSource.getPasswordSc());

                ResultSet rs = dbConn.executeQuery(sql);
                return rs;
    }
    
    public String generateSampleSms(Long dbConnId,String smsTemplate,String sql) {
        System.out.println("Generate sample sms");
        
        Set<String> placeholder = new HashSet<String>();
        int startIndex = smsTemplate.indexOf("[")+1;
        int endIndex = smsTemplate.indexOf("]");
        String columnName;       
        

         
        while (startIndex != -1) {
            
            if (endIndex < startIndex) {
                endIndex = smsTemplate.indexOf("]", startIndex);
                
            }
            if(endIndex==-1) break;
            columnName=smsTemplate.substring(startIndex, endIndex);
            System.out.println("col names from SmsTemplate"+columnName);
            placeholder.add(columnName);
            startIndex = smsTemplate.indexOf("[",startIndex);
            if(startIndex==-1)break;
            startIndex+=1;
            endIndex = smsTemplate.indexOf("]",startIndex);
        }
        
        if(placeholder.size()>0){
            try {
                ResultSet rs=this.executeSql(dbConnId, sql);
                Iterator iterator=placeholder.iterator();
                if(rs.next()){
                    
                    while(iterator.hasNext()){
                        
                        String valueToReplace=(String)iterator.next();
                        
                        smsTemplate=smsTemplate.replaceAll(valueToReplace, rs.getString(valueToReplace));
                        
                        
                    }
                    smsTemplate=smsTemplate.replaceAll("\\[", "");
                    smsTemplate=smsTemplate.replaceAll("\\]", "");
                }
            } catch (SQLException ex) {                
                Logger.getLogger(ScheduleUtility.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return smsTemplate;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
}
