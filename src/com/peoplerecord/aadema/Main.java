package com.peoplerecord.aadema;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		// Implement the Scanner class to read user input
		Scanner scnr = new Scanner(System.in);
		
		// Variables to store user input
		String first;
		String last;
		int age;
		
		// Create a new queue object to store full record
		Queue object = new Queue();
		
		// Prompt the user to enter first name, last name, and age for five people
		System.out.println("Please enter first name, last name, and age for five people.");
		
		// For loop to handle prompting the user to enter information five times
		for (int i = 1; i <= 5; i++) {
			
			// Display person number the needs to enter info for
			System.out.println("\nPerson Number: " + i);
			
			// Prompt user to enter information one field at a time
			System.out.println("First Name: ");
			first = scnr.nextLine();
			
			System.out.println("Last Name: ");
			last = scnr.nextLine();
			
			System.out.println("Age: ");
			age = scnr.nextInt();
			
			// Clear the scanner
			scnr.nextLine();
			
			// Create a new Person object passing in the Person fields
			Person record = new Person(first, last, age);
			
			// Store the Person object record in the deque
			object.addPerson(record);
		}
		
		// Print queue objects in the order the user entered them
		System.out.println("\nOriginal Queue:");
		object.printUnsortedQueue();
		
		// Print queue in descending order by last name
		System.out.println("\nRecords sorted in descending order by last name:");
		object.descendingSortByLastName();
		
		// Print the queue in descending order by age
		System.out.println("\nRecords sorted in descending order by age:");
		object.descendingSortByAge();
		
		// Close the scanner
		scnr.close();
	}
}
