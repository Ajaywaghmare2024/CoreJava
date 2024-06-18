package com.app.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import com.app.custom_exception.StudentException;
import com.app.student.Student;

public class StudentUtils {
	// remove method for students
	public static void deleteStudent(int roll, Map<Integer, Student> students) throws StudentException {
		Student student = students.remove(roll);
		if (student == null)
			throw new StudentException("invalid Rollno");

	}

	// update the marks students
	public static String updateMarks(int rollno, double newMarks, Map<Integer, Student> studs) throws StudentException {
		Student student = studs.get(rollno);
		if (student == null)
			throw new StudentException("invalid Rollno");
		student.setMark(newMarks);
		return "Students marks update successfully";

	}

	// add method for writing dat in file
	public static String storeDetails(String filename, Stream<Student> str) throws IOException {
		try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
			str.forEach(k -> pw.println(k));
		}
		return "Student data stored successfully";
	}

	// add method for read the data from the file
	public static void readDetails(String filename) throws FileNotFoundException, IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			br.lines().forEach(line -> System.out.println(line));
		}

	}

	// add the method for student login
	public static boolean authenticationStudent(String Email, String password, Map<Integer, Student> login)
			throws StudentException {
		 if(login.containsValue(Email))
				 {
			 	Set entryset= login.entrySet();
				 
				 }
				return true;

	}

}
