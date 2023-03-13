package edu.jsp.foodapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import edu.jsp.foodapp.dto.Customer;
import edu.jsp.foodapp.dto.User;


public class CustomerDao {
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("shubham");
	EntityManager manager=factory.createEntityManager();
	EntityTransaction transaction=manager.getTransaction();
	
	public void SaveUser(Customer customer) {
		transaction.begin();
		manager.persist(customer);
		transaction.commit();
	}

	public List<Customer> GetAllUserInfo() {
		String query="select c from Customer c";
		Query q=manager.createQuery(query);
		List<Customer> customers =q.getResultList();
		return customers;		
	}
	
	public Customer GetCustomerById(int id) {
		return manager.find(Customer.class, id);	
	}
	
	public void DeleteCustomerById(int id) {
		transaction.begin();
		Customer customer=GetCustomerById(id);
		manager.remove(customer);
		transaction.commit();
	}
	
	public void UpdatePhoneNumber(int id, long phoneNumber) {
		transaction.begin();
		Customer customer=GetCustomerById(id);
		customer.setPhoneNumber(phoneNumber);
		Customer updateCustomer= manager.merge(customer);
		System.out.println(updateCustomer);
		transaction.commit();
	}



}
