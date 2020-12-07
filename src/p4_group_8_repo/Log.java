package p4_group_8_repo;

import javafx.scene.image.Image;

/**
 * This class creates a log sprite in the game.
 * @author User
 * @see Actor
 * 
 */
public class Log extends Actor {

	private double speed;

	/**
	 * Override abstract method from Actor Class.
	 * Set the speed of the animated log sprite.
	 */
	@Override
	public void act(long now) {
		move(speed, 0);
		if (getX() > 600 && speed > 0)
			setX(-180);
		if (getX() < -300 && speed < 0)
			setX(700);
	}

	/**
	 * Class constructor.
	 * Set the image, position and speed for the log sprite.
	 * 
	 * @param imageLink the file location of the log sprite
	 * @param size the size of the log image
	 * @param xpos x coordinate of the log sprite
	 * @param ypos y coordinate of the log sprite
	 * @param s speed of the log sprite
	 */
	public Log(String imageLink, int size, int xpos, int ypos, double s) {
		setImage(new Image(imageLink, size, size, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
	}

	/**
	 * Check if the log move to the left
	 * @return true if the log move to the left else false
	 */
	public boolean getLeft() {
		return speed < 0;
	}
}
