package p4_group_8_repo;

import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * This class responsible for the Frog sprite which is the character played by a user.
 * @author User
 * @see Actor 
 */
public class Animal extends Actor {
	Image imgW1, imgA1, imgS1, imgD1, imgW2, imgA2, imgS2, imgD2;
	int points = 0, end = 0, imgSize = 36, carD = 0, numOfLives = 3;
	private boolean second = false, carry = false, reset = false, noMove = false;
	double movement = 10.1 * 2; 
	double movementX = 10.666666 * 2; 
	boolean carDeath = false, crocodileDeath = false;
	boolean waterDeath = false, snakeDeath = false;
	boolean stop = false;
	boolean changeScore = false, changeLives = false;
	double w = 800;
	ArrayList<End> inter = new ArrayList<End>();
	
	/**
	 * Class constructor. Set images for the frog sprite and set movement of the sprite.
	 * @param imageLink images file location
	 */
	public Animal(String imageLink) {
		setImage(new Image(imageLink, imgSize, imgSize, true, true));
		setX(278);
		setY(573);
		setGreenFrog();
		
		setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				if (noMove) {

				} else {
					if (second) {
						if (event.getCode() == KeyCode.W) {
							move(0, -movement);
							changeScore = false;
							setImage(imgW1);
							second = false;
						} else if (event.getCode() == KeyCode.A) {
							move(-movementX, 0);
							setImage(imgA1);
							second = false;
						} else if (event.getCode() == KeyCode.S) {
							move(0, movement);
							setImage(imgS1);
							second = false;
						} else if (event.getCode() == KeyCode.D) {
							move(movementX, 0);
							setImage(imgD1);
							second = false;
						}
					} else if (event.getCode() == KeyCode.W) {
						move(0, -movement);
						setImage(imgW2);
						second = true;
						if (getY() < w) {
							changeScore = true;
							w = getY();
							points += 10;
						}
					} else if (event.getCode() == KeyCode.A) {
						move(-movementX, 0);
						setImage(imgA2);
						second = true;
					} else if (event.getCode() == KeyCode.S) {
						move(0, movement);
						setImage(imgS2);
						second = true;
					} else if (event.getCode() == KeyCode.D) {
						move(movementX, 0);
						setImage(imgD2);
						second = true;
					}
				}
			}
		});
		
		setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				if (noMove) {
				} else {
					if (event.getCode() == KeyCode.W) {					
						move(0, -movement);
						setImage(imgW1);
						second = false;
					} else if (event.getCode() == KeyCode.A) {
						move(-movementX, 0);
						setImage(imgA1);
						second = false;
					} else if (event.getCode() == KeyCode.S) {
						move(0, movement);
						setImage(imgS1);
						second = false;
					} else if (event.getCode() == KeyCode.D) {
						move(movementX, 0);
						setImage(imgD1);
						second = false;
					}
				}
			}

		});
	}
	/**
	 * Override the method inherit from Actor class. 
	 * Set death functions and images.
	 * Set intersecting functions.
	 * Set get to home functions.
	 * 
	 * @param now The timestamp of the current frame in nanoseconds.
	 */
	@Override
	public void act(long now) {
		setBounds();
		
		if (carDeath) {
			noMove = true;
			if ((now) % 11 == 0) {
				carD++;
			}
			
			if (carD == 1) {
				setImage(new Image("file:src/p4_group_8_repo/cardeath1.png", imgSize, imgSize, true, true));
			}
			if (carD == 2) {
				setImage(new Image("file:src/p4_group_8_repo/cardeath2.png", imgSize, imgSize, true, true));
			}
			if (carD == 3) {
				setImage(new Image("file:src/p4_group_8_repo/cardeath3.png", imgSize, imgSize, true, true));
			}
			if (carD == 4) {
				numOfLives--;
				changeLives = true;
				setX(278);
				setY(575);
				carDeath = false;
				carD = 0;
				setImage(new Image("file:src/p4_group_8_repo/froggerUp.png", imgSize, imgSize, true, true));
				noMove = false;
			}
		}
		
		if (snakeDeath) {
			noMove = true;
			if ((now) % 11 == 0) {
				carD++;
			}
			if (carD == 1) {
				setImage(new Image("file:src/p4_group_8_repo/cardeath1.png", imgSize, imgSize, true, true));
			}
			if (carD == 2) {
				setImage(new Image("file:src/p4_group_8_repo/cardeath2.png", imgSize, imgSize, true, true));
			}
			if (carD == 3) {
				setImage(new Image("file:src/p4_group_8_repo/cardeath3.png", imgSize, imgSize, true, true));
			}
			if (carD == 4) {
				numOfLives--;
				changeLives = true;
				setX(278);
				setY(575);
				snakeDeath = false;
				carD = 0;
				setImage(new Image("file:src/p4_group_8_repo/froggerUp.png", imgSize, imgSize, true, true));
				noMove = false;
			}

		}
		if (waterDeath) {
			noMove = true;
			if ((now) % 11 == 0) {
				carD++;
			}
			if (carD == 1) {
				setImage(new Image("file:src/p4_group_8_repo/waterdeath1.png", imgSize, imgSize, true, true));
			}
			if (carD == 2) {
				setImage(new Image("file:src/p4_group_8_repo/waterdeath2.png", imgSize, imgSize, true, true));
			}
			if (carD == 3) {
				setImage(new Image("file:src/p4_group_8_repo/waterdeath3.png", imgSize, imgSize, true, true));
			}
			if (carD == 4) {
				setImage(new Image("file:src/p4_group_8_repo/waterdeath4.png", imgSize, imgSize, true, true));
			}
			if (carD == 5) {
				numOfLives--;
				changeLives = true;
				setX(278);
				setY(575);
				waterDeath = false;
				carD = 0;
				setImage(new Image("file:src/p4_group_8_repo/froggerUp.png", imgSize, imgSize, true, true));
				noMove = false;
			}
		}
		
		if (crocodileDeath) {
			noMove = true;
			if ((now) % 11 == 0) {
				carD++;
			}
			if (carD == 1) {
				setImage(new Image("file:src/p4_group_8_repo/waterdeath1.png", imgSize, imgSize, true, true));
			}
			if (carD == 2) {
				setImage(new Image("file:src/p4_group_8_repo/waterdeath2.png", imgSize, imgSize, true, true));
			}
			if (carD == 3) {
				setImage(new Image("file:src/p4_group_8_repo/waterdeath3.png", imgSize, imgSize, true, true));
			}
			if (carD == 4) {
				setImage(new Image("file:src/p4_group_8_repo/waterdeath4.png", imgSize, imgSize, true, true));
			}
			if (carD == 5) {
				numOfLives--;
				changeLives = true;
				setX(278);
				setY(575);
				crocodileDeath = false;
				carD = 0;
				setImage(new Image("file:src/p4_group_8_repo/froggerUp.png", imgSize, imgSize, true, true));
				noMove = false;
			}
		}
		
		if (getIntersectingObjects(Obstacle.class).size() >= 1) {
			carDeath = true;
		}
		
		if (getIntersectingObjects(Log.class).size() >= 1 && !noMove) {
			if(getIntersectingObjects(FemaleFrog.class).size() >= 1 && !noMove){
				getIntersectingObjects(FemaleFrog.class).get(0).carried();
				carry = true;
				imgW1 = new Image("file:src/p4_group_8_repo/FFroggerUp.png", 30, 30, true, true);
				imgA1 = new Image("file:src/p4_group_8_repo/FFroggerLeft.png", 30, 30, true, true);
				imgS1 = new Image("file:src/p4_group_8_repo/FFroggerDown.png", 30, 30, true, true);
				imgD1 = new Image("file:src/p4_group_8_repo/FFroggerRight.png", 30, 30, true, true);
				imgW2 = new Image("file:src/p4_group_8_repo/FFroggerUpJump.png", 30, 30, true, true);
				imgA2 = new Image("file:src/p4_group_8_repo/FFroggerLeftJump.png", 30, 30, true, true);
				imgS2 = new Image("file:src/p4_group_8_repo/FFroggerDownJump.png", 30, 30, true, true);
				imgD2 = new Image("file:src/p4_group_8_repo/FFroggerRightJump.png", 30, 30, true, true);
			}
			if (getIntersectingObjects(Log.class).get(0).getLeft())
				move(-2, 0);
			else
				move(.75, 0);
		} else if(getIntersectingObjects(Crocodile.class).size() >= 1 && !noMove) {
			if (getIntersectingObjects(Crocodile.class).get(0).getSpeed())
				move(0.75, 0);
			else
				move(1.5,0);
			if(getIntersectingObjects(CrocodileHead.class).size() >= 1 && !noMove) {
				crocodileDeath = true;
			}
		} else if(getIntersectingObjects(Snake.class).size() >= 1 && !noMove) {
			snakeDeath = true;
		} else if (getIntersectingObjects(Turtle.class).size() >= 1 && !noMove) {
			move(-1, 0);
		} else if (getIntersectingObjects(WetTurtle.class).size() >= 1) {
			if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
				waterDeath = true;
			} else 
				move(-1, 0);
		} else if (getIntersectingObjects(End.class).size() >= 1) {
			inter = (ArrayList<End>) getIntersectingObjects(End.class);
			 if (getIntersectingObjects(End.class).get(0).isActivated()) {
				 move(0,movement+1);
			 }else {
				 if(getIntersectingObjects(Bug.class).size() >= 1) {
						points += 200;
						getIntersectingObjects(Bug.class).get(0).setImageNull();
				 }
				 if(carry) {
					points += 200;
					setGreenFrog();
				 }
				 points += 50;
				 points -= 10;
				 changeScore = true;
				 carry = false;
				 w = 800;
				 getIntersectingObjects(End.class).get(0).setEnd();
				 end++;
				 setX(278);
				 setY(575);
				 reset = true;
			 }	
		} else if (getY() < 305) {
			waterDeath = false;
		}
		if (getStop()) {
			points += 1000;
		}
	}
	
	/**
	 * Set bounds for the frog sprite to avoid the frog sprite goes over the screen.
	 */
	private void setBounds() {
		if (getY() < 0 || getY() > 650) {
			setX(278);
			setY(575);
		}
		if (getX() < 0) {
			move(movementX , 0);
		}
		if (getX() > 576) {
			move(-movementX, 0);
		}
		if(getY() < 110 && (getX()>45 && getX()<130)) {
			changeScore = false;
			move(0,movement);
		}
		if(getY() < 110 && (getX()>174 && getX()<258)) {
			changeScore = false;
			move(0,movement);
		}
		if(getY() < 110 && (getX()>302 && getX()<382)) {
			changeScore = false;
			move(0,movement);
		}
		if(getY() < 110 && (getX()>429 && getX()<513)) {
			changeScore = false;
			move(0,movement);
		}
		
	}
	
	/**
	 * Set frog sprite images.
	 */
	private void setGreenFrog() {
		setImage(new Image("file:src/p4_group_8_repo/froggerUp.png", imgSize, imgSize, true, true));
		imgW1 = new Image("file:src/p4_group_8_repo/froggerUp.png", imgSize, imgSize, true, true);
		imgA1 = new Image("file:src/p4_group_8_repo/froggerLeft.png", imgSize, imgSize, true, true);
		imgS1 = new Image("file:src/p4_group_8_repo/froggerDown.png", imgSize, imgSize, true, true);
		imgD1 = new Image("file:src/p4_group_8_repo/froggerRight.png", imgSize, imgSize, true, true);
		imgW2 = new Image("file:src/p4_group_8_repo/froggerUpJump.png", imgSize, imgSize, true, true);
		imgA2 = new Image("file:src/p4_group_8_repo/froggerLeftJump.png", imgSize, imgSize, true, true);
		imgS2 = new Image("file:src/p4_group_8_repo/froggerDownJump.png", imgSize, imgSize, true, true);
		imgD2 = new Image("file:src/p4_group_8_repo/froggerRightJump.png", imgSize, imgSize, true, true);
	}
	
	/**
	 * Check if all home is occupied by the frog sprite.
	 * @return true if all home is occupied else false
	 */
	public boolean getStop() {
		return end == 5;
	}
	
	/**
	 * Access to the Points get throughout the game.
	 * @return current points
	 */
	public int getPoints() {
		return points;
	}
	
	/**
	 * Access to the Lives remaining throughout the game.
	 * @return number of lives
	 */
	public int getNumOfLives() {
		return numOfLives;
	}
	
	/**
	 * Set score 
	 * @param score points set from the previous level
	 */
	public void setPoints(int score) {
		points=score;
	}

	/**
	 * Check if score is approved for changes.
	 * If true, set the changeScore variable into false.
	 * @return true if approved else false
	 */
	public boolean changeScore() {
		if (changeScore) {
			changeScore = false;
			return true;
		}
		return false;

	}

	/**
	 * Check if reseting timer is approved.
	 * If true, set the reset variable into false.
	 * @return true if approved else false
	 */
	public boolean reset() {
		if (reset) {
			reset = false;
			return true;
		}
		return false;

	}

	/**
	 * Check if live is approved for changes.
	 * If true, set the changeLives variable into false.
	 * @return true if approved else false
	 */
	public boolean changeLives() {
		if (changeLives) {
			changeLives = false;
			return true;
		}
		return false;

	}

}
