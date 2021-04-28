package com.capgemini.service;

import java.util.List;

import com.capgemini.entities.Customer;
import com.capgemini.entities.Menu;
import com.capgemini.entities.Order;
import com.capgemini.exceptions.NoSuchDishException;
import com.capgemini.exceptions.NoSuchOrderException;

public interface CustomerService {
	public Customer registerCustomer(Customer customer);
	public String placeOrder(Order order);
	public String modifyOrder(Menu menu);
	public boolean cancelOrder(int orderId) throws NoSuchOrderException;
	public List<Menu> viewDishesSortByPrice();
	public List<Menu> searchDishes(String foodName) throws NoSuchDishException;
	public String viewOrderStatus(int orderId) throws NoSuchOrderException;
	public List<Menu> viewMenu();
}
