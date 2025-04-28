package exercise1;

public class Book extends Publication {
	
	public String author;
	
	public Book (String title, int year, String author) {
		super(title, year);
		this.author = author; 
	}
	public String getInfo(){
		return super.getInfo()+ " , by " + this.author;
		
	}

}
