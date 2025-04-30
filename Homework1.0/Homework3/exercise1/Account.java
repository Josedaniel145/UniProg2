package exercise1;

public class Account {
	public String owner;
	private double balance;
	protected int pin;
	String internalNote; 
	
	public Account(String owner, double balance, int pin, String internalNote) {
		this.owner = owner;
		this.balance = balance;
		this.pin= pin;
		this.internalNote= internalNote; 
	}
	
	public  double getBalance() {
		return balance; 
	}
	
	public boolean changepin(int currentPinAttempt, int newPin) {
		if (this.pin == currentPinAttempt) {
			this.pin = newPin;
			return true;
			
		} else {
			return false;
		}
	}

}
