package com.supinfo.rmt.ejb.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rico on 19/11/15.
 */
@Entity
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(nullable = false)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private List<WorkTime> workTimes;

    public Client() {
        this.workTimes = new ArrayList<WorkTime>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<WorkTime> getWorkTimes() {
        return workTimes;
    }

    public void setWorkTimes(List<WorkTime> workTimes) {
        this.workTimes = workTimes;
    }

    /**
     *  Add workTime into workTimes list
     *
     * @param workTime  List
     */
    public void addWorkTime(WorkTime workTime) {
        this.workTimes.add(workTime);
    }

}
