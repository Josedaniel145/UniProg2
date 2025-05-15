package praesenzubung;

public class CreditCardPayment implements PaymentProvider {

	@Override
	public void pay(double amount) {
		// TODO Auto-generated method stub
		System.out.println("Paid:" + amount);
		
	}


}
