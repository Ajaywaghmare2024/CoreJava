package com.app.utils;

import java.time.LocalDate;
import java.util.Set;

import com.app.custom_Exception.PhoneBookException;
import com.app.phonebok.Contact;

public class PhoneBookValidation {

	public static Contact PBValidateInputs(String phoneNumber, String name, String dob, String email,
			Set<Contact> contactList) throws PhoneBookException {
		LocalDate birthdate = LocalDate.parse(dob);

		return new Contact(phoneNumber, name, birthdate, email);

	}
}
