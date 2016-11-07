package com.santander.tools.appstatus.controller;

import com.santander.tools.appstatus.bean.ApplicationStatusBean;
import com.santander.tools.appstatus.service.ApplicationStatus;
import com.santander.tools.appstatus.service.ApplicationStatusService;

import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Application status controller
 *
 * @author OMartinez
 * @version 1.0.0, 04/07/2016
 */
@Controller
public class EstatusApController {

    static Logger log = Logger.getLogger("defaultLogger");
    @Autowired(required=false)
    private ApplicationStatusService estatusApService;

    /**
     * Controller to show the application status page
     *
     * @return return the view name "commons/appStatus/appStatus"
     */
    @RequestMapping(value = "/estatusAp.htm", method = RequestMethod.GET)
    public String getAppStatus(Map<String, Object> model) {
        log.info("Controller to show the application status page");
        List<ApplicationStatusBean> appStatusList = estatusApService.getApplicationStatus();
        model.put("testedComponentsList", appStatusList);
        String estatusAp = "Ok";
        for (ApplicationStatusBean estatus : appStatusList) {
            if (estatus.getStatus()== ApplicationStatus.ERROR) {
                estatusAp = "Error";
            }
        }
        model.put("appStatus", estatusAp);
        return "appStatus/appStatus";
    }
}
