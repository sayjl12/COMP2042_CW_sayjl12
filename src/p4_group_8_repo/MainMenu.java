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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
		Scene scene = new Scene(background,600,650);
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
		button.setLayoutY(430+mainMenuButtons.size()*65);
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
				mainBackground.getScene().setRoot(maingame.getbackground());
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
		howToPlaySubScene = new MySubScene();
		mainBackground.getChildren().add(howToPlaySubScene);
		
		howToPlaySubScene.getPane().getChildren().add(createSubSceneBackButton());
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
	
	public MyButton createSubSceneBackButton() {
		MyButton btnBack= new MyButton();
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
	
	public void addTitle(){
		mainBackground.getChildren().add(new Title(500,50,125));
	}

	public static void main(String args[]) {
		launch(args);
	}
}
