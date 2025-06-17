package praesenzubung;
import java.util.ArrayList;
import java.util.List;

public class Junkyard {
	private List<Vehicle> destroyedVehicles; // Because it's private, no other class (like Main) can directly access this list. You cannot write junkyard.destroyedVehicles.get(0) from outside the Junkyard class. This is the primary mechanism for preventing retrieval.
	
	public Junkyard() {
		this.destroyedVehicles = new ArrayList<>();
		
	}
	public <T extends Vehicle> void destroyVehicle(T vehicle) {
		if(vehicle == null) {
			System.out.println("ERROR");
			return;
		}
		
		if(!vehicle.hasTuv()) {
			destroyedVehicles.add(vehicle);
			
		}
	}
	

}
