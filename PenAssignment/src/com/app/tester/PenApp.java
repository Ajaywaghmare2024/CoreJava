package com.app.tester;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.app.pen.Pen;
import com.app.utils.PenUtils;
import com.app.validation.PenValidation;

public class PenApp {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			boolean exit = false;
			Map<Integer, Pen> pens = new HashMap<Integer, Pen>();
			while (!exit) {
				System.out.println("Enter the options-\n 1. Add new pen\n 2.display list\n 3.update stock pen\n 4.set discountof 20%\n"
						+ "5.Remove pens listed in 9 months");
				System.out.println("Enter the choice");
				try {
					switch (sc.nextInt()) {
					case 1:// add new pen
						/*
						 * String brand, String color, String ink_color, String material, double price,
						 * double discount, int s_quantity, String update_date, String listing_date
						 */
						System.out.println("Enter pens details- Brand,color,ink_color,material,price,discount,quantity,update_date,list_date");
						Pen penAdd=PenValidation.validateInputs(sc.next(), sc.next(), sc.next(), sc.next(), sc.nextDouble(), sc.nextDouble(), sc.nextInt(), sc.next(),sc.next(),pens);
						pens.put(penAdd.getId(), penAdd);
						System.out.println("pen Successfully add"+penAdd);
						break;
					case 2:
						// display all List
						for(Pen p:pens.values())
							System.out.println(p);
					case 3:
						// update the pen stock quentity
						System.out.println("Enter the pen Id");
						 String newQuantity=PenUtils.updatePenStock(sc.nextInt(),sc.nextInt(),LocalDate.parse(sc.next()) ,pens);
						 System.out.println(newQuantity);
						break;
					case 5:
						// remove pens
						System.out.println("Enter the id");
						PenUtils.removePenDetails(sc.nextInt(),pens);
						System.out.println("pen removed!!!");
						
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
