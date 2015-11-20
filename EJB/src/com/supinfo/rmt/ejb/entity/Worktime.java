package com.supinfo.rmt.ejb.entity;

import com.supinfo.rmt.ejb.services.WorkTimeService;

import javax.ejb.EJB;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by Rico on 19/11/15.
 */
@Entity
public class WorkTime implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(nullable = false)
    private Date beginDate;

    @Column(nullable = false)
    private Date endDate;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Employee employee;

    public WorkTime() {
        this.client = new Client();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

}
