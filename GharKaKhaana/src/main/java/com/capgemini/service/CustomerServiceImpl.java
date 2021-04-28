package com.capgemini.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entities.Customer;
import com.capgemini.entities.Menu;
import com.capgemini.entities.Order;
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
	private OrderRepository orderRepository;
	@Autowired
	private AdminService adminService;
	@Autowired
	private MenuRepository menuRepository;

	@Override
	/* Customer registers by giving information */
	public Customer registerCustomer(Customer customer) {
		Customer result = customerRepository.save(customer);
		return result;
	}

	/* Place Order by selecting dishes from menu */
	@Override
	public String placeOrder(Order order) {

		return null;
	}

	/* Cancel order by giving order id */
	@Override
	public boolean cancelOrder(int orderId) throws NoSuchOrderException {
		Order order = adminService.findOrderById(orderId);
		if (order != null) {
			orderRepository.delete(order);
			return true;
		} else {
			throw new NoSuchOrderException("Order with id " + orderId + " not found");
		}
	}

	@Override
	/* View Dishes by Price in Ascending or Descending Order */
	public List<Menu> viewDishesSortByPrice() {
		return null;
	}

	@Override
	/* Search Dishes by their names */
	public List<Menu> searchDishes(String foodName) throws NoSuchDishException {
		return null;
	}

	@Override
	/* View Status of Order by giving order id */
	public String viewOrderStatus(int orderId) throws NoSuchOrderException {
		Order order = new Order();
		return order.getOrderStatus();
	}

	@Override
	/* Update Order by selecting from menu */
	public String modifyOrder(Menu menu) {
		return null;
	}

	@Override
	public List<Menu> viewMenu() {
		return menuRepository.findAll();
	}

}