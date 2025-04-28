package exercise2;

import java.util.ArrayList;

public class Inbox {
	private Mail[] emails;
	private int count;

	public Inbox(int capacity) {
		emails = new Mail[capacity];
		count = 0;
	}

	public void addMail(Mail m) {
		if (count < emails.length) {
			emails[count++] = m;

		} else {
			System.out.println("Inbox is full!");
		}
	}

	public void printHeaders() {
		for (int i = 0; i < count; i++) {
			Mail m = emails[i];
			boolean status = m.read ? true : false;
			System.out.println(i + ": " + status + " | " + m.subject + " | " + m.sender + " | " + m.date);
		}
	}
	public void open(int index){
		if(index < 0 || index >= count) {
			System.out.print("Invalid index: " + index);
			return;
			
		}
		Mail m = emails[index];
		m.MarkAsRead();
		System.out.println(m.getaFormattedString());
	}
	public int countUnread() {
		int unread = 0;
		for(int i =0; i < count; i++) {
			if(!emails[i].read) {
				unread++;
			}
		}
		return unread;
	}

}
