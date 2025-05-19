package praesenze1;

public class BankAccountSimulator {
public static void main(String [] args) {
BankAccount account = new BankAccount (1000);
// TODO: Create and start two threads that each perform:
// - 1000 deposits of 1
// - 1000 withdrawals of 1
TransactionThread thread1= new TransactionThread(account);
TransactionThread thread2= new TransactionThread(account);

thread1.setName("Thread-1");
thread2.setName("Thread-2");



// TODO: Wait for threads to finish using join ()
try {
	thread1.join();
	thread2.join();
}catch (InterruptedException e) {
	System.err.println("Main thread interrupted while waiting for transaction threads");
}

System.out.println (" Final balance: " + account. getBalance ());
}}