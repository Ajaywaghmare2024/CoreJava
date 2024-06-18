package com.app.custom_ordening;

import java.util.Comparator;

import com.app.customer.Customer;

public class CustomerDobLastnameComparator implements Comparator<Customer>{

	@Override
	public int compare(Customer o1, Customer o2) {
		int valCust=o1.getDob().compareTo(o2.getDob());
		if(valCust==0) {
			return o1.getLast_name().compareTo(o2.getLast_name());
		}
		return valCust;
	}
	
}