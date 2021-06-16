package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
	
	@Autowired
	UserRepository userRepo;
	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping("getUser/{name}")
	@CrossOrigin(origins ="http://localhost:4200")
	public ResponseEntity getUser(@PathVariable String name) {
		
		try {
		User user=userRepo.findById(name).get();
		
				
		return new ResponseEntity(user,HttpStatus.OK);
		
		}catch(Exception e) {
			
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("employee")
	@CrossOrigin(origins ="http://localhost:4200")
	public ResponseEntity registerEmp(@RequestBody Employee employee) {
		
		try {
		empRepo.save(employee);
				
		return new ResponseEntity(HttpStatus.OK);
		
		}catch(Exception e) {
			
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
	}
	
	@GetMapping("getAllEmp")
	@CrossOrigin(origins ="http://localhost:4200")
	public ResponseEntity getAllEmp() {
		
		List<Employee> list=empRepo.findAll();
		
		return new ResponseEntity(list,HttpStatus.OK);
	}
	
	@DeleteMapping("deleteEmp/{id}")
	@CrossOrigin(origins ="http://localhost:4200")
	public ResponseEntity deleteEmp(@PathVariable int id) {
		
		empRepo.deleteById(id);
		 
		return new ResponseEntity(HttpStatus.OK);
	}
	
	

}
