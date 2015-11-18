package com.supinfo.rmt.jsf.controller;

import com.supinfo.rmt.ejb.entity.Employee;
import com.supinfo.rmt.ejb.entity.Manager;
import com.supinfo.rmt.ejb.services.ManagerService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.sql.Date;

/**
 * Created by Rico on 14/11/15.
 */
@ManagedBean
public class ManagerController {

    private Employee employee;

    @EJB
    private ManagerService managerService;

    @ManagedProperty(value = "#{userController}")
    private UserController userController;

    @PostConstruct
    public void init() {
        this.employee = new Employee();
    }

    public UserController getUserController() {
        return userController;
    }

    public void setUserController(UserController userController) {
        this.userController = userController;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    /**
     * Create manager's employee
     *
     * @throws IOException
     */
    public void addEmployee() throws IOException {
        // Set current date create employee
        employee.setDate(new Date(new java.util.Date().getTime()));
        // Save user into bdd
        ((Manager)this.userController.getUser()).addEmployee(employee);
        managerService.updateManager((Manager)this.userController.getUser());
        // Redirect to list_view
        ExternalContext eC = FacesContext.getCurrentInstance().getExternalContext();
        this.userController.redirect(eC, "list_employee.xhtml");
    }

}
