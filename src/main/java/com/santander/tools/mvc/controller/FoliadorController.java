package com.santander.tools.mvc.controller;




import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import com.santander.tools.bean.FileMetaBean;
import com.santander.tools.bean.RespuestaJsonBean;



/**
 * Clase que controla todas las peticiones relacionadas foliador
 * 
 * @author OMartinez (1.0.0)
 * @version 1.0.0, 03/08/2016
 */
@Controller
public class FoliadorController extends BaseMultiActionController {

	private static final Logger LOG = Logger.getLogger(FoliadorController.class);  
	
	
	List<FileMetaBean> archivos = new ArrayList<FileMetaBean>();
	
    @SuppressWarnings("unchecked")
	@RequestMapping(value = "/foliador.htm",method = RequestMethod.GET)
    public ModelAndView foliador(HttpServletRequest request, Map<String, Object> model) throws InterruptedException{
    	LOG.debug("Controller para redirigir a la pantalla de foliador");
    	
    	ModelAndView respuestaController = new ModelAndView("foliador");
    	
    	List<FileMetaBean> tmp = (List<FileMetaBean>) request.getSession(false).getAttribute("listaArchivos");
    	
    	archivos.addAll(new ArrayList<FileMetaBean>(tmp)); 
    	
    	//request.getSession(false).removeAttribute("listaArchivos");
    	
        return respuestaController;
    }
    
    
    /**
     * Metodo para obtener la lista de arcivos cargados
     *
     * @param request
     * @param model
     * @return
     */
	
	@RequestMapping(value = "/consultarArchivos.json", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody RespuestaJsonBean consultarArchivos(final HttpServletRequest request,
			final Map<String, Object> model) {
	

    	LOG.info("Controller para obtener, en formato JSON, Archivos cargados previamente");
        RespuestaJsonBean respuesta = new RespuestaJsonBean();

        //try {
            respuesta.setLista(archivos);
            respuesta.setEstatus("ok");

        /*} catch (ServiceException se) {
        	LOG.error("Error al obtener Perfiles: " + se.getMessage() + " " + se.toString());
            respuesta.setEstatus("error");
            respuesta.setMensaje(se.getMessage());
        }*/

        return respuesta;

    }	    
	
}
