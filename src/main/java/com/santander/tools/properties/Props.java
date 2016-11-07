package com.santander.tools.properties;

import java.util.Properties;

/**
 * Clase para almacenar, obtener y establecer las propiedades de la aplicación.
 * 
 * @author OMartinez, V1.1
 * @version 1.1, 04/09/2013
 */
public class Props {
    private static Properties properties = new Properties();
    
    /**
     * Método para obtener el objeto Properties que almacena todas las propiedades
     * cargadas desde la clase PropertiesLoader
     *
     * @return objeto Properties
     */
    public static Properties getProperties() {
        return properties;
    }
    
    /**
     * Método para obtener el valor de la propiedad dada cómo parámetro
     *
     * @param key nombre de la propiedad a consultar su valor
     * @return valor de la propiedad dada cómo parámetro
     */
    public static String get(String key){
        return properties.getProperty(key);
    }
    
}
