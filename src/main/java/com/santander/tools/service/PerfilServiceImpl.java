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
import com.santander.tools.bean.PerfilBean;
import com.santander.tools.bean.PermisoBean;

import com.santander.tools.dao.PerfilDao;
import com.santander.tools.dao.PermisoDao;

/**
 *
 * @version 0.0.1 01/06/2016
 * @author  OMartinez
 */
@Service
public class PerfilServiceImpl implements PerfilService {

	private static Logger log = Logger.getLogger(PerfilServiceImpl.class);

	@Autowired
	private PermisoDao permisoDao;

	@Autowired
	private PerfilDao perfilDao;
	
	@Override
	public PerfilBean getPerfil(int idPerfil) throws ServiceException{
		
		PerfilBean pb = null;
		try {
			List<PermisoBean> lp  = permisoDao.getPermisos(idPerfil);
			
			pb = permisoDao.getPerfil(idPerfil, lp);
			
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			log.equals(e.getMessage());
			throw new ServiceException(e.getMessage());
		}
		return pb;
		
	}
	
	
	
	@Override
	public List<PerfilBean> getPerfiles() throws ServiceException{
		
		List<PerfilBean> lp;
		try {
			lp  = perfilDao.getPerfiles();
			
			
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			log.equals(e.getMessage());
			throw new ServiceException(e.getMessage());
		}
		return lp;
		
	}	

	
    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW, rollbackFor = {ServiceException.class})
    public void registrarPerfil(PerfilBean perfil) throws ServiceException {

        try {

            Long idPerfil = perfilDao.registrarPerfi(perfil);

        } catch (DAOException ex) {
            log.error("No se pudo registrar perfil: " + ex.getMessage());
            throw new ServiceException("No se pudo registrar perfil:"+ex.getMessage());
        }

    }	

}
