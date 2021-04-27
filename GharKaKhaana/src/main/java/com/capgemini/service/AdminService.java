package com.capgemini.service;

import java.util.List;

import com.capgemini.entities.Customer;
import com.capgemini.entities.Order;
import com.capgemini.entities.Vendor;
import com.capgemini.exceptions.NoSuchCustomerException;
import com.capgemini.exceptions.NoSuchVendorException;

public interface AdminService {
	public Vendor addVendor(Vendor vendor);
	public boolean removeVendor(int vendorId) throws NoSuchVendorException;
	public Vendor modifyVendor(int vendorId) throws NoSuchVendorException;
	public List<Order> findSortedOrderByAmount();
	public List<Order> findSortedOrderByDate();
	public List<Order> findAllOrder();
	public void sendOrderAdminToVendor(int vendorId) throws NoSuchVendorException;
	public Customer findCustomerById(int customerId)throws NoSuchCustomerException;
}
