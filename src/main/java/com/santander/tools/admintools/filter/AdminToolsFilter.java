package com.santander.tools.admintools.filter;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

/**
 * Filter to check if the administrator user is authenticated
 *
 * @author OMartinez (1.0.0)
 * @version 1.0.0, 15/07/2016
 */
public class AdminToolsFilter  implements Filter {
    static Logger log = Logger.getLogger(AdminToolsFilter.class);
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest hsr = (HttpServletRequest) request;
        HttpSession session = hsr.getSession(false);
        if (!(  hsr.getRequestURI().equals(hsr.getContextPath() + "/adminTools.cfg") || 
                hsr.getRequestURI().equals(hsr.getContextPath() + "/signInAdminTools.cfg")
            )){
            if (session == null || session.getAttribute("adminUser") == null) {
                log.info("The user is not authenticated");
                ((HttpServletResponse)response).sendRedirect(hsr.getContextPath() + "/adminTools.cfg");
                return;
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
