package p4_group_8_repo;

import javafx.util.Duration;
import java.util.Collection;
import java.util.List;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * This class create the game screen.
 * @author User
 *
 */
public class Main {
	AnimationTimer timer;
	MyStage background;
	Animal animal;
	boolean isHidden,nextLevel;
	MySubScene menuSubScene, howToPlaySubScene, HScoreSubScene, ProceedSubScene, NotProceedSubScene,HScoreSubSceneEnd;
	List<MyButton> arrayOfButton;
	Level level1, level2, level;
	TextField tf;
	ScoreManager sm;
	Lives froglives;
	Countdown countd;

	/**
	 * Class contructor.
	 * Set the game screen with background image, sprite and levels.
	 * 
	 * @param num the number of the level
	 */
	public Main(int num) {
		background = new MyStage();
		
		sm = new ScoreManager();
		
		animal = new Animal("file:src/p4_group_8_repo/froggerUp.png");
		
		
		settingBackground();
		settingLevel(num);
		background.add(new Digit(0, 30, 550, 25));
		background.add(animal);
		createProceedSubScene();
		createMenuSubScene();
		createHowToPlaySubScene();
		createNotProceedSubScene();
		createHScoreSubScene();	
		
	}

	/**
	 * Access to the game screen.
	 * 
	 * @return the game screen 
	 */
	public MyStage getBackground() {
		return background;
	}

