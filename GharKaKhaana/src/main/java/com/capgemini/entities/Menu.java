package com.capgemini.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component /* it will detect our custom beans */
@Scope(scopeName = "prototype") /* keeping this as prototype */
@Entity /* Creating table */
@Table(name = "Menu") /* Specifying table name */
public class Menu {

	@Id
	@Column(name = "MENU_ID")
	private int menuId;

	 /* defining primary key */
	@Column(name = "FOOD_ID") /* specifying column name */
	private int foodId;

	/*
	 * specifying column name, giving length and giving constraint as not null
	 */
	@Column(name = "Food_Name", length = 25, nullable = false)
	private String foodName;

	/*
	 * specifying column name, giving length and giving constraint as not null
	 */
	@Column(name = "Food_Price", length = 25, nullable = false)
	private double foodPrice;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "menu")
	private Set<Order> orders = new HashSet<>();

	

	/* creating parameterized constructor */
	public Menu(int menuId, int foodId, String foodName, double foodPrice, Set<Order> orders) {
		super();
		this.menuId = menuId;
		this.foodId = foodId;
		this.foodName = foodName;
		this.foodPrice = foodPrice;
		this.orders = orders;
	}

	/* creating constructor */
	public Menu() {

	}

	/* creating getters and setters */
	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public double getFoodPrice() {
		return foodPrice;
	}

	public void setFoodPrice(double foodPrice) {
		this.foodPrice = foodPrice;
	}

	/* creating tostring method */
	@Override
	public String toString() {
		return "Menu [menuId=" + menuId + ", foodId=" + foodId + ", foodName=" + foodName + ", foodPrice=" + foodPrice
				+ ", orders=" + orders +  "]";
	}

}