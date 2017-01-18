/**
 * 
 */
package com.santander.tools.bean;

import java.util.List;

/**
 * @author OMartinez
 *
 */
public class PerfilBean {

	private Integer id;
	private String nombre;
	private List<MenuBean> listaMenus;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
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
	 * @return the listaMenus
	 */
	public List<MenuBean> getListaMenus() {
		return listaMenus;
	}

	/**
	 * @param listaMenus the listaMenus to set
	 */
	public void setListaMenus(List<MenuBean> listaMenus) {
		this.listaMenus = listaMenus;
	}


}
