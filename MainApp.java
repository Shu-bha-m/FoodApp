package edu.jsp.foodapp.serviceUser;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import edu.jsp.foodapp.dao.CustomerDao;
import edu.jsp.foodapp.dao.FoodOrderDao;
import edu.jsp.foodapp.dao.ItemDao;
import edu.jsp.foodapp.dao.UserDao;
import edu.jsp.foodapp.dto.Customer;
import edu.jsp.foodapp.dto.FoodOrder;
import edu.jsp.foodapp.dto.Item;
import edu.jsp.foodapp.dto.User;

public class MainApp {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		User user=new User();
		UserDao userDao=new UserDao();
		Customer customer=new Customer();
	    CustomerDao customerDao=new CustomerDao();
	    Item item1=new Item();
	    Item item2=new Item();
	    Item item3=new Item();
	    Item item4=new Item();
	    ItemDao itemDao=new ItemDao();
	    FoodOrder foodOrder=new FoodOrder();
	    FoodOrderDao foodOrderDao=new FoodOrderDao();
	    
	    item1.setId(201);
		item1.setName("Pizza");
		item1.setQuantity(10);
		item1.setCost(299.49);
		
		item2.setId(202);
		item2.setName("Biryani");
		item2.setQuantity(5);
		item2.setCost(169.23);
		
		item3.setId(203);
		item3.setName("cold coffe");
		item3.setQuantity(5);
		item3.setCost(120);
		
		 item4.setId(204);
		 item4.setName("Sprite");
		 item4.setQuantity(10);
		 item4.setCost(299.49);
		
		
		
		System.out.println("for user detailes enter 1 ");
		System.out.println("for customer detailes enter 2 ");
		System.out.println("for item detailes enter 3 ");
		System.out.println("for food Order detailes enter 4 ");
		int input=sc.nextInt();
			
			if (input==1) {
			System.out.println("1-for user data save =1 \n"
					+ "2-to change user phoneNumber =2 \n"
					+ "3-to delete user data =3 \n"
					+ "4-to get info of user by id =4 \n"
					+ "5-to display all detail of user =5");
			System.out.println("enter the choice");
			int key=sc.nextInt();
			switch (key) {
			case 1:
				System.out.println("enter User id=");
				int id=sc.nextInt();
				user.setId(id);
				System.out.println("enter User name=");
				String name=sc.next();
				user.setName(name);
				System.out.println("enter User Email=");
				String email=sc.next();
				user.setEmail(email);
				System.out.println("enter User mobile number=");
				long no = sc.nextLong();
				user.setPhoneNumber(no);
				System.out.println("enter User Password=");
				String password=sc.next();
				user.setPassword(password);
				System.out.println("enter User roll=");
				String roll=sc.next();
				user.setRoll(roll);
				
				userDao.SaveUser(user);
				break;
				
			case 2:
				System.out.println("enter User id=");
				int id1=sc.nextInt();
				System.out.println("enter User new PhoneNumber=");
				long number=sc.nextLong();
				userDao.UpdatePhoneNumber(id1, number);
				break;
			
			case 3:
				System.out.println("enter User id whoes data has to deleted=");
				int id2=sc.nextInt();
				userDao.DeleteUserById(id2);
				break;
				
			case 4:
				System.out.println("enter User id whoes data has to show=");
				int id3=sc.nextInt();
				User user1 =userDao.GetUserById(id3);
				System.out.println(user1);
				break;
				
			case 5:
				List<User> list= userDao.GetAllUserInfo();
				for (User user2 : list) {
					System.out.println(user2);
				}				
				break;
			}
			}
			else if (input==2) {
				System.out.println("1-for Customer data save =1 \n"
						+ "2-to change Customer phoneNumber =2 \n"
						+ "3-to delete Customer data =3 \n"
						+ "4-to get info of Customer by id =4 \n"
						+ "5-to display all detail of Customer =5");
				System.out.println("enter the choice");
				int key=sc.nextInt();
				switch (key) {
				
				case 1:
					System.out.println("enter customer id=");
					int id=sc.nextInt();
					customer.setId(id);
					System.out.println("enter customer name=");
					String name=sc.next();
					customer.setName(name);
					System.out.println("enter customer Email=");
					String email=sc.next();
					customer.setEmail(email);
					System.out.println("enter customer mobile number=");
					long no = sc.nextLong();
					customer.setPhoneNumber(no);
					
					customerDao.SaveUser(customer);
					break;
					
				case 2:
					System.out.println("enter customer id=");
					int id1=sc.nextInt();
					System.out.println("enter customer new PhoneNumber=");
					long number=sc.nextLong();
					customerDao.UpdatePhoneNumber(id1, number);
					break;
					
				case 3:
					System.out.println("enter customer id whoes data has to deleted=");
					int id2=sc.nextInt();
					customerDao.DeleteCustomerById(id2);
					break;
				
				case 4:
					System.out.println("enter customer id whoes data has to show=");
					int id3=sc.nextInt();
					Customer customer1 = customerDao.GetCustomerById(id3);
					System.out.println(customer1);
					break;
					
				case 5:
					List<Customer> list=customerDao.GetAllUserInfo();
					for (Customer customer2 : list) {
						System.out.println(customer2);
					}
					
				}
			}
			
