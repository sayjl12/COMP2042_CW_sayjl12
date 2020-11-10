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
	    

		MyBackgroundImage froggerback = new MyBackgroundImage("file:src/p4_group_8_repo/iKogsKW.png");
	    
		background.add(froggerback);
		
		Level1 l1 = new Level1(background);
		
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
