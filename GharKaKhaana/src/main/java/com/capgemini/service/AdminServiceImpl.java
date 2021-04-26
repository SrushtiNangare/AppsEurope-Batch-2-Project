package com.capgemini.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entities.Order;
import com.capgemini.entities.Vendor;
import com.capgemini.exceptions.NoSuchVendorException;
import com.capgemini.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	/*Creating reference (it creates loosely coupled application)*/
	private AdminRepository adminRepository; 
	@Override
	/* Adds vendor by accepting vendor object*/
	public Vendor addVendor(Vendor vendor) { 
		return null;
	}

	@Override
	/*Deletes vendor by accepting Vendor Id */
	public boolean removeVendor(int vendorId) throws NoSuchVendorException { 
		return false;
	}

	@Override
	/*Updates vendor by accepting vendor id*/
	public Vendor modifyVendor(int vendorId) throws NoSuchVendorException { 
		return null;
	}

	@Override
	/* View Order by sort Amount*/
	public List<Order> findSortedOrderByAmount() { 
		return null;
	}

	@Override
	/* View Order by sort Date*/
	public List<Order> findSortedOrderByDate() { 
		return null;
	}

	@Override
	/*View All Order*/
	public List<Order> findAllOrder() { 
		return null;
	}

	@Override
	/* Send Order to vendor*/
	public void sendOrderAdminToVendor(int vendorId) throws NoSuchVendorException { 
		
	}

}
