/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.santander.tools.admintools.controller;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author OMartinez
 */

@Controller
public class LogTailController {
    
    private static final Logger log = Logger.getRootLogger();
    
    @RequestMapping(value = "/logTail.cfg",method = RequestMethod.GET)
    public String logLevel(Map<String,Object> model){
        log.info("Controller to show the Logs List");
        return "adminTools/logs/logTail";
    }
    
    
    @RequestMapping(value = "/showLogTail.cfg",method = RequestMethod.GET)
    public String showLogTail(HttpServletRequest request, Map<String,Object> model){
         
        log.info("Controller to show the Log: " + request.getParameter("archivo"));
        return "adminTools/logs/logTail"; 
    }
}
