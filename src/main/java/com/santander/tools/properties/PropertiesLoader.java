package com.santander.tools.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.apache.log4j.Logger;

/**
 * PropertiesLoader es una clase que permite la carga de propiedades de
 * configuración *.properties en aplicaciones web, estos parametros están
 * localizados en memoria para ser utilizadas mediante la clase props. Para
 * utilizar esta clase y cargar archivos de propiedades se debe declarar un
 * parámetro en el contexto de la aplicacion con nombre <b>propertiesFile</b> el
 * cúal tiene como valor una o varias rutas abosolutas de los archivos
 * properties a cargar. Sí son más de un archivo, deberán separarse con coma.
 *
 * @author OMartinez, V1.1
 * @version 1.0, 14/08/2016
 */
public class PropertiesLoader implements ServletContextListener {

    /* Variable estatica de log */
    private static final Logger LOG = Logger.getLogger(PropertiesLoader.class);

    /**
     * @{@inheritDoc }
     */
    @Override
    public void contextInitialized(final ServletContextEvent servletContext) {
        final String propertiesFile = servletContext.getServletContext().getInitParameter("propertiesFile");
        final String internalPropertiesFile = servletContext.getServletContext().getInitParameter("internalPropertiesFile");

        Properties props = Props.getProperties();
        LOG.info(String.format("Se cargaran el(los) archivo(s) de propiedades: %s", propertiesFile));
        String[] propFiles = propertiesFile.split(",");
        for (String pf : propFiles) {
            pf = pf.trim();
            if (pf.isEmpty()) {
                continue;
            }
            LOG.info(String.format("Cargando archivo de propiedades: %s", pf));
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(pf);
                props.load(fis);
                LOG.info(String.format("Se cargo OK el archivo de propiedades: %s", pf));
            } catch (IOException ioe) {
                LOG.error("Error al cargar el archivo de propiedades: " + pf);
                LOG.error(ioe.getMessage(), ioe);
                throw new RuntimeException(ioe);
            } finally {
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException ex) {
                        LOG.error("No fue posible cerrar el stream al archivo de propiedades: " + ex.getMessage(), ex);
                    }
                }
            }
        }

        if (internalPropertiesFile != null) {

            LOG.info(String.format("Se cargaran el(los) archivo(s) de propiedades internos: %s", internalPropertiesFile));
            String[] internalPropFiles = internalPropertiesFile.split(",");
            try {
                for (String pf : internalPropFiles) {
                    InputStream is = this.getClass().getClassLoader().getResourceAsStream(pf);
                    props.load(is);
                }

            } catch (IOException ex) {
                LOG.error("No fue posible cerrar el stream al archivo de propiedades: " + ex.getMessage(), ex);
            }
        }

        LOG.info("Se cargaron " + props.size() + " propiedades en total, las cuales son:");
        for (String k : props.stringPropertyNames()) {
            LOG.info(k + "=" + props.getProperty(k));
        }
    }

    /**
     * @{@inheritDoc }
     */
    @Override
    public void contextDestroyed(final ServletContextEvent servletContext) {
        //Left blank intentinally
    }
}
