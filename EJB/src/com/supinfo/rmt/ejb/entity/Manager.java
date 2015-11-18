package com.supinfo.rmt.ejb.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rico on 12/11/15.
 */
@Entity
public class Manager extends User implements Serializable {

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Employee> employees;

    public Manager() {
        this.employees = new ArrayList<Employee>();
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }
}
