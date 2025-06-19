package exercise3;
import java.util.Comparator;
import java.util.List;

public class Main3 {
	public static void main(String[] args) {
		List<Movie> movies = List.of(
				new Movie("The Shawshank Redemption", 9.3, 1994),
	            new Movie("Pulp Fiction", 8.9, 1994),
	            new Movie("The Godfather", 9.2, 1972),
	            new Movie("Inception", 8.8, 2010),
	            new Movie("The Dark Knight", 9.0, 2008),
	            new Movie("Forrest Gump", 8.8, 1994),
	            new Movie("Fight Club", 8.8, 1999),
	            new Movie("Parasite", 8.5, 2019),
	            new Movie("The Lion King", 8.5, 1994)
				
				);
		
		System.out.println("Highly-rated movies, sorted by year(asc) then rating(desc):");
		movies.stream().filter(movie -> movie.getRating() >= 8.5).sorted(Comparator.comparing(Movie::getYear).thenComparing(Comparator.comparing(Movie::getRating).reversed())).forEach(System.out::println);
	}

}
