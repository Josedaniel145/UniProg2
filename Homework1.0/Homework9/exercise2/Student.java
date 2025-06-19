package exercise2;

public class Student {
	private String name;
	private int year;
	private String major;
	
	public Student(String name, int year, String major) {
		this.name = name;
		this.year = year;
		this.major = major;
	}
	
	public String getName() {
		return name;
	}
	
	public int getYear() {
		return year;
	}
	
	public String getMajor() {
		return major; 
	}

}
