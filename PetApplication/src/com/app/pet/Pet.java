package com.app.pet;

import java.io.Serializable;
import java.time.LocalDate;

public class Pet implements Serializable {
	private int petId;
	private String name;
    private PetCategory category;
	private double price;
	private int stock;
	private LocalDate dob;
	private static int cnt;
	
	public Pet() {
		// TODO Auto-generated constructor stub
	}
	

	public Pet(int petId,String name, PetCategory category, double price, int stock, LocalDate dob) {
		super();
		this.petId = petId;
		this.name = name;
		this.category = category;
		this.price = price;
		this.stock = stock;
		this.dob = dob;
	}

	public int getPetId() {
		return petId;
	}

	public void setPetId(int petId) {
		this.petId = petId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PetCategory getCategory() {
		return category;
	}

	public void setCategory(PetCategory category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public static int getCnt() {
		return cnt;
	}

	public static void setCnt(int cnt) {
		Pet.cnt = cnt;
	}


	@Override
	public String toString() {
		return "Pet [petId=" + petId + ", name=" + name + ", category=" + category + ", price=" + price + ", stock="
				+ stock + ", dob=" + dob + "]";
	}
	
	

		
}
