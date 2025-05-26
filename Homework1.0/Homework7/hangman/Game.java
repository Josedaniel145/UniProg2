package hangman;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Game extends JFrame {
// GUI components
	protected JLabel wordLabel, attemptsLabel, timeLabel;
	protected JTextField inputField;
// The word the player has to guess (fixed for now)
	protected String currentWord = "example ";
// Stores the letters guessed by the player
	protected ArrayList<Character> guessedLetters = new ArrayList<>();
// Number of tries left
	protected int attemptsLeft = 6;
// Time left (not yet functional – stays at 60)
	protected int timeLeft = 60;

// Sets up the window and its components
	public Game() {
		setTitle(" Hangman Game ");
		setSize(400, 250);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(6, 1));
// Button to start a new game
		JButton startButton = new JButton(" Start Game ");
		add(startButton);
// Label showing the guessed word with _ for unknown letters
		wordLabel = new JLabel(" Word: ", SwingConstants.CENTER);
		add(wordLabel);
// Label showing how many tries are left
		attemptsLabel = new JLabel(" Attempts left: " + attemptsLeft, SwingConstants.CENTER);
		add(attemptsLabel);
// Label showing the time left (not yet changing)
		timeLabel = new JLabel(" Time left: " + timeLeft, SwingConstants.CENTER);
		add(timeLabel);
// Input field where the player types their guess
		inputField = new JTextField();
		inputField.setHorizontalAlignment(JTextField.CENTER);
		inputField.setEnabled(false); // initially inactive
		add(inputField);
// Starts the game when button is clicked and disables restart
		startButton.addActionListener(e -> {
			startGame();
			startButton.setEnabled(false);
		});
// You will implement this method
		inputField.addActionListener(e ->processInput());
		processInput();
		setVisible(true);
		updateDisplay();
		
	}

// Resets game state when starting a new game
	protected void startGame() {
		guessedLetters.clear();
		attemptsLeft = 6;
		timeLeft = 60;
		updateDisplay();
		inputField.setEnabled(true);
		inputField.requestFocus();
		updateDisplay();
		inputField.setEnabled(true);
		inputField.requestFocus();
	}

//Updates the word , attempts , and time on the screen
	protected void updateDisplay() {
		StringBuilder display = new StringBuilder();
		for (char c : currentWord.toCharArray()) {
			if (guessedLetters.contains(c)) {
				display.append(c).append(" ");
			} else {
				display.append("_ ");
			}
		}
		wordLabel.setText(" Word: " + display.toString());
		attemptsLabel.setText(" Attempts left: " + attemptsLeft);
		timeLabel.setText(" Time left: " + timeLeft);
	}

	/*
	 * TODO Task 1: Add ActionListener for keyboard input on inputField and process
	 * the input
	 */
	public void processInput() {
		String inputText= inputField.getText().toLowerCase();
		inputField.setText("");
		if(inputText.length() !=1) {
			System.out.println("Please enter exactly one letter.");
			return;
		}
		
		char guessedChar = inputText.charAt(0);
//You will implement this
		if(!Character.isLetter(guessedChar)) {
			System.out.println("Please enter exctly one letter. ");
			return;
		}
		handleGuess(guessedChar);
	}

	/*
	 * TODO Task 1: Check if the guessed letter is in the word and handle result
	 */
	protected void handleGuess(char guess) {
		if (guessedLetters.contains(guess)) {
			System.out.println("You have already guessed the letter " + guess + " Try a different one" );
			return;
		}
		guessedLetters.add(guess);
		if(currentWord.indexOf(guess) == -1) {
			attemptsLeft--;
		}
		updateDisplay();
		if(hasWon()) {
			endGame(true);
			
		}else if( attemptsLeft <=0) {
			endGame(false);
		}
//You will implement this
	}

	/*
	 * TODO Task 1: Check if the player has guessed all letters correctly
	 */
	private boolean hasWon() {
		for(char c : currentWord.toCharArray()){
			if(!guessedLetters.contains(c)){
				return false;// You will implement this
			}
		}
		return true;
	}

// TODO Task 1: End the game and show a message
	protected void endGame(boolean won) {
		String message;
		if(won) {
			message = "Congrats, you won!";
		}else {
			message = "Game Over!";
			
		}
		System.out.println(message);
		inputField.setEnabled(false); 
		System.exit(0);
// You will implement this
	}
}