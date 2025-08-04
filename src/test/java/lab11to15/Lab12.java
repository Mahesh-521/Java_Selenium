package lab11to15;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Lab12 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
        System.out.print("Enter a date 1 ");
        String date1 = sc.nextLine();
        System.out.print("Enter a date 2 ");
        String date2 = sc.nextLine();
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate givenDate1 = LocalDate.parse(date1, formatter);
        LocalDate givenDate2 = LocalDate.parse(date2, formatter);

        Period period = Period.between(givenDate1, givenDate2);
        
        System.out.println("Duration from " + givenDate1 + " to " + givenDate2 + ":");
        System.out.println("Years: " + period.getYears());
        System.out.println("Months: " + period.getMonths());
        System.out.println("Days: " + period.getDays());

	}

}
