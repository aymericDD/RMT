package com.supinfo.rmt.ejb.services;

import com.supinfo.rmt.ejb.dao.EmployeeDao;
import com.supinfo.rmt.ejb.entity.Employee;
import com.supinfo.rmt.ejb.entity.Manager;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by Rico on 13/11/15.
 */
@Stateless
public class EmployeeService {

    @EJB
    private EmployeeDao employeeDao;

    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    public Employee updateEmployee(Employee employee) {
        return employeeDao.updateEmployee(employee);
    }

}
