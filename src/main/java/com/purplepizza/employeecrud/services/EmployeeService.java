package com.purplepizza.employeecrud.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.purplepizza.employeecrud.dto.EmployeeDTO;
import com.purplepizza.employeecrud.entities.Employee;
import com.purplepizza.employeecrud.repositories.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	@Transactional(readOnly = true)
	public EmployeeDTO findById(Long id) {
		Optional<Employee> obj = repository.findById(id);
		Employee entity = obj.orElseThrow();
		return new EmployeeDTO(entity);
	}
	
}
