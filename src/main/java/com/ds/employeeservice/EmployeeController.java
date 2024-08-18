package com.ds.employeeservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("api/v1")
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	Producer producer;

	
	@PostMapping("add/employee")
	public ResponseEntity<Employee> updateUserDetails(@RequestBody Employee employee) throws JsonProcessingException {
		if (employeeRepository.findById(employee.getEmpid()).isEmpty()) {
			employeeRepository.save(employee);
			producer.sendEvent("NOTIFICATION", employee.getEmpid());
		}
		return ResponseEntity.ok(employee);
	}

	
	@GetMapping("employee/{id}")
	public ResponseEntity<Optional<Employee>> getBookingById(@PathVariable String id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		return ResponseEntity.ok(employee);
	}
	
	@GetMapping("employees")
	public ResponseEntity<String> getAllEmployees() throws JsonProcessingException {
		List<Employee> employees = employeeRepository.findAll();
		ObjectMapper objectMapper = new ObjectMapper();
		String data =  objectMapper.writeValueAsString(employees);
		return ResponseEntity.ok(data);
	}

}
