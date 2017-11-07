package com.example.hibernatejpa.repository;

import com.example.hibernatejpa.model.manytomany.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
