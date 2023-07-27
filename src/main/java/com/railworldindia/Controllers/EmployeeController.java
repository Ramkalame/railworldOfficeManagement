package com.railworldindia.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.railworldindia.Entites.Employee;
import com.railworldindia.Services.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	
	//create user-->POST mapping
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody Employee employee){
		Employee createdEmployee = employeeService.employeeRegister(employee);
		if (createdEmployee != null) {
            return ResponseEntity.ok("Employee created successfully!");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create employee.");
        }
	}
	
	//delete user -->DELETE Mapping
	@DeleteMapping("/delete/{employeeId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable int employeeId){
		employeeService.deleteEmployeeById(employeeId);
		return ResponseEntity.ok("employee Deleted");
		
		}
	//update user --> PUT Mapping
	@PutMapping("/update/{employeeid}")
	public ResponseEntity<Employee> updateEmployeeInfo(@RequestBody Employee employee, @PathVariable int employeeId){
		
		Employee updatedEmp = employeeService.updateEmployeeDetails(employee, employeeId);
		return ResponseEntity.ok(updatedEmp);
		
	}
	//get user --> GET Mapping
	
	@GetMapping("/login/{email}/{password}")
	public ResponseEntity<String> loginEmployee(@PathVariable String email, @PathVariable String password){
		
		Employee employee = employeeService.findByEmail(email);
		if(employee != null && employee.getPassword().equals(password)) {
			
			return ResponseEntity.ok("Login Successful !");
		}
		else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Credentials");
		}
	}
	

}
