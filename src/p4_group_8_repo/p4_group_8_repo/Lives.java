package p4_group_8_repo;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 * This class creates the frog lives in the game.
 * @author User
 * @see HBox
 *
 */
public class Lives extends HBox{
	ArrayList<ImageView> lives = new ArrayList<ImageView>();
	int shift=0;
	
	/**
	 * Class constructor.
	 * Set the image and image properties and position of 3 frog lives.
	 * @param x the number of frog lives
	 */
	public Lives (int x) {	
		
		for (int i=0; i<x; i++) {
			lives.add(new ImageView (new Image("file:src/p4_group_8_repo/froglives.png",25,25,true,true)));
			getChildren().add(lives.get(i));
		}
		
		setSpacing(8);
		setLayoutY(615);
		setLayoutX(10);		
	}
	
	/**
	 * Remove the frog lives when the frog is death.
	 */
	public void removeLives() {
		getChildren().clear();
		
	}
	
	
}
