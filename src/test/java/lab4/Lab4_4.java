package lab4;

import java.util.ArrayList;
import java.util.Collections;

public class Lab4_4 {

	public static void main(String[] args) {
		ArrayList<String> products = new ArrayList<>();
        products.add("iPhone 14");
        products.add("Samsung Galaxy S22");
        products.add("OnePlus Nord");
        products.add("MacBook Pro");
        products.add("Dell XPS 15");
        products.add("HP Spectre x360");
        products.add("Asus ROG Phone");
        products.add("Lenovo ThinkPad");
        
        Collections.sort(products);

        
        System.out.println("Sorted Product Names:");
        for (String product : products) {
            System.out.println(product);
        }

	}

}
