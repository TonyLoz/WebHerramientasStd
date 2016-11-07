package com.santander.tools.admintools.service;

import com.santander.commons.exceptions.ServiceException;
import com.santander.tools.admintools.bean.AdminUserBean;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Service for administrator user authentication
 *
 * @author OMartinez (1.0.0)
 * @version 1.0.0, 15/07/2016
 */
@Service
public class AdminUserServiceImpl implements AdminUserService {
    static Logger log = Logger.getLogger(AdminUserServiceImpl.class);
    @Value("${administrator.user}")
    private String administratorUser;
    @Value("${administrator.password}")
    private String administratorPassword;

    @Override
    public boolean authenticate(AdminUserBean adminUser) throws ServiceException {
        log.info("Begin of the service to authenticate the admin user");
        boolean isAuthenticated = false;
        try {
            if (adminUser.getUser().equals(administratorUser) && 
                    adminUser.getPassword().equals(administratorPassword)) {
                log.info("Admin user authenticated succesfully");
                isAuthenticated = true;
            } else {
                log.info("User or password incorrectly");
            }
        } catch (Exception e) {
            log.error(e.toString());
            throw new ServiceException("Error in the service to authenticate to the admin user");
        }
        log.info("End of the service to authenticate the admin user");
        return isAuthenticated;
    }
}