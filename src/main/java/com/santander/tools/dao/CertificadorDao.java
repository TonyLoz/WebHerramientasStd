package com.santander.tools.dao;



import java.util.List;

import com.santander.commons.exceptions.DAOException;

import com.santander.tools.bean.CertificadorBean;

public interface CertificadorDao {
	
	
	public Long registrarCertificador(CertificadorBean certificador) throws DAOException;
	
	public List<CertificadorBean> getCertificadores() throws DAOException;
	
	public void actualizarCertificador(CertificadorBean certificador) throws DAOException;
	
	public void borrarCertificador(CertificadorBean certificador) throws DAOException;
}
