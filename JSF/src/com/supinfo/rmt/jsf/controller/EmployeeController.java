package com.supinfo.rmt.jsf.controller;

import com.supinfo.rmt.ejb.entity.Client;
import com.supinfo.rmt.ejb.entity.Employee;
import com.supinfo.rmt.ejb.entity.WorkTime;
import com.supinfo.rmt.ejb.services.EmployeeService;
import com.supinfo.rmt.ejb.services.WorkTimeService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;
import java.io.IOException;
import java.util.Date;

/**
 * Created by Rico on 19/11/15.
 */
@ManagedBean
public class EmployeeController {

    private WorkTime workTime;

    private Client client;

    private Date endDateWorkTime;

    private Date startDateWorkTime;

    @EJB
    private WorkTimeService workTimeService;

    @EJB
    private EmployeeService employeeService;

    @ManagedProperty(value = "#{userController}")
    private UserController userController;

    public UserController getUserController() {
        return userController;
    }

    public void setUserController(UserController userController) {
        this.userController = userController;
    }

    @PostConstruct
    public void init() {
        this.workTime = new WorkTime();
        this.client = new Client();
        this.endDateWorkTime = new Date();
        this.startDateWorkTime = new Date();
    }

    public WorkTime getWorkTime() {
        return workTime;
    }

    public void setWorkTime(WorkTime workTime) {
        this.workTime = workTime;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getEndDateWorkTime() {
        return endDateWorkTime;
    }

    public void setEndDateWorkTime(Date endDateWorkTime) {
        this.endDateWorkTime = endDateWorkTime;
    }

    public Date getStartDateWorkTime() {
        return startDateWorkTime;
    }

    public void setStartDateWorkTime(Date startDateWorkTime) {
        this.startDateWorkTime = startDateWorkTime;
    }

    /**
     * Create manager's employee
     *
     * @throws IOException
     */
    public void addWorkTime() throws IOException {
        this.workTime.setBeginDate(new java.sql.Date(this.startDateWorkTime.getTime()));
        this.workTime.setEndDate(new java.sql.Date(this.endDateWorkTime.getTime()));
        this.workTime.setClient(this.client);
        this.workTime.setEmployee((Employee) this.userController.getUser());
        ((Employee)this.userController.getUser()).addWorktime(this.workTime);
        this.userController.setUser(this.employeeService.updateEmployee((Employee)this.userController.getUser()));
        // Redirect to list_view
        ExternalContext eC = FacesContext.getCurrentInstance().getExternalContext();
        this.userController.redirect(eC, "worktime/list_worktimes.xhtml");
    }

    /**
     * Action :: Return employee's workTimes
     *
     * @return ListDataModel<WorkTime> workTimes
     */
    public ListDataModel<WorkTime> getEmployeeWorkTime() {
        if (this.userController.getUser() instanceof  Employee) {
            return new ListDataModel<WorkTime>(((Employee)this.userController.getUser()).getWorkTimes());
        }
        return null;
    }

    public void removeWorkTime(WorkTime workTime) throws IOException {
        this.workTimeService.removeWorkTime(workTime);
        // Redirect to list_view
        ExternalContext eC = FacesContext.getCurrentInstance().getExternalContext();
        this.userController.redirect(eC, "worktime/list_worktimes.xhtml");
    }

}
