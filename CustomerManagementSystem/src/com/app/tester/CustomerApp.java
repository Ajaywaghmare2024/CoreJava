package com.app.tester;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.app.customer.Customer;
import com.app.utils.CustomerValidations;
import com.app.utlis.CMSUtils;
import com.custom_exception.Customer_Exception;

public class CustomerApp {

	public static void main(String[] args) throws Customer_Exception {
		try (Scanner sc = new Scanner(System.in)) {
			boolean exit = false;

			List<Customer> customers = CMSUtils.populateCustomer();
			// List <Customer> customers=new ArrayList<Customer>();
			while (!exit) {
				System.out.println(
						"Enter the options: 1.Sign up\n 2.Display all\n 3.customer Sign in\n 4.Change Password\n 5.Delete Customer\n 6.Display ascen sort by emails\n 7.Display customer details sorted as per the dob n last name\n 8.Remove plan and date 0.exit");
				System.out.println("Chooes the option");
				try {
					switch (sc.nextInt()) {
					case 1:// resister new customer

						System.out.println("Enter the customer details");
						System.out.println("frist_name,last_name,email, password,resistrationAmount,dob,servePlan");
						Customer customer = CustomerValidations.validateInputs(sc.next(), sc.next(), sc.next(),
								sc.next(), sc.nextDouble(), sc.next(), sc.next(), customers);
						customers.add(customer);
						System.out.println("Customer sign up successfully");
						break;

					case 2:
						// disply all
						for (Customer c : customers)
							System.out.println(c);

						break;
					case 3:
						// Sign in
						System.out.println("Enter the email and password");
						customer = CMSUtils.authenticateCustomer(sc.next(), sc.next(), customers);
						System.out.println("Successfully login ,your deatils " + customers);
						break;

					case 4:
						// change password
						System.out.println("Enter the email and password n new password ");
						customer = CMSUtils.authenticateCustomer(sc.next(), sc.next(), customers);
						customer.setPassword(sc.next());
						System.out.println("Password changed");
						break;

					case 5:// remove customer
						System.out.println("Enter the email to un Subscribe");
						CMSUtils.deleteCustomerDetails(sc.next(), customers);
						break;
					case 6:
						// sorting by asce email
						Collections.sort(customers);
						break;
					case 7:
						// Display customer details sorted as per the dob n last name
						//Collections.sort(customers,new CustomerDobLastnameComparator());
						// Using anonymous class
//						Collections.sort(customers, new Comparator<Customer>() {
//
//							@Override
//							public int compare(Customer c1, Customer c2) {
//								int valcust = c1.getDob().compareTo(c2.getDob());
//								if (valcust == 0) {
//									return c1.getLast_name().compareTo(c2.getLast_name());
//
//								}
//
//								return valcust;
//							}
//
//						});
						  Collections.sort(customers,new Comparator<Customer>() {

							@Override
							public int compare(Customer o1, Customer o2) {
							int valCust=o1.getDob().compareTo(o2.getDob());
							if(valCust==0) {
								return o1.getLast_name().compareTo(o2.getLast_name());
							}
								return valCust;
							}
							  
						});
						
						break;
					case 8:
						// remove operration
						System.out.println("Enter the plan and date");
						CMSUtils.removerCustomer(sc.next(), sc.next(), customers);

						break;

					case 0:
						exit = true;
						break;
					}

				} catch (Exception e) {
					System.out.println(e);
				}

			}

		}
	}

}
