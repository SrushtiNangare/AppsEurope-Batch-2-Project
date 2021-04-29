package com.capgemini.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entities.Customer;
import com.capgemini.entities.Menu;
import com.capgemini.entities.Order;
import com.capgemini.exceptions.NoSuchCustomerException;
import com.capgemini.exceptions.NoSuchDishException;
import com.capgemini.exceptions.NoSuchOrderException;
import com.capgemini.repository.CustomerRepository;
import com.capgemini.repository.MenuRepository;
import com.capgemini.repository.OrderRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	/* Creating reference (it creates loosely coupled application) */
	private CustomerRepository customerRepository;
	@Autowired
	private MenuRepository menuRepository;
	@Autowired
	private OrderRepository orderRepository;

	@Override
	/* Customer registers by giving information */
	public Customer registerCustomer(Customer customer) {
		Customer result = null;
		if (isValidCustomer(customer))
			result = customerRepository.save(customer);
		return result;
	}

	/* Place Order by selecting dishes from menu */
	@Override
	public Order placeOrder(Order order) {
		Order result = orderRepository.save(order); /* inserting record in vendor table */
		return result;
	}

	/* Cancel order by giving order id */
	@Override
	public boolean cancelOrder(int orderId) throws NoSuchOrderException {
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
	/* View Dishes by Price in Ascending or Descending Order */
	public List<Menu> viewDishesSortByPrice() {
		return menuRepository.getDishesBySortedAmount();
	}

	@Override
	/* Search Dishes by their names */
	public List<Menu> searchDishes(String foodName) throws NoSuchDishException {
		return menuRepository.getDishesByName();
	}

	@Override
	/* View Status of Order by giving order id */
	public Order viewOrderStatus(int orderId) throws NoSuchOrderException, NoSuchCustomerException {
		if (isvalidOrderId(orderId)) {
			try {
				Optional<Order> order = orderRepository.findById(orderId); /* checking status by id */
				if (order.get() != null) {
					return order.get();
				}
			} catch (NoSuchElementException e) {
				throw new NoSuchCustomerException(
						"Customer with " + orderId + " is not found"); /* Throwing and handling exception */
			}
		}
		return null;
	}

	@Override
	/* Update Order by selecting from menu */
	public Order modifyOrder(int orderId) throws NoSuchOrderException {
		if (isvalidOrderId(orderId))
			try {
				Order order = findOrderById(orderId); /* calling method findVendorById */
				if (order != null) {
					orderRepository.save(order);
					return order;
				}
			} catch (NoSuchElementException e) {
				throw new NoSuchOrderException(
						"Order with " + orderId + " is not found");/* Throwing and handling exception */
			}
		return null;
	}

	@Override
	public List<Menu> viewMenu() {
		return menuRepository.findAll();
	}

	public boolean isValidCustomer(Customer customer) {
		boolean flag = true;
		String s = Long.toString(customer.getContactNo());
		if (!customer.getFirstName().matches("[A-Za-z]"))
			flag = false;
		else if (!customer.getLastName().matches("[A-Za-z]"))
			flag = false;
		else if (!customer.getUserName().matches("[A-Za-z]"))
			flag = false;
		else if (!customer.getPassword().matches("(?=.*[A-Za-z])(?=.*[@#$%&])"))
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

	public boolean isValidFoodId(int foodId) {
		Menu menu = new Menu();
		boolean flag = true;
		String fid = Integer.toString(menu.getFoodId());
		if (!fid.matches("[0-9]"))
			flag = false;
		return flag;
	}

}