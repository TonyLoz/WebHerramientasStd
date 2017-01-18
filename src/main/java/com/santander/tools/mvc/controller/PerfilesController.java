package com.santander.tools.mvc.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.annotation.XmlSeeAlso;

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
import com.santander.tools.service.PerfilService;

/**
 * Clase que controla todas las peticiones relacionadas alta de perfiles
 * 
 * @author OMartinez (1.0.0)
 * @version 1.0.0, 03/08/2016
 */
@Controller
@XmlSeeAlso({com.santander.tools.bean.PerfilBean.class})
public class PerfilesController extends BaseMultiActionController {

	private static final Logger LOG = Logger.getLogger(PerfilesController.class);

	@Autowired
	PerfilService perfilService;

	@RequestMapping(value = "/perfiles.htm", method = RequestMethod.GET)
	public String mostrarUsuarios() {
		LOG.debug("Controller para redirigir a la pantalla de perfiles");
		return "perfiles";
	}

	@RequestMapping(value = "/guardarPerfil.htm", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody RespuestaJsonBean guardarUsuario(final HttpServletRequest request,
			final Map<String, Object> model) {
		LOG.info("Controller para guardar alta de perfil");
		RespuestaJsonBean respuesta = new RespuestaJsonBean();

		try {

			JSONObject jsonObj = requestParamsToJSON(request);

			// UsuarioBean usuario = (UsuarioBean)
			// request.getSession(false).getAttribute("usuario");

			String perfil = jsonObj.getString("perfil");

			if (perfil == null) {

			}

			PerfilBean perfilNuevo = new PerfilBean();
			perfilNuevo.setNombre(perfil);

			perfilService.registrarPerfil(perfilNuevo);

		} catch (ServiceException se) {
			LOG.error("Error al guardar atencion: " + se.getMessage() + " " + se.toString());
			respuesta.setEstatus("error");
			respuesta.setMensaje(se.getMessage());
		} catch (Exception e) {
			LOG.error("Error al guardar atencion: " + e.getMessage() + " " + e.toString());
			respuesta.setEstatus("error");
			respuesta.setMensaje("Error al guardar atenci&oacute;n");
		}

		return respuesta;
	}
	
	
	
    /**
     * Metodo para obtener la lista de perfiles
     *
     * @param request
     * @param model
     * @return
     */
	
	@RequestMapping(value = "/consultarPerfiles.json", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody RespuestaJsonBean consultarPerfiles(final HttpServletRequest request,
			final Map<String, Object> model) {
	

    	LOG.info("Controller para obtener, en formato JSON, Perfiles");
        RespuestaJsonBean respuesta = new RespuestaJsonBean();
        List<PerfilBean> listaPerfiles;

        try {
        	listaPerfiles = perfilService.getPerfiles();
            respuesta.setLista(listaPerfiles);
            respuesta.setEstatus("ok");

        } catch (ServiceException se) {
        	LOG.error("Error al obtener Perfiles: " + se.getMessage() + " " + se.toString());
            respuesta.setEstatus("error");
            respuesta.setMensaje(se.getMessage());
        }

        return respuesta;

    }	

}
