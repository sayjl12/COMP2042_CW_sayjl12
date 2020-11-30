package p4_group_8_repo;

import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Animal extends Actor {
	Image imgW1;
	Image imgA1;
	Image imgS1;
	Image imgD1;
	Image imgW2;
	Image imgA2;
	Image imgS2;
	Image imgD2;
	int points = 0;
	int end = 0;
	private boolean second = false;
	boolean noMove = false;
	double movement = 10.1 * 2; 
	double movementX = 10.666666 * 2; 
	int imgSize = 36;
	boolean carDeath = false, crocodileDeath = false;
	boolean waterDeath = false, snakeDeath = false;
	boolean stop = false;
	boolean changeScore = false, changeLives = false;
	int carD = 0;
	double w = 800;
	ArrayList<End> inter = new ArrayList<End>();
	int numOfLives = 3;

	public Animal(String imageLink) {
		setImage(new Image(imageLink, imgSize, imgSize, true, true));
		setX(278);
		setY(573);
		imgW1 = new Image("file:src/p4_group_8_repo/froggerUp.png", imgSize, imgSize, true, true);
		imgA1 = new Image("file:src/p4_group_8_repo/froggerLeft.png", imgSize, imgSize, true, true);
		imgS1 = new Image("file:src/p4_group_8_repo/froggerDown.png", imgSize, imgSize, true, true);
		imgD1 = new Image("file:src/p4_group_8_repo/froggerRight.png", imgSize, imgSize, true, true);
		imgW2 = new Image("file:src/p4_group_8_repo/froggerUpJump.png", imgSize, imgSize, true, true);
		imgA2 = new Image("file:src/p4_group_8_repo/froggerLeftJump.png", imgSize, imgSize, true, true);
		imgS2 = new Image("file:src/p4_group_8_repo/froggerDownJump.png", imgSize, imgSize, true, true);
		imgD2 = new Image("file:src/p4_group_8_repo/froggerRightJump.png", imgSize, imgSize, true, true);
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

	@Override
	public void act(long now) {
		int bounds = 0;
		if (getY() < 0 || getY() > 650) {
			setX(278);
			setY(575);
		}
		if (getX() < 0) {
			move(movementX , 0);
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
				//numOfLives--;
				//changeLives = true;
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
				//numOfLives--;
				//changeLives = true;
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
				//numOfLives--;
				//changeLives = true;
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
				//numOfLives--;
				//changeLives = true;
				setX(278);
				setY(575);
				crocodileDeath = false;
				carD = 0;
				setImage(new Image("file:src/p4_group_8_repo/froggerUp.png", imgSize, imgSize, true, true));
				noMove = false;
			}
		}

		if (getX() > 576) {
			move(-movementX, 0);
		}
		if (getIntersectingObjects(Obstacle.class).size() >= 1) {
			carDeath = false;
		}
		/*if (getX() == 240 && getY() == 82) {
			System.out.println("IN");
			stop = true;
		}*/
		if (getIntersectingObjects(Log.class).size() >= 1 && !noMove) {
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
				waterDeath = false;
			} else {
				move(-1, 0);
			}
		} else if (getIntersectingObjects(End.class).size() >= 1) {
			inter = (ArrayList<End>) getIntersectingObjects(End.class);
			 if (getIntersectingObjects(End.class).get(0).isActivated()) {
				 move(0,movement+1);
			 }else {
				 if(getIntersectingObjects(Bug.class).size() >= 1 && !noMove) {
						points += 200;
						changeScore = true;}
				 points += 50;
				 points -= 10;
				 changeScore = true;
				 w = 800;
				 getIntersectingObjects(End.class).get(0).setEnd();
				 end++;
				 setX(278);
				 setY(575);
			 }	
		} else if (getY() < 305) {
			waterDeath = false;
		}
		if (getStop()) {
			points += 1000;
		}
	}

	public boolean getStop() {
		return end == 5;
	}

	public int getPoints() {
		return points;
	}
	
	public int getNumOfLives() {
		return numOfLives;
	}
	
	public void setPoints(int score) {
		points=score;
	}

	public boolean changeScore() {
		if (changeScore) {
			changeScore = false;
			return true;
		}
		return false;

	}
	
	public boolean changeLives() {
		if (changeLives) {
			changeLives = false;
			return true;
		}
		return false;

	}

}
