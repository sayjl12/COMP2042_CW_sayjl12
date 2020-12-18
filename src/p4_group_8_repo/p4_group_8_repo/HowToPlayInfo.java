package p4_group_8_repo;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Contains the info of the game.
 * @author User
 * @see VBox
 *
 */
public class HowToPlayInfo extends VBox{
	
	/**
	 * Class constructor.
	 * Create the information of the game into a vbox, which is ready to implement onto a subscene.
	 */
	public HowToPlayInfo() {
		setSpacing(40);
		setLayoutX(33);
		setLayoutY(90);
		
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
		
		getChildren().addAll(hbox1,hbox2,hbox3,vboxin);
	}
	
}
