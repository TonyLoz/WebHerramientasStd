package com.santander.commons.exceptions;

/**
 * Clase que representa una excepción en la capa de DAO
 *
 * @author OMartinez (1.0.0)
 * @version 1.0.0, 16/07/2016
 */
public class DAOException extends Exception {
    
    private static final long serialVersionUID = 1L;

    public DAOException(String message) {
        super(message);
    }

    public DAOException(final String message, final Throwable e) {
        super(message, e);
    }
}
