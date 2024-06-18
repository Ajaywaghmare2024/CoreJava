package com.app.fruit;

public class Apple extends Fruit{

	
	public Apple(String name, String color, double weight, boolean fresh) {
		super(name, color, weight, fresh);
		
	}
	public void jam() {
		System.out.println(super.getName()+" "+ "Apples creating jam");
		
	}
	@Override
	public void teste() {
		System.out.println("Apples are sweets and sour");
	}
     
}
