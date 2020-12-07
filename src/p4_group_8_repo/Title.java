package p4_group_8_repo;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * This class set the title of the game.
 * @author User
 * @see ImageView
 *
 */
public class Title extends ImageView {

	/**
	 * Class constructor.
	 * Set the image and position of the game title.
	 */
	public Title() {
		setImage(new Image("file:src/p4_group_8_repo/titleimage.png", 500, 500, true, true));
		setX(50);
		setY(125);
	}
}
