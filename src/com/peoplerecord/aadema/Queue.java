package com.peoplerecord.aadema;

import java.util.Deque;
import java.util.ArrayDeque;

public class Queue {
	
	// Create a Deque object of ArrayDeque since it grows dynamically and 
	// is faster than LinkedList
	private Deque<Person> deque = new ArrayDeque<>();
	
	// Add entered person to the deque
	public void addPerson(Person person) {
		
		// Used offer() method for graceful error handling
		deque.offer(person);
	}
	
	// Print contents of the deque after user input
	public void printUnsortedQueue() {
		
		// Use enhanced for loop to print contents
		for (Person record : deque) {
			System.out.println(record);
		}
	}
	
	// Helper methods to print descending sorted data by last name and age
	public void descendingSortByLastName() {
		
		// Store the five people entered into an array
		Person[] records = deque.toArray(new Person[5]);
		
		// Call quickSortLastName() passing in the array above, and lowest and 
		// highest indexes of the array
		quickSortLastName(records, 0, records.length - 1);
		
		// Use enhanced for loop to print sorted deque by last name
		for (Person record : records) {
			System.out.println(record);
		}
		
	public void descendingSortByAge() {
		
		// Store the five people entered into an array
		Person[] records = deque.toArray(new Person[5]);
		
		// Call quickSortAge() passing in the array above, and lowest and
		// highest indexes of the array
		quickSortAge(records, 0, records.length - 1);
		
		// Use enhanced for loop to print the sorted deque by age
		for (Person record : records) {
			System.out.println(record);
		}	
	}
}
