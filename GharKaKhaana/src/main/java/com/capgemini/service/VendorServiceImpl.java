package com.capgemini.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entities.Menu;
import com.capgemini.entities.Order;
import com.capgemini.exceptions.NoSuchFoodItemException;
import com.capgemini.repository.VendorRepository;

@Service
public class VendorServiceImpl implements VendorService{

	@Autowired
	/*Creating reference (it creates loosely coupled application)*/
	private VendorRepository vendorRepository;
	
	@Override
	/*Add Food to Menu by accepting values */
	public Menu addFood(Menu menu) {
		return null;
	}

	@Override
	/*Modify Food to Menu*/
	public Menu modifyFood(Menu menu) throws NoSuchFoodItemException {
		return null;
	}

	@Override
	/*Delete Food from Menu*/
	public boolean removeFood(Menu menu) throws NoSuchFoodItemException {
		return false;
	}

	@Override
	/*View Menu*/
	public List<Menu> viewMenu() {
		return null;
	}

	@Override
	/*Set Order Status*/
	public void setOrderStatus() {
		
	}

	@Override
	/*View all Order*/
	public List<Order> viewOrder() {
		return null;
	}

}
