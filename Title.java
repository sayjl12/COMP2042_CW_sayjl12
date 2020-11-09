package p4_group_8_repo;

import javafx.scene.image.Image;

public class Title extends Actor {

	public Title(int size, int xpos, int ypos) {
		setImage(new Image("file:src/p4_group_8_repo/titleimage.png", size, size, true, true));
		setX(xpos);
		setY(ypos);
	}

	@Override
	public void act(long now) {
		// TODO Auto-generated method stub

	}
}
