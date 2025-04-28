package a1;
import java.util.Scanner;
public class A2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a word to translate: ");
		String input = scanner.nextLine();
		StringBuilder result = new StringBuilder();
		for (char c: input.toCharArray()) {
			result.append(c);
			if ("aeiouAEIOU".contains(String.valueOf(c))) {
				result.append("s").append(c);
			}
		}
		scanner.close();

		System.out.println("Snake language: " + result);
	} 
}
