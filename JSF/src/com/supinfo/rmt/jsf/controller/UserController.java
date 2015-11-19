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
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import java.io.IOException;
import java.util.Date;


/**
 * Created by Rico on 12/11/15.
 */
@ManagedBean(name = "userController")
@SessionScoped
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

    /**
     * Action :: create manager and his employee
     *
     * @throws IOException
     */
    public void createManager() throws  IOException {
        Manager manager = new Manager();
        manager.setDate(new java.sql.Date(new Date().getTime()));
        manager.setEmail("fqdf@fsd.fr");
        manager.setFirstName("First name");
        manager.setLastName("Last name");
        manager.setPassword("password");
        manager.setUserName("User name");

        Employee employee = new Employee();
        employee.setDate(new java.sql.Date(new Date().getTime()));
        employee.setEmail("fqdf@fsd.fr");
        employee.setFirstName("First name ");
        employee.setLastName("Last name");
        employee.setPassword("password");
        employee.setUserName("Employed");


        manager.addEmployee(employee);

        userService.addUser(manager);
    }

    /**
     * Action :: Login user and redirect
     *
     * @throws IOException
     */
    public void login() throws IOException {
        ExternalContext eC = FacesContext.getCurrentInstance().getExternalContext();

        if (!user.getUserName().isEmpty() && !user.getPassword().isEmpty()) {

            Object object = userService.getUserByPassword(user.getUserName(), user.getPassword());

            if (object instanceof Employee) {
                this.user = (Employee)object;
                this.redirect(eC, "employee/employee_home.xhtml");
            } else if (object instanceof Manager) {
                this.user = (Manager)object;
                this.redirect(eC, "manager/manager_home.xhtml");
            }else {
                this.user.setPassword(null);
                this.redirect(eC, "login.xhtml");
            }
        }else {
            this.user.setPassword(null);
            this.redirect(eC, "login.xhtml");
        }
    }

    /**
     * Action :: Return manager's employees
     *
     * @return DataModel<Employee> employees
     */
    public DataModel<Employee> getEmployeesManager() {
        if (this.user instanceof Manager) {
            return new ListDataModel<Employee>(((Manager) this.user).getEmployees());
        }
        return null;
    }

    /**
     * Redirect to specific view
     *
     * @param   eC    ExternalContext
     * @param   view  String
     * @throws  IOException
     */
    public void redirect(ExternalContext eC, String view) throws IOException {
        eC.redirect(eC.getRequestContextPath() + "/" + view);
    }
}
