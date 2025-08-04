package lab11to15;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Lab14 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter Zone ID (e.g. Asia/Kolkata): ");
		String zoneInput = scanner.nextLine();

		ZoneId zone = ZoneId.of(zoneInput);

		ZonedDateTime zonedDateTime = ZonedDateTime.now(zone);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");

		System.out.println("Current date and time in " + zoneInput + " is:");
		System.out.println(zonedDateTime.format(formatter));

	}

}
