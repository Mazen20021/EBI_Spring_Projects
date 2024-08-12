package com.employees.myemployees.Models.Entity;

import jakarta.persistence.*;


@Entity
@Table(name = "employee")
public class EmployeeEntity {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "firstname")
    private String fname;
    @Column(name = "lastname")
    private String lname;
    @Column(name = "depid")
    private String depID;
    @Column(name = "salary")
    private double salary;

    @JoinColumn(name ="project_id")
    @ManyToOne()
    private ProjectEntity projectEntity; // Eager

    public ProjectEntity getProjectEntity() {
        return projectEntity;
    }

    public void setProjectEntity(ProjectEntity projectEntity) {
        this.projectEntity = projectEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getDepID() {
        return depID;
    }

    public void setDepID(String depID) {
        this.depID = depID;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

