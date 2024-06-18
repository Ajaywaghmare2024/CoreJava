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
import java.util.stream.Stream;

import com.app.pet.Pet;
import com.app.utils.PetUtils;

public class PetApp {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			boolean exit = false;

			Map<Integer, Pet> map = new HashMap<Integer, Pet>();
			while (!exit) {
				System.out.println("Enter the options-1.Add new Pet\n 2. Display List of all pets\n "
						+ "3.Delete the pet\n 4.update the pet stock\n 5.Sorting by price\n"
						+ " 6.sort by stock annd save in file\n +7.bufferreader\n +8.");
				System.out.println("Enter the choice!!");
				try {
					switch (sc.nextInt()) {
					case 1:
						// add the new pet
						System.out.println("Enter the detials - PetId Name Category price stock dob");
						Pet pet = PetUtils.validateInputs(sc.nextInt(), sc.next(), sc.next(), sc.nextDouble(),
								sc.nextInt(), sc.next(), map);
						map.put(pet.getPetId(), pet);

						System.out.println("pet added successfully");
						break;
					case 2:
						// display list of pets
						for (Pet p : map.values())
							System.out.println(p);
						break;

					case 3:
						// delete the pet
						System.out.println("Enter the PetId");
						PetUtils.deletePet(sc.nextInt(), map);
						System.out.println("Pet deleted succesffuly!!");
						break;
					case 4:
						// update the stocks
						System.out.println("Enter the petId and newStock");
						String updatePet = PetUtils.updatePetDetails(sc.nextInt(), sc.nextInt(), map);
						System.out.println(updatePet);
						break;
					case 5:
						System.out.println("sort by price");
						System.out.println("Enter the file name");
						String filename = sc.next();
						try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
							for (Pet p : map.values())
								out.writeObject(p);
							// sorting by price
							List<Pet> list = new LinkedList<Pet>(map.values());
							Collections.sort(list, new Comparator<Pet>() {

								@Override
								public int compare(Pet o1, Pet o2) {
									return ((Double) o1.getPrice()).compareTo(o2.getPrice());

								}

							});
							for (Pet p : list)
								System.out.println(p);

							break;
						}

					case 6:
						// sort by stock by stock store in file
						System.out.println("sort by stock");
						System.out.println("Enter the file name ");
						String fileName = sc.next();
						try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
							for (Pet p : map.values())
								out.writeObject(p);
							List<Pet> pets = new LinkedList<Pet>(map.values());
							Collections.sort(pets, new Comparator<Pet>() {

								@Override
								public int compare(Pet o1, Pet o2) {

									if (o1.getStock() < (o2.getStock()))
										return -1;
									if (o1.getStock() == o2.getStock())
										return 0;
									return 1;
								}
							});
							for (Pet p : pets)
								System.out.println(p);

						}
						break;
					case 7:
                             // read the date from the file
						   System.out.println("Enter the filename");
						   PetUtils.readDetails(sc.next());
						   System.out.println("read file successfully");
						break;
						
					case 8:
						// read date by print write
						
						Stream<Pet>str=map.values().stream();
						PetUtils.storeDetails(sc.next(),str);
						break;
					}

				} catch (Exception e) {
					System.out.println(e);
				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
