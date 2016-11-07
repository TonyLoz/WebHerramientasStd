package com.santander.tools.admintools.controller;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller to change the log level
 *
 * @author OMartinez (1.0.0)
 * @version 1.0.0, 21/08/2012
 */
@Controller
public class LogLevelController {
    private static final Logger log = Logger.getRootLogger();
    
    @RequestMapping(value = "/logLevel.cfg",method = RequestMethod.GET)
    public String logLevel(Map<String,Object> model){
        log.info("Controller to show the Log Level Page");
        model.put("loggerName", "defaultLogger");
        Logger logger = Logger.getLogger("defaultLogger");
        model.put("levelLogActual", returnlLogLevel(logger.getLevel()));
        return "adminTools/logLevel/logLevel";
    }
    
    @RequestMapping(value="/changeLogLevel.cfg", method = RequestMethod.POST)
    public String changeLogLevel(String loggerName, String level, HttpServletRequest request, Map<String,Object> model) {
        log.info("Controller to change the log level");
        Logger logger;
        try{
            model.put("loggerName", loggerName);
            model.put("levelLogActual", level);
            if (loggerName != null && !loggerName.isEmpty()){
                logger = Logger.getLogger(loggerName);
                if (logger == null) {
                    model.put("errorMessage", "Not exists a logger with name  " + loggerName);
                    return "adminTools/logLevel/logLevel";
                }
                log.info("Logger to change: " + loggerName);
                model.put("nombreLogger", loggerName);
            } else {
                log.info("Logger to change: root");
                logger = Logger.getRootLogger();
                loggerName = "root";
            }
            if (level == null || level.equals("")){
                model.put("errorMessage", "You must select the log level you wish to change");
                log.info("You must select the log level you wish to change");
                return "adminTools/logLevel/logLevel";
            }
            if ("ALL".equalsIgnoreCase(level)) {
                logger.setLevel(Level.ALL);
            }else if ("TRACE".equalsIgnoreCase(level)) {
                logger.setLevel(Level.TRACE);
            }else if ("DEBUG".equalsIgnoreCase(level)) {
                logger.setLevel(Level.DEBUG);
            }else if ("INFO".equalsIgnoreCase(level)) {
                logger.setLevel(Level.INFO);
            }else if ("WARN".equalsIgnoreCase(level)) {
                logger.setLevel(Level.WARN);
            }else if ("ERROR".equalsIgnoreCase(level)) {
                logger.setLevel(Level.ERROR);
            }else if ("FATAL".equalsIgnoreCase(level)) {
                logger.setLevel(Level.FATAL);
            }else if ("OFF".equalsIgnoreCase(level)) {
                logger.setLevel(Level.OFF);
            }
            log.info("The log level was successfully changed to " + level + " of the logger " + loggerName);
            model.put("okMessage", "The log level was successfully changed to " + level + " of the logger " + loggerName);
        }catch(Exception e){
            log.error(e.toString());
            model.put("errorMessage", "Has occured an error while change the log level (" + e.toString() + ")");
        }
        return "adminTools/logLevel/logLevel";
    }
    
    private String returnlLogLevel(Level level){
        String levelLog = "";
        if(level == Level.ALL){
            levelLog = "ALL";
        }else if(level == Level.TRACE){
            levelLog = "TRACE";
        }else if(level == Level.DEBUG){
            levelLog = "DEBUG";
        }else if(level == Level.INFO){
            levelLog = "INFO";
        }else if(level == Level.WARN){
            levelLog = "WARN";
        }else if(level == Level.ERROR){
            levelLog = "ERROR";
        }else if(level == Level.FATAL){
            levelLog = "FATAL";
        }else if(level == Level.OFF){
            levelLog = "OFF";
        }
        return levelLog;
    }
    
}
