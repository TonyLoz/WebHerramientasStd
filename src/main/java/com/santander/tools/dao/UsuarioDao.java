package com.santander.tools.dao;



import java.util.List;

import com.santander.commons.exceptions.DAOException;

import com.santander.tools.bean.UsuarioBean;

public interface UsuarioDao {
	
	public UsuarioBean getUsuario(String mail) throws DAOException;
	
	public Long registrarUsuario(UsuarioBean Usuario) throws DAOException;
	
	public List<UsuarioBean> getUsuarios() throws DAOException;
}
