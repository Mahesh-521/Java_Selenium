package lab11to15;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Person {

	private String firstName;
	private String lastName;
	private String dateOfBirth;

	public Person(String firstName, String lastName, String dateOfBirth) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
	}

	public int calculateAge() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		LocalDate dob = LocalDate.parse(dateOfBirth, formatter);
		LocalDate currentDate = LocalDate.now();

		return Period.between(dob, currentDate).getYears();
	}

	public String getFullName() {
		return firstName + " " + lastName;
	}

	public void displayDetails() {
		System.out.println("Full Name: " + getFullName());
		System.out.println("Date of Birth: " + dateOfBirth);
		System.out.println("Age: " + calculateAge());
	}

}
