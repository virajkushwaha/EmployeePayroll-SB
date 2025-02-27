package com.app.EmployeePayRoll.dto;

import com.app.EmployeePayRoll.model.Employee;

public class EmployeeDTO {
    public String name ;
    public String department ;
    public double salary;

    public EmployeeDTO(){}

    public EmployeeDTO(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

}
