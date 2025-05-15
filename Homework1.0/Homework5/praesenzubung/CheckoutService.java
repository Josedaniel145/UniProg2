package praesenzubung;

public class CheckoutService {
	private PaymentProvider paymentProvider; 
	
	public CheckoutService(PaymentProvider paymentProvider) {
		this.paymentProvider = paymentProvider;
	}
	
	public void processPayment(double amount) {
		paymentProvider.pay(amount); 
	}

}
