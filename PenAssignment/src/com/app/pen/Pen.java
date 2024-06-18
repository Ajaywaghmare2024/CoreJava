package com.app.pen;

import java.time.LocalDate;

public class Pen {
   private int id;
   private String brand;
   private String color;
   private String ink_color;
   private String material;
   private double price;
   private double discount;
   private int s_quantity;
   private LocalDate update_date;
   private LocalDate listing_date;
   private static int counter;
   
   public Pen() {
	// TODO Auto-generated constructor stub
}

public Pen(String brand, String color, String ink_color, String material, double price, double discount, int s_quantity,
		LocalDate update_date, LocalDate listing_date) {
	super();
	this.id=++counter;
	this.brand = brand;
	this.color = color;
	this.ink_color = ink_color;
	this.material = material;
	this.price = price;
	this.discount = discount;
	this.s_quantity = s_quantity;
	this.update_date = update_date;
	this.listing_date = listing_date;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getBrand() {
	return brand;
}

public void setBrand(String brand) {
	this.brand = brand;
}

public String getColor() {
	return color;
}

public void setColor(String color) {
	this.color = color;
}

public String getInk_color() {
	return ink_color;
}

public void setInk_color(String ink_color) {
	this.ink_color = ink_color;
}

public String getMaterial() {
	return material;
}

public void setMaterial(String material) {
	this.material = material;
}

public double getPrice() {
	return price;
}

public void setPrice(Double price) {
	this.price = price;
}

public double getDiscount() {
	return discount;
}

public void setDiscount(double discount) {
	this.discount = discount;
}

public int getS_quantity() {
	return s_quantity;
}

public void setS_quantity(int s_quantity) {
	this.s_quantity = s_quantity;
}

public LocalDate getUpdate_date() {
	return update_date;
}

public void setUpdate_date(LocalDate update_date) {
	this.update_date = update_date;
}

public LocalDate getListing_date() {
	return listing_date;
}

public void setListing_date(LocalDate listing_date) {
	this.listing_date = listing_date;
}

@Override
public String toString() {
	return "Pen [id=" + id + ", brand=" + brand + ", color=" + color + ", ink_color=" + ink_color + ", material="
			+ material + ", price=" + price + ", discount=" + discount + ", s_quantity=" + s_quantity + ", update_date="
			+ update_date + ", listing_date=" + listing_date + "]";
}
   
   
   
   
   
   
   
}
