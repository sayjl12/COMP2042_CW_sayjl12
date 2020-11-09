package p4_group_8_repo;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MainMenu extends Application {
	@Override
	public void start(Stage stage) {
		MyStage background = new MyStage();
		Scene scene = new Scene(background,600,650);
		BackgroundImage bImage = new BackgroundImage("file:src/p4_group_8_repo/mainmenu.jpg");
		stage.setMaxWidth(614);
		stage.setMaxHeight(687);
		background.add(bImage);
		stage.setTitle("Frogger");
		stage.setScene(scene);
		stage.show();
		// background.playMainMenuMusic();
		background.add(new Title(500, 50, 125));

		Button btnStart = new Button("START");
		btnStart.setFont(Font.font("Berlin Sans FB", 28));
		btnStart.setStyle("-fx-background-color: #8FBC8F");
		btnStart.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				AudioClip ac = new AudioClip("file:src/p4_group_8_repo/steven_hammon_multimedia_rollover_tone.mp3");
				ac.play();
				btnStart.setScaleX(1.1);
				btnStart.setScaleY(1.1);
				btnStart.setStyle("-fx-background-color: #6aa66a");

			}
		});
		btnStart.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				btnStart.setScaleX(1);
				btnStart.setScaleY(1);
				btnStart.setStyle("-fx-background-color:#8FBC8F");
			}
		});
		btnStart.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				AudioClip ac = new AudioClip("file:src/p4_group_8_repo/multimedia_button_click_004.mp3");
				ac.play();
			}
		});

		btnStart.setOnAction(event -> {
			Main maingame = new Main();
			stage.getScene().setRoot(maingame.getbackground());
			// background.stopMusic();
		});
		Button btnExit = new Button("EXIT");
		btnExit.setFont(Font.font("Berlin Sans FB", 28));
		btnExit.setStyle("-fx-background-color: #8FBC8F");
		btnExit.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				AudioClip ac = new AudioClip("file:src/p4_group_8_repo/steven_hammon_multimedia_rollover_tone.mp3");
				ac.setCycleCount(1);
				ac.play();
				btnExit.setScaleX(1.1);
				btnExit.setScaleY(1.1);
				btnExit.setStyle("-fx-background-color: #6aa66a");

			}
		});
		btnExit.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				btnExit.setScaleX(1);
				btnExit.setScaleY(1);
				btnExit.setStyle("-fx-background-color:#8FBC8F");
			}
		});
		btnExit.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				AudioClip ac = new AudioClip("file:src/p4_group_8_repo/multimedia_button_click_004.mp3");
				ac.setCycleCount(1);
				ac.play();
			}
		});
		btnExit.setOnAction(event -> Platform.exit());

		VBox vbox = new VBox(35, btnStart, btnExit);
		vbox.setTranslateX(240);
		vbox.setTranslateY(450);
		vbox.setAlignment(Pos.CENTER);
		background.getChildren().add(vbox);

	}

	public static void main(String args[]) {
		launch(args);
	}
}
