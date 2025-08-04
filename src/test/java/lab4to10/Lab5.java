package lab4to10;

import java.util.Scanner;

public class Lab5 {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Number : ");
		int n=sc.nextInt();
		
		if(n>=0) {
			System.out.println("Positive Number");
		}else {
			System.out.println("Negative Number");
		}

	}

}
