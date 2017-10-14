/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scheduler.webcore.schedule;

import com.scheduler.schedule.Period;
import com.scheduler.schedule.Schedule;
import com.scheduler.schedulerdatabase.DatabaseSource;
import static com.sun.faces.el.ELUtils.createValueExpression;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.component.html.HtmlColumn;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlPanelGroup;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Duncan
 */
@Named
@RequestScoped
public class UpdateSchedule implements Serializable {

    @EJB
    private ScheduleManagerBean smb;
    private Schedule schedule = new Schedule();
    @NotNull
    private Long datbaseconnId;
    private String period;
    private String timeToRun;
    @Inject
    private ScheduleUtility scheduleUtility;
    @Inject 
    private UpdateScheduleBackingBean backing;
    private List<List> rowsData;
    private List<String> columns;
    private HtmlPanelGroup dynamicDataTableGroupViewResult;
    private HtmlPanelGroup dynamicDataTableGroupComposeReply;
    private String sampleSms="";
    private HtmlSelectOneMenu htmlSelectOneMenu;
    /**
     * Creates a new instance of new_schedule
     */
    public UpdateSchedule() {
    }

   
    
    public void updateSchedule(){
        smb.updateSchedule(schedule.getScheduleId(),
                datbaseconnId,
                schedule.getScheduleName(),
                schedule.getSqlToRun(),
                schedule.getReplySms(),
                schedule.getFrequency(),
                period,
                timeToRun);
    }

    public HtmlDataTable executeScheduleSql() {
        List<List> dataFromExecuteSql = scheduleUtility.executeScheduleSql(datbaseconnId, schedule.getSqlToRun());
        columns = dataFromExecuteSql.get(0);
        rowsData = dataFromExecuteSql.get(1);
        String[] dynamicHeaders = new String[columns.size()];
                

        for(int i=0;i<=columns.size()-1;i++){
            dynamicHeaders[i]=columns.get(i);
        }
        HtmlDataTable dynamicDataTable = new HtmlDataTable();
        dynamicDataTable.setValueExpression("value", createValueExpression("#{newSchedule.rowsData}", List.class));
        dynamicDataTable.setVar("dynamicItem");
        dynamicDataTable.setCellspacing("10px");
        dynamicDataTable.setStyleClass("center text-justify table-border");
        dynamicDataTable.setStyle("margin-top:20px");
        dynamicDataTable.setRows(10);
        for (int i = 0; i < rowsData.get(0).size(); i++) {

            // Create <h:column>.
            HtmlColumn column = new HtmlColumn();
            dynamicDataTable.getChildren().add(column);

            // Create <h:outputText value="dynamicHeaders[i]"> for <f:facet name="header"> of column.
            HtmlOutputText header = new HtmlOutputText();
            header.setValue(dynamicHeaders[i]);
            column.setHeader(header);

            // Create <h:outputText value="#{dynamicItem[" + i + "]}"> for the body of column.
            HtmlOutputText output = new HtmlOutputText();
            output.setValueExpression("value",
                    createValueExpression("#{dynamicItem[" + i + "]}", String.class));
            column.getChildren().add(output);
        }

        // Add the datatable to <h:panelGroup binding="#{myBean.dynamicDataTableGroupViewResult}">.dynamicDataTableGroupViewResult = new HtmlPanelGroup();
        
        
        
        return dynamicDataTable;
    }
    
    public void generateSampleDataFromSql(){
        backing.setIsCreateSqlPanelRendered(Boolean.TRUE);
        backing.setIsReplySmsPanelRendered(Boolean.FALSE);
       dynamicDataTableGroupViewResult.getChildren().clear();
       dynamicDataTableGroupViewResult.getChildren().add(executeScheduleSql());
       
    }
    
    public void generateSampleDataFromSqlReply(){
        backing.setIsCreateSqlPanelRendered(Boolean.FALSE);
        backing.setIsReplySmsPanelRendered(Boolean.TRUE);
        dynamicDataTableGroupComposeReply.getChildren().clear();
        dynamicDataTableGroupComposeReply.getChildren().add(executeScheduleSql());
        
     
    }
    
    public void generateSampleSms(){
        sampleSms=scheduleUtility.generateSampleSms(datbaseconnId, schedule.getReplySms(), schedule.getSqlToRun());
        generateSampleDataFromSqlReply();
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
        if(schedule.getDate()!=null){
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        timeToRun=sdf.format(schedule.getDate());
        }
        
        return timeToRun;
    }

    public void setTimeToRun(String timeToRun) {
        this.timeToRun = timeToRun;
    }

    public ScheduleManagerBean getSmb() {
        return smb;
    }

    public void setSmb(ScheduleManagerBean smb) {
        this.smb = smb;
    }

    public ScheduleUtility getScheduleUtility() {
        return scheduleUtility;
    }

    public void setScheduleUtility(ScheduleUtility scheduleUtility) {
        this.scheduleUtility = scheduleUtility;
    }

    public HtmlPanelGroup getDynamicDataTableGroupViewResult() {
        return dynamicDataTableGroupViewResult;
    }

    public void setDynamicDataTableGroupViewResult(HtmlPanelGroup dynamicDataTableGroupViewResult) {
        this.dynamicDataTableGroupViewResult = dynamicDataTableGroupViewResult;
    }

    public List<List> getRowsData() {
        return rowsData;
    }

    public void setRowsData(List<List> rowsData) {
        this.rowsData = rowsData;
    }

    public List<String> getColumns() {
        return columns;
    }

    public void setColumns(List<String> columns) {
        this.columns = columns;
    }

    public HtmlPanelGroup getDynamicDataTableGroupComposeReply() {
        return dynamicDataTableGroupComposeReply;
    }

    public void setDynamicDataTableGroupComposeReply(HtmlPanelGroup dynamicDataTableGroupComposeReply) {
        this.dynamicDataTableGroupComposeReply = dynamicDataTableGroupComposeReply;
    }

    public String getSampleSms() {
        return sampleSms;
    }

    public void setSampleSms(String sampleSms) {
        this.sampleSms = sampleSms;
    }

   

    public HtmlSelectOneMenu getHtmlSelectOneMenu() {
        
            System.out.println("Set Value for htmlSelectOneMenu");
        DatabaseSource dbsrc=schedule.getDbConnection();
        htmlSelectOneMenu=new HtmlSelectOneMenu();
        htmlSelectOneMenu.setValue(dbsrc.getId());
        String label=dbsrc.getHostSc()+"-"+dbsrc.getDatabasenameSc()+"-"+dbsrc.getUserSc();
        htmlSelectOneMenu.setLabel(label);
        return htmlSelectOneMenu;
    }

    public void setHtmlSelectOneMenu(HtmlSelectOneMenu htmlSelectOneMenu) {
        this.htmlSelectOneMenu = htmlSelectOneMenu;
    }

    public UpdateScheduleBackingBean getBacking() {
        return backing;
    }

    public void setBacking(UpdateScheduleBackingBean backing) {
        this.backing = backing;
    }

}
