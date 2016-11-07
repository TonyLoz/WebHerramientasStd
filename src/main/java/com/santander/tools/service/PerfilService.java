/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.santander.tools.service;




import java.util.List;

import com.santander.commons.exceptions.ServiceException;
import com.santander.tools.bean.PerfilBean;



/**
 *
 * @author Z615563
 */
public interface PerfilService {
    
	public List<PerfilBean> getPerfiles() throws ServiceException;
    public PerfilBean getPerfil(int idPerfil) throws ServiceException;
    public void registrarPerfil(PerfilBean perfil) throws ServiceException;
    
    
}
