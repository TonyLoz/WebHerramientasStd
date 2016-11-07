package com.santander.commons.exceptions;

/**
 * Clase para formatear excepciones
 *
 * @author OMartinez (1.0.0)
 * @version 1.0.0, 16/07/2016
 */
public class FormatException {
    
    /**
     * Método estático para obtener el stack trace de una excepción
     * 
     * @return regresa el stack trace de la excepción
     */
    public static String obtieneStackTrace(Exception e) {
        StringBuilder st = new StringBuilder("");
        for (StackTraceElement element : e.getStackTrace()) {
            st.append(element.toString()).append("\n");            
        }
        return st.toString();
    }
}
