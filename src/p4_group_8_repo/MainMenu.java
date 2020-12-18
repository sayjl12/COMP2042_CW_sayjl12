package p4_group_8_repo;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This class creates a Main Menu screen for the game.
 * 
 * @author User
 * @see Application
 *
 */
public class MainMenu extends Application {
	
	MyStage background;
	private MySubScene howToPlaySubScene;
	List<MyButton> mainMenuButtons;

	/**
	 * Override the method by adding the background image and stage properties for the main menu screen/
	 * 
	 */
	@Override
	public void start(Stage stage) {
		mainMenuButtons = new ArrayList<>();
		
		background = new MyStage();
		Scene scene = new Scene(background, 600, 650);
		
		MyBackgroundImage bImage = new MyBackgroundImage("file:src/p4_group_8_repo/mainmenu.jpg");
		background.add(bImage);
		
		stage.setMaxWidth(614);
		stage.setMaxHeight(687);
		
		stage.setTitle("Frogger");
		stage.setScene(scene);
		stage.show();
		
		background.playMainMenuMusic();
		
		addTitle();
		createStartButton();
		createHowToPlayButton();
		createExitButton();
		createHowToPlaySubScene();
	}

	/**
	 * Add the button into the screen.
	 * 
	 * @param button specific button
	 */
	public void addButton(MyButton button) {
		button.setLayoutX(200);
		button.setLayoutY(430 + mainMenuButtons.size() * 65);
		mainMenuButtons.add(button);
		background.getChildren().add(button);
	}

	/**
	 * Create a Start Button with Functions
	 */
	public void createStartButton() {
		MyButton btnStart = new MyButton("START",25);
		btnStart.addButtonFunction();
		btnStart.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				Main maingame = new Main(1);
				background.getScene().setRoot(maingame.getBackground());
				background.stopMusic();
			}
		});
		addButton(btnStart);
	}

	/**
	 * Create a How To Play Button with Functions
	 */
	public void createHowToPlayButton() {
		MyButton btnHowToPlay = new MyButton("HOW TO PLAY",25);
		btnHowToPlay.addButtonFunction();
		btnHowToPlay.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				howToPlaySubScene.moveSubScene();
			}
		});
		addButton(btnHowToPlay);
	}

	/**
	 * Create an Exit Button with Functions.
	 */
	public void createExitButton() {
		MyButton btnExit = new MyButton("EXIT",25);
		btnExit.addButtonFunction();
		btnExit.setOnAction(event -> Platform.exit());
		addButton(btnExit);
	}

	/**
	 * Create a subscene of How To Play Information.
	 */
	public void createHowToPlaySubScene() {
		howToPlaySubScene = new MySubScene(1);
		background.getChildren().add(howToPlaySubScene);

		howToPlaySubScene.getPane().getChildren().add(createSubSceneBackButton());
		howToPlaySubScene.getPane().getChildren().add(new HowToPlayInfo());
	}

	/**
	 * Create a back button for the subscenes.
	 * @return a back button
	 */
	public MyButton createSubSceneBackButton() {
		MyButton btnBack = new MyButton("file:src/p4_group_8_repo/BackButton2.png",380,29);
		btnBack.addButtonFunction();
		btnBack.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				howToPlaySubScene.moveBackSubScene();
			}
		});
		return btnBack;
	}
	
	/**
	 * Add a game title to the main menu screen.
	 */
	public void addTitle() {
		background.getChildren().add(new Title());
	}

	/**
	 * Main method which run the game.
	 * @param args command line arguments
	 */
	public static void main(String args[]) {
		launch(args);
	}
}
