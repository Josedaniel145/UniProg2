package exercise1;

public class Textbook extends Book {
	public String subject;
	
	public Textbook(String title,int year,String subject, String author) {
		super(title, year, author);
		
		this.subject = subject;
	}
	
	public String getInfo() {
		String bookInfo = super.getInfo();
		String textbookInfo = bookInfo + " Subjec: " + this.subject;
		
		return textbookInfo;
	}

}
