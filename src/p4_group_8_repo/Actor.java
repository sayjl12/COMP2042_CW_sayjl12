package p4_group_8_repo;

import javafx.scene.image.ImageView;
import java.util.ArrayList;

/**
 * This class is extends from ImageView Class to add animated sprite.
 * 
 * @author User
 * @see javafx.scene.image.ImageView
 */
public abstract class Actor extends ImageView {
	
	/**
	 * This method is to move a sprite.
	 * 
	 * @param dx This is the x coordinate of the sprite.
	 * @param dy This is the y coordinate of the sprite.
	 */
	public void move(double dx, double dy) {
		setX(getX() + dx);
		setY(getY() + dy);
	}
	
	/**
	 * This method access to the World class.
	 * 
	 * @return World This returns to the value of property parent.
	 */
	public World getWorld() {
		return (World) getParent();
	}
	
	/**
	 * This method determine the whether actor object intersects another actor object.
	 * 
	 * @param <A> Type of element.
	 * @param cls This refer a particular class.
	 * @return ArrayList This returns to a array lists of an actor objects.
	 */
	public <A extends Actor> java.util.List<A> getIntersectingObjects(java.lang.Class<A> cls) {
		ArrayList<A> someArray = new ArrayList<A>();
		for (A actor : getWorld().getObjects(cls)) {
			if (actor != this && actor.intersects(this.getBoundsInLocal())) {
				someArray.add(actor);
			}
		}
		return someArray;
	}
	
	/**
	 * This is an abstract method to be implemented by child class.
	 * 
	 * @param now The timestamp of the current frame in nanoseconds.
	 * 
	 */
	public abstract void act(long now);

}
