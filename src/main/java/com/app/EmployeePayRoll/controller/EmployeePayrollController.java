package com.app.EmployeePayRoll.controller;

import com.app.EmployeePayRoll.dto.EmployeeDTO;
import com.app.EmployeePayRoll.model.Employee;
import com.app.EmployeePayRoll.services.EmployeePayrollServices;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/emp")
public class EmployeePayrollController {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(EmployeePayrollController.class);

    private final EmployeePayrollServices employeeServices;
    @Autowired
    public EmployeePayrollController(EmployeePayrollServices employeeServices) {
        this.employeeServices = employeeServices;
    }
    @GetMapping
    public List<Employee> gettingAllEmployees(){
        logger.info("Retrieving all the values from the employees");
        return employeeServices.getAllEmployees();
    }
    @GetMapping("/{id}")
    public Optional<Employee> gettingEmployeeByID(@PathVariable Long id){
        logger.info("Retrieving employee by id:{}",id);
        return employeeServices.getEmployeeById(id);
    }


    @PostMapping
    public Employee saveEmployee(@Valid @RequestBody EmployeeDTO emp){
        logger.info("Received Request Body: {}", emp);
        return employeeServices.saveEmployee(emp);
    }


    @PutMapping("/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable Long id,@Valid @RequestBody EmployeeDTO employee){
        try {
            employeeServices.updateEmployee(id, employee);
            return ResponseEntity.ok("Employee with ID " + id + " updated successfully.");
        } catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }


    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        try {
            employeeServices.deleteEmployee(id);
            return ResponseEntity.ok("Employee with ID " + id + " deleted successfully.");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


}
