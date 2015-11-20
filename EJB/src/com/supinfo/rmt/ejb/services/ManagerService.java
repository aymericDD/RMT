package com.supinfo.rmt.ejb.services;

import com.supinfo.rmt.ejb.dao.ManagerDao;
import com.supinfo.rmt.ejb.entity.Client;
import com.supinfo.rmt.ejb.entity.Manager;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Created by Rico on 13/11/15.
 */
@Stateless
public class ManagerService {

    @EJB
    private ManagerDao managerDao;

    public Manager updateManager(Manager manager) {
        return managerDao.updateManager(manager);
    }

}