	/**
	 * Create a Pause Button for the game with Fucntions.
	 */
	public void createPauseButton() {
		isHidden = true;
		MyButton btnPause = new MyButton("file:src/p4_group_8_repo/PauseButton.png",3,8);
		btnPause.addButtonFunction();
		btnPause.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if (isHidden) {
					background.stop();
					menuSubScene.moveSubScene();
					btnPause.setPlay();
					isHidden = false;
					countd.timeline.pause();
				} else {
					background.start();
					menuSubScene.moveBackSubScene();
					btnPause.setPause();
					isHidden = true;
					countd.timeline.play();
				}

			}
		});
		background.getChildren().add(btnPause);
	}
	
	/**
	 * Create an Exit Button to exit the game.
	 * @return Exit Button
	 */
	public MyButton createExitButton() {
		MyButton btnExit = new MyButton("EXIT",25);
		btnExit.addButtonFunction();
		btnExit.setOnAction(event -> Platform.exit());
		return btnExit;

	}
	
	/**
	 * Create a How To Play Button to show the information of the game.
	 * @return How To Play Button
	 */
	public MyButton createHowToPlayButton() {
		MyButton btnHowToPlay = new MyButton("HOW TO PLAY",25);
		btnHowToPlay.addButtonFunction();
		btnHowToPlay.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				menuSubScene.moveBackSubScene();
				howToPlaySubScene.moveSubScene();
			}
		});
		return btnHowToPlay;
	}
	
	/**
	 * Create a back button for a specific subscene.
	 * @param num To determine which back button to create depends on the subscene.
	 * @return the back button
	 */
	public MyButton createSubSceneBackButton(int num) {
		MyButton btnBack = new MyButton("file:src/p4_group_8_repo/BackButton2.png",380,29);
		btnBack.addButtonFunction();
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
	
	/**
	 * Create a high score button to show the score list.
	 * @return High Score Button
	 */
	public MyButton createHScoreButton() {
		MyButton btnHScore = new MyButton("SCORE",25);
		btnHScore.addButtonFunction();
		btnHScore.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				menuSubScene.moveBackSubScene();
				HScoreSubScene.moveSubScene();

			}
		});
		return btnHScore;
	}
	
	/**
	 * Create a submit button to submit the player's name.
	 * @return Submit Button
	 */
	public MyButton createSubmitButton() {
		MyButton btnSubmit = new MyButton("Submit",20);
		btnSubmit.addButtonFunction();
		btnSubmit.setLayoutX(54);
		btnSubmit.setLayoutY(110);
		btnSubmit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				NotProceedSubScene.moveBackSubScene();
				HScoreSubScene.moveSubScene();
				int score = animal.getPoints();
				String name = tf.getText();
				
				sm.addScore(name,score);
				createHScoreSubSceneEnd();
				HScoreSubSceneEnd.moveSubScene();
			}
		});
		return btnSubmit;
	}
	
	/**
	 * Create a Proceed Button for the player to proceed to next level.
	 * 
	 * @return Proceed Button
	 */
	public MyButton createProceedButton() {
		MyButton btnProceed = new MyButton("YES",20);
		btnProceed.addButtonFunction();
		btnProceed.setLayoutX(54);
		btnProceed.setLayoutY(60);
		btnProceed.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				nextLevel=true;
				int currentLevelNumber = level.getLevelNumber();				
				if (nextLevel == true) {					
					background.getChildren().clear();
					int nextLevelNumber = currentLevelNumber + 1;						
					settingBackground();									
					settingLevel(nextLevelNumber);
					
					int score = animal.getPoints();
					animal = new Animal("file:src/p4_group_8_repo/froggerUp.png");
					background.add(animal);
					
					animal.setPoints(score);
					
					setNumber(score);
					
					createMenuSubScene();
					createHowToPlaySubScene();
					
					createProceedSubScene();
					createNotProceedSubScene();
					createHScoreSubScene();

				}

			}
		});
		return btnProceed;
	}
	
	/**
	 * Create a Not Proceed Button for the player to stop playing from a level
	 * @return Not Proceed Button
	 */
	public MyButton createNotProceedButton() {
		MyButton btnNotProceed = new MyButton("NO",20);
		btnNotProceed.addButtonFunction();
		btnNotProceed.setLayoutX(54);
		btnNotProceed.setLayoutY(110);
		btnNotProceed.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				ProceedSubScene.moveBackSubScene();
				NotProceedSubScene.moveSubScene();
				ImageView iv = new ImageView(new Image("file:src/p4_group_8_repo/LevelCleared2.png",150,150,true,true));
				iv.setX(230);
				iv.setY(150);
				ScaleTransition st = new ScaleTransition(Duration.millis(800),iv);
		        st.setByX(0.8);
		        st.setByY(0.9);
		        st.setCycleCount(Animation.INDEFINITE);
		        st.setAutoReverse(true);
		        st.play();
				background.getChildren().add(iv);

			}
		});
		return btnNotProceed;
	}
	
	/**
	 * Create a Menu Subscene for the player to check n information or exit the game
	 */
	public void createMenuSubScene() {
		menuSubScene = new MySubScene(2);
		background.getChildren().add(menuSubScene);
		VBox vbox = new VBox(20);
		vbox.setTranslateX(54);
		vbox.setTranslateY(100);
		vbox.getChildren().addAll(createHowToPlayButton(), createHScoreButton(), createExitButton());
		menuSubScene.getPane().getChildren().add(vbox);
	}

	/**
	 * Create a How To Play Subscene with the game information.
	 */
	public void createHowToPlaySubScene() {
		howToPlaySubScene = new MySubScene(3);
		background.getChildren().add(howToPlaySubScene);
		
		//InfoLabel label1 = new InfoLabel("HOW TO PLAY");
		howToPlaySubScene.getPane().getChildren().add(createSubSceneBackButton(1));
		//howToPlaySubScene.getPane().getChildren().add(label1);
		howToPlaySubScene.getPane().getChildren().add(new HowToPlayInfo());
	}

	/**
	 * Create a High Score Subscene to show the score list.
	 */
	public void createHScoreSubScene() {
		HScoreSubScene = new MySubScene(3);
		background.getChildren().add(HScoreSubScene);

		HScoreSubScene.getPane().getChildren().add(createSubSceneBackButton(2));
		HScoreSubScene.getPane().getChildren().add(sm.getHighscoreString());
	}
	
	/**
	 * Create a subscene to ask the player proceed to next level or not.
	 */
	public void createProceedSubScene() {
		ProceedSubScene = new MySubScene(4);
		background.getChildren().add(ProceedSubScene);
		ProceedSubScene.getPane().getChildren().add(createProceedButton());
		ProceedSubScene.getPane().getChildren().add(createNotProceedButton());
		InfoLabel label = new InfoLabel("Proceed to Next Level?");
		label.setLayoutX(50);
		label.setLayoutY(25);
		ProceedSubScene.getPane().getChildren().add(label);

	}
	
	/**
	 * Create a subscene which the player chose to not proceed to the next level by requesting the player's name.
	 */
	public void createNotProceedSubScene() {
		NotProceedSubScene = new MySubScene(4);
		background.getChildren().add(NotProceedSubScene);
		
		tf = new TextField();
		InfoLabel text2 = new InfoLabel("Please insert a name.");
		text2.setLayoutX(30);
		text2.setLayoutY(30);
		InfoLabel text = new InfoLabel("Name:");
		tf.setFont(new Font("Berlin Sans FB",15));
		tf.setPrefWidth(170);
		HBox hbox = new HBox(8,text,tf);
		hbox.setLayoutX(35);
		hbox.setLayoutY(60);
		NotProceedSubScene.getPane().getChildren().addAll(text2,hbox,createSubmitButton());	

	}
	
	/**
	 * Create a subscene to show the player the high score list.
	 */
	public void createHScoreSubSceneEnd() {
		HScoreSubSceneEnd = new MySubScene(3);
		background.getChildren().add(HScoreSubSceneEnd);

		HScoreSubSceneEnd.getPane().getChildren().add(sm.getHighscoreString());
	}	

	/**
	 * Start the game screen, music and timer.
	 */
	public void start() {
		//background.playMusic();
		createTimer();
		timer.start();
	}

	/**
	 * Control the game process.
	 */
	public void createTimer() {
		timer = new AnimationTimer() {
			@Override
			public void handle(long now) {
			    if(animal.reset()) {
			    	countd.resetTimer();
			    }
				if(animal.changeLives()) {
					setFrogLives(animal.getNumOfLives());
				}
				if(animal.getNumOfLives() == 0) {
					froglives.removeLives();
					stop();
					background.stop();
					ImageView iv = new ImageView(new Image("file:src/p4_group_8_repo/GameOver1.png",150,150,true,true));
					iv.setX(220);
					iv.setY(60);
					background.getChildren().add(iv);
					ScaleTransition st = new ScaleTransition(Duration.millis(800),iv);
			        st.setByX(0.8);
			        st.setByY(0.9);
			        st.setCycleCount(Animation.INDEFINITE);
			        st.setAutoReverse(true);
			        st.play();
			        NotProceedSubScene.moveSubScene();
					
				}
				if (animal.changeScore()) {
					setNumber(animal.getPoints());
				}
				if (animal.getStop()) {					
					// background.stopMusic();
					nextLevel = false;
					stop();			
					background.stop();
					ProceedSubScene.moveSubScene();					
					int currentLevelNumber = level.getLevelNumber();
					if (currentLevelNumber == 10) {
						ImageView iv = new ImageView(new Image("file:src/p4_group_8_repo/LevelCleared3.png",200,200,true,true));
						iv.setX(200);
						iv.setY(150);
						ScaleTransition st = new ScaleTransition(Duration.millis(800),iv);
				        st.setByX(0.8);
				        st.setByY(0.9);
				        st.setCycleCount(Animation.INDEFINITE);
				        st.setAutoReverse(true);
				        st.play();
						background.getChildren().add(iv);
						NotProceedSubScene.moveSubScene();
					}

				}
			}
		};
	}

	/**
	 * Set the frog lives into the game.
	 * 
	 * @param n the number of frog lives
	 */
	protected void setFrogLives(int n) {
		froglives.removeLives();
		addFrogLives(n);
		
	}

	/**
	 * Set the level of the game.
	 * 
	 * @param levelNumber the number of the level
	 */
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
		case 4:
			level = new Level(background, 4);
			break;
		case 5:
			level = new Level(background, 5);
			break;
		case 6:
			level = new Level(background, 6);
			break;
		case 7:
			level = new Level(background, 7);
			break;
		case 8:
			level = new Level(background, 8);
			break;
		case 9:
			level = new Level(background, 9);
			break;
		case 10:
			level = new Level(background, 10);
			break;
		}

	}

	/**
	 * Set the background of the game screen including frog's home, countdown, pause button, frog's lives and background image
	 */
	public void settingBackground() {
		MyBackgroundImage froggerback = new MyBackgroundImage("file:src/p4_group_8_repo/iKogsKW.png");
		background.add(froggerback);

		background.add(new End(15, 77));
		background.add(new End(144, 77));
		background.add(new End(272, 77));
		background.add(new End(399, 77));
		background.add(new End(527, 77));
		background.add(new Bug());
		background.start();
		start();
		countd = new Countdown(background,animal);
		
		createPauseButton();
		addFrogLives(3);
	}
	
	/**
	 * Add the frog lives image to the game screen.
	 * @param x the number of the frog lives
	 */
	public void addFrogLives(int x) {
		froglives = new Lives(x);
		background.getChildren().add(froglives);
	}

	/**
	 * Stop the timer and countdown timer
	 */
	public void stop() {
		timer.stop();
		countd.timeline.stop();
	}

	/**
	 * Display the score obtained by the player onto the game screen.
	 * @param n the score obtained by the player
	 */
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
