package exercise3;

public class Movie {
	private String title;
	private double rating; 
	private int year;
	
	public Movie(String title, double rating, int year) {
		this.title = title;
		this.rating = rating;
		this.year = year;
	}
	
	public String getTitle() {
		return title;
	}
	
	public double getRating() {
		return rating;
	}
	
	public int getYear() {
		return year; 
	}
	@Override
	public String toString() {
		return "Movie{" + "title'" + title + '\'' + "rating=" + rating + ", year=" + year + '}';
	}

}
