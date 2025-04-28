package exercise2;

public class Mail {
	public String address;
	public String subject;
	public String message;
	public String date;
	public String sender;
	public boolean read;

	public Mail(String address, String subject, String message, String date, String sender) {
		this.address = address;
		this.subject = subject;
		this.message = message;
		this.date = date;
		this.read = false;
		this.sender = sender; 
	}
	
	public void MarkAsRead() {
		this.read = true; 
	}
	
	public String getaFormattedString() {
		return this.subject + " from "+ this.sender + " on "+ this.date + ": " + this.message;
	}

}
