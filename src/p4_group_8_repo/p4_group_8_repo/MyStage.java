package p4_group_8_repo;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * This class set the stage of the scene.
 * 
 * @author User
 * @see World
 *
 */
public class MyStage extends World {
	MediaPlayer mediaPlayer;

	/**
	 * Null method
	 */
	@Override
	public void act(long now) {
	}

	/**
	 * Class constructor.
	 * 
	 */
	public MyStage() {
		
	}

	/**
	 * Set the background music to be played in the game screen.
	 */
	public void playMusic() {
		String musicFile = "src/p4_group_8_repo/Frogger Main Song Theme (loop).mp3";
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		mediaPlayer.play();
	}

	/**
	 * Set the background music to be played in the main menu screen.
	 */
	public void playMainMenuMusic() {
		String musicFile = "src/p4_group_8_repo/02 Opening.mp3";
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		mediaPlayer.play();
	}

	/**
	 * Stop the music being played.
	 */
	public void stopMusic() {
		mediaPlayer.stop();
	}

}
