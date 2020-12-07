package p4_group_8_repo;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

/**
 * This class creates a background stage screen by inherit Pane Class.
 * 
 * @author User
 * @see Pane
 *
 */
public abstract class World extends Pane {
	private AnimationTimer timer;

	/**
	 * Class constructor.
	 * Set the listener of the game such as key pressed or released.
	 * 
	 */
	public World() {

		sceneProperty().addListener(new ChangeListener<Scene>() {

			@Override
			public void changed(ObservableValue<? extends Scene> observable, Scene oldValue, Scene newValue) {
				if (newValue != null) {
					newValue.setOnKeyReleased(new EventHandler<KeyEvent>() {

						@Override
						public void handle(KeyEvent event) {
							if (getOnKeyReleased() != null)
								getOnKeyReleased().handle(event);
							List<Actor> myActors = getObjects(Actor.class);
							for (Actor anActor : myActors) {
								if (anActor.getOnKeyReleased() != null) {
									anActor.getOnKeyReleased().handle(event);
								}
							}
						}

					});

					newValue.setOnKeyPressed(new EventHandler<KeyEvent>() {

						@Override
						public void handle(KeyEvent event) {
							if (getOnKeyPressed() != null)
								getOnKeyPressed().handle(event);
							List<Actor> myActors = getObjects(Actor.class);
							for (Actor anActor : myActors) {
								if (anActor.getOnKeyPressed() != null) {
									anActor.getOnKeyPressed().handle(event);
								}
							}
						}

					});
				}

			}

		});
	}

	/**
	 * Create a timer for the game in order to add animated game sprite.
	 */
	public void createTimer() {
		timer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				act(now);
				List<Actor> actors = getObjects(Actor.class);

				for (Actor anActor : actors) {
					anActor.act(now);
				}

			}
		};
	}

	/**
	 * Start the timer
	 */
	public void start() {
		createTimer();
		timer.start();
	}

	/**
	 * Stop the timer
	 */
	public void stop() {
		timer.stop();
	}

	/**
	 * Add Actor Object into the screen.
	 * 
	 * @param actor actor object
	 */
	public void add(Actor actor) {
		getChildren().add(actor);
	}

	/**
	 * Remove an Actor Object from the screen.
	 * @param actor actor object
	 */
	public void remove(Actor actor) {
		getChildren().remove(actor);
	}

	/**
	 * Access to the Actor array list.
	 * 
	 * @param <A> The type of the element
	 * @param cls A specific class name
	 * @return the Actor array list 
	 */
	public <A extends Actor> List<A> getObjects(Class<A> cls) {
		ArrayList<A> someArray = new ArrayList<A>();
		for (Node n : getChildren()) {
			if (cls.isInstance(n)) {
				someArray.add((A) n);
			}
		}
		return someArray;
	}

	/**
	 * abstract method
	 * @param now The timestamp of the current frame in nanoseconds.
	 */
	public abstract void act(long now);
}
