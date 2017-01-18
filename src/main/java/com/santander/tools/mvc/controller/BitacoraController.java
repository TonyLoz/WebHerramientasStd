package com.santander.tools.mvc.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.santander.commons.exceptions.ServiceException;
import com.santander.tools.bean.BitacoraBean;
import com.santander.tools.bean.PerfilBean;
import com.santander.tools.bean.RespuestaJsonBean;
import com.santander.tools.bean.UsuarioBean;
import com.santander.tools.service.BitacoraService;
import com.santander.tools.service.PerfilService;
import com.santander.tools.service.UsuarioService;


/**
 * Clase que controla todas las peticiones relacionadas alta de usuarios
 * 
 * @author OMartinez (1.0.0)
 * @version 1.0.0, 03/08/2016
 */
@Controller
public class BitacoraController extends BaseMultiActionController {

	private static final Logger LOG = Logger.getLogger(BitacoraController.class);  
	
	@Autowired
	BitacoraService bitacoraService;	
	
    @RequestMapping(value = "/bitacora.htm",method = RequestMethod.GET)
    public String mostrarUsuarios(){
    	LOG.debug("Controller para redirigir a la pantalla de usuarios");
        return "bitacora";
    }
    
    
    /**
     * Metodo para obtener la lista de bitacora
     *
     * @param request
     * @param model
     * @return
     */
	
	@RequestMapping(value = "/consultarBitacora.json", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody RespuestaJsonBean consultarPerfiles(final HttpServletRequest request,
			final Map<String, Object> model) {
	

    	LOG.info("Controller para obtener, en formato JSON, Bitacora");
        RespuestaJsonBean respuesta = new RespuestaJsonBean();
        List<BitacoraBean> listaBitacora;

        try {
        	listaBitacora = bitacoraService.getBitacora();
            respuesta.setLista(listaBitacora);
            respuesta.setEstatus("ok");

        } catch (ServiceException se) {
        	LOG.error("Error al obtener Bitacora: " + se.getMessage() + " " + se.toString());
            respuesta.setEstatus("error");
            respuesta.setMensaje(se.getMessage());
        }

        return respuesta;

    }	

 	    
	
}
