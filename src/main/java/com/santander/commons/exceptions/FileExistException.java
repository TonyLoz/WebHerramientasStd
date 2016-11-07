package com.santander.commons.exceptions;

import java.io.IOException;

/**
 * Clase que representa una excepcion durante la escritura de un archivo existente.
 * @author Celso Perez (1.0.0)
 * @version 1.0.0, 16/07/2016
 */
public class FileExistException extends IOException {
    
    private static final long serialVersionUID = 1L;

    public FileExistException(String message) {
        super(message);
    }

    public FileExistException(final String message, final Throwable e) {
        super(message, e);
    }
}
