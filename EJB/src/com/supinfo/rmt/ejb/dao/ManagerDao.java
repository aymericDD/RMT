package com.supinfo.rmt.ejb.dao;

import com.supinfo.rmt.ejb.entity.Employee;
import com.supinfo.rmt.ejb.entity.Manager;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by Rico on 13/11/15.
 */
@Local
public interface ManagerDao {

    public void updateManager(Manager manager);

}
