/**
 * 
 */
package com.santander.tools.bean;



/**
 * @author OMartinez
 *
 */
public class PermisoBean implements Comparable<PermisoBean> {
	private String opcion;
	private String controller;
	private String menu;
	private int idxMenu;
	private int idxOpcion;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PermisoBean)) {
            return false;
        }
        PermisoBean server = (PermisoBean) o;
        return menu.equals(server.getMenu());
    }

    @Override
    public int hashCode() {
        return menu.hashCode();
    }

	@Override
	public int compareTo(PermisoBean o) {
		 return this.getMenu().compareTo(o.getMenu());

	}		
	
	
	public String getOpcion() {
		return opcion;
	}

	public void setOpcion(String opcion) {
		this.opcion = opcion;
	}

	public String getController() {
		return controller;
	}

	public void setController(String controller) {
		this.controller = controller;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public int getIdxMenu() {
		return idxMenu;
	}

	public void setIdxMenu(int idxMenu) {
		this.idxMenu = idxMenu;
	}

	public int getIdxOpcion() {
		return idxOpcion;
	}

	public void setIdxOpcion(int idxOpcion) {
		this.idxOpcion = idxOpcion;
	}

}
