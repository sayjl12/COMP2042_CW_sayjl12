package p4_group_8_repo;

/**
 * This class indicate the level to be shown.
 * @author User
 *
 */
public class Level {
	MyStage stage;
	int levelNumber;

	/**
	 * Class constructor.
	 * Set the level according to requests.
	 * @param stage the background stage of the game
	 * @param num the level to be shown and executed
	 */
	public Level(MyStage stage, int num) {
		this.stage = stage;
		setLevelNumber(num);
		
		switch (levelNumber) {
		case 1:
			setLevel1();
			break;
		case 2:
			setLevel2();
			break;
		case 3:
			setLevel3();
			break;
		case 4:
			setLevel4();
			break;
		case 5:
			setLevel5();
			break;
		case 6:
			setLevel6();
			break;
		case 7:
			setLevel7();
			break;
		case 8:
			setLevel8();
			break;
		case 9:
			setLevel9();
			break;
		case 10:
			setLevel10();
			break;
		}
	}
	
	/**
	 * Set the level desired.
	 * @param num the number of the level
	 */
	private void setLevelNumber(int num) {
		levelNumber = num;
	}

	/**
	 * Access to the number of the level.
	 * @return current level's number
	 */
	public int getLevelNumber() {
		return levelNumber;
	}
	
	/**
	 * Set the obstacles, turtles, female frog and log sprite for Level 1.
	 */
	public void setLevel1() {
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1right.png", 500, 532, 2, 45, 45));
		
		stage.add(new Obstacle("file:src/p4_group_8_repo/truck1" + "Right.png", 0, 494, 1, 120, 35));
		stage.add(new Obstacle("file:src/p4_group_8_repo/truck1" + "Right.png", 300, 494, 1, 120, 35));
		stage.add(new Obstacle("file:src/p4_group_8_repo/truck1" + "Right.png", 600, 494, 1, 120, 35));
		
		stage.add(new Obstacle("file:src/p4_group_8_repo/truck2Right.png", 0, 410, 1, 200, 155));
		stage.add(new Obstacle("file:src/p4_group_8_repo/truck2Right.png", 500, 410, 1, 200, 155));
		
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 500, 370, -5, 45, 45));
		
		stage.add(new Turtle(3, 500, 290, -1, 130, 130));
		stage.add(new Turtle(3, 300, 290, -1, 130, 130));
		stage.add(new WetTurtle(3,700, 290, -1, 130, 130));
		
		stage.add(new Log("file:src/p4_group_8_repo/log3.png", 125, 50, 250, 0.75));
		stage.add(new Log("file:src/p4_group_8_repo/log3.png", 125, 270, 250, 0.75));
		stage.add(new Log("file:src/p4_group_8_repo/log3.png", 125, 490, 250, 0.75));
		
		stage.add(new Log("file:src/p4_group_8_repo/logs.png", 273, 0, 208, -2));
		stage.add(new Log("file:src/p4_group_8_repo/logs.png", 273, 400, 208, -2));
		
		stage.add(new FemaleFrog(50,213,-2));
		
		stage.add(new WetTurtle(3,600, 168, -1, 130, 130));
		stage.add(new WetTurtle(3,400, 168, -1, 130, 130));
		stage.add(new WetTurtle(3,200, 168, -1, 130, 130));	
		
		stage.add(new Log("file:src/p4_group_8_repo/log3.png", 125, 0, 130, 0.75));
		stage.add(new Log("file:src/p4_group_8_repo/log3.png", 125, 220, 130, 0.75));
		stage.add(new Log("file:src/p4_group_8_repo/log3.png", 125, 440, 130, 0.75));
	}
	
	/**
	 * Set the obstacles, turtles and log sprite for Level 2.
	 */
	public void setLevel2() {
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 500, 532, -2, 45, 45));
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 0, 532, -2, 45, 45));
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 300, 532, -2, 45, 45));
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 100, 532, -2, 45, 45));
		
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1right.png", 500, 494, 2, 45, 45));
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1right.png", 0, 494, 2, 45, 45));
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1right.png", 100, 494, 2, 45, 45));
		
		stage.add(new Obstacle("file:src/p4_group_8_repo/truck2Right.png", 0, 450, 1, 200, 155));
		stage.add(new Obstacle("file:src/p4_group_8_repo/truck2Right.png", 500, 450, 1, 200, 155));
		
		stage.add(new Obstacle("file:src/p4_group_8_repo/scarleft.png", 500, 410, -5, 40, 40));
		
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1right.png", 450, 370, 2, 45, 45));
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1right.png", 0, 370, 2, 45, 45));
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1right.png", 100, 370, 2, 45, 45));
		
		stage.add(new Turtle(3, 500, 290, -1, 130, 130));
		
		stage.add(new Log("file:src/p4_group_8_repo/log3.png", 125, 50, 250, 0.75));
		stage.add(new Log("file:src/p4_group_8_repo/log3.png", 125, 270, 250, 0.75));
		stage.add(new Log("file:src/p4_group_8_repo/log3.png", 125, 490, 250, 0.75));
		
		stage.add(new Log("file:src/p4_group_8_repo/logs.png", 273, 400, 208, -2));
		stage.add(new Log("file:src/p4_group_8_repo/logs.png", 273, 0, 208, -2));
		
		stage.add(new WetTurtle(3,600, 168, -1, 130, 130));
		stage.add(new WetTurtle(3,400, 168, -1, 130, 130));
		
		stage.add(new Log("file:src/p4_group_8_repo/log2.png", 148, 0, 130, 0.75));
		stage.add(new Log("file:src/p4_group_8_repo/log2.png", 148, 220, 130, 0.75));
		stage.add(new Log("file:src/p4_group_8_repo/log2.png", 148, 440, 130, 0.75));
	}
	
	/**
	 * Set the obstacles, turtles and log sprite for Level 3.
	 */
	public void setLevel3() {
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1right.png", 500, 532, 2, 45, 45));
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1right.png", 0, 532, 2, 45, 45));
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1right.png", 100, 532, 2, 45, 45));
		
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 500, 494, -2, 45, 45));
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 0, 494, -2, 45, 45));
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 350, 494, -2, 45, 45));
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 100, 494, -2, 45, 45));
		
		stage.add(new Obstacle("file:src/p4_group_8_repo/scarright.png", 500, 450, -5, 42, 42));
		
		stage.add(new Obstacle("file:src/p4_group_8_repo/struckright.png", 500, 410, 1, 40, 40));
		stage.add(new Obstacle("file:src/p4_group_8_repo/struckright.png", 180, 410, 1, 40, 40));
		
		stage.add(new Obstacle("file:src/p4_group_8_repo/truck2Left.png", 400, 370, -2, 200, 155));
		
		stage.add(new Turtle(3, 500, 290, -1, 130,130));
		stage.add(new Turtle(3, 300, 290, -1, 130, 130));
		
		stage.add(new Log("file:src/p4_group_8_repo/log3.png", 125, 50, 250, 0.75));
		stage.add(new Log("file:src/p4_group_8_repo/log3.png", 125, 270, 250, 0.75));
		stage.add(new Log("file:src/p4_group_8_repo/log3.png", 125, 490, 250, 0.75));
		
		stage.add(new Log("file:src/p4_group_8_repo/logs.png", 273, 400, 208, -2));
		stage.add(new Log("file:src/p4_group_8_repo/logs.png", 273, 0, 208, -2));
		
		stage.add(new WetTurtle(3,600, 168, -1, 130, 130));
		stage.add(new WetTurtle(3,400, 168, -1, 130, 130));
		stage.add(new WetTurtle(3,600, 168, -1, 130, 130));
		
		stage.add(new Log("file:src/p4_group_8_repo/log3.png", 125, 50, 130, 0.75));
		stage.add(new Log("file:src/p4_group_8_repo/log3.png", 125, 270, 130, 0.75));
		stage.add(new Log("file:src/p4_group_8_repo/log3.png", 125, 490, 130, 0.75));
	}
	
	/**
	 * Set the obstacles, turtles, snake and log sprite for Level 4.
	 */
	public void setLevel4() {
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1right.png", 590, 532, 2, 45, 45));
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1right.png", 400, 532, 2, 45, 45));
		stage.add(new Obstacle("file:src/p4_group_8_repo/scarright.png", 250, 532, 2, 42, 42));
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1right.png", 0, 532, 2, 45, 45));
		
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1right.png", 540, 494, 2, 45, 45));
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1right.png", 450, 494, 2, 45, 45));
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1right.png", 300, 494, 2, 45, 45));
		stage.add(new Obstacle("file:src/p4_group_8_repo/scarright.png", 100, 494, 2, 42, 42));
		
		stage.add(new Obstacle("file:src/p4_group_8_repo/scarleft.png", 520, 450, -2, 40, 40));
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 450, 450, -2, 45, 45));
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 300, 450, -2, 45, 45));
		stage.add(new Obstacle("file:src/p4_group_8_repo/scarleft.png", 30, 450, -2, 40, 40));
		
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1right.png", 450, 410, 5, 45, 45));
		stage.add(new Obstacle("file:src/p4_group_8_repo/scarright.png", 245, 410, 5, 42, 42));
		stage.add(new Obstacle("file:src/p4_group_8_repo/scarright.png", 100, 410, 5, 42, 42));
		
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1right.png", 0, 370, 2, 45, 45));
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1right.png", 300, 370, 2, 45, 45));
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1right.png", 570, 370, 2, 45, 45));
		
		stage.add(new Snake(599,335));
		
		stage.add(new WetTurtle(2,600, 290, -1, 85, 85));
		stage.add(new WetTurtle(2,400, 290, -1, 85, 85));
		stage.add(new WetTurtle(2,150, 290, -1, 85, 85));
		
		stage.add(new Log("file:src/p4_group_8_repo/log3.png", 125, 100, 250, 0.75));
		stage.add(new Log("file:src/p4_group_8_repo/log3.png", 125, 490, 250, 0.75));
		
		stage.add(new Log("file:src/p4_group_8_repo/logs.png", 273, 400, 208, -2));
		
		stage.add(new Turtle(3, 500, 168, -1, 130, 130));
		stage.add(new WetTurtle(2,250, 168, -1, 85, 85));
		stage.add(new Turtle(3, 0, 168, -1, 130, 130));
		
		stage.add(new Log("file:src/p4_group_8_repo/log2.png", 148, 0, 130, 0.75));
		stage.add(new Log("file:src/p4_group_8_repo/log2.png", 148, 220, 130, 0.75));
	}
	
	/**
	 * Set the obstacles, turtles, crocodiles, snake and logs sprite for Level 5.
	 */
	public void setLevel5() {
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 500, 532, -2, 45, 45));
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 0, 532, -2, 45, 45));
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 300, 532, -2, 45, 45));
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 100, 532, -2, 45, 45));
		
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1right.png", 540, 494, 2, 45, 45));
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1right.png", 450, 494, 2, 45, 45));
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1right.png", 300, 494, 2, 45, 45));
		stage.add(new Obstacle("file:src/p4_group_8_repo/scarright.png", 100, 494, 2, 42, 42));
		
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1right.png", 580, 450, 2, 45, 45));
		stage.add(new Obstacle("file:src/p4_group_8_repo/struckright.png", 500, 450, 2, 40, 40));
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1right.png", 260, 450, 2, 45, 45));
		stage.add(new Obstacle("file:src/p4_group_8_repo/struckright.png", 400, 450, 2, 40, 40));
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1right.png", 80, 450, 2, 45, 45));
		
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 500, 410, -1, 45, 45));
		stage.add(new Obstacle("file:src/p4_group_8_repo/truck2Left.png", 0, 410, -1, 200, 155));
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 300, 410, -1, 45, 45));
		
		stage.add(new Obstacle("file:src/p4_group_8_repo/truck1Right.png", 570, 370, 2, 120, 35));
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1right.png", 300, 370, 2, 45, 45));
		stage.add(new Obstacle("file:src/p4_group_8_repo/scarright.png", 100, 370, 2, 42, 42));
		
		stage.add(new Snake(210,335));
		
		stage.add(new Turtle(3, 350, 290, -1, 130, 130));
		stage.add(new Turtle(3, 0, 290, -1, 130, 130));
		
		stage.add(new Log("file:src/p4_group_8_repo/log3.png", 125, 100, 250, 0.75));
		stage.add(new Log("file:src/p4_group_8_repo/log3.png", 125, 490, 250, 0.75));
		
		stage.add(new Log("file:src/p4_group_8_repo/logs.png", 273, 400, 208, -2));
		
		stage.add(new Turtle(3, 500, 168, -1, 130, 130));
		stage.add(new WetTurtle(2,250, 168, -1, 85, 85));
		stage.add(new Turtle(3, 0, 168, -1, 130, 130));
		
		stage.add(new Crocodile(150, 120, 1.5, 120, 120));
		stage.add(new CrocodileHead(150, 120, 1.5, 40,40));
		stage.add(new Crocodile(508, 120, 1.5, 120, 120));
		stage.add(new CrocodileHead(508, 120, 1.5, 40,40));
	}
	
	/**
	 * Set the obstacles, turtles, crocodiles and snake and logs sprite for Level 6.
	 */
	public void setLevel6() {
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1right.png", 500, 532, 2, 45, 45));
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1right.png", 0, 532, 2, 45, 45));
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1right.png", 100, 532, 2, 45, 45));
		
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 300, 494, -2, 45, 45));
		stage.add(new Obstacle("file:src/p4_group_8_repo/scarleft.png", 500, 494, -2, 40, 40));
		stage.add(new Obstacle("file:src/p4_group_8_repo/scarleft.png", 100, 494, -2, 40, 40));
		
		stage.add(new Obstacle("file:src/p4_group_8_repo/struckright.png", 595, 450, 2, 40, 40));
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1right.png", 150, 450, 2, 45, 45));
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1right.png", 360, 450, 2, 45, 45));
		
		stage.add(new Obstacle("file:src/p4_group_8_repo/truck2Left.png", 400, 410, -1, 200, 155));
		
		stage.add(new Obstacle("file:src/p4_group_8_repo/struckright.png", 500, 370, 3, 40, 40));
		stage.add(new Obstacle("file:src/p4_group_8_repo/struckright.png", 250, 370, 3, 40, 40));
		
		stage.add(new Snake(300,335));
		
		stage.add(new Turtle(3, 590, 290, -1, 130, 130));
		stage.add(new WetTurtle(2,280, 290, -1, 85, 85));
		stage.add(new Turtle(2, 460, 290, -1, 85, 85));
		stage.add(new WetTurtle(3,100, 290, -1,130,130));
		
		stage.add(new Log("file:src/p4_group_8_repo/log3.png", 125, 100, 250, 0.75));
		stage.add(new Log("file:src/p4_group_8_repo/log3.png", 125, 300, 250, 0.75));
		stage.add(new Log("file:src/p4_group_8_repo/log3.png", 125, 580, 250, 0.75));
		
		stage.add(new Turtle(2, 550, 208, -1, 85, 85));
		stage.add(new WetTurtle(3,280, 208, -1, 130, 130));
		stage.add(new Turtle(3, 460, 208, -1, 130, 130));
		stage.add(new WetTurtle(2,150, 208, -1,85,85));
		
		stage.add(new Log("file:src/p4_group_8_repo/log2.png", 148, 0, 168, 0.75));
		stage.add(new Log("file:src/p4_group_8_repo/log2.png", 148, 220, 168, 0.75));
		
		stage.add(new Crocodile(300, 120, 1.5, 120, 120));
		stage.add(new CrocodileHead(300, 120, 1.5, 40,40));
	}
	
	/**
	 * Set the obstacles, turtles, crocodiles, snakes and logs sprite for Level 7.
	 */
	public void setLevel7() {
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 500, 532, -2, 45, 45));
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 0, 532, -2, 45, 45));
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 300, 532, -2, 45, 45));
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 100, 532, -2, 45, 45));
		
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1right.png", 540, 494, 2, 45, 45));
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1right.png", 450, 494, 2, 45, 45));
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1right.png", 300, 494, 2, 45, 45));
		stage.add(new Obstacle("file:src/p4_group_8_repo/scarright.png", 100, 494, 2, 42, 42));
		
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 580, 450, -2, 45, 45));
		stage.add(new Obstacle("file:src/p4_group_8_repo/scarleft.png", 500, 450, -2, 40, 40));
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 260, 450, -2, 45, 45));
		stage.add(new Obstacle("file:src/p4_group_8_repo/scarleft.png", 400, 450, -2, 40, 40));
		
		stage.add(new Obstacle("file:src/p4_group_8_repo/scarright.png", 500, 410, 5, 42, 42));
		stage.add(new Obstacle("file:src/p4_group_8_repo/scarright.png", 300, 410, 5, 42, 42));
		
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 300, 370, -2, 45, 45));
		stage.add(new Obstacle("file:src/p4_group_8_repo/scarleft.png", 500, 370, -2, 40, 40));
		stage.add(new Obstacle("file:src/p4_group_8_repo/scarleft.png", 100, 370, -2, 40, 40));
		
		stage.add(new Snake(100,335));
		stage.add(new Snake(599,335));
		
		stage.add(new WetTurtle(2,600, 290, -1, 85, 85));
		stage.add(new WetTurtle(3,400, 290, -1,130, 130));
		stage.add(new Turtle(3,150, 290, -1, 130, 130));
		
		stage.add(new Log("file:src/p4_group_8_repo/log3.png", 125, 100, 250, -2));
		stage.add(new Log("file:src/p4_group_8_repo/log3.png", 125, 300, 250, -2));
		stage.add(new Log("file:src/p4_group_8_repo/log3.png", 125, 580, 250, -2));
		
		stage.add(new Log("file:src/p4_group_8_repo/logs.png", 273, 400, 208, 0.75));
		
		stage.add(new Turtle(2,0, 168, -1, 85, 85));
		stage.add(new WetTurtle(2,450, 168, -1, 85, 85));
		stage.add(new Turtle(2,300, 168, -1, 85, 85));
		stage.add(new WetTurtle(2,150, 168, -1, 85, 85));
		
		stage.add(new Log("file:src/p4_group_8_repo/log2.png", 148, 0, 130, 0.75));
		stage.add(new Crocodile(300, 120, 0.75, 120, 120));
		stage.add(new CrocodileHead(300, 120, 0.75, 40,40));
		
	}
	
	/**
	 * Set the obstacles, turtles, crocodiles, snakes and logs sprite for Level 8.
	 */
	public void setLevel8() {
		stage.add(new Snake(599,580));
		
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1right.png", 540, 532, 2, 45, 45));
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1right.png", 450, 532, 2, 45, 45));
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1right.png", 300, 532, 2, 45, 45));
		stage.add(new Obstacle("file:src/p4_group_8_repo/scarright.png", 100, 532, 2, 42, 42));
		
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 580, 494, -2, 45, 45));
		stage.add(new Obstacle("file:src/p4_group_8_repo/scarleft.png", 500, 494, -2, 40, 40));
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 260, 494, -2, 45, 45));
		stage.add(new Obstacle("file:src/p4_group_8_repo/scarleft.png", 400, 494, -2, 40, 40));
		
		stage.add(new Obstacle("file:src/p4_group_8_repo/struckright.png", 590, 450, 2, 40, 40));
		stage.add(new Obstacle("file:src/p4_group_8_repo/struckright.png", 500, 450, 2, 40, 40));
		stage.add(new Obstacle("file:src/p4_group_8_repo/struckright.png", 300, 450, 2, 40, 40));
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1right.png", 200, 450, 2, 45, 45));
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1right.png", 60, 450, 2, 45, 45));
		
		stage.add(new Obstacle("file:src/p4_group_8_repo/scarleft.png", 600, 410, -5, 40, 40));
		stage.add(new Obstacle("file:src/p4_group_8_repo/scarleft.png", 300, 410, -5, 40, 40));
		
		stage.add(new Obstacle("file:src/p4_group_8_repo/truck1Right.png", 0, 370, 2, 120, 35));
		stage.add(new Obstacle("file:src/p4_group_8_repo/truck1Right.png", 300, 370, 2, 120, 35));
		stage.add(new Obstacle("file:src/p4_group_8_repo/truck1Right.png", 600, 370, 2, 120, 35));
		
		stage.add(new Snake(100,335));
		
		stage.add(new Turtle(3, 500, 290, -1, 130, 130));
		stage.add(new Turtle(3, 300, 290, -1, 130, 130));
		stage.add(new WetTurtle(3,700, 290, -1, 130, 130));
		
		stage.add(new Log("file:src/p4_group_8_repo/log3.png", 125, 100, 250, -2));
		stage.add(new Log("file:src/p4_group_8_repo/log3.png", 125, 300, 250, -2));
		stage.add(new Log("file:src/p4_group_8_repo/log3.png", 125, 580, 250, -2));
		
		stage.add(new Log("file:src/p4_group_8_repo/logs.png", 273, 400, 208, 0.75));
		
		stage.add(new Turtle(2,0, 168, -1, 85, 85));
		stage.add(new WetTurtle(2,450, 168, -1, 85, 85));
		stage.add(new Turtle(2,300, 168, -1, 85, 85));
		stage.add(new WetTurtle(2,150, 168, -1, 85, 85));
		
		stage.add(new Log("file:src/p4_group_8_repo/log2.png", 148, 0, 130, 0.75));
		stage.add(new Crocodile(300, 120, 0.75, 120, 120));
		stage.add(new CrocodileHead(300, 120, 0.75, 40,40));
	}
	
	/**
	 * Set the obstacles, turtles, crocodiles, snakes and logs sprite for Level 9.
	 */
	public void setLevel9() {
		stage.add(new Snake(610,580));
		
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 500, 532, -2, 45, 45));
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 0, 532, -2, 45, 45));
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 300, 532, -2, 45, 45));
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 100, 532, -2, 45, 45));
		
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1right.png", 540, 494, 2, 45, 45));
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1right.png", 450, 494, 2, 45, 45));
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1right.png", 300, 494, 2, 45, 45));
		stage.add(new Obstacle("file:src/p4_group_8_repo/scarright.png", 100, 494, 2, 42, 42));
		
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 580, 450, -2, 45, 45));
		stage.add(new Obstacle("file:src/p4_group_8_repo/scarleft.png", 500, 450, -2, 40, 40));
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 260, 450, -2, 45, 45));
		stage.add(new Obstacle("file:src/p4_group_8_repo/scarleft.png", 400, 450, -2, 40, 40));
		
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1right.png", 540, 410, 4, 45, 45));
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1right.png", 450, 410, 4, 45, 45));
		stage.add(new Obstacle("file:src/p4_group_8_repo/scarright.png", 300, 410, 4, 42, 42));
		stage.add(new Obstacle("file:src/p4_group_8_repo/scarright.png", 100, 410, 4, 42, 42));
		
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 580, 450, -2, 45, 45));
		stage.add(new Obstacle("file:src/p4_group_8_repo/scarleft.png", 500, 450, -2, 40, 40));
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 260, 450, -2, 45, 45));
		stage.add(new Obstacle("file:src/p4_group_8_repo/scarleft.png", 400, 450, -2, 40, 40));
		
		stage.add(new Snake(650,335));
		
		stage.add(new Turtle(3, 500, 290, -1, 130, 130));
		stage.add(new Turtle(3, 300, 290, -1, 130, 130));
		stage.add(new WetTurtle(3,700, 290, -1, 130, 130));
		
		stage.add(new Log("file:src/p4_group_8_repo/log3.png", 125, 100, 250, -2));
		stage.add(new Log("file:src/p4_group_8_repo/log3.png", 125, 300, 250, -2));
		
		stage.add(new Log("file:src/p4_group_8_repo/logs.png", 273, 500, 208, 0.75));
		stage.add(new Log("file:src/p4_group_8_repo/log3.png", 125, 300, 208, 0.75));
		stage.add(new Log("file:src/p4_group_8_repo/log3.png", 125, 100, 208, 0.75));
		
		stage.add(new Turtle(3, 500, 168, -1, 130, 130));
		stage.add(new Turtle(3, 300, 168, -1, 130, 130));
		stage.add(new WetTurtle(3,700, 168, -1, 130, 130));
		
		stage.add(new Log("file:src/p4_group_8_repo/log2.png", 148, 0, 130, 0.75));
		stage.add(new Crocodile(300, 120, 0.75, 120, 120));
		stage.add(new CrocodileHead(300, 120, 0.75, 40,40));
	}
	
	/**
	 * Set the obstacles, turtles, crocodiles, snakes and logs sprite for Level 10.
	 */
	public void setLevel10() {
		stage.add(new Snake(680,580));
		
		stage.add(new Obstacle("file:src/p4_group_8_repo/struckright.png", 590, 532, 2, 40, 40));
		stage.add(new Obstacle("file:src/p4_group_8_repo/struckright.png", 500, 532, 2, 40, 40));
		stage.add(new Obstacle("file:src/p4_group_8_repo/struckright.png", 300, 532, 2, 40, 40));
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1right.png", 200, 532, 2, 45, 45));
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1right.png", 60, 532, 2, 45, 45));
		
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 580, 494, -2, 45, 45));
		stage.add(new Obstacle("file:src/p4_group_8_repo/scarleft.png", 500, 494, -2, 40, 40));
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 260, 494, -2, 45, 45));
		stage.add(new Obstacle("file:src/p4_group_8_repo/scarleft.png", 400, 494, -2, 40, 40));
		
		stage.add(new Obstacle("file:src/p4_group_8_repo/struckright.png", 550, 450, 2, 40, 40));
		stage.add(new Obstacle("file:src/p4_group_8_repo/struckright.png", 490, 450, 2, 40, 40));
		stage.add(new Obstacle("file:src/p4_group_8_repo/struckright.png", 260, 450, 2, 40, 40));
		stage.add(new Obstacle("file:src/p4_group_8_repo/scarright.png", 160, 450, 2, 42, 42));
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1right.png", 0, 450, 2, 45, 45));
		
		stage.add(new Obstacle("file:src/p4_group_8_repo/scarleft.png", 530, 410, -1, 40, 40));
		stage.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 0, 410, -1, 45, 45));
		stage.add(new Obstacle("file:src/p4_group_8_repo/scarleft.png", 100, 410, -1, 40, 40));
		stage.add(new Obstacle("file:src/p4_group_8_repo/scarleft.png", 300, 410, -1, 40, 40));
		
		stage.add(new Obstacle("file:src/p4_group_8_repo/truck1Right.png", 0, 370, 3, 120, 35));
		stage.add(new Obstacle("file:src/p4_group_8_repo/truck1Right.png", 300, 370, 3, 120, 35));
		stage.add(new Obstacle("file:src/p4_group_8_repo/truck1Right.png", 600, 370, 3, 120, 35));
		
		stage.add(new Snake(640,335));
		stage.add(new Snake(250,335));
		
		stage.add(new Turtle(3, 500, 290, -1, 130, 130));
		stage.add(new Turtle(3, 300, 290, -1, 130, 130));
		
		stage.add(new Log("file:src/p4_group_8_repo/log3.png", 125, 100, 250, -2));
		stage.add(new Log("file:src/p4_group_8_repo/log3.png", 125, 300, 250, -2));
		stage.add(new Log("file:src/p4_group_8_repo/log3.png", 125, 500, 250, -2));
		
		stage.add(new Log("file:src/p4_group_8_repo/logs.png", 273, 100, 208, 0.75));
		
		stage.add(new WetTurtle(3, 500, 168, -1, 130, 130));
		stage.add(new Turtle(3, 300, 168, -1, 130, 130));
		stage.add(new WetTurtle(3,700, 168, -1, 130, 130));
		
		stage.add(new Crocodile(300, 120, 1.5, 120, 120));
		stage.add(new CrocodileHead(300, 120, 1.5, 40,40));
	}

	
}
