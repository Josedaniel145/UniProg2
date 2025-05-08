package exercise2;

public class EComController {
	public static void main(String[] args) {
		System.out.println("--- E-Commerce System: Testing Object Creation & Validation ---");

		// --- Scenario 1: All data is valid ---
		System.out.println("\n--- Scenario 1: Valid Data ---");
		try {
			ShippingInfo info1 = new ShippingInfo("Munich", 80331, "Germany");
			Profile profile1 = new Profile(info1);
			Customer customer1 = new Customer(profile1, 123);

			System.out.println("SUCCESS: Customer 1 created.");
			System.out.println("Shipping city for Customer 1: " + customer1.getCustomerShippingCity());

		} catch (InvalidShippingInfoException e) {
			System.err.println("ERROR (Shipping Info): " + e.getMessage());
		} catch (MissingShippingInfoException e) {
			System.err.println("ERROR (Profile): " + e.getMessage());
		} catch (InvalidCustomerException e) {
			System.err.println("ERROR (Customer): " + e.getMessage());
		} catch (Exception e) { // A general catch for any other unexpected errors
			System.err.println("UNEXPECTED ERROR: " + e.getMessage());
			e.printStackTrace(); // Print more details for unexpected errors
		}
		// --- Scenario 2: Invalid ShippingInfo (empty city) ---
		System.out.println("\n--- Scenario 2: Invalid ShippingInfo (empty city) ---");
		try {
			ShippingInfo info2 = new ShippingInfo("", 80331, "Germany"); // Invalid: empty city
			Profile profile2 = new Profile(info2); // This line won't be reached
			Customer customer2 = new Customer(profile2, 124); // This line won't be reached
			System.out.println("SUCCESS: Customer 2 created."); // This line won't be reached
		} catch (InvalidShippingInfoException e) {
			System.err.println("EXPECTED ERROR (Shipping Info): " + e.getMessage());
		} catch (MissingShippingInfoException e) {
			System.err.println("ERROR (Profile): " + e.getMessage());
		} catch (InvalidCustomerException e) {
			System.err.println("ERROR (Customer): " + e.getMessage());
		}

		// --- Scenario 3: Invalid ShippingInfo (negative zip) ---
		System.out.println("\n--- Scenario 3: Invalid ShippingInfo (negative zip) ---");
		try {
			ShippingInfo info3 = new ShippingInfo("Berlin", -100, "Germany"); // Invalid: negative zip
			Profile profile3 = new Profile(info3);
			Customer customer3 = new Customer(profile3, 125);
			System.out.println("SUCCESS: Customer 3 created.");
		} catch (InvalidShippingInfoException e) {
			System.err.println("EXPECTED ERROR (Shipping Info): " + e.getMessage());
		} catch (MissingShippingInfoException e) {
			System.err.println("ERROR (Profile): " + e.getMessage());
		} catch (InvalidCustomerException e) {
			System.err.println("ERROR (Customer): " + e.getMessage());
		}

		// --- Scenario 4: Missing ShippingInfo in Profile ---
		System.out.println("\n--- Scenario 4: Missing ShippingInfo for Profile ---");
		try {
			// We need a valid ShippingInfo to try and pass null to Profile
			ShippingInfo validTempInfo = new ShippingInfo("ValidCity", 12345, "Country");
			Profile profile4 = new Profile(null); // Invalid: passing null for shippingInfo
			Customer customer4 = new Customer(profile4, 126);
			System.out.println("SUCCESS: Customer 4 created.");
		} catch (InvalidShippingInfoException e) { // Added to catch exception from validTempInfo if it were invalid
			System.err.println("ERROR (Shipping Info - for temp): " + e.getMessage());
		} catch (MissingShippingInfoException e) {
			System.err.println("EXPECTED ERROR (Profile): " + e.getMessage());
		} catch (InvalidCustomerException e) {
			System.err.println("ERROR (Customer): " + e.getMessage());
		}

		// --- Scenario 5: Invalid Customer (null profile) ---
		System.out.println("\n--- Scenario 5: Invalid Customer (null profile) ---");
		try {
			Customer customer5 = new Customer(null, 127); // Invalid: null profile
			System.out.println("SUCCESS: Customer 5 created.");
		} catch (InvalidCustomerException e) {
			System.err.println("EXPECTED ERROR (Customer): " + e.getMessage());
		}

		// --- Scenario 6: Invalid Customer (negative ID) ---
		System.out.println("\n--- Scenario 6: Invalid Customer (negative ID) ---");
		try {
			ShippingInfo info6 = new ShippingInfo("Frankfurt", 60306, "Germany");
			Profile profile6 = new Profile(info6);
			Customer customer6 = new Customer(profile6, -1); // Invalid: negative ID
			System.out.println("SUCCESS: Customer 6 created.");
		} catch (InvalidShippingInfoException e) {
			System.err.println("ERROR (Shipping Info): " + e.getMessage());
		} catch (MissingShippingInfoException e) {
			System.err.println("ERROR (Profile): " + e.getMessage());
		} catch (InvalidCustomerException e) {
			System.err.println("EXPECTED ERROR (Customer): " + e.getMessage());
		}
		System.out.println("\n--- End of E-Commerce System Tests ---");

	}

}
