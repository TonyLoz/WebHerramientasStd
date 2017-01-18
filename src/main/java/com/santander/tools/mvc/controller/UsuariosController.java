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
public class UsuariosController extends BaseMultiActionController {

	private static final Logger LOG = Logger.getLogger(UsuariosController.class);  
	
	@Autowired
	UsuarioService usuarioService;
	
	
    @RequestMapping(value = "/usuarios.htm",method = RequestMethod.GET)
    public String mostrarUsuarios(){
    	LOG.debug("Controller para redirigir a la pantalla de usuarios");
        return "usuarios";
    }
    
    
    @RequestMapping(value = "/guardarUsuario.json", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    RespuestaJsonBean guardarUsuario(final HttpServletRequest request, final Map<String, Object> model) {
    	LOG.info("Controller para guardar alta de usuario");
        RespuestaJsonBean respuesta = new RespuestaJsonBean();

        try {

            JSONObject jsonObj = requestParamsToJSON(request);

            //UsuarioBean usuario = (UsuarioBean) request.getSession(false).getAttribute("usuario");

            String usuario = jsonObj.getString("nombre");
            String correo = jsonObj.getString("correo");
            String idPerfil = jsonObj.getString("perfil");
            int idpef=0;
            if(idPerfil != null){
            	idpef = Integer.parseInt(idPerfil);
            }
            
            UsuarioBean usuarioNuevo = new UsuarioBean();
            usuarioNuevo.setNombre(usuario);
            usuarioNuevo.setCorreo(correo);
            usuarioNuevo.setIdPerfil(idpef);
            
            usuarioService.registrarUsuario(usuarioNuevo);

  
        } catch (ServiceException se) {
        	LOG.error("Error al guardar usuario: " + se.getMessage() + " " + se.toString());
            respuesta.setEstatus("error");
            respuesta.setMensaje(se.getMessage());
        } catch (Exception e) {
        	LOG.error("Error al guardar usuario: " + e.getMessage() + " " + e.toString());
            respuesta.setEstatus("error");
            respuesta.setMensaje("Error al guardar usuario");
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
	
	@RequestMapping(value = "/consultarUsuarios.json", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody RespuestaJsonBean consultarUsuarios(final HttpServletRequest request,
			final Map<String, Object> model) {
	

    	LOG.info("Controller para obtener, en formato JSON, Usuarios");
        RespuestaJsonBean respuesta = new RespuestaJsonBean();
        List<UsuarioBean> listaUsuarios;

        try {
        	listaUsuarios = usuarioService.getUsuarios();
            respuesta.setLista(listaUsuarios);
            respuesta.setEstatus("ok");

        } catch (ServiceException se) {
        	LOG.error("Error al obtener Perfiles: " + se.getMessage() + " " + se.toString());
            respuesta.setEstatus("error");
            respuesta.setMensaje(se.getMessage());
        }

        return respuesta;

    }	    
	
}
