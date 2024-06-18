package com.app.utils;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import com.app.customer.Customer;
import com.app.customer.ServicePlans;
import com.custom_exception.Customer_Exception;

public class CustomerValidations {
	// validateInputs
		public static Customer validateInputs( String frist_name, String last_name, String email, String password,
				double resistrationAmount, String dob, String servePlan, List<Customer> customers) throws Customer_Exception{
			
			checkForDupCustomer(email,customers);
			ServicePlans plans=parseAndValidatePlanAndCharges(servePlan, resistrationAmount);
			validatePassword(password);
			LocalDate birthDate = LocalDate.parse(dob);
			validateAge(dob);
			//ServicePlans plans =parseAndValidateType(servePlan);
			return new Customer(frist_name, last_name, email, password, resistrationAmount, birthDate ,plans );
		}

	
	   //add method to check dupliacte customer email id
	
	public static void checkForDupCustomer(String Email,List<Customer> customers)throws Customer_Exception {
		Customer newCust=new Customer(Email);
		if(customers.contains(newCust))
			throw new Customer_Exception("dup email id");
	}
	
	
	
	// add method to parse validate planes and its charges
	public static ServicePlans parseAndValidatePlanAndCharges(String servePlan,double regAmt)throws Customer_Exception {
		ServicePlans Plan= ServicePlans.valueOf(servePlan.toUpperCase());
		if(Plan.getServicePlan() == regAmt) 
			return Plan;
		throw new Customer_Exception("Reg amount doesn't match with plans");
		
		
	}
	
	public static void  validatePassword(String password) throws Customer_Exception{
		
		String regex="((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})";
//     boolean pass=password.matches(regex);
     if(!password.matches(regex)) 
//    	 System.out.println("password is correct");
         throw new Customer_Exception("password is not valid");
     
		
		
	}
	
	//add a static methof
//	public static void validateAge(String dob)throws Customer_Exception{
//		LocalDate birthdate = LocalDate.parse(dob);
//		int age =Period.between(birthdate,LocalDate.now()).getYears();
//		if(age<21) {
//			throw new Customer_Exception("Under age:");
//		}
//	}
//	
	
	// add method for validate age 
	public static void validateAge(String dob) throws Customer_Exception{
		 LocalDate birthDate=LocalDate.parse(dob);
		 int age=Period.between(birthDate,LocalDate.now()).getYears();
		 if(age<21) {
			 throw new Customer_Exception("Invalidate age");
		 }
	}
	
	
	
	
	
	
	
}

