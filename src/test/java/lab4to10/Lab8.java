package lab4to10;

import lab3.Lab3_1NameException;

public class Lab8 {

	enum Gender {
		M, F;
	}

	public static void main(String[] args) {

		Person p;
		try {
			p = new Person("mahesh", "banda", 'M');
			System.out.println("Person Details : ");
			System.out.println("-----------------");
			System.out.println("First Name : " + p.firstName);
			System.out.println("Last Name : " + p.lastName);
			System.out.println("Gender : " + Gender.M);
		} catch (Lab3_1NameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

	}

}
