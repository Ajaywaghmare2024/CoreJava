package com.app.item;

import java.io.Serializable;
import java.time.LocalDate;

public class Item implements Serializable{
	private String Item_code;
	private String description;
	private double price;
	private LocalDate shipDate;

	public Item(String item_code, String description, double price, LocalDate shipDate) {
		super();
		Item_code = item_code;
		this.description = description;
		this.price = price;
		this.shipDate = shipDate;
	}

	public String getItem_code() {
		return Item_code;
	}

	public void setItem_code(String item_code) {
		Item_code = item_code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getShipDate() {
		return shipDate;
	}

	public void setShipDate(LocalDate shipDate) {
		this.shipDate = shipDate;
	}

	@Override
	public String toString() {
		return "Item [Item_code=" + Item_code + ", description=" + description + ", price=" + price + ", shipDate="
				+ shipDate + "]";
	}

}
