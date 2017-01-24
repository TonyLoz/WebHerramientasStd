package com.santander.tools.bean;



/**
 * Clase que representa un usuario.
 * @author OMartinez, V1.1
 * @version 1.0, 22/01/2017
 */
public class CertificadorBean {
	
	private int idCertificador = 0; 

	private String nombre = "";
    private int seleccionado = 0;    
    
    
	/**
	 * @return the idCertificador
	 */
	public int getIdCertificador() {
		return idCertificador;
	}
	/**
	 * @param idCertificador the idCertificador to set
	 */
	public void setIdCertificador(int idCertificador) {
		this.idCertificador = idCertificador;
	}    
    /**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the seleccionado
	 */
	public int getSeleccionado() {
		return seleccionado;
	}
	/**
	 * @param seleccionado the seleccionado to set
	 */
	public void setSeleccionado(int seleccionado) {
		this.seleccionado = seleccionado;
	}

    
    
}
