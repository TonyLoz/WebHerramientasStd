package com.santander.tools.bean;

import java.util.List;

/**
 * Clase que representa una respuesta json
 * @author OMartinez, V1.1
 * @version 1.0, 14/08/2016
 */
public class RespuestaJsonBean {
    
    private String estatus;
    private String mensaje;
    private String valor;
    private List<?> lista = null;


	public RespuestaJsonBean() {
    }

    public RespuestaJsonBean(String estatus, String mensaje) {
        this.estatus = estatus;
        this.mensaje = mensaje;
    }

    /**
	 * @return the lista
	 */
	public List<?> getLista() {
		return lista;
	}

	/**
	 * @param lista the lista to set
	 */
	public void setLista(List<?> lista) {
		this.lista = lista;
	}   
    
    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
}
