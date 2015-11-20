package com.supinfo.rmt.ejb.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rico on 12/11/15.
 */
@Entity
public class Employee extends User implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    public List<WorkTime> workTimes;

    @ManyToOne
    @JoinColumn(nullable = false)
    public Manager manager;

    public Employee() {
        this.workTimes = new ArrayList<WorkTime>();
    }

    public List<WorkTime> getWorkTimes() {
        return workTimes;
    }

    public void setWorkTimes(List<WorkTime> workTimes) {
        this.workTimes = workTimes;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public void addWorktime(WorkTime workTime) {
        this.workTimes.add(workTime);
    }
}
