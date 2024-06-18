package com.app.validation;

import java.time.LocalDate;
import java.util.Map;

import com.app.custom_exception.PenException;
import com.app.pen.Pen;

public class PenValidation {
	public static LocalDate parseDate(String date) {
		return LocalDate.parse(date);
	}

	public static Pen validateInputs(String brand, String color, String ink_color, String material, double price,
			double discount, int s_quantity, String update_date, String listing_date,Map<Integer, Pen> pen) throws PenException {
		LocalDate up_date = parseDate(update_date);
		LocalDate list_date = parseDate(listing_date);

		return new Pen(brand, color, ink_color, material, price, discount, s_quantity, up_date, list_date);

	}
}
