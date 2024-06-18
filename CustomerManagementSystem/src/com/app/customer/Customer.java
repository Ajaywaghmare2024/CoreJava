package com.app.customer;

import java.time.LocalDate;



public class Customer implements Comparable<Customer>{
	private static final String getEmail = null;
	private int id;
	private String Frist_name;
	private String Last_name;
	private String Email;
	private String password;
	private double resistrationAmount;
	private LocalDate dob;
	private ServicePlans servePlan;
	private static int counter =0;
	
	public Customer( String frist_name, String last_name, String email, String password,
			double resistrationAmount, LocalDate dob, ServicePlans servePlan ) {

		//super();
		this.id = ++counter;
		Frist_name = frist_name;
		Last_name = last_name;
		Email = email;
		this.password = password;
		this.resistrationAmount = resistrationAmount;
		this.dob = dob;
		this.servePlan = servePlan;
	}
	// add overload ctor to wrap pk
	public Customer(String email) {
		Email = email;
	}



	@Override
	public String toString() {
		return "Customer [id=" + id + ", Frist_name=" + Frist_name + ", Last_name=" + Last_name + ", Email=" + Email
				+ ", password=" + password + ", resistrationAmount=" + resistrationAmount + ", dob=" + dob
				+ ", servePlan=" + servePlan + "]";
	}

//	@Override
//	public boolean equals(Object o) {
//		System.out.println("in customer equals");
//		if(o instanceof Customer) {
//			Customer c=(Customer)o;
//			return this.Email.equals(c.Email);
//			
//		}
//		return false;
//	}
//	@Override
//	public int compareTo(Customer anotherCustomer) {
//		return this.Email.compareTo(anotherCustomer.Email);
//	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFrist_name() {
		return Frist_name;
	}
	public void setFrist_name(String frist_name) {
		Frist_name = frist_name;
	}
	public String getLast_name() {
		return Last_name;
	}
	public void setLast_name(String last_name) {
		Last_name = last_name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getResistrationAmount() {
		return resistrationAmount;
	}
	public void setResistrationAmount(double resistrationAmount) {
		this.resistrationAmount = resistrationAmount;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public ServicePlans getServePlan() {
		return servePlan;
	}
	public void setServePlan(ServicePlans servePlan) {
		this.servePlan = servePlan;
	}
	
	
	// write comparable interface compareTo methiod
	// thr class implements by Comparable<Customer>
	@Override
	public int compareTo(Customer newCustomer) {
		return this.Email.compareTo(newCustomer.Email);
		
	}
	//add method the for equals
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Customer) {
			// create a instance
			Customer c=(Customer)o;
			return this.Email.equals(c.Email);
		}
		return false;
		
	}
	





}
