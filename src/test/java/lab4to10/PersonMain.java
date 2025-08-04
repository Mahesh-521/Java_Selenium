package lab4to10;

public class PersonMain {

	public static void main(String[] args) {
		
		Person p=new Person("mahesh","banda",'M');
		
		System.out.println("Person Details : ");
		System.out.println("-----------------");
		System.out.println("First Name : "+p.firstName);
		System.out.println("Last Name : "+p.lastName);
		System.out.println("Gender : "+p.gender);
		

	}

}
