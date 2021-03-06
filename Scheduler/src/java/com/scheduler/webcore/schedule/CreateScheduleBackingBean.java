/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scheduler.webcore.schedule;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Duncan
 */
@Named
@SessionScoped
public class CreateScheduleBackingBean implements Serializable {
private Boolean isReplySmsPanelRendered=false;
private Boolean isCreateSqlPanelRendered=true;
    /**
     * Creates a new instance of Backing
     */
    public CreateScheduleBackingBean() {
    }

    public Boolean getIsReplySmsPanelRendered() {
        return isReplySmsPanelRendered;
    }

    public void setIsReplySmsPanelRendered(Boolean isReplySmsPanelRendered) {
        this.isReplySmsPanelRendered = isReplySmsPanelRendered;
    }

    public Boolean getIsCreateSqlPanelRendered() {
        return isCreateSqlPanelRendered;
    }

    public void setIsCreateSqlPanelRendered(Boolean isCreateSqlPanelRendered) {
        this.isCreateSqlPanelRendered = isCreateSqlPanelRendered;
    }
    
}
