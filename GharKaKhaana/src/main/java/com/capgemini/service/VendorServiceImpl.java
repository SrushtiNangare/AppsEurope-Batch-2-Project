package com.capgemini.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entities.Menu;
import com.capgemini.entities.Order;
import com.capgemini.exceptions.NoSuchFoodItemException;
import com.capgemini.repository.MenuRepository;
import com.capgemini.repository.OrderRepository;

@Service
public class VendorServiceImpl implements VendorService {

	/* Creating reference (it creates loosely coupled application) */
	@Autowired
	/* Creating reference (it creates loosely coupled application) */
	private MenuRepository menuRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	/* Add Food to Menu by accepting values */
	public Menu addFood(Menu menu) {// this method should't be included
		Menu result = null;
		if(isValidMenu(menu))
			result = menuRepository.save(menu);
		return result;
	}

	@Override
	public Menu findMenuById(int foodId) throws NoSuchFoodItemException {
		try {
			Optional<Menu> menu = menuRepository.findById(foodId);
			if (menu.get() != null)
				return menu.get();
		} catch (NoSuchElementException e) {
			throw new NoSuchFoodItemException("Menu with id " + foodId + " not found.");
		}
		return null;
	}

	@Override
	/* Modify Food to Menu */
	public Menu modifyFood(Menu menu) throws NoSuchFoodItemException {
		Menu result = null;
		if(isValidMenu(menu))
			result = menuRepository.save(menu);
		return result;
	}

	@Override
	/* Delete Food from Menu */
	public boolean removeFood(int foodId) throws NoSuchFoodItemException {
		Menu menu = findMenuById(foodId); /* calling method findMenuById */
		if (menu != null) {
			menuRepository.delete(menu);
			return true;
		} else {
			throw new NoSuchFoodItemException(
					"Menu with " + foodId + " is not found"); /* Throwing and handling exception */
		}
	}

	@Override
	/* View Menu */
	public List<Menu> viewAllMenu() {
		return menuRepository.findAll();
	}

	@Override
	/* Set Order Status */
	public void setOrderStatus() {

	}

	@Override
	/* View all Order */
	public List<Order> viewOrder() {
		return orderRepository.findAll();
	}

	/*
	 * @Override public Order sendOrderToCustomer(int orderId) {// how to match
	 * order id with cust id Customer customer = new Customer();
	 * customer.getCustomerId(); customer.getFirstName();
	 * customer.getCustomerAddress(); customer.getContactNo();
	 * 
	 * 
	 * 
	 * return null; }
	 * 
	 * 
	 * 
	 * @Override public String setOrderStatus(int orderId) { Order order1 = new
	 * Order(); Optional<Order> order = vendorRepository.findById(orderId); if
	 * (order.get() != null) { sendOrderToCustomer(orderId); return
	 * "Order with OrderId " + orderId +
	 * " Accepted and Successfully delivered to customer";// can also // specify //
	 * customer name // here } else return "Order not Accepted";
	 * 
	 * 
	 * 
	 * }
	 */
	public boolean isValidMenu(Menu menu) {
		boolean flag = true;
		String price = Double.toString(menu.getFoodPrice());
		if(!menu.getFoodName().matches("[A-Za-z]+"))
			flag = false;
		else if(!price.matches("\\d"));
			flag = false;
		return flag;
	}

}