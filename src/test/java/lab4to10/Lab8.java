package lab4to10;

public class Lab8 {

	enum Gender {
		M, F;
	}

	public static void main(String[] args) {

		Person p = new Person("mahesh", "banda", 'M');

		System.out.println("Person Details : ");
		System.out.println("-----------------");
		System.out.println("First Name : " + p.firstName);
		System.out.println("Last Name : " + p.lastName);
		System.out.println("Gender : " + Gender.M);

	}

}
