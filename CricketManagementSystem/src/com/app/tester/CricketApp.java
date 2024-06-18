package com.app.tester;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

import com.app.cricket.Cricketer;
import com.app.utils.CricketUtils;

public class CricketApp {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			boolean exit = false;
			Map<String, Cricketer> map = new HashMap<String, Cricketer>();
			while (!exit) {
				System.out.println("Enter the option-\n 1.Accept min 5 cricketer\n 2.Modify cricketer rating\n"
						+ "3. search cricketer by name\n 4. Display All cricketr List\n 5.Display all criketers is sorted by rating");
				System.out.println("Enter the choice:\n");

				try {
					switch (sc.nextInt()) {
					case 1:
						// accept 5 deatils of cricketer
						System.out.println("Enter the cricketer values-: Name ,email,phone No,rating ,age");
						Cricketer cricks = CricketUtils.validateInputs(sc.next(), sc.next(), sc.next(), sc.nextInt(),
								sc.nextInt(), map);
						map.put(cricks.getEmail(), cricks);
						System.out.println("crickter add successfully!!!!");

						break;
					case 2:
						// Modify crickter string
						System.out.println("Enter the email");
						int rating = CricketUtils.modifyRating(sc.next(), sc.nextInt(), map);
						System.out.println(rating);
						System.out.println("update Sucessfully");
						break;
					case 3:
						// search cricketer by name
						System.out.println("Enter the name");
						String cName = CricketUtils.searchByName(sc.next(), map);
						System.out.println(cName);
						// System.out.println("Name search Successfully!!!");

						break;

					case 4:
						// display
						for (Cricketer cricket : map.values())
							System.out.println(cricket);
						break;
					case 5:
						// Display all cricters sort by rating

						LinkedList<Cricketer> list = new LinkedList<Cricketer>(map.values());

						Collections.sort(list, new Comparator<Cricketer>() {

							@Override
							public int compare(Cricketer o1, Cricketer o2) {
								if (o1.getRating() < o2.getRating())
									return -1;
								if (o1.getRating() == o2.getRating())
									return 0;

								return 1;
							}
						});
						System.out.println("sorted as per rating");
						for (Cricketer c : list)
							System.out.println(c);
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
