package com.supinfo.rmt.ejb.dao.jpa;

import com.supinfo.rmt.ejb.dao.EmployeeDao;
import com.supinfo.rmt.ejb.entity.Employee;

import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by Rico on 13/11/15.
 */
@Stateless
public class JpaEmployeeDao implements EmployeeDao {

    @Override
    public List<Employee> getAllEmployees() {
        return null;
    }

}
