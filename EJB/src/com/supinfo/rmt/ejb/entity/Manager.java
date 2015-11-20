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

    @OneToMany(cascade = CascadeType.ALL)
    private List<Employee> employees;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Client> clients;

    public Manager() {
        this.employees = new ArrayList<Employee>();
        this.clients = new ArrayList<Client>();
    }

    public List<Employee> getEmployees() {
        return this.employees;
    }

    public List<Client> getClients() {
        return this.clients;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    /**
     * Add employee into employees list
     *
     * @param employee  List
     */
    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    /**
     * Add employee into employees list
     *
     * @param client    List
     */
    public void addClient(Client client) {
        this.clients.add(client);
    }
}
