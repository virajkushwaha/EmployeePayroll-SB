package com.app.EmployeePayRoll.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double salary;
    private String gender;

    @Column(name = "start_date")
    private LocalDate startDate;
    private String note;
    private String profilePic;
    private String department;

    public Employee(String name, double salary, String gender, LocalDate startDate, String note, String profilePic, String department) {
        this.name = name;
        this.salary = salary;
        this.gender = gender;
        this.startDate = startDate;
        this.note = note;
        this.profilePic = profilePic;
        this.department = department;
    }
}
