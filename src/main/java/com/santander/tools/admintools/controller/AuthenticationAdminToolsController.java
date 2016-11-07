package com.santander.tools.admintools.controller;

import com.santander.commons.exceptions.ServiceException;
import com.santander.tools.admintools.bean.AdminUserBean;
import com.santander.tools.admintools.service.AdminUserService;

import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller for administrator user authentication
 *
 * @author OMartinez (1.0.0)
 * @version 1.0.0, 15/07/2016
 */
@Controller
public class AuthenticationAdminToolsController {

    static Logger log = Logger.getLogger("defaultLogger");

    @Autowired
    private AdminUserService adminUserService;

    @RequestMapping(value = "/adminTools.cfg", method = RequestMethod.GET)
    public String adminTools(Map<String, Object> model) {
        log.info("Controller to show the sign in page");
        return "adminTools/authentication";
    }

    @RequestMapping(value = "/signInAdminTools.cfg", method = RequestMethod.POST)
    public String signInAdminTools(String user, String password, HttpServletRequest request) {
        log.info("Controller to authenticate the administrator");
        request.setAttribute("user", user);
        request.setAttribute("password", password);
        if (user == null || user.trim().equals("")
                || password == null || password.trim().equals("")) {
            request.setAttribute("errorMsg", "The user and password are required");
            return "adminTools/authentication";
        }
        AdminUserBean au = new AdminUserBean();
        au.setUser(user);
        au.setPassword(password);
        try {
            if (adminUserService.authenticate(au)) {
                HttpSession sesion = request.getSession(true);
                sesion.setAttribute("adminUser", au);
                return "redirect:/adminToolsMenu.cfg";
            } else {
                log.info("The user or password are incorrect");
                request.setAttribute("errorMsg", "The user or password are incorrect");
                return "adminTools/authentication";
            }
        } catch (ServiceException se) {
            log.error(se.toString());
            request.setAttribute("errorMsg", se.toString());
        }
        return "adminTools/authentication";
    }

    @RequestMapping(value = "/adminToolsMenu.cfg", method = RequestMethod.GET)
    public String adminToolsMenu(Map<String, Object> model) {
        log.info("Controller to show the administrator tools menu");
        return "adminTools/menu";
    }

    @RequestMapping(value = "/signOutAdminTools.cfg", method = RequestMethod.GET)
    public String cerrarSesion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("Controller to sign out the administrator");
        HttpSession session = request.getSession(false);
        log.info("The session was closed in the administrator tools");
        session.invalidate();
        return "adminTools/authentication";
    }
}
