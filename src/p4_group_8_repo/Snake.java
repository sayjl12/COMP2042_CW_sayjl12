package p4_group_8_repo;

import java.util.Random;

import javafx.scene.image.Image;

public class Snake extends Actor {
	Image snake1, snake2, snake3, snake4;
	private double speed;
	
	@Override
	public void act(long now) {
		
		if (now / 900000000 % 4 == 0) {
			setImage(snake1);
		} else if (now / 900000000 % 4 == 1) {
			setImage(snake2);
		} else if (now / 900000000 % 4== 2) {
			setImage(snake4);
		} else if (now / 900000000 % 4 == 3) {
			setImage(snake3);
		}

		move(speed, 0);
		if (getX() > 10000 && speed > 0)
			setX(-200);
		if (getX() < -500 && speed < 0)
			setX(600);		
	}
	
	public Snake(int xpos, int ypos) {
		snake1 = new Image("file:src/p4_group_8_repo/snake1.png", 55, 55, true, true);
		snake2 = new Image("file:src/p4_group_8_repo/snake2.png", 55, 55, true, true);
		snake3 = new Image("file:src/p4_group_8_repo/snake3.png", 55, 55, true, true);
		snake4 = new Image("file:src/p4_group_8_repo/snake4.png", 55, 55, true, true);
		
		
		setX(xpos);
		setY(ypos);
		speed = -1;
		setImage (snake1);
		
	}
}
