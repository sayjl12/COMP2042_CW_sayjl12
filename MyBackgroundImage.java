package p4_group_8_repo;

import javafx.scene.image.Image;

public class MyBackgroundImage extends Actor {

	@Override
	public void act(long now) {

	}

	public MyBackgroundImage(String imageLink) {
		setImage(new Image(imageLink, 600, 650, false, true));

	}

}
