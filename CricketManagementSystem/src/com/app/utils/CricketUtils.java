package com.app.utils;

import java.util.Map;

import com.app.cricket.Cricketer;
import com.app.custom_exception.CricketerException;

public class CricketUtils {
	// add the method for check Duplicate
	public static void checkForDups(String email, Map<String, Cricketer> cricketers) throws CricketerException {
		if (cricketers.containsKey(email))

			throw new CricketerException("Its is duplicate email");

	}

	/*
	 * String name, String email, String phone, int rating, int age)
	 */
	// add thr method for validate input
	public static Cricketer validateInputs(String name, String email, String phone, int rating, int age,
			Map<String, Cricketer> crickets) throws CricketerException {
		checkForDups(email, crickets);

		return new Cricketer(name, email, phone, rating, age);

	}

	// add the method for Modify the name
	public static int modifyRating(String email, int newRating, Map<String, Cricketer> cmap) throws CricketerException {
		Cricketer cricketer = cmap.get(email);
		if (cricketer == null)
			throw new CricketerException("invalid email");
		cricketer.setRating(newRating);

		return cricketer.getRating();
	}

	// add ametyhod for searching
	public static String searchByName(String name, Map<String, Cricketer> crickets) throws CricketerException {
		for (Cricketer c : crickets.values())
			if (c.getName().equals(name)) {
				System.out.println(c);
			}
		throw new CricketerException("invalid name");

	}
	//
}
