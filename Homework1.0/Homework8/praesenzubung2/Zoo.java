package praesenzubung2;
import java.util.HashMap;
import java.util.Map;
public class Zoo {
	private Map <Mammal, Integer> zooInhabitants;
	public Zoo() {
		this.zooInhabitants = new HashMap<>();
	}
	public void addAnimal(Mammal m) {
		Mammal speciesKey = new Mammal(m.getName()) {
			
		};
		Integer currentCount = zooInhabitants.get(speciesKey);
		if(currentCount == null) {
			zooInhabitants.put(speciesKey, 1);
			
		}else {
			zooInhabitants.put(speciesKey, currentCount +1);
		}
		System.out.println("Added " + m.getName() + " (" + m.getIndividualName() + "). Current count for " + m.getName() + ": " + zooInhabitants.get(speciesKey));
	}
	
	public int getSpeciesCount(String speciesName) {
		Mammal speciesKey = new Mammal(speciesName) {
			
		};
		return zooInhabitants.getOrDefault(speciesKey, 0); 
	}
	public void printZooInhabitants() {
		System.out.println("\\n--- Zoo Inhabitants ---");
		if(zooInhabitants.isEmpty()) {
			System.out.print("The zoo is empty! ");
			return;
		}
		for(Map.Entry<Mammal, Integer> entry : zooInhabitants.entrySet()) {
			System.out.println(entry.getKey().getName() + ": " + entry.getValue());
		}
		System.out.println("------------");
	}
	

}
