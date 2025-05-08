package exercise3;

public class Calculator {
	public static double divide(double a, double b) {
		try {
			if (b == 0.0) {
				throw new ArithmeticException("Division by zero attempted in Calculator.divide().");
			}
			return a / b;
		} catch (ArithmeticException e) { // This 'catch' is now valid because of the 'throw' above
			System.err.println("Error: " + e.getMessage());
			System.err.println("Returning NaN as a default value.");
			return Double.NaN;// Return "Not a Number" as a sensible default
		}
	}

	// ...
	public static void main(String[] args) {
		System.out.println("--- Variant 1: Handling in divide ---");
		System.out.println("Result of 10/2: " + Calculator.divide(10, 2));
		System.out.println("Result of 3/0: " + Calculator.divide(10, 0));
	}
}
