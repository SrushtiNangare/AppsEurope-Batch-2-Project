package com.capgemini.entities;

 

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

 

@Component/* it will detect our custom beans*/
@Scope(scopeName="prototype")/* keeping this as prototype*/
@Entity/*Creating table*/
@Table(name="Menu")/* Specifying table name*/
public class Menu {
    @Id/* defining primary key*/
    @GeneratedValue(strategy = GenerationType.IDENTITY)/*generating value automatically*/
    @Column(name="FOOD_ID")/*specifying column name*/
    private int foodId;
    
	/*specifying column name, giving length 
	and giving constraint as not null*/
    @Column(name="Food_Name", length=25, nullable = false)
    private String foodName;
    
    /*specifying column name, giving length 
	and giving constraint as not null*/
    @Column(name="Food_Price", length=25, nullable = false)
    private double foodPrice;
    
    @ManyToMany(fetch=FetchType.LAZY,mappedBy="menu")
	private Set<Order> orders = new HashSet<>();

    @ManyToMany(fetch=FetchType.LAZY,mappedBy="menu")
	private Set<Vendor> vendor = new HashSet<>();
    
    /*creating parameterized constructor*/
    public Menu(String foodName, double foodPrice) {
        super();
        this.foodName = foodName;
        this.foodPrice = foodPrice;
    }
    
    /*creating  constructor*/
    public Menu() {

    }
    
    /*creating getters and setters*/
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

    /*creating tostring method*/
	@Override
	public String toString() {
		return "Menu [foodId=" + foodId + ", foodName=" + foodName + ", foodPrice=" + foodPrice + "]";
	}

    

}