/**
 * 
 */
package com.santander.tools.bean;

import java.util.List;

/**
 * @author scary
 *
 */
public class MenuBean {

	private String nombre;
	
	private List<PermisoBean> listaOpciones;

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
	 * @return the listaOpciones
	 */
	public List<PermisoBean> getListaOpciones() {
		return listaOpciones;
	}

	/**
	 * @param listaOpciones the listaOpciones to set
	 */
	public void setListaOpciones(List<PermisoBean> listaOpciones) {
		this.listaOpciones = listaOpciones;
	}	
	
	
}
