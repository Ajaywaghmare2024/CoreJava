package com.app.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Stream;

import com.app.custom_exception.PetException;
import com.app.pet.Pet;
import com.app.pet.PetCategory;

public class PetUtils {
     public static LocalDate parseDate(String date)throws PetException{
		return LocalDate.parse(date);
    	 
     }
     
     public static PetCategory parsecategory(String category)throws PetException{
    	 return PetCategory.valueOf(category);
     }
     // check for duplicate
     public static void checkForDup(int id,Map<Integer, Pet>pets)throws PetException{
    	 if(pets.containsKey(id))
    		 throw new PetException("Duplicate Id ");
     }
     /*
      * int petId,String name, PetCategory category, double price, int stock, LocalDate dob
      */
     // validate inputs 
     public static Pet validateInputs(int petId,String name, String category, double price, int stock, String dob,Map<Integer, Pet> pets)throws PetException{
    	 checkForDup(petId, pets);
    	LocalDate birthdate=LocalDate.parse(dob);
    	PetCategory cat=PetCategory.valueOf(category.toUpperCase());
    	 return new Pet(petId,name,cat,price,stock,birthdate);
     }
     // update the pet stock
     public static String updatePetDetails(int petId,int newStock,Map<Integer, Pet> maps)throws PetException {
    	 Pet pet=maps.get(petId);
    	 if(pet==null)
    		 throw new PetException("Invalid id, Please checked");
    	 pet.setStock(newStock);
    		 
		return "Stock updated succesffully";
	}
     // delete the pet
     public static void deletePet(int id,Map<Integer, Pet>pets)throws PetException{
       Pet pet=pets.remove(id);
       if(pet==null)
       throw new PetException("Invalid Id");
     }
     
     public static void readDetails(String filename) throws FileNotFoundException, IOException{
    	try(BufferedReader br=new BufferedReader(new FileReader(filename))){
    		br.lines().forEach(line->System.out.println(line));
    	}
     }
     
     public static String storeDetails(String Filename,Stream<Pet> str) throws IOException {
    	 try(PrintWriter pw=new PrintWriter(new FileWriter(Filename))){
    		 str.forEach(k->pw.println(k)); 
    	 }
		return "Write file successfully";
     }
     
}
