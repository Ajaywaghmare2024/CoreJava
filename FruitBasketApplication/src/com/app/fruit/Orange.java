package com.app.fruit;

public class Orange extends Fruit{

	public Orange(String name, String color, double weight, boolean fresh) {
		super(name, color, weight, fresh);
		
	}
	public void juice() {
		System.out.println(super.getName()+super.getColor()+" "+"orange is juicy");
		
	}
	@Override
	public void teste() {
		System.out.println("Oranges are sour");
	}
	

}
