package com.app.tester;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.app.phonebok.Contact;
import com.app.utils.PhoneBookValidation;

public class PhoneBookApp {

	public static void main(String[] args) {
		try(Scanner sc= new Scanner(System.in)){
			 
			boolean exit = false;
			
			Set<Contact> contactList = new HashSet<>();
			
			while(!exit) {
				System.out.println("Ente the option 1.Add Contact\n 2. Diplay All Contact Details");
				System.out.println("Choose an option:");
				try {
					switch (sc.nextInt()) {
					case 1:
						// Add the contact Details
						System.out.println("Enter the Contact Details - phone no, Name , dob , Email");
						Contact cont=PhoneBookValidation.PBValidateInputs(sc.next(),sc.next(),sc.next(),sc.next(),contactList);
						contactList.add(cont);
						System.out.println("Contact added successfully!!!!!");
						break;
						
					case 2:
						// Display all Contact details
						for(Contact c: contactList)
							System.out.println(c);
						break;
						
					}
					
				}catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}

	}

}
