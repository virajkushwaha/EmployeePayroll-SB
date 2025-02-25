package com.app.EmployeePayRoll.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name cannot be blank")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "Department cannot be blank")
    @Column(nullable = false)
    private String department;

    @NotNull(message = "Salary cannot be null")
    @Min(value = 1000, message = "Salary must be at least 1000")
    @Column(nullable = false)
    private Double salary;

    public Employee(Long id, String name, String department, Double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "Name cannot be blank") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Name cannot be blank") String name) {
        this.name = name;
    }

    public @NotBlank(message = "Department cannot be blank") String getDepartment() {
        return department;
    }

    public void setDepartment(@NotBlank(message = "Department cannot be blank") String department) {
        this.department = department;
    }

    public @NotNull(message = "Salary cannot be null") @Min(value = 1000, message = "Salary must be at least 1000") Double getSalary() {
        return salary;
    }

    public void setSalary(@NotNull(message = "Salary cannot be null") @Min(value = 1000, message = "Salary must be at least 1000") Double salary) {
        this.salary = salary;
    }
}
