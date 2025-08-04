package lab11to15;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Lab13 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		System.out.print("Enter the product purchase date (yyyy-MM-dd): ");
		String inputDate = sc.nextLine();
		LocalDate purchaseDate = LocalDate.parse(inputDate, formatter);

		System.out.print("Enter warranty period (years): ");
		int years = sc.nextInt();

		System.out.print("Enter warranty period (months): ");
		int months = sc.nextInt();

		LocalDate expiryDate = purchaseDate.plusYears(years).plusMonths(months);

		System.out.println("Warranty Expiry Date: " + expiryDate);

	}

}
