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
import com.santander.tools.bean.PerfilBean;
import com.santander.tools.bean.RespuestaJsonBean;
import com.santander.tools.bean.UsuarioBean;
import com.santander.tools.service.UsuarioService;


/**
 * Clase que controla todas las peticiones relacionadas alta de usuarios
 * 
 * @author OMartinez (1.0.0)
 * @version 1.0.0, 03/08/2016
 */
@Controller
public class CertificadoresController extends BaseMultiActionController {

	private static final Logger LOG = Logger.getLogger(CertificadoresController.class);  
	
	
	
    @RequestMapping(value = "/certificadores.htm",method = RequestMethod.GET)
    public String mostrarUsuarios(){
    	LOG.debug("Controller para redirigir a la pantalla de usuarios");
        return "certificadores";
    }
    
    


 	    
	
}
