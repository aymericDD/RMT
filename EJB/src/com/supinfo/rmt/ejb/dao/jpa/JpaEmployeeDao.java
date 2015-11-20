package com.supinfo.rmt.ejb.dao.jpa;

import com.supinfo.rmt.ejb.dao.EmployeeDao;
import com.supinfo.rmt.ejb.entity.Employee;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Rico on 13/11/15.
 */
@Stateless
public class JpaEmployeeDao implements EmployeeDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Employee> getAllEmployees() {
        return null;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return em.merge(employee);
    }
}
