package com.app.tester;

import java.util.Scanner;

import com.app.fruit.Fruit;
import com.app.fruit.FruitUtils;

public class FruitApp {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of fruitBasket");
		int n = sc.nextInt();
		// create an fruit array for store the fruit
		Fruit[] farr = new Fruit[n];

		while (true) {
			System.out.println("Enter the chioce");
			System.out.println("1.Add fruit\n2.Display List of all Fruit\n3.Display All Fruit Name\n"
					+ "4.Display not fresh fruit\n5.Display Fruit test\n "
					+ "6.Display all specials Methods\n0.exit");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				FruitUtils.addFruit(farr);
				System.out.println("Fruit Added");

				break;
			case 2:
				FruitUtils.displayAllFruit(farr);
				break;
			case 3:
				FruitUtils.getAllFruitName(farr);
				break;
			case 4:
				FruitUtils._isFresh(farr);
				break;
			case 5:
				FruitUtils.sourFruit(farr);
				break;
			case 6:
				FruitUtils.FruitSpecialMethod(farr);
				break;
			case 0:
			   break;

			
			}
		}

	}
}
