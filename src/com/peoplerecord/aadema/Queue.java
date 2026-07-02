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
	
	// Use quick sort to sort data by last name in descending order
	public int lastNamePartition(Person[] records, int low, int high) {
		
		// Define the pivot value as the last value in the array
		String pivot = records[high].getLastName();
		
		// Initialize i to one position before the start of the subarray
		// to track elements less than pivot and elements still not processed
		int i = low - 1;
		
		// Loop through the array and move smaller elements to the left
		// of the pivot
		for (int j = low; j <= high - 1; j++) {
			
			// Ignoring case, check to see if the element value is greater than the
			// pivot value - .compareToIgnoreCase() returns an integer so if greater
			// than the pivot value, the value belong on left side for ascending order
			if (records[j].getLastName().compareToIgnoreCase(pivot) > 0) {
				
				// Increment i by 1
				i++;
				
				// Call the swap() method to swap index i with index j in the array
				swap(records, i, j);
			}
		}
		// Move the pivot to its final position
		swap(records, i + 1, high);
		
		// Tell quick sort where the pivot ended up
		return i + 1;	  
	}
	
	// Quick sort method implementation
	public void quickSortLastName(Person[] records, int low, int high) {
		
		// Using recursion, create the base case where there is nothing left to sort
		if (low < high) {
			
			// Store pivot index by calling lastNamePartition() to store the pivot's final index
			int pivotIndex = lastNamePartition(records, low, high);
			
			// Recursivelly call quickSortLastName() to sort both subarrays first to the
			// left of the pivot then to the right of the pivot
			quickSortLastName(records, low, pivotIndex - 1);
			quickSortLastName(records, pivotIndex + 1, high);
		}
	}
	
	// Similar to the descending sort above, we sort in descending order by the age
	public int agePartition(Person[] records, int low, int high) {
		
		// Define the pivot value as the last value in the array
		int pivot = records[high].getAge();
		
		// Initialize i to one position before the start of the subarray
		// to track elements less than pivot and elements still not processed
		int i = low - 1;
		
		// Loop through the array and move smaller elements to the left
		// of the pivot
		for (int j = low; j <= high - 1; j++) {
			
			// Check to see if the element value is greater than the
			if (records[j].getAge() > pivot) {
				
				// Increment i by 1
				i++;
				
				// Call the swap() method to swap index i with index j in the array
				swap(records, i, j);
			}
		}
		// Move the pivot to its final position
		swap(records, i + 1, high);
		
		// Tell quick sort where the pivot ended up
		return i + 1;	  
	}
	
	// Quick sort method implementation
	public void quickSortAge(Person[] records, int low, int high) {
		
		// Using recursion, create the base case where there is nothing left to sort
		if (low < high) {
			
			// Store pivot index by calling lastNamePartition() to store the pivot's final index
			int pivotIndex = agePartition(records, low, high);
			
			// Recursivelly call quickSortLastName() to sort both subarrays first to the
			// left of the pivot then to the right of the pivot
			quickSortAge(records, low, pivotIndex - 1);
			quickSortAge(records, pivotIndex + 1, high);
		}
	}
	
	// Helper method to handle swapping indexes
	public void swap(Person[] array, int first, int second) {
		
		// Create a temporary variable to temporarily hold a value to swap
		Person temp = array[first];
		
		// Set i equal to j since i is stored in the temprary variable
		array[first] = array[second];
		
		// Set j equal to the temporary value since i now holds the value of j
		array[second] = temp;
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
