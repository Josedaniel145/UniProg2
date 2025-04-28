package exercise1;

public class Publication {
	public String title;
	public int year;
	
	public Publication(String title, int year) {
		this.title = title;
		this.year = year; 
	}
	
	public String getInfo() {
		return this.title + " published in " + this.year;
		
	}

}
