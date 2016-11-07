package com.santander.commons.exceptions;

/**
 * Clase que representa una excepción en la capa de service
 *
 * @author OMartinez (1.0.0)
 * @version 1.0.0, 16/07/2016
 */
public class ServiceException extends Exception {
    
    private static final long serialVersionUID = 1L;

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(final String message, final Throwable e) {
        super(message, e);
    }
}
