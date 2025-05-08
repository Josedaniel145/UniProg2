package exercise1;

public class ShippingInfo {
	private String city;
	private int zip;
	private String country;
	
	public ShippingInfo(String city, int zip, String country) {
		this.city = city;
		this.zip = zip;
		this.country = country;
	}
	
	public String getCity() {
		return city;
	}
	public int getZip() {
		return zip;
	}
	public String getCountry() {
		return country;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	public void setCountry(String country) {
		this.country = country; 
	}
	
}
