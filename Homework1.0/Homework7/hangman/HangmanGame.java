package hangman;

import javax.swing.SwingUtilities;

public class HangmanGame extends GameGUI implements GameLogic, TimerLogic {
	protected Thread timerThread;
	protected boolean timerRunning;

	public HangmanGame() {
		super();
	}

	@Override
	public void processInput() {
		inputField.addActionListener(e -> {
			String inputText = inputField.getText().toLowerCase();
			inputField.setText("");
			if (inputText.length() != 1) {
				System.out.println("Please enter exactly one letter.");
				return;
			}
			char guessedChar = inputText.charAt(0);
			if (!Character.isLetter(guessedChar)) {
				System.out.println("Please enter exactly one letter.");
			}
			handleGuess(guessedChar);

		});
	}

	@Override
	public void handleGuess(char guess) {
		if (guessedLetters.contains(guess)) {
			System.out.println("You have already guessed the letter " + guess);
			return;
		}
		guessedLetters.add(guess);
		if (currentWord.indexOf(guess) == -1) {
			attemptsLeft--;
		}
		updateDisplay();
		if (hasWon()) {
			endGame(true);
		} else if (attemptsLeft <= 0) {
			endGame(false);
		}

	}

	@Override
	public boolean hasWon() {
		for (char c : currentWord.toCharArray()) {
			if (!guessedLetters.contains(c)) {
				return false;
			}
		}
		return true;

	}

	@Override
	public void endGame(boolean won) {
		if (timerRunning) {
			timerRunning = false;
			if (timerThread != null && timerThread.isAlive()) {
				timerThread.interrupt();

			}
		}
		String message;
		if (won) {
			message = "Congratulations! You won! The word was: " + currentWord;
		} else {
			message = "Game Over! You lost. The word was: " + currentWord;
			if (timeLeft <= 0 && attemptsLeft > 0 && !hasWon()) {
				message = "Time's up! You lost. The word was: " + currentWord;
			}
		}
		System.out.println(message);
		inputField.setEnabled(false);
		System.out.flush();
		System.exit(0);
	}

	@Override
	public void startTimer() {
		if (timerThread != null && timerThread.isAlive()) {
			timerThread.interrupt();
		}
		timerRunning = true;
		timeLeft = 60;
		updateDisplay();
		TimerRunnable runnable = new TimerRunnable(this);
		timerThread = new Thread(runnable);
		timerThread.start();
	}

	@Override
	protected void startGame() {
		super.startGame();
		startTimer();
	}

	private class TimerRunnable implements Runnable {
		private final HangmanGame gameInstance;

		public TimerRunnable(HangmanGame game) {
			this.gameInstance = game;
		}

		@Override
		public void run() {
			try {
				while (gameInstance.timerRunning && gameInstance.timeLeft > 0) {
					Thread.sleep(1000);
					if (!gameInstance.timerRunning)
						break;
					gameInstance.timeLeft--;
					SwingUtilities.invokeLater(() -> gameInstance.updateDisplay());
				}
				if (gameInstance.timerRunning && gameInstance.timeLeft <= 0) {
					timerRunning = false;
					SwingUtilities.invokeLater(() -> {
						if (gameInstance.attemptsLeft > 0 && !gameInstance.hasWon()) {
							gameInstance.endGame(false);
						}
					});
				}
			} catch (InterruptedException e) {
				gameInstance.timerRunning = false;
				System.out.println("Timer thread interrupted and stopped.");
			}
		}
	}
}
