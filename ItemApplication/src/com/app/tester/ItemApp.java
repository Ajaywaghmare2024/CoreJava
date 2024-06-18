package com.app.tester;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.app.item.Item;
import com.app.validation.ItemValidation;

public class ItemApp {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner (System.in)){
			
			boolean exit=false;
			Map<String, Item>map=new HashMap<String, Item>();
			while(!exit) {
				System.out.println("Enter the items Deatils-1.Add Item\n 2.Display All items\n 3.sort by item code\n"
						+ " 4.sort by price uisng serilization\n 0.Exit ");
				System.out.println("Enter your choice");
				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter the items detials--");
						System.out.println("Item_code, Description,price,shiping date");
						Item item=ItemValidation.validateInputs(sc.next(), sc.next(), sc.nextDouble(), sc.next(),map);
						map.put(item.getItem_code(), item);
						
						System.out.println("Item Added successfully"+item);
						break;

					case 2:
						System.out.println("Display all itemsList");
						for(Item i:map.values())
							System.out.println(i);
							
						break;
					case 3:
						System.out.println("sort by item_Code");
						System.out.println("Enter the file name");
						String filename=sc.next();
						try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(filename))){
							for(Item i:map.values())
								out.writeObject(i);
							Map<String, Item> list=new TreeMap<>();
							for(Item i:list.values())
								System.out.println(i);
						}
						break;
					case 4:
						 System.out.println("sort by price");
						 System.out.println("Enter the file name");
						 String fileName=sc.next();
						 try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(fileName))){
							 for(Item i:map.values())
								 out.writeObject(i);
							// add Linlkd list
							 List<Item>items=new LinkedList<Item>(map.values());
							 Collections.sort(items,new Comparator<Item>() {

								@Override
								public int compare(Item o1, Item o2) {
									
									return ((Double)o1.getPrice()).compareTo(o2.getPrice());
								}
							} );
							for(Item i: items)
								System.out.println(i);
							
							 
						 }
						break;
					case 0:
						exit=true;
						break;
						
						
					}
					
					
				}catch(Exception e) {
					System.out.println(e);
				}
			}
			
		}catch (Exception e) {
			System.out.println(e);
		}
	}

}
