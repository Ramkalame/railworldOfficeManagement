package com.railworldindia.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.railworldindia.Entites.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	public Employee findByEmail(String email);

	public List<Employee> findBySalary(double salary);
	
	public List<Employee> findByRole(String role);

}
