package lab2;

public class Lab2_2 {

	public static void main(String[] args) {
		Person smith = new Person("Smith", 23);
        Person kathy = new Person("Kathy", 26);
        
        Account smithAccount = new SavingsAccount(smith, 2000);
        Account kathyAccount = new CurrentAccount(kathy, 3000, 1000);
        
        smithAccount.deposit(2000);
        kathyAccount.withdraw(3500);
        smithAccount.withdraw(1600);
        
        System.out.println(smithAccount);
        System.out.println(kathyAccount);

	}

}
