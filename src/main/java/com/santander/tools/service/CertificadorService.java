/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.santander.tools.service;




import java.util.List;

import com.santander.commons.exceptions.ServiceException;
import com.santander.tools.bean.CertificadorBean;



/**
 *
 * @author Z615563
 */
public interface CertificadorService {
    
    
	public void registrarCertificador(CertificadorBean certificador) throws ServiceException;
	public void borrarCertificador(CertificadorBean certificador) throws ServiceException;
	public void actualizarCertificador(CertificadorBean certificador) throws ServiceException;
	public List<CertificadorBean> getCertificadores() throws ServiceException;
}
