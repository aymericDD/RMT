package com.supinfo.rmt.jsf.controller;

import com.supinfo.rmt.ejb.entity.Employee;
import com.supinfo.rmt.ejb.entity.Manager;
import com.supinfo.rmt.ejb.entity.User;
import com.supinfo.rmt.ejb.services.UserService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.util.Date;


/**
 * Created by Rico on 12/11/15.
 */
@ManagedBean @SessionScoped
public class UserController {

    @EJB
    private UserService userService;

    private User user;

    @PostConstruct
    public void init() {
        this.user = new User();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void createManager() throws  IOException {
        Manager manager = new Manager();
        manager.setDate(new java.sql.Date(new Date().getTime()));
        manager.setEmail("fqdf@fsd.fr");
        manager.setFirstName("First name");
        manager.setLastName("Last name");
        manager.setPassword("password");
        manager.setUserName("User name");
        userService.addUser(manager);
    }

    public void createEmployee() throws  IOException {
        Employee employee = new Employee();
        employee.setDate(new java.sql.Date(new Date().getTime()));
        employee.setEmail("fqdf@fsd.fr");
        employee.setFirstName("First name ");
        employee.setLastName("Last name");
        employee.setPassword("password");
        employee.setUserName("Employed");
        userService.addUser(employee);
    }

    public void login() throws IOException {
        ExternalContext eC = FacesContext.getCurrentInstance().getExternalContext();

        if (!user.getUserName().isEmpty() && !user.getPassword().isEmpty()) {

            this.user = userService.getUserByPassword(user.getUserName(), user.getPassword());

            if (this.user instanceof Employee) {
                this.redirect(eC, "employee_home.xhtml");
            } else if (this.user instanceof Manager) {
                this.redirect(eC, "manager_home.xhtml");
            } else {
                this.redirect(eC, "login.xhtml");
            }
        } else {
            this.redirect(eC, "login.xhtml");
        }
    }

    public void redirect(ExternalContext eC, String view) throws IOException {
        eC.redirect(eC.getRequestContextPath() + "/" + view);
    }
}
