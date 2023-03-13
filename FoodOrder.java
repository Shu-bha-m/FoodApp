package edu.jsp.foodapp.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class FoodOrder {
	@Id
	private int id;
	@CreationTimestamp
	private LocalDateTime createDateTime;
	private String orderStatus;
	@OneToMany
	List<Item> items;
	private double totalCost;
	public FoodOrder() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDateTime getCreateDateTime() {
		return createDateTime;
	}
	public void setCreateDateTime(LocalDateTime createDateTime) {
		this.createDateTime = createDateTime;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	@Override
	public String toString() {
		return "FoodOrder [id=" + id + ", createDateTime=" + createDateTime + ", orderStatus=" + orderStatus
				+  ", totalCost=" + totalCost + "]";
	}
	
	
	
}
