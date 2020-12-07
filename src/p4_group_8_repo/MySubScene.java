package p4_group_8_repo;

import javafx.animation.TranslateTransition;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.util.Duration;

/**
 * This class create the subscene of the game and control the movement of the subscene.
 * 
 * @author User
 * @see SubScene
 *
 */
public class MySubScene extends SubScene {

	private static final String backgroundImage = "file:src/p4_group_8_repo/GreenPanel.png";

	/**
	 * Class constructor.
	 * Set the desired subscene's image and position throughout the game.
	 * @param num determine which subscene to be created
	 */
	public MySubScene(int num) {
		super(new AnchorPane(), 600, 650);
		prefWidth(600);
		prefHeight(650);

		if (num == 1) {
			BackgroundImage image = new BackgroundImage(new Image(backgroundImage, 470, 450, false, true),
					BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
			AnchorPane root = (AnchorPane) this.getRoot();
			root.setBackground(new Background(image));

			setLayoutX(-470);
			setLayoutY(200);
		}

		if (num == 2) {
			BackgroundImage image = new BackgroundImage(new Image(backgroundImage, 300, 450, false, true),
					BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
			AnchorPane root = (AnchorPane) this.getRoot();
			root.setBackground(new Background(image));

			setLayoutX(-384);
			setLayoutY(150);
		}

		if (num == 3) {
			BackgroundImage image = new BackgroundImage(new Image(backgroundImage, 470, 450, false, true),
					BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
			AnchorPane root = (AnchorPane) this.getRoot();
			root.setBackground(new Background(image));

			setLayoutX(-470);
			setLayoutY(150);
		}
		if (num == 4) {
			BackgroundImage image = new BackgroundImage(new Image(backgroundImage, 300, 200, false, true),
					BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
			AnchorPane root = (AnchorPane) this.getRoot();
			root.setBackground(new Background(image));

			setLayoutX(-384);
			setLayoutY(220);
		}
	}

	/**
	 * Move the subscene created to be shown to the user.
	 */
	public void moveSubScene() {
		TranslateTransition tt = new TranslateTransition();
		tt.setDuration(Duration.millis(50));
		tt.setNode(this);
		tt.setByX(529);
		tt.play();
	}

	/**
	 * Move the subscene back to the original position to hide the subscene.
	 */
	public void moveBackSubScene() {
		TranslateTransition tt = new TranslateTransition();
		tt.setDuration(Duration.millis(50));
		tt.setNode(this);
		tt.setByX(-529);
		tt.play();
	}

	/**
	 * Access to the root of the subscene in Anchor Pane.
	 * @return root of the subscene
	 */
	public AnchorPane getPane() {
		return (AnchorPane) this.getRoot();
	}

}
