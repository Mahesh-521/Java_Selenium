package lab4to10;

import lab3.Lab3_1NameException;

public class PersonMain {

	public static void main(String[] args) {
		
		Person p;
		try {
			p = new Person("mahesh","banda",'M');
			System.out.println("Person Details : ");
			System.out.println("-----------------");
			System.out.println("First Name : "+p.firstName);
			System.out.println("Last Name : "+p.lastName);
			System.out.println("Gender : "+p.gender);
		} catch (Lab3_1NameException e) {
			e.printStackTrace();
		}
		
		
		

	}

}
