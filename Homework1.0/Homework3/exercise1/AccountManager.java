package exercise1;

public class AccountManager {
	Account managerAccount = new Account("Charle", 2000.0, 1122, "Manager view");

	public void testAccess() {
		System.out.println(
				"a : " +managerAccount.owner + " b: "+ managerAccount.getBalance() + " c: " + managerAccount.pin + " d: " + managerAccount.internalNote);
	}

	public static void main(String[] args) {
		AccountManager manager = new AccountManager();
		manager.testAccess();

	}

}
