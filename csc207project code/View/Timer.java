package View;

import javax.swing.text.View;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Timer {

	private int roundTime;
	private Viewer viewer;

	private String curr_round;
	private int counter;

	public Timer(int time, Viewer viewer) {
		this.roundTime = time;
		this.viewer = viewer;
		this.curr_round = viewer.getRound();
		this.counter = time;
		countDown();
	}

	public void countDown() {
		final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
		final Runnable runnable = new Runnable() {
			int countdownStarter = roundTime;

			public void run() {

				viewer.drawTimer(Timer.this);
				counter = countdownStarter;
				countdownStarter--;
				if (!Objects.equals(curr_round, viewer.getRound())) {
					countdownStarter = roundTime;
					curr_round = viewer.getRound();
				}

				if (countdownStarter == 0) {
					viewer.nextRound();
					curr_round = viewer.getRound();
					countdownStarter = roundTime;
				}

			}
		};
		scheduler.scheduleAtFixedRate(runnable, 0, 1, SECONDS);
	}

	public int getCounter() {
		return counter;
	}

}