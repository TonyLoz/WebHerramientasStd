package com.santander.tools.dao;

import java.util.List;

import com.santander.commons.exceptions.DAOException;
import com.santander.tools.bean.PerfilBean;
import com.santander.tools.bean.PermisoBean;

public interface PermisoDao {
	
	public List<PermisoBean> getPermisos(int idPerfil) throws DAOException;
	public PerfilBean getPerfil(int idPerfil, List<PermisoBean> listaPermisos) throws DAOException;
			
}
