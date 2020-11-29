package p4_group_8_repo;

import javafx.scene.image.Image;

public class Crocodile extends Actor {
	
	Image crocodileO, crocodileC;
	private double speed;
	
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
	
	public Crocodile(int xpos, int ypos, double s, int w, int h) {
		crocodileO = new Image("file:src/p4_group_8_repo/CrocodileO.png", w, h, true, true);
		crocodileC = new Image("file:src/p4_group_8_repo/CrocodileC.png", w, h, true, true);
		
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage (crocodileO);
		
	}
	
	public boolean getSpeed() {
		return speed ==0.75 ;
	}

}
