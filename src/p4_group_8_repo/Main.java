package p4_group_8_repo;

import javafx.util.Duration;
import java.util.Collection;
import java.util.List;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

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

	public Main(int num) {
		background = new MyStage();
		sm = new ScoreManager();
		
		animal = new Animal("file:src/p4_group_8_repo/froggerUp.png");
		
		background.add(new Digit(0, 30, 550, 25));
		settingBackground();
		settingLevel(num);
		background.add(animal);
		createProceedSubScene();
		createMenuSubScene();
		createHowToPlaySubScene();
		createNotProceedSubScene();
		createHScoreSubScene();	
		
		
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
		
		//InfoLabel label1 = new InfoLabel("HOW TO PLAY");
		howToPlaySubScene.getPane().getChildren().add(createSubSceneBackButton(1));
		//howToPlaySubScene.getPane().getChildren().add(label1);
		howToPlaySubScene.getPane().getChildren().add(createHowToPlayImage());
	}
	
	public VBox createHowToPlayImage() {
		VBox vbox = new VBox();
		vbox.setSpacing(40);
		vbox.setLayoutX(33);
		vbox.setLayoutY(90);
		
		HBox hbox1 = new HBox();
		InfoLabel l1 = new InfoLabel("Move your frog around with ");
		ImageView iv1 = new ImageView(new Image("file:src/p4_group_8_repo/ArrowKeys.png",55,55,true,true));
		InfoLabel l2 = new InfoLabel(" to get it home.");
		hbox1.getChildren().addAll(l1,iv1,l2);
		
		HBox hbox2 = new HBox(5);
		InfoLabel l3 = new InfoLabel("Avoid getting hit by");
		ImageView iv2  = new ImageView(new Image("file:src/p4_group_8_repo/car1left.png",40,40,true,true));
		ImageView iv3  = new ImageView(new Image("file:src/p4_group_8_repo/scarleft.png"));
		ImageView iv4  = new ImageView(new Image("file:src/p4_group_8_repo/scarright.png"));
		ImageView iv5  = new ImageView(new Image("file:src/p4_group_8_repo/struckright.png"));
		ImageView iv6  = new ImageView(new Image("file:src/p4_group_8_repo/truck1Left.png",80,65,true,true));
		InfoLabel l4 = new InfoLabel(".");
		hbox2.getChildren().addAll(l3,iv2,iv3,iv4,iv5,iv6,l4);
		
		HBox hbox3 = new HBox();
		InfoLabel l5 = new InfoLabel("Jump on ");
		ImageView iv7 = new ImageView(new Image("file:src/p4_group_8_repo/log3.png"));
		InfoLabel l6 = new InfoLabel(" and ");
		ImageView iv8 = new ImageView(new Image("file:src/p4_group_8_repo/TurtleAnimation2.png"));
		InfoLabel l7 = new InfoLabel(" to cross the river.");
		hbox3.getChildren().addAll(l5,iv7,l6,iv8,l7);
		
		VBox vboxin = new VBox();
		HBox hbox4 = new HBox();
		HBox hbox5 = new HBox();
		InfoLabel l8 = new InfoLabel("Diving ");
		ImageView iv9 = new ImageView(new Image("file:src/p4_group_8_repo/TurtleAnimation2.png"));
		InfoLabel l9 = new InfoLabel(" might cause you death,");
		InfoLabel l10 = new InfoLabel("     so make sure to jump in the right time.");
		hbox4.getChildren().addAll(l8,iv9,l9);
		hbox5.getChildren().add(l10);
		vboxin.getChildren().addAll(hbox4,hbox5);
		
		vbox.getChildren().addAll(hbox1,hbox2,hbox3,vboxin);
		
		return vbox;
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
		HScoreSubScene.getPane().getChildren().add(sm.getHighscoreString());
	}
	
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
	
	public MyButton createSubmitButton() {
		MyButton btnSubmit = new MyButton("Submit", "Berlin Sans FB", 20, "#8FBC8F");
		btnSubmit.mouseEntered();
		btnSubmit.mouseExited();
		btnSubmit.mouseClicked();
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
				//System.out.println(score);
				//System.out.println(name);
				//stringscore  = sm.getHighscoreString();
				System.out.print(sm.getHighscoreString());
				//System.out.print(stringscore);
				createHScoreSubSceneEnd();
				HScoreSubSceneEnd.moveSubScene();
			}
		});
		return btnSubmit;
	}
	
	public void createHScoreSubSceneEnd() {
		HScoreSubSceneEnd = new MySubScene(3);
		background.getChildren().add(HScoreSubSceneEnd);

		HScoreSubSceneEnd.getPane().getChildren().add(sm.getHighscoreString());
	}
	
	
	public MyButton createProceedButton() {
		MyButton btnProceed = new MyButton("YES", "Berlin Sans FB", 20, "#8FBC8F");
		btnProceed.mouseEntered();
		btnProceed.mouseExited();
		btnProceed.mouseClicked();
		btnProceed.setLayoutX(54);
		btnProceed.setLayoutY(60);
		btnProceed.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				//System.out.println(animal.getPoints());
				nextLevel=true;
				int currentLevelNumber = level.getLevelNumber();				
				if (nextLevel == true) {					
					background.getChildren().clear();
					int nextLevelNumber = currentLevelNumber + 1;						
					settingBackground();									
					settingLevel(nextLevelNumber);
					//System.out.println(animal.getPoints());
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
	
	public MyButton createNotProceedButton() {
		MyButton btnNotProceed = new MyButton("NO", "Berlin Sans FB", 20, "#8FBC8F");
		btnNotProceed.mouseEntered();
		btnNotProceed.mouseExited();
		btnNotProceed.mouseClicked();
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

	public void start() {
		// background.playMusic();
		createTimer();
		timer.start();
	}

	public void createTimer() {
		timer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				if(animal.getNumOfLives() == 2) {
					froglives.removeLives();
					addFrogLives(2);
				}
				if(animal.getNumOfLives() == 1) {
					froglives.removeLives();
					addFrogLives(1);
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
					if (currentLevelNumber == 3) {
						NotProceedSubScene.moveSubScene();
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
		
		background.start();
		start();

		createPauseButton();
		addFrogLives(3);
	}
	
	public void addFrogLives(int x) {
		froglives = new Lives(x);
		background.getChildren().add(froglives);
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
