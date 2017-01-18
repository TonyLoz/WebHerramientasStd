package com.santander.tools.dao;



import java.util.List;

import com.santander.commons.exceptions.DAOException;
import com.santander.tools.bean.PerfilBean;


public interface PerfilDao {
	
	public List<PerfilBean> getPerfiles() throws DAOException;
	
	public Long registrarPerfi(PerfilBean perfil) throws DAOException;
}
