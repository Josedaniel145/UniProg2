package praesenz3;

public class WrapperTask {

    public static void main(String[] args) {
        char[] values = {'1', 'a', '3', 'z', '9'};
        int[] nums = {10, 0, -4, 20, 5};

        // You can call your methods here and print results
        // Example:
        // System.out.println(countDigitsPrimitive(values));
        System.out.println(countDigitsPrimitive(values));
    }

    // Task A: Count digits using only primitives (e.g., ASCII comparison)
    public static int countDigitsPrimitive(char[] values) {
        // TODO: Implement using primitive logic
    	int count = 0;
 
    	for(int i = 0; i< values.length; i++) {
    		char c = values[i];
    		if(c <= '0' && c>= '9') {
    			return count++;
    		}
    		
    	}
        return count;
    }

    // Task B: Count digits using Character.isDigit()
    public static int countDigitsWrapper(char[] values) {
        // TODO: Implement using wrapper method
    	int count2 = 0;
    	for(int i = 0; i < values.length; i++) {
    		char d = values[i];
    		
    		if(Character.isDigit(d)) {
    			return count2++;
    			
    		}
    		
    		
    	}
        return count2;
    }

    // Task C: Find max using only primitives
    public static int maxPrimitive(int[] nums) {
        // TODO: Implement using primitive comparison
    	int count3 = 0;
    	for(int i = 0; i <nums.length; i++) {
    		int e = nums[i];
    		if (e <= 'a' && e>= 'z') {
    			return count3++;
    		}
    		
    	}
        return count3;
    }

    // Task D: Find max using Integer.compare()
    public static int maxWithWrapper(int[] nums) {
        // TODO: Implement using wrapper comparison
    	int count4 = 0;
    	for(int i = 0; i <nums.length; i++) {
    		char f = nums[i];
    		if(Integer.compare(f)) {
    			
    		}
    	}
        return 0;
    }
}

/**
* Skeleton starter for Exercise "Fleet Frenzy – Abstract vs. Interface".
* Fill in all TODO sections to make the program compile and run.
*/
// ---------- Abstract class ----------
public abstract class Vehicle {
protected String id;
protected double maxLoad; // kg
public Vehicle(String id, double maxLoad) {
this.id = id;
this.maxLoad = maxLoad;
}
/** @return maximum distance (km) the vehicle can travel with
* current energy */
public abstract double getRange();
/** @return fuel (or energy) needed in litres/kWh to drive
* the given distance (km) */
public abstract double fuelNeeded(double distance);
}
// ---------- Interface for fuel-driven vehicles ----------
public interface Refuelable {
void refuel(double liters);
double getFuelLevel();
/**
* Default helper: can the vehicle travel 'distance ' km with
* current fuel?
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
void charge(double kWh);
double getBatteryLevel();
}

// ---------- Concrete Truck ----------
public class Truck extends Vehicle implements Refuelable {
// TODO: add attributes , constants and implement required methods
	double fuelLevel; 
	
public Truck(String id, double maxLoad, double tankCapacity) {
super(id, maxLoad);
// TODO: initialise attributes

}
// TODO: implement Vehicle + Refuelable methods
}
// ---------- Concrete Electric Van ----------
public class EVan extends Vehicle implements Electrified {
// TODO: add attributes , constants and implement required methods
public EVan(String id, double maxLoad, double batteryCapacity) {
super(id, maxLoad);
// TODO: initialise attributes
}
// TODO: implement Vehicle + Electrified methods
}
// ---------- Demo ----------
public class FleetDemo {
public static void main(String[] args) {
// TODO: create a Truck and an EVan, test methods as described
}}