package praesenzubung;

public class Convertible extends Vehicle {
	private boolean hasRetractableRoof;
	public Convertible(String brand, boolean hasTuv, boolean hasRetractableRoof) {
		super(brand, hasTuv);
		this.hasRetractableRoof = hasRetractableRoof; 
	}
	public boolean hasRetractableRoof() {
		return hasRetractableRoof; 
	}
}
