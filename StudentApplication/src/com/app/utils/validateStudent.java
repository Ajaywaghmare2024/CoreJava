package com.app.utils;

import java.time.LocalDate;
import java.util.Map;

import com.app.custom_exception.StudentException;
import com.app.student.Student;
import com.app.student.Subject;

public class validateStudent {
	public static LocalDate parseDate(String dob) throws StudentException {
		return LocalDate.parse(dob);

	}

	public static Subject parseSubject(String subject) throws StudentException {
		return Subject.valueOf(subject.toUpperCase());

	}

	// check for duplicates
	public static boolean checkForDup(String email, Map<Integer, Student> map) throws StudentException {
		
		Student newStud = new Student(email);
		if (map.containsValue(newStud))
			throw new StudentException("Duplicate Email !!");
		return true;
	}

	// validate inputs
	public static Student validateInputs(String name, String email, String password, String subject, String dob,
			double mark, Map<Integer, Student> studs) throws StudentException {
		checkForDup(email, studs);
		LocalDate birthdate = parseDate(dob);
		Subject sub = parseSubject(subject);
		return new Student(name, email, password, sub, birthdate, mark);

	}
}
