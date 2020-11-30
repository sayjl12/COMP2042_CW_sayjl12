package p4_group_8_repo;

import javafx.scene.image.Image;

public class Bug extends Actor{
	public Bug() {
		setImage(new Image("file:src/p4_group_8_repo/bug.png", 25, 25, true, true));	
	}

	@Override
	public void act(long now) {
		
		
		
		
		
		if (now / 900000000 % 20 == 0 || now / 900000000 % 20 == 1 ) {
			setX(537);
			setY(90);
			setImage(new Image("file:src/p4_group_8_repo/bug.png", 25, 25, true, true));
			if(getIntersectingObjects(End.class).size() >= 1) {
				if(getIntersectingObjects(End.class).get(0).isActivated()) {
					setImage(null);
				}
			}
			if(getIntersectingObjects(Animal.class).size() >= 1) {
				setImage(null);
			}

		} else if (now / 900000000 % 20 == 2 || now / 900000000 % 20 == 3 ) {
			setX(409);
			setY(90);
			setImage(new Image("file:src/p4_group_8_repo/bug.png", 25, 25, true, true));
			if(getIntersectingObjects(End.class).size() >= 1) {
				if(getIntersectingObjects(End.class).get(0).isActivated()) {
					setImage(null);
				}
			}
			if(getIntersectingObjects(Animal.class).size() >= 1) {
				setImage(null);
			}
			
		} else if (now / 900000000 % 20 == 4 || now / 900000000 % 20 == 5 ) {
			setX(282);
			setY(90);
			setImage(new Image("file:src/p4_group_8_repo/bug.png", 25, 25, true, true));
			if(getIntersectingObjects(End.class).size() >= 1) {
				if(getIntersectingObjects(End.class).get(0).isActivated()) {
					setImage(null);
				}
			}
			if(getIntersectingObjects(Animal.class).size() >= 1) {
				setImage(null);
			}
			
		} else if (now / 900000000 % 20 == 6 || now / 900000000 % 20 == 7 ) {
			setX(154);
			setY(90);
			setImage(new Image("file:src/p4_group_8_repo/bug.png", 25, 25, true, true));
			if(getIntersectingObjects(End.class).size() >= 1) {
				if(getIntersectingObjects(End.class).get(0).isActivated()) {
					setImage(null);
				}
			}
			if(getIntersectingObjects(Animal.class).size() >= 1) {
				setImage(null);
			}
			
		} else if (now / 900000000 % 20 == 8 || now / 900000000 % 20 == 9 ) {
			setX(25);
			setY(90);
			setImage(new Image("file:src/p4_group_8_repo/bug.png", 25, 25, true, true));
			if(getIntersectingObjects(End.class).size() >= 1) {
				if(getIntersectingObjects(End.class).get(0).isActivated()) {
					setImage(null);
				}
			}
			if(getIntersectingObjects(Animal.class).size() >= 1) {
				setImage(null);
			}
			
		} else {
			setImage(null);
		}
		
	}
	
	public void setImageNull() {
		setImage(null);
	}
}
