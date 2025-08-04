package lab4to10;

import lab4to10.Lab8.Gender;

public class Person {
	
	String firstName;
	String lastName;
	char gender;
	long phoneNumber;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	
	public Person(String firstName, String lastName, char gender) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
	}
	
	public Person(String firstName, String lastName, char m,long phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = m;
		this.phoneNumber=phoneNumber;
	}
	
	public void display() {
		System.out.println("Person Details : ");
		System.out.println("-----------------");
		System.out.println("First Name : "+firstName);
		System.out.println("Last Name : "+lastName);
		System.out.println("Gender : "+gender);
		System.out.println("Phone Number : "+phoneNumber);
	}
	

}
