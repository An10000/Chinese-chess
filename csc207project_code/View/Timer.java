package View;

import javax.swing.text.View;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import javafx.stage.Stage;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Timer {

	private int roundTime;
	private Viewer viewer;
	private Stage stage;
	private String curr_round;
	private int counter;

	public Timer(int time, Viewer viewer, Stage stage) {
		this.roundTime = time;
		this.viewer = viewer;
		this.curr_round = viewer.getRound();
		this.counter = time;
		this.stage = stage;
		countDown();
	}

	private void countDown() {
		final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
		final Runnable runnable = new Runnable() {
			int countdownStarter = roundTime;

			public void run() {
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

				stage.setOnCloseRequest(event -> {
					scheduler.shutdown();
				});
			}
		};
		scheduler.scheduleAtFixedRate(runnable, 0, 1, SECONDS);

	}

	public int getCounter() {
		return counter;
	}

}