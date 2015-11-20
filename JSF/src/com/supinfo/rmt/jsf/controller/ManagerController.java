package com.supinfo.rmt.jsf.controller;

import com.supinfo.rmt.ejb.entity.Client;
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

    private Client client;

    @EJB
    private ManagerService managerService;

    @ManagedProperty(value = "#{userController}")
    private UserController userController;

    @PostConstruct
    public void init() {
        this.employee = new Employee();
        this.client = new Client();
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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
        this.userController.setUser(managerService.updateManager((Manager)this.userController.getUser()));
        // Redirect to list_view
        ExternalContext eC = FacesContext.getCurrentInstance().getExternalContext();
        this.userController.redirect(eC, "employee/list_employee.xhtml");
    }

    /**
     * Create manager's client
     *
     * @throws IOException
     */
    public void addClient() throws IOException {
        // Save user into bdd
        ((Manager)this.userController.getUser()).addClient(this.client);
        this.userController.setUser(managerService.updateManager((Manager)this.userController.getUser()));
        // Redirect to list_view
        ExternalContext eC = FacesContext.getCurrentInstance().getExternalContext();
        this.userController.redirect(eC, "client/list_client.xhtml");
    }

}
