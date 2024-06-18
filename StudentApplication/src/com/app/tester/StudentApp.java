package com.app.tester;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

import com.app.student.Student;
import com.app.utils.StudentUtils;
import com.app.utils.validateStudent;

public class StudentApp {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			boolean exit = false;
			Map<Integer, Student> map = new HashMap<>();
			while (!exit) {
				System.out.println("Enter the option-1.Add new students\n 2.Display All students\n"
						+ " 3.Delete Student\n 4.Update student Marks\n 5.sort by marks\n "
						+ "6.sort by name and store binary using serilization\n 7.write data in file\n"
						+ "8.file in text format\n 9.Student Login ");

				System.out.println("Enter the choice---");
				try {
					switch (sc.nextInt()) {
					case 1:
						// add the new students
						System.out.println("Enter the students details");
						System.out.println("Name Email Password subject Dob Marks");
						Student student = validateStudent.validateInputs(sc.next(), sc.next(), sc.next(), sc.next(),
								sc.next(), sc.nextDouble(), map);
						
						map.put(student.getRollNo(), student);
						System.out.println("Students add Successfully");

						break;

					case 2:
						// Display all students list
						// map.forEach((k, v) -> System.out.println(v));
						for (Student s : map.values())
							System.out.println(s);
						break;
					case 3:
						// delete the rollNo
						System.out.println("Enter the rollno");
						StudentUtils.deleteStudent(sc.nextInt(), map);
						System.out.println("Student delete successfully!!!");
						break;
					case 4:
						// update the students details
						System.out.println("Enter the rollNo n marks");
						StudentUtils.updateMarks(sc.nextInt(), sc.nextDouble(), map);
						System.out.println("mark updated");

						break;
					case 5:
						// sort by marks;
						List<Student> list = new LinkedList<>(map.values());
						Collections.sort(list, new Comparator<Student>() {

							@Override
							public int compare(Student o1, Student o2) {

								return ((Double) o1.getMark()).compareTo(o2.getMark());
							}
						});
						for (Student s : list)
							System.out.println(s);
						break;

					case 6:
						// sort by Students name
						System.out.println("Students sort by names");
						System.out.println("Enter the file name");
						String filename = sc.next();
						try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
							for (Student s : map.values())
								out.writeObject(s);

							List<Student> lists = new LinkedList<>(map.values());
							Collections.sort(lists, new Comparator<Student>() {

								@Override
								public int compare(Student o1, Student o2) {

									return o1.getName().compareTo(o2.getName());
								}
							});
							for (Student s : lists)
								System.out.println(s);

							System.out.println("File data store  in binary!!!using serilization");

						}
						break;
					case 7:
						// Write the data by file stored in text format
						System.out.println("Enter the filename");
						Stream<Student> str = map.values().stream();
						StudentUtils.storeDetails(sc.next(), str);
						System.out.println("Write data sucessfully");
						break;

					case 8:
						// read the from the file
						System.out.println("Enter the filename");
						StudentUtils.readDetails(sc.next());
						System.out.println("File read sucessfully");
						break;
					case 9:
						// Student login
						System.out.println("Enter the Email and password");
						StudentUtils.authenticationStudent(sc.next(), sc.next(), map);
						System.out.println("Student Login sucesssfully!!!!");

						break;

					case 0:
						exit = true;

						break;
					}

				} catch (Exception e) {
					System.out.println(e);
				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
