/*
 * File: CollectNewspaperKarel.java
 * --------------------------------
 * At present, the CollectNewspaperKarel subclass does nothing.
 * Your job in the assignment is to add the necessary code to
 * instruct Karel to walk to the door of its house, pick up the
 * newspaper (represented by a beeper, of course), and then return
 * to its initial position in the upper left corner of the house.
 */

import stanford.karel.*;

public class CollectNewspaperKarel extends SuperKarel {
	public void run() {
		moveToNewspaper();
		pickNewspaper();
		returnHome();
	}
	
	public void moveToNewspaper() {
		turnRight();
		move();
		turnLeft();
		move();
		move();
		move();
	}

	public void pickNewspaper() {
		pickBeeper();
		turnRight();
		turnRight();
	}
	
	public void returnHome() {
		move();
		move();
		move();
		turnRight();
		move();
		turnRight();
	}
}
