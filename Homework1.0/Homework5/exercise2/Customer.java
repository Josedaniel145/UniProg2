package exercise2;

public class Customer {
	private Profile profile;
	private int id;
	
	public Customer(Profile profile, int id) throws InvalidCustomerException {
		if(profile == null) {
			throw new InvalidCustomerException("Profile must not be empty");
		}
		if(id <= 0) {
			throw new InvalidCustomerException("Id must not be negative");
		}
		
		this.profile = profile;
		this.id = id;
	}
	public Profile getProfile() {
		return profile;
		
	}
	public int getId() {
		return id;
	}
	
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	
	public void setId(int id) {
		this.id = id; 
	}
	public String getCustomerShippingCity() {
        // Check if profile actually exists to avoid errors
        if (this.profile != null) {
            // Ask our own profile object for the shipping city.
            // The profile object will then figure out how to get it.
            return this.profile.getShippingCityFromInfo();
        }
        // If there's no profile, return a default or indicate an error
        return "N/A (No Profile)";
    }

}
