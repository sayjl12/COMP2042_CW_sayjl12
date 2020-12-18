package p4_group_8_repo;

import javafx.scene.image.Image;

/**
 * This class creating a crocodile sprite.
 * @author User
 * @see Actor
 */
public class Crocodile extends Actor {
	
	Image crocodileO, crocodileC;
	private double speed;
	
	/**
	 * Override the method to create an animated crocodile sprite.
	 * 
	 * @param now The timestamp of the current frame in nanoseconds.
	 */
	@Override
	public void act(long now) {
		if (now / 900000000 % 2 == 0) {
			setImage(crocodileO);

		} else if (now / 900000000 % 2 == 1) {
			setImage(crocodileC);
		}

		move(speed, 0);
		if (getX() > 600 && speed > 0)
			setX(-200);
		if (getX() < -75 && speed < 0)
			setX(600);
		
	}
	
	/**
	 * Class constructor.
	 * Set the image, position and speed of a crocodile sprite.
	 * 
	 * @param xpos x coordinate of the crocodile sprite.
	 * @param ypos y coordinate of the crocodile sprite.
	 * @param s speed of the crocodile.
	 * @param w width of the crocodile image.
	 * @param h height of the crocodile image.
	 */
	public Crocodile(int xpos, int ypos, double s, int w, int h) {
		crocodileO = new Image("file:src/p4_group_8_repo/CrocodileO.png", w, h, true, true);
		crocodileC = new Image("file:src/p4_group_8_repo/CrocodileC.png", w, h, true, true);
		
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage (crocodileO);
		
	}
	
	/**
	 * Check if the speed of the crocodile equals to 0.75
	 * @return true if speed equals to 0.75 else false
	 */
	public boolean getSpeed() {
		return speed == 0.75 ;
	}

}
