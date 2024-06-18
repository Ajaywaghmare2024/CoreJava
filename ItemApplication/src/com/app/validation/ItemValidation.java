package com.app.validation;

import java.time.LocalDate;
import java.util.Map;

import com.app.custom_exception.ItemException;
import com.app.item.Item;

public class ItemValidation {
	public static LocalDate parseDate(String date) {

		return LocalDate.parse(date);

	}

	public static Item validateInputs(String item_code, String description, double price, String shipDate,
			Map<String, Item> items) throws ItemException {
		LocalDate shipdate = parseDate(shipDate);

		return new Item(item_code, description, price, shipdate);

	}
}
