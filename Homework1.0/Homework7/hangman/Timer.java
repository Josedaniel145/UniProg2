package hangman;

public class Timer extends Game {
	protected Thread timerThread ;
	protected boolean timerRunning ;
	// TODO: Override startGame () to also start the timer
	// TODO: Implement startTimer () to create and start the timer thread
	public Timer() {
		super();
	}
	@Override
	protected void startGame() {
		super.startGame();
		startTimer();
	}
	protected void startTimer() {
		if(timerThread != null && timerThread.isAlive()) {
			timerThread.interrupt();
		}
		timerRunning = true;
		TimerRunnable runnable = new TimerRunnable(this);
		timerThread = new Thread(runnable);
		timerThread.start();
	}

}
