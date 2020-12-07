package p4_group_8_repo;

import javafx.scene.image.Image;

/**
 * This class creates obstacles such as cars, trucks and sport cars.
 * 
 * @author User
 * @see Actor
 *
 */
public class Obstacle extends Actor {
	private int speed;

	/**
	 * Override abstract method from Actor Class.
	 * Set the speed of the animated obstacles sprite.
	 */
	@Override
	public void act(long now) {
		move(speed, 0);
		if (getX() > 600 && speed > 0)
			setX(-200);
		if (getX() < -50 && speed < 0)
			setX(600);
	}

	/**
	 * Class constructor.
	 * Set the image, position and speed for the obstacle.
	 * 
	 * @param imageLink file location of the obstacle image
	 * @param xpos x coordinate of the obstacle
	 * @param ypos y coordinate of the obstacle
	 * @param s speed of the obstacle
	 * @param w width of the obstacle's image size
	 * @param h height of the obstacle's image size
	 */
	public Obstacle(String imageLink, int xpos, int ypos, int s, int w, int h) {
		setImage(new Image(imageLink, w, h, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
	}

}
