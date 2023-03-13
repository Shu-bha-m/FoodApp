package edu.jsp.foodapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import edu.jsp.foodapp.dto.FoodOrder;
import edu.jsp.foodapp.dto.User;

public class FoodOrderDao {
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("shubham");
	EntityManager manager=factory.createEntityManager();
	EntityTransaction transaction=manager.getTransaction();
	
	public void SaveUser(FoodOrder foodOrder) {
		transaction.begin();
		manager.persist(foodOrder);
		transaction.commit();
	}


	public List<FoodOrder> GetAllFoodOrderInfo() {
		String query="select f from FoodOrder f";
		Query q=manager.createQuery(query);
		List<FoodOrder> foodOrders =q.getResultList();
		return foodOrders;		
	}
	
	public FoodOrder GetFoodOrderById(int id) {
		return manager.find(FoodOrder.class, id);	
	}
	
	public void DeleteUserById(int id) {
		transaction.begin();
		FoodOrder foodOrder = GetFoodOrderById(id);
		manager.remove(foodOrder);
		transaction.commit();
	}
	
	public void UpdateStatus(int id, String status) {
		transaction.begin();
		FoodOrder foodOrder = GetFoodOrderById(id);
		foodOrder.setOrderStatus(status);
		FoodOrder updateOrder= manager.merge(foodOrder);
		System.out.println(updateOrder);
		transaction.commit();
	}

}
