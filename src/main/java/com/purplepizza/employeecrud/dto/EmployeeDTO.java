package com.purplepizza.employeecrud.dto;

import java.io.Serializable;
import java.time.Instant;

import com.purplepizza.employeecrud.entities.Employee;

public class EmployeeDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String address;
	private Double salary;
	private String seniorityLevel;
	private String role;
	private Instant entryDate;
	
	public EmployeeDTO() {
	}

	public EmployeeDTO(Long id, String name, String address, Double salary, String seniorityLevel, String role,
			Instant entryDate) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.salary = salary;
		this.seniorityLevel = seniorityLevel;
		this.role = role;
		this.entryDate = entryDate;
	}
	
	public EmployeeDTO(Employee entity) {
		id = entity.getId();
		name = entity.getName();
		address = entity.getAddress();
		salary = entity.getSalary();
		seniorityLevel = entity.getSeniorityLevel();
		role = entity.getRole();
		entryDate = entity.getEntryDate();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getSeniorityLevel() {
		return seniorityLevel;
	}

	public void setSeniorityLevel(String seniorityLevel) {
		this.seniorityLevel = seniorityLevel;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Instant getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Instant entryDate) {
		this.entryDate = entryDate;
	}
}
