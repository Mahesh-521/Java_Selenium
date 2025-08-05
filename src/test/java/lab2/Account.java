package lab2;

//public abstract class Account
public class Account {
	private static long accCounter = 1000;
	protected long accNum = 0;
	protected double balance;
	protected Person accHolder;

	private static final double MIN_BALANCE = 500.0;

	public Account(Person person, double initialBalance) {
		if (initialBalance < MIN_BALANCE) {
			throw new IllegalArgumentException("Balance should 500");
		}
		this.accNum = accCounter++;
		this.accHolder = person;
		this.balance = initialBalance;
	}

	public long getAccNum() {
		return accNum;
	}

	public void setAccNum(long accNum) {
		this.accNum = accNum;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Person getAccHolder() {
		return accHolder;
	}

	public void setAccHolder(Person accHolder) {
		this.accHolder = accHolder;
	}

	void deposit(double amount) {
		if (amount > 0) {
			balance += amount;
			System.out.println("Desposited " + amount + " to " + accHolder.getName());
		} else {
			System.out.println("Invalid deposit Amount");
		}
	}

	void withdraw(double amount) {
		if (amount > 0 && (balance - amount >= MIN_BALANCE)) {
			balance -= amount;
			System.out.println("Withdrawn " + amount + " from " + accHolder.getName());
		} else {
			System.out.println("Invalid withdrawn Amount or Insufficient Balance");
		}
	}
	
//	public abstract void withdraw(double amount);

	public String toString() {
		return "Account{" + "accNum=" + accNum + ", accHolder=" + accHolder + ", balance=" + balance + '}';
	}

}
