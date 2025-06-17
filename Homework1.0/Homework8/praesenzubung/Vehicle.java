package praesenzubung;

public abstract class Vehicle {
	protected String brand;
	protected boolean hasTuv;
	
	public Vehicle(String brand, boolean hasTuv) {
		this.brand = brand;
		this.hasTuv = hasTuv;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public boolean hasTuv() {
		return hasTuv;
	}

}
