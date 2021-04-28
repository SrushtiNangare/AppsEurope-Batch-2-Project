package com.capgemini.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entities.Menu;
import com.capgemini.entities.Order;
import com.capgemini.exceptions.NoSuchFoodItemException;
import com.capgemini.repository.MenuRepository;

@Service
public class VendorServiceImpl implements VendorService{

	/*Creating reference (it creates loosely coupled application)*/
	@Autowired
	private MenuRepository menuRepository;
	
	@Override
	/*Add Food to Menu by accepting values */
    public Menu addFood(Menu menu) {// this method should't be included
	        return menuRepository.save(menu);
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
		return menuRepository.findAll();
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
