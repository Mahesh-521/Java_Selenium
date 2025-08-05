package lab2;

public class CurrentAccount extends Account {
	
	private double overDraftLimit;
	
	public CurrentAccount(Person person, double initialBalance,double overDraftLimit) {
		super(person, initialBalance);
		this.overDraftLimit=overDraftLimit;
	}

	@Override
	public void withdraw(double amount) {
		if (amount > 0 && (balance - amount) >= -overDraftLimit) {
			balance -= amount;
            System.out.println("Withdrawn " + amount + " from " + accHolder.getName());
        } else {
        	System.out.println("Invalid withdrawn Amount or Insufficient Balance");
        }
	}
	
	public double getOverDraftLimit() {
        return overDraftLimit;
    }

}
