package lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lab4_2 {

	public static void main(String[] args) {


		File f=new File("numbers.txt");
		
		try {
			Scanner sc=new Scanner(f);
			
			sc.useDelimiter(",");
			
			while(sc.hasNext()) {
				int num=sc.nextInt();
				if(num%2==0) {
					System.out.println(num);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
