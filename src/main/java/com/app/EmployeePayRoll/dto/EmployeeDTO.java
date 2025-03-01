package com.app.EmployeePayRoll.dto;

import com.app.EmployeePayRoll.model.Employee;
import jakarta.websocket.server.ServerEndpoint;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Data
@Setter
public  class EmployeeDTO {
    private String name ;
    private String department ;
    private double salary;

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
