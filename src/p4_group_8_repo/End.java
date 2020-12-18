package p4_group_8_repo;

import javafx.scene.image.Image;

/**
 * This class represent and create the home of the frog which need to occupied by the frog.
 * @author User
 * @see Actor
 *
 */
public class End extends Actor {
	boolean activated = false;

	/**
	 * Null method
	 * @param now The timestamp of the current frame in nanoseconds.
	 */
	@Override
	public void act(long now) {

	}

	/**
	 * Class constructor.
	 * Set image and position of the frog's home.
	 * 
	 * @param x x coordinate of the home.
	 * @param y y coordinate of the home.
	 */
	public End(int x, int y) {
		setX(x);
		setY(y);
		setImage(new Image("file:src/p4_group_8_repo/Transparent.png", 58, 58, true, true));

	}

	/**
	 * Set the image of home when the frog reached the home.
	 */
	public void setEnd() {
		setImage(new Image("file:src/p4_group_8_repo/FrogEnd1.png", 52.5, 52.5, true, true));
		activated = true;
	}

	/**
	 * Check if the home is occupied by the frog.
	 * @return true if occupied else false
	 */
	public boolean isActivated() {
		return activated;
	}

}
