package com.capgemini.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entities.Menu;
import com.capgemini.entities.Order;
import com.capgemini.exceptions.NoSuchFoodItemException;
import com.capgemini.repository.MenuRepository;
import com.capgemini.repository.OrderRepository;
import com.capgemini.utilities.GlobalResources;

@Service
public class VendorServiceImpl implements VendorService {

	Logger logger = GlobalResources.getLogger(VendorServiceImpl.class);

	/* Creating reference (it creates loosely coupled application) */
	@Autowired
	/* Creating reference (it creates loosely coupled application) */
	private MenuRepository menuRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Override
	/* Add Food to Menu by accepting values */
	public Menu addFood(Menu menu) {// this method should't be included
		String methodName = "addFood()";
		logger.info(methodName + "called");
		Menu result = null;
		if (isValidMenu(menu))
			logger.info("Valid Menu");
		result = menuRepository.save(menu);
		return result;
	}

	@Override
	public Menu findFoodById(int foodId) throws NoSuchFoodItemException {
		String methodName = "findFoodById()";
		logger.info(methodName + "called");
		try {
			if (isvalidFoodId(foodId)) {
				logger.info("Valid Food Id");
				Optional<Menu> menu = menuRepository.findById(foodId);
				if (menu.get() != null)
					return menu.get();
			}
		} catch (NoSuchElementException e) {
			throw new NoSuchFoodItemException("Menu with id " + foodId + " not found.");
		}

		return null;
	}

	@Override
	/* Modify Food to Menu */
	public Menu modifyFood(Menu menu) throws NoSuchFoodItemException {
		String methodName = "modifyFood()";
		logger.info(methodName + "called");
		Menu result = null;
		if (isValidMenu(menu))
			logger.info("Valid Menu");
		result = menuRepository.save(menu);
		return result;
	}

	@Override
	/* Delete Food from Menu */
	public boolean removeFood(int foodId) throws NoSuchFoodItemException {
		String methodName = "removeFood()";
		logger.info(methodName + "called");
		try {
			if (isvalidFoodId(foodId)) {
				logger.info("Valid Food Id");
				Menu menu = findFoodById(foodId); /* calling method findMenuById */
				if (menu != null) {
					menuRepository.delete(menu);
					return true;
				}
			}
		} catch (NoSuchElementException e) {
			throw new NoSuchFoodItemException(
					"Food with " + foodId + " is not found"); /* Throwing and handling exception */
		}

		return false;
	}

	@Override
	/* View Menu */
	public List<Menu> viewAllMenu() {
		String methodName = "viewAllMenu()";
		logger.info(methodName + "called");
		return menuRepository.findAll();
	}

	@Override
	/* Set Order Status */
	public void setOrderStatus() {
	}

	@Override
	/* View all Order */
	public List<Order> viewOrder() {
		String methodName = "viewOrder()";
		logger.info(methodName + "called");
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
		if (!menu.getFoodName().matches("[A-Za-z]+"))
			flag = false;
		else if (!price.matches("\\d"))
			flag = false;
		return flag;
	}

	public boolean isvalidFoodId(int foodId) {
		boolean flag = true;
		if (foodId <= 0)
			flag = false;
		return flag;
	}

}