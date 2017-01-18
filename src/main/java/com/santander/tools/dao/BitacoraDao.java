package com.santander.tools.dao;



import java.util.List;

import com.santander.commons.exceptions.DAOException;

import com.santander.tools.bean.BitacoraBean;

public interface BitacoraDao {
	
	
	public List<BitacoraBean> getObtenerBitacora() throws DAOException;
}
