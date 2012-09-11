/**
 * MidpointFindingKarel
 * 
 * @author: Mandeep Condle
 * 
 * Algorithm:
 * 1. Place Beepers on every other corner including the first one
 * 2. If there is a Beeper at the last corner, it's ODD, else EVEN
 */

import stanford.karel.*;

public class MidpointFindingKarel extends SuperKarel {
        //2 integers to save number of corners and the midpoint
        private int numberOfCorners = 0;
        private int midPoint = 0;
        
	public void run() {
            traverseRow();
            System.out.println(getCorners());
            System.out.println(calculateMidpoint());
            System.out.println(numberOfCorners + " " + midPoint);
            cleanUpReturn();
            moveToMidpoint();
	}

        public void traverseRow() {
            putBeeper();
            addCorners();
            while(frontIsClear()) {
                move();
                addCorners();
                if (frontIsClear()) {
                    move();
                    putBeeper();
                    addCorners();
                }
            }
        }
        
        /**
         * Adds to the numberOfCorners while Karel traverses
         */
        public void addCorners() {
            numberOfCorners++;
        }
        
        /**
         * Returns the number of corners
         */
        public int getCorners() {
            return numberOfCorners;
        }
        
        /**
         * Determines EVEN / ODD midpoint based on numberOfCorners 
         */
        public int calculateMidpoint() {
            int corners = getCorners();
            if (corners%2 == 1) {   //ODD
                midPoint = (corners + 1) / 2;
            } else {    //EVEN
                midPoint = corners / 2;
            }
            return midPoint;
        }
        
        /**
         * Cleans up the row and returns to 1,1 facing East
         */
        public void cleanUpReturn() {
            turnAround();
            while (frontIsClear()) {
                if (beepersPresent()) {
                    pickBeeper();
                }
                move();    
            }
            turnAround();
            if (beepersPresent()) {
                pickBeeper();
            }
        
        }
        
        /**
         * From 1,1 it moves eastwards towards the middle point
         */
        public void moveToMidpoint() {
            int dest = calculateMidpoint();
            System.out.println(numberOfCorners + " " + midPoint);
            for (int i = 0; i < dest-1; i++) {
                move();
            }
            putBeeper();    //Place beeper at the midpoint
        }
}