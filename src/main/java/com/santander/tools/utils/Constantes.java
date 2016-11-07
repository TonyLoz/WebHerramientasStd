package com.santander.tools.utils;

/**
 * Archivo de constantes globales.
 * @author Victor.Alvarado, Cesar.Perez
 * @version 1.0.0
 */
public final class Constantes {
    //DATASOURCES
    public static final String DATASOURCE_CENTRAL = "dataSourceCentral";
    
    //NOMBRE DE ATRIBUTOS DE SESIÓN
    public static final String SESSION_ATR_USUARIO = "usuario";
    
    
    //ESTADOS DEL USUARIO
    public static enum Usuario {

        ACTIVO("1"),
        INACTIVO("2");
        
        private final String estado;

        private Usuario(final String estado) {
            this.estado = estado;
        }

        public String getEstado() {
            return estado;
        }
    };
}
