package p4_group_8_repo;

import javafx.scene.image.Image;

/**
 * This class creates a turtle sprite which able to sunk into the river.
 * 
 * @author User
 * @see Actor
 *
 */
public class WetTurtle extends Actor {
	Image turtle1;
	Image turtle2;
	Image turtle3;
	Image turtle4;
	private int speed;
	int i = 1;
	boolean bool = true;
	boolean sunk = false;

	/**
	 * Override the abstract method from Actor Class.
	 * Set an animated turtle sprite in the game which able to sunk into river.
	 */
	@Override
	public void act(long now) {

		if (now / 900000000 % 4 == 0) {
			setImage(turtle2);
			sunk = false;

		} else if (now / 900000000 % 4 == 1) {
			setImage(turtle1);
			sunk = false;
		} else if (now / 900000000 % 4 == 2) {
			setImage(turtle3);
			sunk = false;
		} else if (now / 900000000 % 4 == 3) {
			setImage(turtle4);
			sunk = true;
		}

		move(speed, 0);
		if (getX() > 600 && speed > 0)
			setX(-200);
		if (getX() < -75 && speed < 0)
			setX(600);
	}

	/**
	 * Class constructor.
	 * Set the image, position, speed and number of turtles sprite.
	 * 
	 * @param n the number of turtle sprite
	 * @param xpos x coordinate of the turtle sprite
	 * @param ypos y coordinate of the turtle sprite
	 * @param s speed of the turtle sprite
	 * @param w width of the turtle image size
	 * @param h height of the turtle image size
	 */
	public WetTurtle(int n, int xpos, int ypos, int s, int w, int h) {
		
		if (n==3) {
			turtle1 = new Image("file:src/p4_group_8_repo/TurtleAnimation1.png", w, h, true, true);
			turtle2 = new Image("file:src/p4_group_8_repo/TurtleAnimation2Wet.png", w, h, true, true);
			turtle3 = new Image("file:src/p4_group_8_repo/TurtleAnimation3Wet.png", w, h, true, true);
			turtle4 = new Image("file:src/p4_group_8_repo/TurtleAnimation4Wet.png", w, h, true, true);
		}
		
		if(n==2) {
			turtle1 = new Image("file:src/p4_group_8_repo/TurtleAnimation21.png", w, h, true, true);
			turtle2 = new Image("file:src/p4_group_8_repo/TurtleAnimation22Wet.png", w, h, true, true);
			turtle3 = new Image("file:src/p4_group_8_repo/TurtleAnimation23Wet.png", w, h, true, true);
			turtle4 = new Image("file:src/p4_group_8_repo/TurtleAnimation24Wet.png", w, h, true, true);
		}
		
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(turtle2);
	}

	/**
	 * Check if the turtle is sunk into the river.
	 * 
	 * @return true if sunk else false
	 */
	public boolean isSunk() {
		return sunk;
	}
}
