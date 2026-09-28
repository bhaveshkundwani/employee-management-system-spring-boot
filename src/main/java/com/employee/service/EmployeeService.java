package com.employee.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    /*
     * Get all employees
     */
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    /*
     * Create new employee
     */
    public Employee createEmployee(Employee employee) {

        String employeeId = generateEmployeeId();
        employee.setId(employeeId);
        return employeeRepository.save(employee);
    }

    /*
     * Update existing employee
     */
    public boolean updateEmployee(Employee employee) {

        Optional<Employee> existingEmployee = employeeRepository.findById(employee.getId());

        if (existingEmployee.isPresent()) {
            employeeRepository.save(employee);
            return true;
        }

        return false;
    }

    /*
     * Delete employee
     */
    public boolean deleteEmployee(String employeeId) {

        Optional<Employee> existingEmployee = employeeRepository.findById(employeeId);

        if (existingEmployee.isPresent()) {
            employeeRepository.deleteById(employeeId);
            return true;
        }

        return false;
    }

    /*
     * Delete all employees
     */
    public void deleteAllEmployees() {
        employeeRepository.deleteAll();
    }

    /*
     * Generate unique employee ID
     */
    private String generateEmployeeId() {

        String employeeId;

        do {
            int randomNumber = 1000 + new Random().nextInt(9000);
            employeeId = "EMP" + randomNumber;
        } while (employeeRepository.existsById(employeeId));

        return employeeId;
    }
}
