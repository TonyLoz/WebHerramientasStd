package com.santander.tools.appstatus.bean;

import com.santander.tools.appstatus.service.ApplicationStatus;

/**
 * Bean representing the component application status
 *
 * @author OMartinez
 * @version 1.0.0, 03/07/2016
 */
public class ApplicationStatusBean {

    private String component;
    private ApplicationStatus status;

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public ApplicationStatus getStatus() {
        return status;
    }

    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }

}
