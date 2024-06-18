package com.app.utlis;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.app.customer.Customer;
import com.app.customer.ServicePlans;
import com.custom_exception.Customer_Exception;

public class CMSUtils {

	   public static Customer authenticateCustomer(String Email,String password,List<Customer>list) throws Customer_Exception{
    	 //public indexOf(Object o)
    	 // 1.indexOf
    	 Customer newCustomer=new Customer(Email);
    	
    	 int index =list.indexOf(newCustomer);
    	 
    	// 2. invalid email:throw custom exc
    	 if(index == -1)
    		 throw new Customer_Exception("Invalid email,Login fail");
    	 Customer customer =list.get(index);
    	//3.get customer ref actual check pwd --invalid --throw exc
    	 //re the cust ref
    	
    	 if(customer.getPassword().equals(password))
    		 return customer;
    	 throw new Customer_Exception("Invalid Password,Login fail");
    	 
    
    	
    	 
     }
     public static String deleteCustomerDetails(String Email,List<Customer>customeres ) throws Customer_Exception{
    	 int index=customeres.indexOf(new Customer(Email));
    	 if(index == -1)
    		 throw new Customer_Exception("cant un subscribe - invalid e,email");
    	 
    	 //valid email
    	 
    	return "Removed details of "+customeres.remove(index).getFrist_name();
	
     }
     
     
         public static List<Customer> populateCustomer() {
	 		Customer a1 = new Customer("Ajay","Waghmare","ajay@123","123",5000,LocalDate.parse("2001-12-17"),ServicePlans.DIAMOND);
	 				
	 		Customer a2 = new Customer("Rushi","Waghmare","rushi@123","1230",1000,LocalDate.parse("1996-10-14"),ServicePlans.SILVER);
	 		Customer a3 = new Customer("Harsh","muli","harsh@123","1234",2000,LocalDate.parse("1998-12-17"),ServicePlans.GOLD);
	 		Customer a4 = new Customer("Aniket","kadu","ani@123","12345",10000,LocalDate.parse("2024-12-17"),ServicePlans.PLATINUM);
	 		Customer a5 =new Customer("pd","dev","paddy@123","123456",5000,LocalDate.parse("1943-08-16"),ServicePlans.DIAMOND);
	 		Customer a6 =new Customer("vikram","rajput","vikram@123","1234567",2000,LocalDate.parse("2001-12-17"),ServicePlans.GOLD);
	 				Customer[] custs = { a1, a2, a3, a4, a5, a6,};
	 		List<Customer> list = new ArrayList<>();// up casting
	 		for (Customer c : custs)
	 			list.add(c);
	 		return list;
	 	}
   
     
     
     public static void removerCustomer(String Plan,String dob,List<Customer> customers)throws Customer_Exception {
    	 ServicePlans chosenPlan=ServicePlans.valueOf(Plan.toUpperCase());
			LocalDate birthdate=LocalDate.parse(dob);
			Iterator<Customer> custItr=customers.iterator();
			while(custItr.hasNext())
			{
				Customer c=custItr.next();
				if(c.getServePlan().equals(chosenPlan )&& c.getDob().isAfter(birthdate)) {
					custItr.remove();
				}
			
			}
     }
}
