package praesenzubung;

public class Main {
	public static void main(String[] args) {
		Convertible myConvertible= new Convertible("BMW", false, true);
		Junkyard junkyard = new Junkyard();
		junkyard.destroyVehicle(myConvertible);
	}

}
