package exercise1;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("Printing all CoursePhase constants and their messages:");
		System.out.println("--------------------------------");
		for(CoursePhase phase : CoursePhase.values()) { //You are not accessing the private variable directly. You are calling a public method that has access to the private variable and gives you its value
			System.out.println("Constant: " + phase.name() + " -> Message: \"" + phase.getMessage() + "\"");
		}
	}
	

}
