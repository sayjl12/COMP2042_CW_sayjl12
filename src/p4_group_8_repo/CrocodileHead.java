package p4_group_8_repo;

import javafx.scene.image.Image;

public class CrocodileHead extends Actor{
	
	Image crocodileHO, crocodileHC;
	private double speed;
	
	@Override
	public void act(long now) {
		if (now / 900000000 % 2 == 0) {
			setImage(crocodileHO);

		} else if (now / 900000000 % 2 == 1) {
			setImage(crocodileHC);
		}

		move(speed, 0);
		if (getX() > 600 && speed > 0)
			setX(-200);
		if (getX() < -75 && speed < 0)
			setX(600);		
	}
	
	public CrocodileHead(int xpos, int ypos, double s, int w, int h) {
		crocodileHO = new Image("file:src/p4_group_8_repo/CrocodileHO.png", w, h, true, true);
		crocodileHC = new Image("file:src/p4_group_8_repo/CrocodileHC.png", w, h, true, true);
		
		setX(xpos+92);
		setY(ypos);
		speed = s;
		setImage (crocodileHO);
		
	}
	
}
