package praesenzubung2;
import java.util.Objects;

public  abstract class Mammal {
	private String name; 
	public Mammal(String name) {
		if(name == null || name.trim().isEmpty()) {
			throw new IllegalArgumentException("Mammal name (species) cannot be null or empty.");
		}
		this.name = name;
	}
	public String getName() {
		return name;
	}
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() !=0.getClass()) return false;
		Mammal mammal = (Mammal) o;
		return name.equals(mammal.name);
	}
	@Override
	public int hashCode() {
		return Object.hash(name);
	}
	@Override
	public String toString() {
		return "Spieces: " + name; 
	}

}
