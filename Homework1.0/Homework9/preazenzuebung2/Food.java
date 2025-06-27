package preazenzuebung2;

public class Food {
	private String type;
	private boolean foul;
	
	public Food(String type, boolean foul) {
		this.foul = foul;
		this.type = type;
	}
	
	public boolean isFoul(){
		return foul;
	}
	@Override
	public String toString() {
		return type;
	}
	public String getType() {
		return type; 
	}
	

}
