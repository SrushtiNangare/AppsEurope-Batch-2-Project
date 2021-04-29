package com.capgemini.service;

import java.util.List;

import com.capgemini.entities.Menu;
import com.capgemini.entities.Order;
import com.capgemini.exceptions.NoSuchFoodItemException;
 
public interface VendorService {
    public Menu addFood(Menu menu);
    public Menu modifyFood(Menu menu) throws NoSuchFoodItemException;
    public boolean removeFood(int foodId) throws NoSuchFoodItemException;
    //public String setOrderStatus(int orderId);
    public List<Menu> viewAllMenu();
    //public Order sendOrderToCustomer(int orderId);
    public void setOrderStatus();
    public List<Order> viewOrder();
    public Menu findMenuById(int foodId) throws NoSuchFoodItemException;
}