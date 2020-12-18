package p4_group_8_repo;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Font;

/**
 * This class create the buttons in the game.
 * 
 * @author User
 * @see Button
 *
 */
public class MyButton extends Button {

	DropShadow shadow = new DropShadow();
	
	/**
	 * Class constructor for text button.
	 * Set the text, font, style and size of the text button.
	 * 
	 * @param text text of the button to be shown
	 * @param font font size of the text button
	 */
	public MyButton(String text, int font) {
		setPrefWidth(200);
		setText(text);
		setFont(Font.font("Berlin Sans FB", font));
		setStyle("-fx-background-color: #8FBC8F");
	}
	
	/**
	 * Class constructor for image button.
	 * Set the image, image size, style and position of the image button.
	 * 
	 * @param text the file location of the image button
	 * @param x x coordinate of the image button
	 * @param y y coordinate of the image button
	 */
	public MyButton(String text, int x, int y) {
		ImageView iv = new ImageView(new Image(text));
		iv.setFitHeight(40);
		iv.setFitWidth(40);
		setGraphic(iv);
		setStyle("-fx-background-color: transparent");
		setLayoutX(x);
		setLayoutY(y);
	}
	
	/**
	 * Set the image button into play image button.
	 */
	public void setPlay() {
		ImageView iv2 = new ImageView(new Image("file:src/p4_group_8_repo/PlayButton.png"));
		iv2.setFitHeight(40);
		iv2.setFitWidth(40);
		setGraphic(iv2);
	}
	
	/**
	 * Set the image button into pause image button.
	 */
	public void setPause() {
		ImageView iv = new ImageView(new Image("file:src/p4_group_8_repo/PauseButton.png"));
		iv.setFitHeight(40);
		iv.setFitWidth(40);
		setGraphic(iv);
	}

	/**
	 * Set the properties of the button when the mouse pointer enter into the button region.
	 */
	public void mouseEntered() {
		setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				AudioClip ac = new AudioClip("file:src/p4_group_8_repo/steven_hammon_multimedia_rollover_tone.mp3");
				ac.play();
				setScaleX(1.1);
				setScaleY(1.1);
				setEffect(shadow);

			}
		});
	}

	/**
	 * Set the properties of the button when the mouse pointer exited from the button region.
	 */
	public void mouseExited() {
		setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				setScaleX(1);
				setScaleY(1);
				setEffect(null);
			}
		});
	}

	/**
	 * Set the properties of the button when the button is clicked by the mouse pointer.
	 */
	public void mouseClicked() {
		setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				AudioClip ac = new AudioClip("file:src/p4_group_8_repo/multimedia_button_click_004.mp3");
				ac.play();
			}
		});
	}
	
	/**
	 * Add the button properties to the button.
	 */
	public void addButtonFunction() {
		mouseEntered();
		mouseExited();
		mouseClicked();
	}
}
