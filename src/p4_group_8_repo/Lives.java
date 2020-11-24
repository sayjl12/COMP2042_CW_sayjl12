package p4_group_8_repo;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class Lives extends HBox{
	ArrayList<ImageView> lives = new ArrayList<ImageView>();
	int shift=0;
	
	public Lives (int x) {	
		
		for (int i=0; i<x; i++) {
			lives.add(new ImageView (new Image("file:src/p4_group_8_repo/froglives.png",25,25,true,true)));
			getChildren().add(lives.get(i));
		}
		
		setSpacing(8);
		setLayoutY(615);
		setLayoutX(10);		
	}
	
	public void removeLives() {
		getChildren().clear();
		
	}
	
	
}
