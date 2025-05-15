package praesenzubung;

public class PaymentSystemTest {
	public static void main(String[] args) {
		PaymentProvider payPalProvider = new PayPalPayment();
        CheckoutService checkoutWithPayPal = new CheckoutService(payPalProvider);
        System.out.println("Processing PayPal payment:");
        checkoutWithPayPal.processPayment(100.50);

        System.out.println("---");

        // A payment using a credit card
        PaymentProvider creditCardProvider = new CreditCardPayment();
        CheckoutService checkoutWithCreditCard = new CheckoutService(creditCardProvider);
        System.out.println("Processing Credit Card payment:");
        checkoutWithCreditCard.processPayment(75.25);

        System.out.println("---");
	}
}
