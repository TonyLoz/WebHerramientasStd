package com.santander.tools.mvc.filter;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.santander.tools.utils.Constantes;

/**
 * Filtro que valida sí el usuario que esta realizando alguna petición a alguna
 * URL con terminación "htm" está autenticado. En caso de que no este autenticado,
 * se redirige a la página de autenticación.
 *
 * @author Omartinez (1.0.0)
 * @version 1.0.0 16/07/2016
 */
public class SesionFilter implements Filter {
    private static final Logger LOG = Logger.getLogger(SesionFilter.class);

    /**
     * Método que valida sí el usuario que esta realizando alguna petición a alguna
     * URL con terminación "htm" está autenticado o no. En caso de que no este autenticado,
     * se redirige a la página de autenticación. Sólo para las URLs "/autenticacion.htm"
     * y "/autenticar.htm" no se va a realizar la validación.
     *
     * @param request objeto request
     * @param response objeto response
     * @param chain objeto FilterChain
     *
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest hsrequest = (HttpServletRequest) request;
        HttpServletResponse hsresponse = (HttpServletResponse) response;
        HttpSession session = hsrequest.getSession(false);
        LOG.debug("Validando sesion");
        LOG.debug("Solicitando URL:" + hsrequest.getRequestURI());
        if (!(  hsrequest.getRequestURI().equals(hsrequest.getContextPath() + "/autenticacion.htm") ||
                hsrequest.getRequestURI().equals(hsrequest.getContextPath() + "/autenticar.htm") ||
                hsrequest.getRequestURI().equals(hsrequest.getContextPath() + "/estatusAp.htm") ||
                hsrequest.getRequestURI().equals(hsrequest.getContextPath() + "/cerrarSesion.htm") ||
                hsrequest.getRequestURI().equals(hsrequest.getContextPath() + "/invalidarSesion.htm")
            )){
            if (session == null || session.getAttribute(Constantes.SESSION_ATR_USUARIO) == null) {
                String uri = hsrequest.getRequestURI();
                if(StringUtils.endsWith(uri, ".json")) {
                    hsresponse.setStatus(302);
                    return;
                }
                else {
                    LOG.debug("No existe sesion, se redirige a la pagina de autenticacion");
                    hsresponse.sendRedirect(hsrequest.getContextPath() + "/autenticacion.htm");
                    return;
                }
            }
        }
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}