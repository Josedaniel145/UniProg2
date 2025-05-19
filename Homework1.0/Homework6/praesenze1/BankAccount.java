package praesenze1;

public class BankAccount {
private int balance;
public BankAccount (int initialBalance ) {
this.balance = initialBalance ;
}
// TODO: Implement deposit and withdraw methods
public synchronized void deposit(int amount) {
	balance = balance + amount;
}
public synchronized void withdraw(int amount) {
	balance = balance - amount; 
}
public int getBalance () {
return balance;
}
}