			else if(input==3) {
				System.out.println("1-for item data save =1 \n"
						+ "2-to change item cost =2 \n"
						+ "3-to delete item data =3 \n"
						+ "4-to get info of item by id =4 \n"
						+ "5-to display all detail of item =5");
				System.out.println("enter the choice");
				int key=sc.nextInt();
				switch (key) {
				case 1:
					
					itemDao.SaveItem(item1);
					itemDao.SaveItem(item2);
					itemDao.SaveItem(item3);
					itemDao.SaveItem(item4);
					break;
					
				case 2:
					System.out.println("enter item id=");
					int id1=sc.nextInt();
					System.out.println("enter item new cost=");
					double cost=sc.nextLong();
					itemDao.UpdateCost(id1, cost);
					break;
					
				case 3:
					System.out.println("enter item id whoes data has to deleted=");
					int id2=sc.nextInt();
					itemDao.DeleteUserById(id2);
					break;
					
				case 4:
					System.out.println("enter item id whoes data has to show=");
					int id3=sc.nextInt();
					Item item = itemDao.GetItemById(id3);
					System.out.println(item);
					break;
					
				case 5:
					List<Item> list=itemDao.GetAllItemInfo();
					for (Item item5 : list) {
						System.out.println(item5);
					}
					break;
				
			}
			}
			else  {
				System.out.println("1-for item data save =1 \n"
						+ "2-to change order status =2 \n"
						+ "3-to delete order  =3 \n"
						+ "4-to get order info by id =4 \n"
						+ "5-to display all detail of order =5");
				System.out.println("enter the choice");
				int key=sc.nextInt();
				switch (key) {
				case 1:
					foodOrder.setId(303);
					foodOrder.setOrderStatus("dispached");
					double cost=item1.getCost()*item1.getQuantity();
					foodOrder.setTotalCost(cost);
					List<Item> items1=Arrays.asList(item1,item4);
					foodOrder.setItems(items1);
					foodOrderDao.SaveUser(foodOrder);
					break;
					
				case 2:
					System.out.println("enter item id=");
					int id1=sc.nextInt();
					System.out.println("enter updated status=");
					String status=sc.next();
					foodOrderDao.UpdateStatus(id1, status);
					break;
					
				case 3:
					System.out.println("enter order id whoes order has to deleted=");
					int id2=sc.nextInt();
					foodOrderDao.DeleteUserById(id2);
					break;
					
				case 4:
					System.out.println("enter order id whoes data has to show=");
					int id3=sc.nextInt();
					FoodOrder order = foodOrderDao.GetFoodOrderById(id3);
					System.out.println(order);
					break;
					
				case 5:
					List<FoodOrder> list=foodOrderDao.GetAllFoodOrderInfo();
					for (FoodOrder foodOrder2 : list) {
						System.out.println(foodOrder2);
					}	
					
				}
			}
}
}