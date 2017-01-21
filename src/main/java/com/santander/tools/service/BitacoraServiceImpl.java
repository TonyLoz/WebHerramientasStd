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

import com.santander.commons.exceptions.DAOException;
import com.santander.commons.exceptions.ServiceException;
import com.santander.tools.bean.BitacoraBean;
import com.santander.tools.dao.BitacoraDao;

/**
 *
 * @version 0.0.1 18/01/2017
 * @author OMartinez
 */
@Service
public class BitacoraServiceImpl implements BitacoraService {

	private static Logger log = Logger.getLogger(BitacoraServiceImpl.class);

	@Autowired
	private BitacoraDao bitacoraDao;

	
	@Override
	public List<BitacoraBean> getBitacora() throws ServiceException{
		
		List<BitacoraBean> lp;
		try {
			lp  = bitacoraDao.getObtenerBitacora();
			
			
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			log.equals(e.getMessage());
			throw new ServiceException(e.getMessage());
		}
		return lp;
		
	}		
	
}
