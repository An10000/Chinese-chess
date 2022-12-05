package View;

import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.stage.Stage;
import javafx.util.Duration;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Timer {

	private int roundTime;
	private Viewer viewer;
	private Stage stage;
	private String curr_round;
	private int counter;
	private int count;

	/**
	 * The constructor of Timer.
	 * @param time  An integer that represents the duration of each round in second.
	 * @param viewer  The viewer that is used to visualize the game.
	 * @param stage  The stage that is used to build visualization.
	 */
	public Timer(int time, Viewer viewer, Stage stage) {
		this.roundTime = time;
		this.viewer = viewer;
		this.curr_round = viewer.getRound();
		this.counter = time;
		this.stage = stage;
		this.count = 0;
		countDown();
	}

	/**
	 * The method will create a new timeline to countdown.
	 */
	private void countDown() {
		Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.25), e -> updateTime()));
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
	}

	/**
	 * The method will update the current time that the player has,
	 * and notify the viewer about the change of time.
	 */
	private void updateTime() {
		if (!viewer.checkEnd()) {
			count++;
			System.out.println(count);
			if (count == 4) {
				System.out.println("run!");
				counter--;
				count = 0;
				System.out.println(counter);
			}
			if (counter == 0) {
				viewer.nextRound();
				counter = roundTime;
			}
			else if (!curr_round.equals(viewer.getRound())) {
				counter = roundTime;
				curr_round = viewer.getRound();
			}
		}
	}

	/**
	 * Return the remaining time of current round in second.
	 * @return counter
	 */
	public int getCounter() {
		return counter;
	}

}