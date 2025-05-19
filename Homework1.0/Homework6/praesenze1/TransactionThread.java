package praesenze1;

public class TransactionThread extends Thread {
	
	private BankAccount account;
	private static final int NUM_OPERATIONS = 1000;
	
	public TransactionThread(BankAccount account) {
		this.account = account;
		
	}
	@Override 
	public void run() {
		for(int i=0; i < NUM_OPERATIONS; i++) {
			account.deposit(1);
			account.withdraw(1);
		}
		System.out.println(Thread.currentThread().getName() + " finished its transactions.");
	}
	
}
