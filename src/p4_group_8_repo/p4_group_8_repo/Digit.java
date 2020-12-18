package p4_group_8_repo;

import javafx.scene.image.Image;

/**
 * This class display the score throughtout the game.
 * 
 * @author User
 * @see Actor
 *
 */
public class Digit extends Actor {
	int dim;
	Image im1;

	/**
	 * Null method.
	 * 
	 * @param now The timestamp of the current frame in nanoseconds.
	 */
	@Override
	public void act(long now) {

	}

	/**
	 * Class constructor.
	 * Set the image and position of the score.
	 * @param n the score obtained throughout the game.
	 * @param dim the width and height of the score image.
	 * @param x x coordinate of the score image.
	 * @param y y coordinate of the score image.
	 */
	public Digit(int n, int dim, int x, int y) {
		im1 = new Image("file:src/p4_group_8_repo/0" + n + ".png", dim, dim, true, true);
		setImage(im1);
		setX(x);
		setY(y);
	}
}
