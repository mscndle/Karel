/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * Algorithm:
 * 1. Karel starts from the left corner by placing a Beeper there
 * 2. First move will always be going East
 * 3. If there's no wall move up and face West and traverse that row
 * 4. Repeat above till no wall exists
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {

	public void run() {
		int row = 0;
		while (true) {
			putBeeper();    //the world is at least 1x1
			if (frontIsClear()) {	
				move();		//for a 1x1 world
			} 
			
			//Start by placing beepers going east till I see a wall
			placeBeepersEast();
			
			//If there is no wall move to next row and face west
			if (frontIsClear()) {
				moveRowFaceWest();
			} else {
				break;
			}
			
			placeBeepersWest();
			
                        //If there is no wall move to next row and face east
			if (frontIsClear()) {
				moveRowFaceEast();
			} else {
				break;
			}
                        
		}//end of while	 
		System.out.println("Checkboard done...");
                
	}//end of main	
        
	/*
	 * This method places Beepers on alternate corners moving East
	 * First move is moving one space.
	 */
	public void placeBeepersEast() {
		while(frontIsClear()) {
			move();
			putBeeper();
			if (frontIsClear()) {
				move();
			}
		}
		turnLeft();
	}

	/**
	 * This method places Beepers on alternate corners moving West
	 * First move is a moving one space.
	 */
	public void placeBeepersWest() {
		while(frontIsClear()) {
			move();
			putBeeper();
			if (frontIsClear()) {
				move();
			}
		}
		turnRight();
	}

	/*
	 * This method moves Karel from East side of one row to upper row
     * EVEN vs ODD logic is handled here
	 */
	public void moveRowFaceWest() {
                if (noBeepersPresent()) {
                    move();
                    turnLeft();
                    putBeeper();
                    move();
                } else {
                    move();
                    turnLeft();
                }
	}
	
	/*
	 * This method moves Karel from West most point to upper row facing East
	 */
	public void moveRowFaceEast() {
		move();
		turnRight();
	}
	
}
