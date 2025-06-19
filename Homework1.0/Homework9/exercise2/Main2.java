package exercise2;

public class Main2 {
	public static void main(String[] args) {
		Student alice = new Student("Alice", 2, "Physics");
		
		StudentFormatter simpleFormatter = s -> "Student " + s.getName() + ", Year " + s.getYear();
		StudentFormatter detailedFormatter = s -> s.getName() + " studies "+ s.getMajor() + " in Year: " + s.getYear();
		
		System.out.println(simpleFormatter.format(alice));
		System.out.println(detailedFormatter.format(alice)); 
  		}
}
