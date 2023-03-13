package edu.jsp.foodapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import edu.jsp.foodapp.dto.Item;
import edu.jsp.foodapp.dto.User;

public class ItemDao {
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("shubham");
	EntityManager manager=factory.createEntityManager();
	EntityTransaction transaction=manager.getTransaction();
	
	public void SaveItem(Item item) {
		transaction.begin();
		manager.persist(item);
		transaction.commit();
	}

	public List<Item> GetAllItemInfo() {
		String query="select i from Item i";
		Query q=manager.createQuery(query);
		List<Item> items=q.getResultList();
		return items ;		
	}
	
	public Item GetItemById(int id) {
		return manager.find(Item.class, id);	
	}
	
	public void DeleteUserById(int id) {
		transaction.begin();
		Item item=GetItemById(id);
		manager.remove(item);
		transaction.commit();
	}
	
	public void UpdateCost(int id, double cost) {
		transaction.begin();
		Item item=GetItemById(id);
		item.setCost(cost);
		Item updateCost= manager.merge(item);
		System.out.println(updateCost);
		transaction.commit();
	}


}
