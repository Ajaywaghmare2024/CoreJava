package com.app.phonebok;

import java.time.LocalDate;

public class Contact {
	private String phoneNumber;
	private String name;
	private LocalDate dob;
	private String email;


	public Contact(String phoneNumber, String name, LocalDate dob, String email) {
		super();
		this.phoneNumber = phoneNumber;
		this.name = name;
		this.dob = dob;
		this.email = email;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getName() {
		return name;
	}





	public LocalDate getDob() {
		return dob;
	}





	public String getEmail() {
		return email;
	}





	@Override
	public String toString() {
		return "Contact [phoneNumber=" + phoneNumber + ", name=" + name + ", dob=" + dob + ", email=" + email + "]";
	}

	// equals method override
	@Override
	public boolean equals(Object o) {
		if(o instanceof Contact) {
			System.out.println("in equals in contact");
			Contact c=(Contact)o;//downcasting 
			return this.name.equals(c.name) && this.dob.equals(c.dob);

		}
		return false;
	}

	// hashcode method 
	@Override
	public int hashCode() {
		return name.hashCode() * dob.hashCode();
	}


}
