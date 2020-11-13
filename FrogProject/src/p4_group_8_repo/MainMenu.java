package p4_group_8_repo;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class MainMenu extends Application {

	MyStage mainBackground;
	private MySubScene howToPlaySubScene;
	List<MyButton> mainMenuButtons;

	@Override
	public void start(Stage stage) {
		mainMenuButtons = new ArrayList<>();
		MyStage background = new MyStage();
		mainBackground = background;
		Scene scene = new Scene(background, 600, 650);
		MyBackgroundImage bImage = new MyBackgroundImage("file:src/p4_group_8_repo/mainmenu.jpg");
		stage.setMaxWidth(614);
		stage.setMaxHeight(687);
		background.add(bImage);
		stage.setTitle("Frogger");
		stage.setScene(scene);
		stage.show();
		// background.playMainMenuMusic();

		addTitle();
		createStartButton();
		createHowToPlayButton();
		createExitButton();
		createHowToPlaySubScene();
	}

	public MyStage getBackground() {
		return mainBackground;
	}

	public void addButton(MyButton button) {
		button.setLayoutX(200);
		button.setLayoutY(430 + mainMenuButtons.size() * 65);
		mainMenuButtons.add(button);
		mainBackground.getChildren().add(button);
	}

	public void createStartButton() {
		MyButton btnStart = new MyButton("START", "Berlin Sans FB", 25, "#8FBC8F");
		btnStart.mouseEntered();
		btnStart.mouseExited();
		btnStart.mouseClicked();
		btnStart.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				Main maingame = new Main(1);
				mainBackground.getScene().setRoot(maingame.getBackground());
				// mainBackground.stopMusic();
			}
		});
		addButton(btnStart);
	}

	public void createHowToPlayButton() {
		MyButton btnHowToPlay = new MyButton("HOW TO PLAY", "Berlin Sans FB", 25, "#8FBC8F");
		btnHowToPlay.mouseEntered();
		btnHowToPlay.mouseExited();
		btnHowToPlay.mouseClicked();
		addButton(btnHowToPlay);
		btnHowToPlay.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				howToPlaySubScene.moveSubScene();
			}
		});
	}

	public void createExitButton() {
		MyButton btnExit = new MyButton("EXIT", "Berlin Sans FB", 25, "#8FBC8F");
		btnExit.mouseEntered();
		btnExit.mouseExited();
		btnExit.mouseClicked();
		btnExit.setOnAction(event -> Platform.exit());
		addButton(btnExit);
	}

	public void createHowToPlaySubScene() {
		howToPlaySubScene = new MySubScene(1);
		mainBackground.getChildren().add(howToPlaySubScene);

		howToPlaySubScene.getPane().getChildren().add(createSubSceneBackButton());
	}

	public MyButton createSubSceneBackButton() {
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
		btnBack.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				howToPlaySubScene.moveBackSubScene();
			}
		});
		return btnBack;
	}

	public void addTitle() {
		mainBackground.getChildren().add(new Title(500, 50, 125));
	}

	public static void main(String args[]) {
		launch(args);
	}
}
