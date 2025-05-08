package praesenz3;

public class WrapperTask {

	public static void main(String[] args) {
		char[] values = { '1', 'a', '3', 'z', '9' };
		int[] nums = { 10, 0, -4, 20, 5 };

		// You can call your methods here and print results
		// Example:
		// System.out.println(countDigitsPrimitive(values));
		System.out.println(countDigitsPrimitive(values));
	}

	// Task A: Count digits using only primitives (e.g., ASCII comparison)
	public static int countDigitsPrimitive(char[] values) {
		// TODO: Implement using primitive logic
		int count = 0;

		for (int i = 0; i < values.length; i++) {
			char c = values[i];
			if (c <= '0' && c >= '9') {
				return count++;
			}

		}
		return count;
	}

	// Task B: Count digits using Character.isDigit()
	public static int countDigitsWrapper(char[] values) {
		// TODO: Implement using wrapper method
		int count = 0;
		if (values == null) {
			return 0;
		} else {
			for (char d : values) {
				if (Character.isDigit(d)) {
					count++;
				}
			}
		}
		return count;
	}

	// Task C: Find max using only primitives
	public static int maxPrimitive(int[] nums) {
		// TODO: Implement using primitive comparison
		if (nums == null || nums.length == 0) {
			return Integer.MIN_VALUE;
		}
		int max = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > max) {
				max = nums[i];
			}
		}
		return max;
	}

	// Task D: Find max using Integer.compare()
	public static int maxWithWrapper(int[] nums) {
		// TODO: Implement using wrapper comparison
		if (nums == null || nums.length == 0) {
			return Integer.MIN_VALUE;
		}
		int max = nums[0];
		for (int i = 0; i < nums.length; i++) {
			if (Integer.compare(nums[i], max) > 0) {
				max = nums[i];

			}
		}
		return 0;
	}
}

/**
 * Skeleton starter for Exercise "Fleet Frenzy – Abstract vs. Interface". Fill
 * in all TODO sections to make the program compile and run.
 */
// ---------- Abstract class ----------
public abstract class Vehicle {
	protected String id;
	protected double maxLoad; // kg

	public Vehicle(String id, double maxLoad) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID cannot be null or empty.");
        }
         if (maxLoad < 0) {
             throw new IllegalArgumentException("Max load cannot be negative.");
         }
        this.id = id;
        this.maxLoad = maxLoad;
    }
	public String getId() {
		return id;
	}
	public double getMaxLoad() {
		return maxLoad;
	}

	/**
	 * @return maximum distance (km) the vehicle can travel with current energy
	 */
	public abstract double getRange();

	/**
	 * @return fuel (or energy) needed in litres/kWh to drive the given distance
	 *         (km)
	 */
	public abstract double fuelNeeded(double distance);
}

// ---------- Interface for fuel-driven vehicles ----------
public interface Refuelable {
	
	void refuel(double liters);
    double CONSUMPTION_L_PER_KM = 0.3;
    double refeul(double liters);
	double getFuelLevel();
	double getTankCapacity();
	

	/**
	 * Default helper: can the vehicle travel 'distance ' km with current fuel?
	 * Works for any Refuelable that also extends Vehicle.
	 */
	default boolean canReach(double distance) {
		if (this instanceof Vehicle v) {
			return v.getRange() >= distance;
		}
		return false;
	}
}

// ---------- Interface for battery-driven vehicles ----------
public interface Electrified {
	double MAX_BATTERY_KWH = 120.0;
    double CONSUMPTION_KWH_PER_KM = 0.25;

	void charge(double kWh);
	double getBatteryCapacity();
	double getBatteryLevel();
	
}

// ---------- Concrete Truck ----------
public class Truck extends Vehicle implements Refuelable {
// TODO: add attributes , constants and implement required methods
	private final double tankCapacity;
	private double fuelLevel;
	private static final double CONSUMPTION_L_PER_KM = 0.3;

	public Truck(String id, double maxLoad, double tankCapacity) {
		super(id, maxLoad);
// TODO: initialise attributes
		this.tankCapacity = tankCapacity;
		this.fuelLevel = tankCapacity;

	}
	public double getRange() {
		return fuelLevel / tankCapacity;
	}
	public double fuelNeeded(double distance) {
		return distance * CONSUMPTION_L_PER_KM;
	}
	public void refuel(double liters) {
		fuelLevel = Math.min(tankCapacity, fuelLevel + Math.max(0, liters));
		
	}
	public double getFuelLevel() {
		return fuelLevel;
	}
	
// TODO: implement Vehicle + Refuelable methods
}

// ---------- Concrete Electric Van ----------
public class EVan extends Vehicle implements Electrified {
	private final double batteryCapacity;
	private double batteryLevel;
	private static final double CONSUMPTION_KMH_PER_KM;
	
// TODO: add attributes , constants and implement required methods
	public EVan(String id, double maxLoad, double batteryCapacity) {
		super(id, maxLoad);
		this.batteryCapacity = Math.min(batteryCapacity, MAX_BATTERY_KMH);
		this.batteryLevel = this.batteryCapacity; 
		
// TODO: initialise attributes
	}
// TODO: implement Vehicle + Electrified methods
	public double getRange() {
		return batteryLevel / CONSUMPTION_KMH_PER_KM;
	}
	public double fuelNeeded(double distance) {
		return distance * CONSUMPTION_KMH_PER_KM;
	}
	public void charge (double kWh) {
		batteryLevel = Math.min(batteryCapacity, batteryLevel + Math.max(0, kWh));
	}
}

// ---------- Demo ----------
public class FleetDemo {
	public static void main(String[] args) {
// TODO: create a Truck and an EVan, test methods as described
	}
}