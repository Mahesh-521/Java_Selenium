package lab11to15;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Lab11 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
        System.out.print("Enter a date ");
        String date = sc.nextLine();
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate givenDate = LocalDate.parse(date, formatter);

       
        LocalDate currentDate = LocalDate.now();

        Period period = Period.between(givenDate, currentDate);
        
        System.out.println("Duration from " + givenDate + " to " + currentDate + ":");
        System.out.println("Years: " + period.getYears());
        System.out.println("Months: " + period.getMonths());
        System.out.println("Days: " + period.getDays());

	}

}
