package edu.jsp.foodapp.dao;

import java.rmi.Remote;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import edu.jsp.foodapp.dto.User;

public class UserDao {
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("shubham");
	EntityManager manager=factory.createEntityManager();
	EntityTransaction transaction=manager.getTransaction();
	
	public void SaveUser(User user) {
		transaction.begin();
		manager.persist(user);
		transaction.commit();
	}
	
	public List<User> GetAllUserInfo() {
		String query="select u from User u";
		Query q=manager.createQuery(query);
		List<User> user=q.getResultList();
		return user;		
	}
	
	public User GetUserById(int id) {
		return manager.find(User.class, id);	
	}
	
	public void DeleteUserById(int id) {
		transaction.begin();
		User user=GetUserById(id);
		manager.remove(user);
		transaction.commit();
	}
	
	public void UpdatePhoneNumber(int id, long phoneNumber) {
		transaction.begin();
		User user=GetUserById(id);
		user.setPhoneNumber(phoneNumber);
		User updateUser= manager.merge(user);
		System.out.println(updateUser);
		transaction.commit();
	}

}
