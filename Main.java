package p4_group_8_repo;

import java.io.File;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main {
	AnimationTimer timer;
	MyStage background;
	Animal animal;
	
	public Main() {
	    background = new MyStage();
	    

		BackgroundImage froggerback = new BackgroundImage("file:src/p4_group_8_repo/iKogsKW.png");
	    
		background.add(froggerback);
		
		background.add(new Log("file:src/p4_group_8_repo/log3.png", 125, 0, 130, 0.75));
		background.add(new Log("file:src/p4_group_8_repo/log3.png", 125, 220, 130, 0.75));
		background.add(new Log("file:src/p4_group_8_repo/log3.png", 125, 440, 130, 0.75));
		background.add(new Log("file:src/p4_group_8_repo/logs.png", 273, 0, 208, -2));
		background.add(new Log("file:src/p4_group_8_repo/logs.png", 273, 400, 208, -2));
		background.add(new Log("file:src/p4_group_8_repo/log3.png", 125, 50, 250, 0.75));
		background.add(new Log("file:src/p4_group_8_repo/log3.png", 125, 270, 250, 0.75));
		background.add(new Log("file:src/p4_group_8_repo/log3.png", 125, 490, 250, 0.75));
		
		background.add(new Turtle(500, 290, -1, 130, 130));
		background.add(new Turtle(300, 290, -1, 130, 130));
		background.add(new WetTurtle(700, 290, -1, 130, 130));
		background.add(new WetTurtle(600, 168, -1, 130, 130));
		background.add(new WetTurtle(400, 168, -1, 130, 130));
		background.add(new WetTurtle(200, 168, -1, 130, 130));

		background.add(new Obstacle("file:src/p4_group_8_repo/truck1"+"Right.png", 0, 490, 1, 120, 105));
		background.add(new Obstacle("file:src/p4_group_8_repo/truck1"+"Right.png", 300, 490, 1, 120, 105));
		background.add(new Obstacle("file:src/p4_group_8_repo/truck1"+"Right.png", 600, 490, 1, 120, 105));
		background.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 100, 450, -1, 45, 45));
		background.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 250, 450, -1, 45, 45));
		background.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 400, 450, -1, 45, 45));
		background.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 550, 450, -1, 45, 45));
		background.add(new Obstacle("file:src/p4_group_8_repo/truck2Right.png", 0, 410, 1, 200, 160));
		background.add(new Obstacle("file:src/p4_group_8_repo/truck2Right.png", 500, 410, 1, 200, 160));
		background.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 500, 370, -5, 45, 45));
		background.add(new Obstacle("file:src/p4_group_8_repo/car1right.png", 500, 532, 2, 45, 45));
		
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
	}
	
	public MyStage getbackground() {
		return background;
	}
	
	public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	if (animal.changeScore()) {
            		setNumber(animal.getPoints());
            	}
            	if (animal.getStop()) {
            		System.out.print("STOPP:");
            		background.stopMusic();
            		stop();
            		background.stop();
            		Alert alert = new Alert(AlertType.INFORMATION);
            		alert.setTitle("You Have Won The Game!");
            		alert.setHeaderText("Your High Score: "+animal.getPoints()+"!");
            		alert.setContentText("Highest Possible Score: 800");
            		alert.show();
            	}
            }
        };
    }
	public void start() {
	background.playMusic();
    	createTimer();
        timer.start();
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
    		  shift+=22;
    		}
    }
}
