/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.santander.tools.service;


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.santander.commons.exceptions.DAOException;
import com.santander.commons.exceptions.ServiceException;

import com.santander.tools.bean.CertificadorBean;
import com.santander.tools.dao.CertificadorDao;

/**
 *
 * @version 0.0.1 01/06/2016
 * @author OMartinez
 */
@Service
public class CertificadorServiceImpl implements CertificadorService {

	private static Logger log = Logger.getLogger(CertificadorServiceImpl.class);

	@Autowired
	private CertificadorDao certificadorDao;



    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW, rollbackFor = {ServiceException.class})
    public void registrarCertificador(CertificadorBean certificador) throws ServiceException {

        try {

            Long idCert = certificadorDao.registrarCertificador(certificador);

        } catch (DAOException ex) {
            log.error("No se pudo registrar certificador: " + ex.getMessage());
            throw new ServiceException("No se pudo registrar certificador:"+ex.getMessage());
        }

    }
    
    
    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW, rollbackFor = {ServiceException.class})
    public void actualizarCertificador(CertificadorBean certificador) throws ServiceException {

        try {

        	certificadorDao.actualizarCertificador(certificador);

        } catch (DAOException ex) {
            log.error("No se pudo actualizar certificador: " + ex.getMessage());
            throw new ServiceException("No se pudo actualizar certificador:"+ex.getMessage());
        }

    }	    
    
    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW, rollbackFor = {ServiceException.class})
    public void borrarCertificador(CertificadorBean certificador) throws ServiceException {

        try {

        	certificadorDao.borrarCertificador(certificador);

        } catch (DAOException ex) {
            log.error("No se pudo borrar certificador: " + ex.getMessage());
            throw new ServiceException("No se pudo borrar certificador:"+ex.getMessage());
        }

    }    
	
	@Override
	public List<CertificadorBean> getCertificadores() throws ServiceException{
		
		List<CertificadorBean> ls;
		try {
			ls  = certificadorDao.getCertificadores();

			
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage());
		}
		return ls;
		
	}	
	
	
}
