package a1;

import java.util.Scanner;

public class A1 {
	public static void main(String[] args) {
		int numberToGuess = (int) (Math.random() * 20) + 1;
		Scanner scanner = new Scanner(System.in);
		int guess;
		int attempts = 0;
		boolean won = false;
		while (attempts < 5) {
			guess = scanner.nextInt();
			attempts++;
			if (guess == numberToGuess) {
				System.out.println("Correct guessed in " + attempts + " attemps");
				won = true;
				break;
			} else if (guess < numberToGuess) {
				System.out.println("Too Low");
			} else if (guess > numberToGuess) {
				System.out.println("Too High");
			}
		}
		scanner.close();

		if(!won) {
			System.out.println("Out of attempts. The number was: " + numberToGuess);
		}
	}

}
