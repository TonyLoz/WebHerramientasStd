package com.santander.tools.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.apache.log4j.Logger;

/**
 * Listener para cargar el archivo de propiedades comunes. La ruta y nombre del 
 * archivo se deberá especificar en el parámetro de contexto rutaComunesProperties
 *
 * @author OMartinez, V1.0.0
 * @version 1.0.0, 20/07/2016
 */
public class ComunesListener implements ServletContextListener {
    private static final Logger LOG = Logger.getLogger(ComunesListener.class);
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        final String rutaComunesProperties = sce.getServletContext().getInitParameter("rutaComunesProperties");
        if (rutaComunesProperties == null || rutaComunesProperties.isEmpty()){
            LOG.info("No se configuro el parametro de contexto rutaComunesProperties; " +
                    "no se cargara el archivo de propiedades comunes");
            return;
        }
        
        LOG.info(String.format("Cargando el archivo de propiedades %s", rutaComunesProperties));
        FileInputStream fis = null;
        Properties properties = new Properties();
        try {
            fis = new FileInputStream(rutaComunesProperties);
            properties.load(fis);
            LOG.info(String.format("Se cargo OK el archivo de propiedades %s", rutaComunesProperties));
            ServletContext sc = sce.getServletContext();
            
            LOG.info("Las propiedades cargadas quedaran disponibles en los siguientes atributos del contexto:");
            
            LOG.info(String.format("urlComunesCss=%s", properties.getProperty("url.comunes.css")));
            sc.setAttribute("urlComunesCss", properties.getProperty("url.comunes.css"));
            
            LOG.info(String.format("urlComunesFichas=%s", properties.getProperty("url.comunes.fichas")));
            sc.setAttribute("urlComunesFichas", properties.getProperty("url.comunes.fichas"));
            
            LOG.info(String.format("urlComunesImg=%s", properties.getProperty("url.comunes.img")));
            sc.setAttribute("urlComunesImg", properties.getProperty("url.comunes.img"));
            
            LOG.info(String.format("urlComunesJs=%s", properties.getProperty("url.comunes.js")));
            sc.setAttribute("urlComunesJs", properties.getProperty("url.comunes.js"));
            
        } catch (IOException ioe) {
            LOG.error(String.format("Error al cargar el archivo de propiedades %s ", rutaComunesProperties));
            LOG.error(ioe.getMessage(), ioe);
            throw new RuntimeException(ioe);
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException ex) {
                    LOG.error(String.format("Error al cerrar el stream del archivo de propiedades ", rutaComunesProperties), ex);
                }
            }
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //Left blank intentinally
    }
}
