package p4_group_8_repo;

public class Level {
	MyStage stage;
	int levelNumber;

	public Level(MyStage stage, int num) {
		this.stage = stage;
		setLevelNumber(num);

		if (levelNumber == 1) {
			stage.add(new Log("file:src/p4_group_8_repo/log3.png", 125, 0, 130, 0.75));
			stage.add(new Log("file:src/p4_group_8_repo/log3.png", 125, 220, 130, 0.75));
			stage.add(new Log("file:src/p4_group_8_repo/log3.png", 125, 440, 130, 0.75));
			stage.add(new Log("file:src/p4_group_8_repo/logs.png", 273, 0, 208, -2));
			stage.add(new Log("file:src/p4_group_8_repo/logs.png", 273, 400, 208, -2));
			stage.add(new Log("file:src/p4_group_8_repo/log3.png", 125, 50, 250, 0.75));
			stage.add(new Log("file:src/p4_group_8_repo/log3.png", 125, 270, 250, 0.75));
			stage.add(new Log("file:src/p4_group_8_repo/log3.png", 125, 490, 250, 0.75));

			stage.add(new Turtle(500, 290, -1, 130, 130));
			stage.add(new Turtle(300, 290, -1, 130, 130));
			stage.add(new WetTurtle(700, 290, -1, 130, 130));
			stage.add(new WetTurtle(600, 168, -1, 130, 130));
			stage.add(new WetTurtle(400, 168, -1, 130, 130));
			stage.add(new WetTurtle(200, 168, -1, 130, 130));

			stage.add(new Obstacle("file:src/p4_group_8_repo/truck1" + "Right.png", 0, 490, 1, 120, 105));
			stage.add(new Obstacle("file:src/p4_group_8_repo/truck1" + "Right.png", 300, 490, 1, 120, 105));
			stage.add(new Obstacle("file:src/p4_group_8_repo/truck1" + "Right.png", 600, 490, 1, 120, 105));
			stage.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 100, 450, -1, 45, 45));
			stage.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 250, 450, -1, 45, 45));
			stage.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 400, 450, -1, 45, 45));
			stage.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 550, 450, -1, 45, 45));
			stage.add(new Obstacle("file:src/p4_group_8_repo/truck2Right.png", 0, 410, 1, 200, 160));
			stage.add(new Obstacle("file:src/p4_group_8_repo/truck2Right.png", 500, 410, 1, 200, 160));
			stage.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 500, 370, -5, 45, 45));
			stage.add(new Obstacle("file:src/p4_group_8_repo/car1right.png", 500, 532, 2, 45, 45));
		}

		if (levelNumber == 2) {
			stage.add(new Log("file:src/p4_group_8_repo/log3.png", 125, 0, 130, 0.75));
		}

		if (levelNumber == 3) {
			stage.add(new Turtle(500, 290, -1, 130, 130));
		}

	}

	private void setLevelNumber(int num) {
		levelNumber = num;

	}

	public int getLevelNumber() {
		return levelNumber;

	}

	public void removeLevel() {
		stage.getChildren().clear();
	}
}
