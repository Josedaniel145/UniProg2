package exercise2;

import java.util.Scanner;

public class AnagramChecker {
	/**
	 * Returns true if the two strings are anagrams of each other.
	 */
	public static boolean isAnagram(String a, String b) {
// TODO: implement using countLetters ()
		if(a.length() !=b.length()) {
			return false;
		}
		int[] countsA = countLetters(a);
		int[] countsB = countLetters(b);
		for (int i=0; i <26; i++) {
			if (countsA[i] != countsB[i]) {
				return false;
			}
			
		}
		return true; 
	}

	/**
	 * Helper method to count how many times each letter (a-z) appears.
	 */
	public static int[] countLetters(String s) {
		int[] counts = new int[26]; // Each element automatically starts at 0. Index 0 will count 'a's, index 1 will count 'b's, ..., index 25 will count 'z's.
		for(int i=0; i < s.length(); i++) {
			char currentCharacter =s.charAt(i);
			if (currentCharacter >= 'a' && currentCharacter <= 'z') {
				int index = currentCharacter - 'a'; // 'a' - 'a' is 0, 'b' - 'a'  is 1
				counts[index]++; //increment the count for a letter.
			}
		}
// TODO: fill array with letter frequencies
		return counts;
	}

	/**
	 * Print only letters that appear in the string with their counts.
	 */
	public static void printLetterCounts(String s) {
// TODO: implement nicely formatted output
		int [] counts = countLetters(s);
		for (int i =0; i  <26; i ++) {
			int count = counts[i];
			if (count > 0) {
				char letter = (char)('a' + i);
				System.out.println(letter + ": " + count);
						
			}
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
// Get two strings from the user
		System.out.print(" Enter the first string: ");
		String word1 = scanner.nextLine();
		System.out.print(" Enter the second string: ");
		String word2 = scanner.nextLine();
// TODO: Process the strings here (ignore spaces , case)
		String processed1 = word1.toLowerCase().replaceAll("\\s+", "");
		String processed2 = word2.toLowerCase().replaceAll("\\s+", "");
		
		System.out.println(" Are they anagrams? " + isAnagram(word1, word2));
		printLetterCounts(processed1);
		scanner.close();
	}
}