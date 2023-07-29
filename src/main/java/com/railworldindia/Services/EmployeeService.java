package com.railworldindia.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railworldindia.Entites.Employee;
import com.railworldindia.Repositories.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	public Employee findById(Integer employeeId) {
		Employee emp = employeeRepository.findById(employeeId).get();
		return emp;
	}
	
	public List<Employee> findByRole(String role){
		
		List<Employee> emp = employeeRepository.findByRole(role);
		return emp;
	}
	
	public Employee findByEmail(String email) {
		
		return employeeRepository.findByEmail(email);
	}
	
	public Employee employeeRegister(Employee employee) {
		
		return employeeRepository.save(employee);
	}
	
	
	public Employee updateEmployeeDetails(Employee employee, Integer employeeId) {
		Employee emp = employeeRepository.findById(employeeId).get();
		emp.setName(employee.getName());
		emp.setEmail(employee.getEmail());
		emp.setPassword(employee.getPassword());
		emp.setSalary(employee.getSalary());
		emp.setContact(employee.getContact());
		emp.setRole(employee.getRole());
		return employeeRepository.save(emp);
	}
	
	public List<Employee> getAllEmployee(){
		
		List<Employee> employees = employeeRepository.findAll();
		
		return employees;
		
	}
	
	public List<Employee> findBySalary(double salary){
		
		List<Employee> emp = employeeRepository.findBySalary(salary);
		return emp;
	}
	
	public void deleteEmployeeById(int employeeId) {
        // Check if the employee exists before deleting
        if (employeeRepository.existsById(employeeId)) {
            employeeRepository.deleteById(employeeId);
        } else {
            throw new IllegalArgumentException("Employee not found with ID: " + employeeId);
        }
    }
	

}
