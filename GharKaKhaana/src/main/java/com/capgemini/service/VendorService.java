package com.capgemini.service;

import java.util.List;

import com.capgemini.entities.Menu;
import com.capgemini.entities.Order;
import com.capgemini.exceptions.NoSuchFoodItemException;

public interface VendorService {
	public Menu addFood(Menu menu);
	public Menu modifyFood(Menu menu)throws NoSuchFoodItemException;
	public boolean removeFood(Menu menu) throws NoSuchFoodItemException;
	public List<Menu> viewMenu();
	public void setOrderStatus();
	public List<Order> viewOrder();
}
