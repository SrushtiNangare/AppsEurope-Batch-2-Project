package com.capgemini.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.Customer;
import com.capgemini.service.CustomerService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping(path="customers")
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	@PostMapping(path="/add",consumes=MediaType.APPLICATION_JSON_VALUE)
	//http://localhost:9090/student-api/customers/add
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
		ResponseEntity<Customer> response= null;
		Customer result = service.registerCustomer(customer);
		if(result != null)
			response = new ResponseEntity<Customer>(result,HttpStatus.CREATED);
		else
			response = new ResponseEntity<Customer>(result,HttpStatus.BAD_REQUEST);
		return response;
	}

}
