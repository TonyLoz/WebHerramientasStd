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
import com.santander.tools.bean.UsuarioBean;
import com.santander.tools.dao.UsuarioDao;

/**
 *
 * @version 0.0.1 01/06/2016
 * @author OMartinez
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {

	private static Logger log = Logger.getLogger(UsuarioServiceImpl.class);

	@Autowired
	private UsuarioDao usuarioDao;

	@Autowired
	private PerfilService perfilService;
	
	@Override
	public UsuarioBean getUsuario(String email) throws ServiceException{
		
		UsuarioBean usr1 = null;
		try {
			usr1  = usuarioDao.getUsuario(email);
			
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			log.equals(e.getMessage());
			throw new ServiceException(e.getMessage());
		}
		return usr1;
		
	}
	
	
	
    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW, rollbackFor = {ServiceException.class})
    public void registrarUsuario(UsuarioBean usuario) throws ServiceException {

        try {

            Long idUsuario = usuarioDao.registrarUsuario(usuario);

        } catch (DAOException ex) {
            log.error("No se pudo registrar usuario: " + ex.getMessage());
            throw new ServiceException("No se pudo registrar usuario:"+ex.getMessage());
        }

    }	
	
	@Override
	public List<UsuarioBean> getUsuarios() throws ServiceException{
		
		List<UsuarioBean> ls;
		try {
			ls  = usuarioDao.getUsuarios();
			
			/*for(int i=0; i< ls.size(); i++){
				
				PerfilBean perfil = perfilService.getPerfil(ls.get(i).getIdPerfil());
				ls.get(i).setPerfil(perfil);
			}*/
			
			
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			log.equals(e.getMessage());
			throw new ServiceException(e.getMessage());
		}
		return ls;
		
	}	
	
	
}
