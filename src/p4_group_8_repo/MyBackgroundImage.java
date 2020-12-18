package p4_group_8_repo;

import javafx.scene.image.Image;

/**
 * Set the Background Image of the game.
 * 
 * @author User
 * @see Actor
 *
 */
public class MyBackgroundImage extends Actor {

	/**
	 * Null method
	 */
	@Override
	public void act(long now) {

	}

	/**
	 * Class constructor.
	 * Set the background image for the screen.
	 * @param imageLink file location of the background image
	 */
	public MyBackgroundImage(String imageLink) {
		setImage(new Image(imageLink, 600, 650, false, true));

	}

}