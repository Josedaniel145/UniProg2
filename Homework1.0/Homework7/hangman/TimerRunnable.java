package hangman;

import javax.swing.SwingUtilities;

public class TimerRunnable implements Runnable {
	private final Timer gameInstance;
	protected boolean timerRunning;

	public TimerRunnable(Timer game) {
		this.gameInstance = game;
	}

	@Override
	public void run() {
// TODO: Implement the countdown loop
// - Decrease timeLeft every second
// - Update the time label using SwingUtilities . invokeLater ()
// - End the game if time runs out
		
		try {
			while (gameInstance.timerRunning && gameInstance.timeLeft > 0) {
				Thread.sleep(1000);
				if(!gameInstance.timerRunning) break;
				gameInstance.timeLeft--;
				SwingUtilities.invokeLater(()->{
					gameInstance.updateDisplay();
				});
			}
		 if(gameInstance.timerRunning && gameInstance.timeLeft <= 0) {
			timerRunning = false;
			SwingUtilities.invokeLater(()->{
				System.out.println("Time's up!");
				gameInstance.endGame(false);
			});
		}
	} catch(InterruptedException e) {
		gameInstance.timerRunning = false;
		System.out.println("Timer thread interrupted and stopped");
	}
}
}
