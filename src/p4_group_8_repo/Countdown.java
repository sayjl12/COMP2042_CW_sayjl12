package p4_group_8_repo;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.util.Duration;

/**
 * This class is to create a countdown timer for each level
 * @author User
 *
 */
public class Countdown{
	Timeline timeline;
	static final Integer STARTTIME = 30;
	private Label timerLabel = new Label();
	IntegerProperty timeSeconds = new SimpleIntegerProperty(STARTTIME);
	
	/**
	 * Class constructor. 
	 * Set a label to display the timer.
	 * Set countdown by using Timeline.
	 * 
	 * @param background background stage for the screen
	 * @param animal the frog sprite
	 */
	public Countdown(MyStage background, Animal animal) {
		timerLabel.textProperty().bind(timeSeconds.asString());
	    timerLabel.setTextFill(Color.RED);
	    timerLabel.setStyle("-fx-font-size: 2.5em;");
	    timerLabel.setTranslateY(605);
	    timerLabel.setTranslateX(550);
 
		if (timeline != null) {
	        timeline.stop();
	    }
	    timeSeconds.set(STARTTIME);
	    timeline = new Timeline();
	    timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(STARTTIME+1),new KeyValue(timeSeconds, 0)));
	    timeline.playFromStart();
	    background.getChildren().add(timerLabel);
	   
	    timeline.setOnFinished(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				animal.numOfLives--;
				resetTimer();
				
			}   	
	    });
	    
	    
	}
	
	/**
	 * This is to reset the countdown timer every time it reaches 0
	 */
	public void resetTimer() {
		if (timeline != null) {
			timeline.stop();
		}
		    timeSeconds.set(STARTTIME);
		    timeline.getKeyFrames().add(
		            new KeyFrame(Duration.seconds(STARTTIME+1),
		            new KeyValue(timeSeconds, 0)));
		    timeline.playFromStart();
		
	}
}
