package com.example.springboot.service;

import com.example.springboot.model.Employee;
import com.example.springboot.repository.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeService {

    private final EmployeeRepo employeeRepo;

    public List<Employee> getAllEmployees(){
        return employeeRepo.findAll();
    }

    public Employee getEmployeeById(UUID id){
        Optional<Employee> optionalEmployee = employeeRepo.findById(id);
        if(optionalEmployee.isPresent()){
            return optionalEmployee.get();
        }
        log.info("Employee with id: {} doesn't exist", id);
        return null;
    }

    public Employee saveEmployee(Employee employee){
        employee.setCreatedAt(ZonedDateTime.now());
        employee.setUpdatedAt(ZonedDateTime.now());
        Employee savedEmployee = employeeRepo.save(employee);

        log.info("Employee with id: {} saved successfully", employee.getId());
        return savedEmployee;
    }

    public Employee updateEmployee (Employee employee) {
        Optional<Employee> existingEmployee = employeeRepo.findById(employee.getId());
        employee.setCreatedAt(existingEmployee.get().getCreatedAt());
        employee.setUpdatedAt(ZonedDateTime.now());

        Employee updatedEmployee = employeeRepo.save(employee);

        log.info("Employee with id: {} updated successfully", employee.getId());
        return updatedEmployee;
    }
    public void deleteEmployeeById (UUID id){
        employeeRepo.deleteById(id);
    }
}
