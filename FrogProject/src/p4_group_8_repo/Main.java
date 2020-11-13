package p4_group_8_repo;

import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

public class Main {
	AnimationTimer timer;
	MyStage background;
	Animal animal;
	boolean isHidden;
	MySubScene menuSubScene, howToPlaySubScene, HScoreSubScene;
	List<MyButton> arrayOfButton;
	Level level1, level2, level;
	String abc;

	public Main(int num) {
		background = new MyStage();
		settingBackground();
		settingLevel(num);

	}

	public MyStage getBackground() {
		return background;
	}

	public void addButton(MyButton button) {
		button.setLayoutX(3);
		button.setLayoutY(8);
		background.getChildren().add(button);
	}

	public void createPauseButton() {
		isHidden = true;
		MyButton btnPause = new MyButton();
		ImageView iv = new ImageView(new Image("file:src/p4_group_8_repo/PauseButton.png"));
		ImageView iv2 = new ImageView(new Image("file:src/p4_group_8_repo/PlayButton.png"));
		iv.setFitHeight(40);
		iv.setFitWidth(40);
		iv2.setFitHeight(40);
		iv2.setFitWidth(40);
		btnPause.setGraphic(iv);
		btnPause.setStyle("-fx-background-color: transparent");
		btnPause.mouseEntered();
		btnPause.mouseExited();
		btnPause.mouseClicked();
		btnPause.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if (isHidden) {
					background.stop();
					menuSubScene.moveSubScene();
					btnPause.setGraphic(iv2);
					isHidden = false;
				} else {
					background.start();
					menuSubScene.moveBackSubScene();
					btnPause.setGraphic(iv);
					isHidden = true;
				}

			}
		});
		addButton(btnPause);
	}

	public void createMenuSubScene() {
		menuSubScene = new MySubScene(2);
		background.getChildren().add(menuSubScene);
		VBox vbox = new VBox(20);
		vbox.setTranslateX(54);
		vbox.setTranslateY(100);
		vbox.getChildren().addAll(createHowToPlayButton(), createHScoreButton(), createExitButton());
		menuSubScene.getPane().getChildren().add(vbox);
	}

	public MyButton createExitButton() {
		MyButton btnExit = new MyButton("EXIT", "Berlin Sans FB", 25, "#8FBC8F");
		btnExit.mouseEntered();
		btnExit.mouseExited();
		btnExit.mouseClicked();
		btnExit.setOnAction(event -> Platform.exit());
		return btnExit;

	}

	public void createHowToPlaySubScene() {
		howToPlaySubScene = new MySubScene(3);
		background.getChildren().add(howToPlaySubScene);

		howToPlaySubScene.getPane().getChildren().add(createSubSceneBackButton(1));
	}

	public MyButton createHowToPlayButton() {
		MyButton btnHowToPlay = new MyButton("HOW TO PLAY", "Berlin Sans FB", 25, "#8FBC8F");
		btnHowToPlay.mouseEntered();
		btnHowToPlay.mouseExited();
		btnHowToPlay.mouseClicked();
		btnHowToPlay.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				menuSubScene.moveBackSubScene();
				howToPlaySubScene.moveSubScene();

			}
		});
		return btnHowToPlay;
	}

	public MyButton createSubSceneBackButton(int num) {
		MyButton btnBack = new MyButton();
		ImageView iv = new ImageView(new Image("file:src/p4_group_8_repo/BackButton2.png"));
		iv.setFitHeight(40);
		iv.setFitWidth(40);
		btnBack.setGraphic(iv);
		btnBack.setStyle("-fx-background-color: transparent");
		btnBack.setLayoutX(380);
		btnBack.setLayoutY(29);
		btnBack.mouseEntered();
		btnBack.mouseExited();
		btnBack.mouseClicked();
		if (num == 1) {
			btnBack.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					howToPlaySubScene.moveBackSubScene();
					menuSubScene.moveSubScene();
				}

			});
		}
		if (num == 2) {
			btnBack.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					HScoreSubScene.moveBackSubScene();
					menuSubScene.moveSubScene();
				}

			});
		}

		return btnBack;
	}

	public MyButton createHScoreButton() {
		MyButton btnHScore = new MyButton("SCORE", "Berlin Sans FB", 25, "#8FBC8F");
		btnHScore.mouseEntered();
		btnHScore.mouseExited();
		btnHScore.mouseClicked();
		btnHScore.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				menuSubScene.moveBackSubScene();
				HScoreSubScene.moveSubScene();

			}
		});
		return btnHScore;
	}

	public void createHScoreSubScene() {
		HScoreSubScene = new MySubScene(3);
		background.getChildren().add(HScoreSubScene);

		HScoreSubScene.getPane().getChildren().add(createSubSceneBackButton(2));
	}

	public void start() {
		// background.playMusic();
		createTimer();
		timer.start();
	}

	public void createTimer() {
		timer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				if (animal.changeScore()) {
					setNumber(animal.getPoints());
				}
				if (animal.getStop()) {
					// background.stopMusic();
					stop();
					background.stop();
					boolean nextLevel = true;
					int currentLevelNumber = level.getLevelNumber();
					if (nextLevel == true) {
						background.getChildren().clear();

						settingBackground();
						int nextLevelNumber = currentLevelNumber + 1;
						settingLevel(nextLevelNumber);

					}
					if (currentLevelNumber == 3) {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("You Have Won The Game!");
						alert.setHeaderText("Your High Score: " + animal.getPoints() + "!");
						alert.setContentText("Highest Possible Score: 800");
						alert.show();
					}

				}
			}
		};
	}

	public void settingLevel(int levelNumber) {
		switch (levelNumber) {
		case 1:
			level = new Level(background, 1);
			break;
		case 2:
			level = new Level(background, 2);
			break;
		case 3:
			level = new Level(background, 3);
			break;
		}

	}

	public void settingBackground() {
		MyBackgroundImage froggerback = new MyBackgroundImage("file:src/p4_group_8_repo/iKogsKW.png");
		background.add(froggerback);

		background.add(new End(15, 77));
		background.add(new End(144, 77));
		background.add(new End(272, 77));
		background.add(new End(399, 77));
		background.add(new End(527, 77));

		animal = new Animal("file:src/p4_group_8_repo/froggerUp.png");
		background.add(animal);

		background.add(new Digit(0, 30, 550, 25));
		background.start();
		start();

		createPauseButton();
		createMenuSubScene();
		createHowToPlaySubScene();
		createHScoreSubScene();

	}

	public void stop() {
		timer.stop();
	}

	public void setNumber(int n) {
		int shift = 0;
		while (n > 0) {
			int d = n / 10;
			int k = n - d * 10;
			n = d;
			background.add(new Digit(k, 30, 560 - shift, 25));

			shift += 22;

		}

	}
}
