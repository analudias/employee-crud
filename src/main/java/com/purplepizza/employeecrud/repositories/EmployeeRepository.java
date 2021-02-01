package com.purplepizza.employeecrud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.purplepizza.employeecrud.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
