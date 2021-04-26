package com.capgemini.entities;

 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    @Column(name="Menu_Id")/*specifying column name*/
    private int menuId;
    
    /*specifying column name, giving length 
	and giving constraint as not null*/
    @Column(name="Food_Name", length=25, nullable = false)
    private String foodName;
    
    /*specifying column name, giving length 
	and giving constraint as not null*/
    @Column(name="Food_Price", length=25, nullable = false)
    private double foodPrice;

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
        return "Menu [foodName=" + foodName + ", foodPrice=" + foodPrice + "]";
    }

}