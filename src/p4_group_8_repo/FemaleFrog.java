package p4_group_8_repo;

import javafx.scene.image.Image;

/**
 * This class represent and create a female frog sprite which might need to escort back to the frog's home.
 * @author User
 * @see Actor
 *
 */
public class FemaleFrog extends Actor{
	
	Image fFrogLeftJump, fFrogRightJump, fFrogLeft, fFrogRight;
	private double speed;
	
	/**
	 * Override the abstract method from Actor class.
	 * Create an animated female frog.
	 */
	@Override
	public void act(long now) {
		
		if (now / 900000000 % 4 == 0) {
			move(0.2,0);
			setImage(fFrogRightJump);
		} else if (now / 900000000 % 4 == 1) {
			setImage(fFrogRight);
		} else if(now / 900000000 % 4 == 2) {
			move(-0.2,0);
			setImage(fFrogLeftJump);
		} else if (now / 900000000 % 4 == 3) {
			setImage(fFrogLeft);
		}
		move(speed, 0);
		if (getX() > 600 && speed > 0)
			setX(-180);
		if (getX() < -300 && speed < 0)
			setX(700);
		
	}
	
	/**
	 * Class constructor.
	 * Set the image, position and speed of the female frog sprite.
	 * @param xpos x coordinate of the female frog
	 * @param ypos y coordinate of the female frog
	 * @param s speed of the female frog
	 */
	public FemaleFrog(int xpos, int ypos, double s) {
		fFrogLeft = new Image("file:src/p4_group_8_repo/FFroggerLeft.png", 30, 30, true, true);
		fFrogRight = new Image("file:src/p4_group_8_repo/FFroggerRight.png", 30, 30, true, true);
		fFrogLeftJump = new Image("file:src/p4_group_8_repo/FFroggerLeftJump.png", 30, 30, true, true);
		fFrogRightJump = new Image("file:src/p4_group_8_repo/FFroggerRightJump.png", 30, 30, true, true);
		
		setX(xpos);
		setY(ypos);
		speed = s;
	}
	
	/**
	 * Set the female frog images into null from its actual position, if the female frog is carried by the green frog.
	 * This is to show the female frog is being carried and no longer in its actual position.
	 */
	public void carried() {
		fFrogLeft = new Image("file:src/p4_group_8_repo/null.png", 30, 30, true, true);
		fFrogRight = new Image("file:src/p4_group_8_repo/null.png", 30, 30, true, true);
		fFrogLeftJump = new Image("file:src/p4_group_8_repo/null.png", 30, 30, true, true);
		fFrogRightJump = new Image("file:src/p4_group_8_repo/null.png", 30, 30, true, true);
		setImage(null);
	}

}
