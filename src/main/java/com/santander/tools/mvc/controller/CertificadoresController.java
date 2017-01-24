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
import com.santander.tools.bean.CertificadorBean;
import com.santander.tools.service.CertificadorService;
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
	
	@Autowired
	CertificadorService certificadorService;	
	
    @RequestMapping(value = "/certificadores.htm",method = RequestMethod.GET)
    public String mostrarUsuarios(){
    	LOG.debug("Controller para redirigir a la pantalla de certificadores");
        return "certificadores";
    }
    
    
    @RequestMapping(value = "/guardarCertificador.json", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    RespuestaJsonBean guardarCertificador(final HttpServletRequest request, final Map<String, Object> model) {
    	LOG.info("Controller para guardar alta de certificador");
        RespuestaJsonBean respuesta = new RespuestaJsonBean();

        try {

            JSONObject jsonObj = requestParamsToJSON(request);

            //UsuarioBean usuario = (UsuarioBean) request.getSession(false).getAttribute("usuario");

            String nombre = jsonObj.getString("nombre");
            
            CertificadorBean certificador = new CertificadorBean();
            certificador.setNombre(nombre);
            
            certificadorService.registrarCertificador(certificador);

            respuesta.setEstatus("ok");
            respuesta.setMensaje("Se agrego correctamente el certificador");
            
  
        } catch (ServiceException se) {
        	LOG.error("Error al guardar certificador: " + se.getMessage() + " " + se.toString());
            respuesta.setEstatus("error");
            respuesta.setMensaje(se.getMessage());
        } catch (Exception e) {
        	LOG.error("Error al guardar certificador: " + e.getMessage() + " " + e.toString());
            respuesta.setEstatus("error");
            respuesta.setMensaje("Error al guardar certificador:"+e.getMessage());
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
	
	@RequestMapping(value = "/consultarCertificadores.json", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody RespuestaJsonBean consultarCertificadores(final HttpServletRequest request,
			final Map<String, Object> model) {
	

    	LOG.info("Controller para obtener, en formato JSON, certificadores");
        RespuestaJsonBean respuesta = new RespuestaJsonBean();
        List<CertificadorBean> lista;

        try {
        	lista = certificadorService.getCertificadores();
            respuesta.setLista(lista);
            respuesta.setEstatus("ok");

        } catch (ServiceException se) {
        	LOG.error("Error al obtener Certificadores: " + se.getMessage() + " " + se.toString());
            respuesta.setEstatus("error");
            respuesta.setMensaje(se.getMessage());
        }

        return respuesta;

    }
	
	
    @RequestMapping(value = "/actualizarCertificadores.json", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    RespuestaJsonBean actualizarCertificadores(final HttpServletRequest request, final Map<String, Object> model) {
    	LOG.info("Controller para actualizar Certificador");
        RespuestaJsonBean respuesta = new RespuestaJsonBean();

        try {

            JSONObject jsonObj = requestParamsToJSON(request);

            //UsuarioBean usuario = (UsuarioBean) request.getSession(false).getAttribute("usuario");

            String nombre = jsonObj.getString("nombre");
            String idCert = jsonObj.getString("idCert");
            int idcert=0;
            if(idCert != null){
            	idcert = Integer.parseInt(idCert);
            }
            
            CertificadorBean certificador = new CertificadorBean();
            certificador.setNombre(nombre);
            certificador.setIdCertificador(idcert);
            
            certificadorService.actualizarCertificador(certificador);

            respuesta.setEstatus("ok");
            respuesta.setMensaje("Se actualizo correctamente el certificador");
            
        } catch (ServiceException se) {
        	LOG.error("Error al actualizar certificador: " + se.getMessage() + " " + se.toString());
            respuesta.setEstatus("error");
            respuesta.setMensaje(se.getMessage());
        } catch (Exception e) {
        	LOG.error("Error al actualizar certificador: " + e.getMessage() + " " + e.toString());
            respuesta.setEstatus("error");
            respuesta.setMensaje("Error al actualizar certificador");
        }

        return respuesta;
    }
	
	
    
    @RequestMapping(value = "/borrarCertificador.json", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    RespuestaJsonBean borrarCertificador(final HttpServletRequest request, final Map<String, Object> model) {
    	LOG.info("Controller para borrar usuario");
        RespuestaJsonBean respuesta = new RespuestaJsonBean();

        try {

            JSONObject jsonObj = requestParamsToJSON(request);

            //UsuarioBean usuario = (UsuarioBean) request.getSession(false).getAttribute("usuario");

            String idCert = jsonObj.getString("idCert");
            int idc=0;
            if(idCert != null){
            	idc = Integer.parseInt(idCert);
            }
            
            CertificadorBean certificador = new CertificadorBean();
            certificador.setIdCertificador(idc);
            
            certificadorService.borrarCertificador(certificador);

            respuesta.setEstatus("ok");
            respuesta.setMensaje("Se borro correctamente el certificador");
            
        } catch (ServiceException se) {
        	LOG.error("Error al borrar certificador: " + se.getMessage() + " " + se.toString());
            respuesta.setEstatus("error");
            respuesta.setMensaje(se.getMessage());
        } catch (Exception e) {
        	LOG.error("Error al borrar certificador: " + e.getMessage() + " " + e.toString());
            respuesta.setEstatus("error");
            respuesta.setMensaje("Error al borrar certificador");
        }

        return respuesta;
    }    


 	    
	
}
