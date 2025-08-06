package lab3;

import java.util.Arrays;

public class Lab3_4 {

	public static void main(String[] args) {
		
		String[] products= {"Laptop", "Mouse", "Keyboard", "Monitor", "Charger", "Phone"};
		
		System.out.println("Original Products : ");
		for(String product:products) {
			System.out.println(product);
		}
		
		Arrays.sort(products);
		
		System.out.println("After sorting Products : ");
		for(String product:products) {
			System.out.println(product);
		}
	}

}
