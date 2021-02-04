package com.purplepizza.employeecrud.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.purplepizza.employeecrud.dto.EmployeeDTO;
import com.purplepizza.employeecrud.entities.Employee;
import com.purplepizza.employeecrud.repositories.EmployeeRepository;
import com.purplepizza.employeecrud.services.exceptions.ResourceNotFoundException;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	@Transactional(readOnly = true)
	public EmployeeDTO findById(Long id) {
		Optional<Employee> obj = repository.findById(id);
		Employee entity = obj.orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));
		return new EmployeeDTO(entity);
	}

	@Transactional(readOnly = true)
	public List<EmployeeDTO> findAll() {
		List<Employee> list = repository.findAll();
		return list.stream().map(x -> new EmployeeDTO(x)).collect(Collectors.toList());
	}

	@Transactional
	public EmployeeDTO update(Long id, EmployeeDTO dto) {
		try {
			Employee entity = repository.getOne(id);
			entity.setId(dto.getId());
			entity.setName(dto.getName());
			entity.setSalary(dto.getSalary());
			entity.setAddress(dto.getAddress());
			entity.setSeniorityLevel(dto.getSeniorityLevel());
			entity.setRole(dto.getRole());
			entity.setEntryDate(dto.getEntryDate());
			return new EmployeeDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found: " +id);
		}
		
	}

	@Transactional
	public EmployeeDTO insert(EmployeeDTO dto) {
		Employee entity = new Employee();
		entity.setName(dto.getName());
		entity.setSalary(dto.getSalary());
		entity.setAddress(dto.getAddress());
		entity.setSeniorityLevel(dto.getSeniorityLevel());
		entity.setRole(dto.getRole());
		entity.setEntryDate(dto.getEntryDate());
		entity = repository.save(entity);
		return new EmployeeDTO(entity);
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found: " +id);
		}
		
	}
	
}
