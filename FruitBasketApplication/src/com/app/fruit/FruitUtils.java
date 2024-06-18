package com.app.fruit;

import java.util.Scanner;

public class FruitUtils {
	// method for Add new fruit in basket
	public static void addFruit(Fruit[] arr) {
		Scanner sc = new Scanner(System.in);
		// add the for loop
		for (int i = 0; i < arr.length; i++) {
			System.out.println("Enter the choice for store fruit");
			System.out.println("1.Apple 2.Mango 3.Orange");
			int choice = sc.nextInt();
			System.out.println("Enter the Name:");
			String name = sc.next();
			System.out.println("Enter the color of fruit");
			String color = sc.next();
			System.out.println("Enter the weight");
			double weight = sc.nextDouble();
			System.out.println("Fruit is fresh/true or stale/false");
			boolean fresh = sc.nextBoolean();
			switch (choice) {
			case 1:
				// add Apple
				arr[i] = new Apple(name, color, weight, fresh);
				break;
			case 2:
				// add Mango
				arr[i] = new Mango(name, color, weight, fresh);

				break;
			case 3:
				// add Orange
				arr[i] = new Orange(name, color, weight, fresh);
				break;

			default:
				break;
			}

		}

	}

	// add method for display all list
	public static void displayAllFruit(Fruit[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

	}

	// add method for names of fruit
	public static void getAllFruitName(Fruit[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i].getName());
		}

	}

	// add the method for fruit is fresh or stale
	public static void _isFresh(Fruit[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].isFresh() == false) {
				System.out.println(arr[i].getName() +" "+"is not fresh");
			}
		}

	}

	// method for fruit is sour or not
	public static void sourFruit(Fruit[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i].teste();
			System.out.println();
		}

	}

	// add method for special method of fruit
	public static void FruitSpecialMethod(Fruit[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] instanceof Apple) {
				((Apple) arr[i]).jam();
				System.out.println();
			}
			if (arr[i] instanceof Mango) {
				((Mango) arr[i]).pulp();
				System.out.println();
			}
			if (arr[i] instanceof Orange) {
				((Orange) arr[i]).juice();
			}
		}

	}

}
