package exercise2;

public class Main {
	public static void main(String[] args) {
		Inbox inbox = new Inbox(10);
		inbox.addMail(new Mail("me@ex.com",
	            "Welcome!",
	            "This is your first message.",
	            "2025-04-28 18:00",
	            "alice@wonderland.org"));
		inbox.addMail(new Mail("me@ex.com",
	            "News",
	            "Check out today's physics headlines.",
	            "2025-04-28 18:10",
	            "charlie@chocolate.factory"));
		inbox.addMail(new Mail(
			    "me@ex.com",
			    "Reminder",
			    "Don't forget to review Java basics.",
			    "2025-04-28 18:05",
			    "bob@builder.com"
			));
		System.out.println("Unread messages: " + inbox.countUnread());
		inbox.open(1);
		System.out.println();
		System.out.println("Manually marking message #2 as read. ");
		inbox.printHeaders();
		System.out.println();
		System.out.println("Unread messages now: " + inbox.countUnread());
	}
	
	
	

}
