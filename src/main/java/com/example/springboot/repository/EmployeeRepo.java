package com.example.springboot.repository;

import com.example.springboot.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeeRepo extends JpaRepository<Employee, UUID> {
}
