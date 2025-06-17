package praesenzubung;

public class Motorbike extends Vehicle{
	private int engineCC;
	public Motorbike(String brand, boolean hasTuv, int engineCC) {
		super(brand, hasTuv);
		this.engineCC= engineCC;
	}
	
	public getEngineCC() {
		return engineCC;
	}

}
