package com.capgemini.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entities.Admin;
import com.capgemini.entities.Customer;
import com.capgemini.entities.Order;
import com.capgemini.entities.Vendor;
import com.capgemini.exceptions.NoSuchCustomerException;
import com.capgemini.exceptions.NoSuchOrderException;
import com.capgemini.exceptions.NoSuchVendorException;
import com.capgemini.repository.AdminRepository;
import com.capgemini.repository.CustomerRepository;
import com.capgemini.repository.OrderRepository;
import com.capgemini.repository.VendorRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	/* Creating reference (it creates loosely coupled application) */
	private CustomerRepository customerRepository;

	@Autowired
	private VendorRepository vendorRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private AdminRepository adminRepository;

	@Override
	/* Adds vendor by accepting vendor object */
	public Vendor addVendor(Vendor vendor) {
		Vendor result = null;
		if (isValidVendor(vendor))
			System.out.println(vendor);
			result = vendorRepository.save(vendor); /* inserting record in vendor table */
		return result;
	}

	@Override
	/* Deletes vendor by accepting Vendor Id */
	public boolean removeVendor(int vendorId) throws NoSuchVendorException {
		if (isvalidVendorId(vendorId)) {
			try {
				Vendor vendor = findVendorById(vendorId); /* calling method findVendorById */
				if (vendor != null) {
					vendorRepository.delete(vendor);
					return true;
				}
			} catch (NoSuchElementException e) {
				throw new NoSuchVendorException(
						"Vendor with " + vendorId + " is not found"); /* Throwing and handling exception */
			}
		}
		return false;
	}

	@Override
	/* Updates vendor by accepting vendor id */
	public Vendor modifyVendor(Vendor vendor) throws NoSuchVendorException {
		Vendor result = null;
		
		if (isValidVendor(vendor))
			
			result = vendorRepository.save(vendor);
		return result;
	}

	@Override
	/* View Order by sort Amount */
	public List<Order> findSortedOrderByAmount() {
		return orderRepository.getOrderBySortedAmount();
	}

	@Override
	/* View Order by sort Date */
	public List<Order> findSortedOrderByDate() {
		return orderRepository.getOrderBySortedDate();
	}

	@Override
	/* View All Order */
	public List<Order> findAllOrder() {
		return orderRepository.findAll();
	}

	@Override
	/* Send Order to vendor */
	public void sendOrderAdminToVendor(int vendorId) throws NoSuchVendorException {

	}

	@Override
	public Customer findCustomerById(int customerId) throws NoSuchCustomerException {
		if (isvalidCustomerId(customerId)) {
			try {
				Optional<Customer> customer = customerRepository.findById(customerId); /* selecting customer by id */
				if (customer.get() != null) {
					return customer.get();
				}
			} catch (NoSuchElementException e) {
				throw new NoSuchCustomerException(
						"Customer with " + customerId + " is not found"); /* Throwing and handling exception */
			}
		}
		return null;
	}

	@Override
	public Vendor findVendorById(int vendorId) throws NoSuchVendorException {
		if (isvalidVendorId(vendorId)) {
			try {
				Optional<Vendor> vendor = vendorRepository.findById(vendorId); /* selecting vendor by id */
				if (vendor.get() != null) {
					return vendor.get();
				}
			} catch (NoSuchElementException e) {
				throw new NoSuchVendorException(
						"Vendor with " + vendorId + " is not found"); /* Throwing and handling exception */
			}
		}
		return null;
	}

	@Override
	public boolean removeOrderByAdmin(int orderId) throws NoSuchOrderException {
		if (isvalidOrderId(orderId)) {
			try {
				Order order = findOrderById(orderId); /* calling method findOrderById */
				if (order != null) {
					orderRepository.delete(order);
					return true;
				}
			} catch (NoSuchElementException e) {
				throw new NoSuchOrderException(
						"Order with " + orderId + " is not found"); /* Throwing and handling exception */
			}
		}
		return false;
	}

	@Override
	public Order findOrderById(int orderId) throws NoSuchOrderException {
		if (isvalidOrderId(orderId)) {
			try {
				Optional<Order> order = orderRepository.findById(orderId); /* selecting order by id */
				if (order.get() != null) {
					return order.get();
				}
			} catch (NoSuchElementException e) {
				throw new NoSuchOrderException(
						"Order with " + orderId + " is not found"); /* Throwing and handling exception */
			}
		}
		return null;
	}

	@Override
	/* Register Admin with their details */
	public Admin registerAdmin(Admin admin) {
		Admin result = null;
		if (isValidAdmin(admin))
			System.out.println(admin);
			result = adminRepository.save(admin);
		return result;
	}

	@Override
	/* Find All Registered Admins with their details */
	public List<Admin> findAllAdmins() {
		return adminRepository.findAll();
	}

	@Override
	public List<Vendor> findAllVendors() {
		return vendorRepository.findAll();
	}

	@Override
	public List<Customer> findAllCustomer() {
		return customerRepository.findAll();
	}

	private boolean isValidAdmin(Admin admin) {
		boolean flag = true;
		if (!admin.getAdminName().matches("[A-Za-z]"))
			flag = false;
		else if (!admin.getAdminUsername().matches("[A-Za-z]"))
			flag = false;
		else if (!admin.getAdminPassword().matches("[A-Za-z][@#$%&]"))
			flag = false;
		return flag;
	}

	public boolean isValidVendor(Vendor vendor) {
		boolean flag = true;
		String s = Long.toString(vendor.getVendorContact());
		if (!vendor.getVendorName().matches("[A-Za-z]"))
			flag = false;
		else if (!vendor.getVendorUsername().matches("[A-Za-z]"))
			flag = false;
		else if (!vendor.getVendorPassword().matches("[A-Za-z][@#$%&]"))
			flag = false;
		else if (!s.matches("\\d{10}"))
			flag = false;
		return flag;
	}

	public boolean isvalidOrderId(int orderId) {
		Order order = new Order();
		boolean flag = true;
		String id = Integer.toString(order.getOrderId());
		if (!id.matches("[0-9]"))
			flag = false;
		return flag;
	}

	public boolean isvalidVendorId(int vendorId) {
		Vendor vendor = new Vendor();
		boolean flag = true;
		String vid = Integer.toString(vendor.getVendorId());
		if (!vid.matches("[0-9]"))
			flag = false;
		return flag;
	}

	public boolean isvalidCustomerId(int customerId) {
		Customer customer = new Customer();
		boolean flag = true;
		String cid = Integer.toString(customer.getCustomerId());
		if (!cid.matches("[0-9]"))
			flag = false;
		return flag;
	}

}
