package com.app.fruit;

public class Mango extends Fruit {

	public Mango(String name, String color, double weight, boolean fresh) {
		super(name, color, weight, fresh);
		
	}
	public void pulp() {
		System.out.println(super.getName()+super.getColor()+" "+"pulp is creating");
		
	}
	@Override
	public void teste() {
		System.out.println(" Mango teste is sour");
		
	}
	

}
