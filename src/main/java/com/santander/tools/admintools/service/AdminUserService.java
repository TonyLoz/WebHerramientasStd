package com.santander.tools.admintools.service;

import com.santander.commons.exceptions.ServiceException;
import com.santander.tools.admintools.bean.AdminUserBean;

/**
 * Service for administrator user authentication
 *
 * @author OMartinez (1.0.0)
 * @version 1.0.0, 15/07/2016
 */
public interface AdminUserService {

    /**
     * Method for authenticate to the administrator user
     *
     * @param adminUser usuario
     * @return indicator of the autentication of the admin user
     * @throws ServiceException service exception
     */
    public boolean authenticate(AdminUserBean adminUser) throws ServiceException;
}
