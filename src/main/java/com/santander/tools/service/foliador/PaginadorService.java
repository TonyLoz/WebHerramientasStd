package com.santander.tools.service.foliador;

import java.io.File;

import java.io.InputStream;

import com.santander.commons.exceptions.ServiceException;

public interface PaginadorService {
	
	
	
	public InputStream paginarDocumento(byte[] inputFile, String outputFile) throws ServiceException;
}
