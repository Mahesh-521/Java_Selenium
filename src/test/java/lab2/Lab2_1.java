package lab2;

public class Lab2_1 {

	public static void main(String[] args) {
		
		Person smith = new Person("Smith", 23);
        Person kathy = new Person("Kathy", 26);
        
        Account smithAccount=new Account(smith, 2000);
        Account kathyAccount=new Account(kathy, 3000);
        
        smithAccount.deposit(2000);
        kathyAccount.withdraw(2000);

        System.out.println(smithAccount);
        System.out.println(kathyAccount);
	}

}
