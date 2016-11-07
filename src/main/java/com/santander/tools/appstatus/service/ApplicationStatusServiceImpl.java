package com.santander.tools.appstatus.service;

import com.santander.tools.appstatus.bean.ApplicationStatusBean;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * Implementación del servicio para consultar el estatus de la aplicacion
 *
 * @author Cesar Alejandro Perez Aguiñaga
 * @version 1.0.0, 04/12/2012
 */
@Service
public class ApplicationStatusServiceImpl implements ApplicationStatusService {

    static Logger log = Logger.getLogger("defaultLogger");

    @Override
    public List<ApplicationStatusBean> getApplicationStatus() {
        log.info("Inicio del servicio para consultar el estatus de la aplicacion");
        List<ApplicationStatusBean> estatusList = new ArrayList<ApplicationStatusBean>();
        estatusList.add(consultarEstatusBdXyz());
        log.info("Fin del servicio para consultar el estatus de la aplicacion");
        return estatusList;
    }

    private ApplicationStatusBean consultarEstatusBdXyz() {
        log.info("Checando estaus de BD XYZ");
        ApplicationStatusBean as = new ApplicationStatusBean();
        as.setComponent("BD XYZ");
        as.setStatus(ApplicationStatus.OK);
        log.info(as.getComponent() + ": " + as.getStatus());
        return as;
    }
}
