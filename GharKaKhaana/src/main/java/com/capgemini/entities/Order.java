package com.capgemini.entities;

 

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
 

@Component/* it will detect our custom beans*/
@Scope(scopeName = "prototype")/* keeping this as prototype*/
@Entity/*Creating table*/
@Table(name = "OrderTbl")/* Specifying table name*/
public class Order {
    @Id/* defining primary key*/
    @GeneratedValue(strategy = GenerationType.IDENTITY)/*generating value automatically*/
    @Column(name = "Order_Id")/*specifying column name*/
    private int orderId;

    /*specifying column name, giving length 
	and giving constraint as not null*/
    @Column(name = "Order_Date", nullable = false)
    private LocalDate orderDate;

    /*specifying column name, giving length 
	and giving constraint as not null*/
    @Column(name = "Order_Time", nullable = false)
    private LocalTime orderTime;

    /*specifying column name, giving length 
	and giving constraint as not null*/
    @Column(name = "Order_Status", length = 200, nullable = false)
    private String orderStatus;

    /*specifying column name, giving length 
	and giving constraint as not null*/
    @Column(name = "Order_Price", length = 10, nullable = false)
    private double orderPrice;

    @ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "food_orders", 
				joinColumns = { @JoinColumn(name = "order_id") }, 
				inverseJoinColumns = { @JoinColumn(name = "food_id") }
				)
	private Set<Menu> menu = new HashSet<>();
    
    
	public Set<Menu> getMenu() {
		return menu;
	}

	public void setMenu(Set<Menu> menu) {
		this.menu = menu;
	}

	/*creating parameterized constructor*/
    public Order(LocalDate orderDate, LocalTime orderTime, String orderStatus, double orderPrice) {
        super();
        this.orderDate = orderDate;
        this.orderTime = orderTime;
        this.orderStatus = orderStatus;
        this.orderPrice = orderPrice;
    }

    /*creating constructor*/
    public Order() {

    }

    /*creating getters and setters*/
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalTime orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    /*creating tostring method*/

 

}