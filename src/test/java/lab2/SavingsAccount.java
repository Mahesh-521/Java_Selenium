package lab2;

public class SavingsAccount extends Account {
	
	private static final double MIN_BALANCE = 500.0;

	public SavingsAccount(Person person, double initialBalance) {
		super(person, initialBalance);
		if (initialBalance < MIN_BALANCE) {
			throw new IllegalArgumentException("Balance should 500");
		}
	}

	@Override
	void withdraw(double amount) {
		
		if (amount > 0 && (balance - amount) >= MIN_BALANCE) {
            balance -= amount;
            System.out.println("Withdrawn " + amount + " from " + accHolder.getName());
        } else {
        	System.out.println("Invalid withdrawn Amount or Insufficient Balance");

        }
	}

}
