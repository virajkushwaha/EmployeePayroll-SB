package com.app.EmployeePayRoll.services;

import com.app.EmployeePayRoll.dto.EmployeeDTO;
import com.app.EmployeePayRoll.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.EmployeePayRoll.repository.*;
import java.util.NoSuchElementException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Slf4j
@Service
public class EmployeePayrollServices {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(EmployeePayrollServices.class);
    @Autowired
    EmployeeRepository employeeRepository;
    //Getting Employees
    public List<Employee> getAllEmployees(){
        logger.info("Fetching the Employees Details");
        return employeeRepository.findAll();
    }
    public Optional<Employee> getEmployeeById(Long id){
        logger.info("Searching the ID and getting details at :"+id);
        return employeeRepository.findById(id);
    }

    public Employee saveEmployee(EmployeeDTO emp){
        logger.info("Received Employee Data Before Saving: {}", emp);
        Employee savedEmployee = new Employee(
                emp.getName(),
                emp.getSalary(),
                emp.getGender(),
                emp.getStartDate(),
                emp.getNote(),
                emp.getProfilePic(),
                emp.getDepartment()
        );
        logger.info("Saved Employee Data: {}", savedEmployee);

        return employeeRepository.save(savedEmployee);
    }



    // Method to update employee
    public Employee updateEmployee(Long id, EmployeeDTO employee){
        logger.info("Updating employee with ID: {} with details: {}", id, employee);

        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> {
                    logger.warn("Employee with ID {} not found, cannot update.", id);
                    return new NoSuchElementException("Employee with ID " + id + " not found.");
                });

        existingEmployee.setName(employee.getName());
        existingEmployee.setDepartment(employee.getDepartment());
        existingEmployee.setSalary(employee.getSalary());
        existingEmployee.setGender(employee.getGender());
        existingEmployee.setProfilePic(employee.getProfilePic());
        existingEmployee.setStartDate(employee.getStartDate());
        existingEmployee.setNote(employee.getNote());

        Employee updatedEmployee = employeeRepository.save(existingEmployee);

        logger.info("Employee updated successfully: {}", updatedEmployee);
        return updatedEmployee;
    }

    public void deleteEmployee(Long id){
        logger.info("Deleting employee with ID: {}", id);

        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> {
                    logger.warn("Employee with ID {} not found, cannot delete.", id);
                    return new NoSuchElementException("Employee with ID " + id + " not found.");
                });

        employeeRepository.delete(existingEmployee);
        logger.info("Employee with ID {} deleted successfully.", id);
    }

}
