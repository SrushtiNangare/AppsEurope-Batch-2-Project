package com.capgemini.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entities.Customer;
import com.capgemini.entities.Menu;
import com.capgemini.exceptions.NoSuchDishException;
import com.capgemini.exceptions.NoSuchOrderException;
import com.capgemini.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	/* Creating reference (it creates loosely coupled application)*/
	private CustomerRepository customerRepository;

	@Override
	/*Customer registers by giving information*/
	public Customer registerCustomer(Customer customer) {
		Customer result = customerRepository.save(customer);
		return result;
	}

	/*Place Order by selecting dishes from menu */
	@Override
	public String placeOrder(Menu menu) {
		
		return null;
	}

	/*Cancel order by giving order id*/
	@Override
	public boolean cancelOrder(int orderId) throws NoSuchOrderException {
		
		return false;
	}

	@Override
	/*View Dishes by Price in Ascending or Descending Order*/
	public List<Menu> viewDishesSortByPrice() {
		return null;
	}

	@Override
	/*Search Dishes by their names*/
	public List<Menu> searchDishes(String foodName) throws NoSuchDishException {
		return null;
	}

	@Override
	/*View Status of Order by giving order id*/
	public void viewOrderStatus(int orderId) throws NoSuchOrderException {

	}

	@Override
	/*Update Order by selecting from menu*/
	public String modifyOrder(Menu menu) {
		return null;
	}

}
