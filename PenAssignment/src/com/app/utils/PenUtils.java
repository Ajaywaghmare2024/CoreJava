package com.app.utils;

import java.time.LocalDate;
import java.util.Map;

import com.app.custom_exception.PenException;
import com.app.pen.Pen;

public class PenUtils {
 //update the stock
	public static String updatePenStock(int id,int newQuantity,LocalDate newDate,Map<Integer, Pen> mapPen)throws PenException {
		Pen pen=mapPen.get(id);
		if(pen==null)
			throw new PenException("invalid id"); 
           pen.setS_quantity(newQuantity);
		   pen.setUpdate_date(newDate);
		
		return "pens stock updated";
		
	}

	public static void removePenDetails(int penId, Map<Integer, Pen> removePen) throws PenException{
		
		Pen pen=removePen.remove(penId);
		if(pen==null)
			throw new PenException("invalid pen id");
		System.out.println("removed pen successfully"+pen);
		
		
		
	}
}
