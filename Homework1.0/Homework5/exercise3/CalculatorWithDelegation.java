package exercise3;

public class CalculatorWithDelegation {
	public static double divide(double a, double b) {
		if (b == 0.0) {
			throw new ArithmeticException("Division by zero attempted");
		}
		return a / b;
	}

	public class Main {
		public static void main(String[] args) {
			System.out.println("--- Variant 2: Handling in main (caller) ---");
			try {
				double result1 = CalculatorWithDelegation.divide(10, 2);
				System.out.println("Result of 10/2: " + result1);
			} catch (ArithmeticException e) {
				System.err.println("Error during division: " + e.getMessage());
				System.err.println("The program caught an unexpected error for 10/2.");

			}
			try {
				double result2 = CalculatorWithDelegation.divide(3, 0);
				System.out.println("Result of 3/0: " + result2);
			} catch (ArithmeticException e) {
				System.err.println("Error during division: " + e.getMessage());
				System.err.println("due to division by zero");

			}
		}
	}
}
