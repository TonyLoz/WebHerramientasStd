package com.santander.tools.mvc.controller;

import com.santander.tools.bean.PerfilBean;
import com.santander.tools.bean.UsuarioBean;
import com.santander.tools.service.PerfilService;
import com.santander.tools.service.UsuarioService;
import com.santander.tools.utils.Constantes;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Controller de autenticación, para el manejo del acceso y sesion del usuario
 * 
 * @author César Perez
 * @version 1.0.0 28/05/2014
 */
@Controller
public class AutenticacionController {

	private static final Logger LOG = Logger.getLogger(AutenticacionController.class);

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private PerfilService perfilService;

	/**
	 * Controller para redirigir a la pagina de autenticacion
	 * 
	 * @return nombre de la vista a mostrar
	 */
	@RequestMapping(value = "/autenticacion.htm", method = RequestMethod.GET)
	public String mostrarAutenticacion() {
		LOG.info("Peticion para redirigir a la pagina de autenticacion");
		return "autenticacion";
	}

	/**
	 * Controller para autenticar al usuario
	 * 
	 * @param request
	 *            objeto request
	 * @param model
	 *            modelo
	 * @return nombre de la vista a mostrar
	 */
	@RequestMapping(value = "/autenticar.htm", method = RequestMethod.POST)
	public String autenticar(HttpServletRequest request, Map<String, Object> model) {
		LOG.info("Atendiendo peticion de autenticacion");
		HttpSession sesion = request.getSession(true);
		String usuarioParam = request.getParameter("usuario");
		String contrasenaParam = request.getParameter("contrasena");
		LOG.info("Autenticando al usuario " + usuarioParam);
		if (StringUtils.isEmpty(usuarioParam) || StringUtils.isEmpty(contrasenaParam)) {
			LOG.info("No se ha especificado el usuario o la contraseña");
			model.put("mensajeError", "No se ha especificado el Usuario o la Contrase&ntilde;a");
			return "autenticacion";
		}

		String nav = "redirect:/home.htm";
		try {

			UsuarioBean usuarioAutenticado = usuarioService.getUsuario(usuarioParam);
			if (usuarioParam.equals(usuarioAutenticado.getCorreo())
					&& contrasenaParam.equals(usuarioAutenticado.getContrasena())) {

				PerfilBean perfil = perfilService.getPerfil(usuarioAutenticado.getIdPerfil());
				usuarioAutenticado.setPerfil(perfil);

				sesion.setAttribute(Constantes.SESSION_ATR_USUARIO, usuarioAutenticado);
				sesion.setAttribute("idUsuario", usuarioAutenticado.getIdUsuario());
				sesion.setAttribute("Usuario", usuarioAutenticado.getUsuario());
				sesion.setAttribute("nombre", usuarioAutenticado.getNombre());

				return "redirect:/home.htm";
			} else {
				model.put("mensajeError", "Usuario o contrase&ntilde;a incorrecta");
				model.put("usr", usuarioAutenticado);

			}

		} catch (Exception e) {
			LOG.error(e.toString());
			model.put("mensajeError", "Lo sentimos, ocurri&oacute; un error al autenticar al usuario");
		}
		return "autenticacion";
	}

	/**
	 * Controller para cerrar sesión
	 * 
	 * @param request
	 *            objeto request
	 * @return regresa la cadena "redirect:/autenticacion" la cual indica que se
	 *         va a enviar a la pagina de autenticación
	 */
	@RequestMapping(value = "/cerrarSesion.htm", method = RequestMethod.GET)
	public String logoutSesion(final HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			Object usrObj = session.getAttribute(Constantes.SESSION_ATR_USUARIO);
			if (usrObj != null) {
				UsuarioBean user = (UsuarioBean) usrObj;
				LOG.info("Usuario " + user.getUsuario() + " termino su sesion!");
			}
			session.invalidate();
		}
		return "redirect:/autenticacion.htm";
	}

	/**
	 * Controller para invalidar sesión
	 * 
	 * @param request
	 *            objeto request
	 */
	@RequestMapping(value = "/invalidarSesion.htm", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void invalidarSesion(final HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
	}
}