package com.capgemini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.Admin;
import com.capgemini.entities.Customer;
import com.capgemini.entities.Order;
import com.capgemini.entities.Vendor;
import com.capgemini.exceptions.NoSuchCustomerException;
import com.capgemini.exceptions.NoSuchOrderException;
import com.capgemini.exceptions.NoSuchVendorException;
import com.capgemini.service.AdminService;
import com.capgemini.utilities.GlobalResources;
import org.slf4j.Logger;



@RestController
@RequestMapping(path = "admins")
public class AdminController {

	private Logger logger = GlobalResources.getLogger(AdminController.class);
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping(path = "/addAdmin", consumes = MediaType.APPLICATION_JSON_VALUE)
	// http://localhost:9090/GharKaKhana-api/admins/addAdmin
	public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin) {
		String methodName="addAdmin()";
        logger.info(methodName + "called");
		System.out.println(admin);
		ResponseEntity<Admin> response = null;
		Admin result = adminService.registerAdmin(admin);
		if (result != null)
			response = new ResponseEntity<Admin>(result, HttpStatus.CREATED);
		else
			response = new ResponseEntity<Admin>(result, HttpStatus.BAD_REQUEST);
		return response;
	}

	@PostMapping(path = "/addVendor", consumes = MediaType.APPLICATION_JSON_VALUE)
	// http://localhost:9090/GharKaKhana-api/admins/addVendor
	public ResponseEntity<Vendor> addVendor(@RequestBody Vendor vendor) {
		System.out.println(vendor);
		ResponseEntity<Vendor> response = null;
		System.out.println(vendor);
		Vendor result = adminService.addVendor(vendor);
		if (result != null)
			response = new ResponseEntity<Vendor>(result, HttpStatus.CREATED);
		else
			response = new ResponseEntity<Vendor>(result, HttpStatus.BAD_REQUEST);
		return response;
	}
	// http://localhost:9090/GharKaKhana-api/admins/viewAllAdmin
	@GetMapping(path="/viewAllAdmin")
	public ResponseEntity<List<Admin>> getAllAdmin() {
		String methodName="getAllAdmin()";
        logger.info(methodName + "called");
		ResponseEntity<List<Admin>> response = null;
		List<Admin> result = adminService.findAllAdmins();
		if(result != null)
			response = new ResponseEntity<List<Admin>>(result,HttpStatus.OK);
		else
			response = new ResponseEntity<List<Admin>>(result,HttpStatus.BAD_REQUEST);
		return response;
	}
	
	// http://localhost:9090/GharKaKhana-api/admins/viewAllCustomer
	@GetMapping(path="/viewAllCustomer")
	public ResponseEntity<List<Customer>> getAllCustomer() {
		ResponseEntity<List<Customer>> response = null;
		List<Customer> result = adminService.findAllCustomer();
		if(result != null)
			response = new ResponseEntity<List<Customer>>(result,HttpStatus.OK);
		else
			response = new ResponseEntity<List<Customer>>(result,HttpStatus.BAD_REQUEST);
		return response;
	}
	
	// http://localhost:9090/GharKaKhana-api/admins/viewAllVendor
	@GetMapping(path="/viewAllVendor")
	public ResponseEntity<List<Vendor>> getAllVendor() {
		ResponseEntity<List<Vendor>> response = null;
		List<Vendor> result = adminService.findAllVendors();
		if(result != null)
			response = new ResponseEntity<List<Vendor>>(result,HttpStatus.OK);
		else
			response = new ResponseEntity<List<Vendor>>(result,HttpStatus.BAD_REQUEST);
		return response;
	}
	
	// http://localhost:9090/GharKaKhana-api/admins/deleteVendor/
	@DeleteMapping(path="deleteVendor/{vendorId}")
	public ResponseEntity<Boolean> deleteVendor(@PathVariable("vendorId") int vendorId) throws NoSuchVendorException{
		ResponseEntity<Boolean> response =null;
		boolean result = adminService.removeVendor(vendorId);
		if(result)
			response = new ResponseEntity<Boolean>(result,HttpStatus.OK);
		return response;
	}
	
	
	@PutMapping(path="updateVendor/{vendorId}",consumes = MediaType.APPLICATION_JSON_VALUE,produces = "application/json")
	public ResponseEntity<Vendor> updateVendor(@RequestBody Vendor vendor){
		ResponseEntity<Vendor> response = null;
		System.out.println(vendor);
		Vendor result = adminService.addVendor(vendor);
		if (result != null)
			response = new ResponseEntity<Vendor>(result, HttpStatus.CREATED);
		else
			response = new ResponseEntity<Vendor>(result, HttpStatus.BAD_REQUEST);
		return response;
	}
	
	
	// http://localhost:9090/GharKaKhana-api/admins/viewAllOrder
	@GetMapping(path="/viewAllOrder")
	public ResponseEntity<List<Order>> getAllOreder(){
		ResponseEntity<List<Order>> response = null;
		List<Order> result = adminService.findAllOrder();
		if(result != null)
			response = new ResponseEntity<List<Order>>(result,HttpStatus.OK);
		else 
			response = new ResponseEntity<List<Order>>(result,HttpStatus.BAD_REQUEST);
		return response;
	}
	
	// http://localhost:9090/GharKaKhana-api/admins/findVendorById/
	@GetMapping(path="findVendorById/{vendorId}")
	public ResponseEntity<Vendor> getVendorById(@PathVariable("vendorId") int vendorId) throws NoSuchVendorException{
		ResponseEntity<Vendor> response = null;
		Vendor result = adminService.findVendorById(vendorId);
		response = new ResponseEntity<Vendor>(result,HttpStatus.FOUND);
		return response;
	}
	
	// http://localhost:9090/GharKaKhana-api/admins/findOrderById/
	@GetMapping(path="findOrderById/{orderId}")
	public ResponseEntity<Order> getOrderById(@PathVariable("orderId") int orderId) throws NoSuchOrderException{
		ResponseEntity<Order> response = null;
		Order result = adminService.findOrderById(orderId);
		response = new ResponseEntity<Order>(result,HttpStatus.FOUND);
		return response;
	}
	
	// http://localhost:9090/GharKaKhana-api/admins/findCustomerId/
	@GetMapping(path="findCustomerId/{customerId}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("customerId") int customerId) throws NoSuchCustomerException{
		ResponseEntity<Customer> response = null;
		Customer result = adminService.findCustomerById(customerId);
		response = new ResponseEntity<Customer>(result,HttpStatus.FOUND);
		return response;
	}
	
	// http://localhost:9090/GharKaKhana-api/admins/findOrderByDate
	@GetMapping(path="findOrderByDate")
	public ResponseEntity<List<Order>> getOrderByDate(){
		ResponseEntity<List<Order>> response = null;
		List<Order> result = adminService.findSortedOrderByDate();
		if(result != null) 
			response = new ResponseEntity<List<Order>>(result,HttpStatus.OK);
		else
			response = new ResponseEntity<List<Order>>(result,HttpStatus.BAD_REQUEST);
		return response;
	}
	
	// http://localhost:9090/GharKaKhana-api/admins/findOrderByAmount
	@GetMapping(path="findOrderByAmount")
	public ResponseEntity<List<Order>> getOrderByAmount(){
		ResponseEntity<List<Order>> response = null;
		List<Order> result = adminService.findSortedOrderByAmount();
		if(result != null)
			response = new ResponseEntity<List<Order>>(result,HttpStatus.OK);
		else
			response = new ResponseEntity<List<Order>>(result,HttpStatus.BAD_REQUEST);
		return response;
	}
	
}