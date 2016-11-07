package com.santander.commons.exceptions;

/**
 * Clase que representa una excepción al consumir un web service
 * 
 * @author OMartinez (1.0.0)
 * @version 1.0.0, 24/09/2016
 */
public class WSException extends Exception{
    
    private static final long serialVersionUID = 1L;
    public WSException(String message) {
        super(message);
    }
}
