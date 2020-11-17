package p4_group_8_repo;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Font;

public class MyButton extends Button{
	
	DropShadow shadow = new DropShadow();
	
	public MyButton() {
	}

	public MyButton(String text, String font, int fontSize,String backgroundColor) {
		setPrefWidth(200);
		setText(text);
		setFont(Font.font(font, fontSize));
		setStyle("-fx-background-color:"+backgroundColor);
	}
	
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
	
	public void mouseClicked() {
		setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				AudioClip ac = new AudioClip("file:src/p4_group_8_repo/multimedia_button_click_004.mp3");
				ac.play();
			}
		});
	}
}
