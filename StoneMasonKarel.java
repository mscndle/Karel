/*
 * File: StoneMasonKarel.java
 * --------------------------
 * Algorithm:
 * Karel starts off at 1st ave and 1st street.
 * Keep fixing columns (going up and down) and moving to next column
 * unless there is a wall obstructing on the east.
 * Works for any length of columns. Columns don't have to be same length.
 */

/*
 * Assumptions about the world:
 * 1. Karel starts at 1st ave, 1st street, facing east with infinite beepers
 * 2. Columns are exactly 4 units apart, 1st, 5th, 9th...
 * 3. End of columns is a wall after the final column
 * 4. Top of the columns is a wall, columns can be of different heights
 * 5. Do not place beepers on top of already placed beepers
 */


import stanford.karel.*;

public class StoneMasonKarel extends SuperKarel {
	
	public void run() {
		while (true) {
			turnLeft();
			fixColumn();
			if (!frontIsBlocked()) {
				for (int i=0; i<4; i++) {
					move();
				}
				System.out.println("Moving to next column");
			} else {
				break;
			}
		}
		System.out.println("Done building...");
	}
	
	
	//Since column can be of any length (even zero)
	//check if there is a wall ahead
	//If there is a wall -> turn right, move to next column
	//else -> if there is no beeper -> put a beeper and move one step
	//at the end of it all, turn around and come back down
	public void fixColumn() {
		while (!frontIsBlocked()) {
			if (noBeepersPresent()) {
				putBeeper();
				move();
			}
			else {				
				move();
			}		
		}
		if (noBeepersPresent()) {	//last block before wall without beeper
			putBeeper();
		}
		//Once Beepers are put everywhere, turn around and head back south
		turnAround();
		while (!frontIsBlocked()) {
			move();
		}
		turnLeft();	//face east
		System.out.println("Fixed column");
	}
	

}
