package com.peoplerecord.aadema;

public class Person {
	
	// Create variables to hold the person's first name, last name, and age
	private String firstName;
	private String lastName;
	private int age;
	
	// Constructor to initialize the fields
	public Person(String firstName, String lastName, int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	// Generate getters for the first and last names, and age
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}
	
	// Generate the toString() method
	@Override
	public String toString() {
		return "Person firstName: " + firstName + ", lastName: " + lastName + ", age: " + age;
	}
}
