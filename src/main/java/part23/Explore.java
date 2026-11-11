package part23;

import mbot.*;

// Guide: GUIDE.md in this folder, steps 3, 5 and 6
//
// SECTION A — FOLLOW ALONG: type the main method from the guide in this class.
//    It makes a Scout and sends it through the junctions to the goal.
//    Leave the package, import, @MBotLab and class lines alone. Type everything else.
//
// SECTION B — COMMENTS: put a // comment ABOVE every line of code, in YOUR OWN WORDS.
// specifies the world setup for the mBot simulation, with junctions
@MBotLab(world = "junctions")
// defines the name of the class
public class Explore {
    // the main method is the start of the program
    public static void main(String[] args){
        // creates a new Scout object called scout with the name "Pathfinder"
        Scout scout = new Scout("Pathfinder");
        // repeats the loop 3 times, with leg going from 1 to 3
        for (int leg = 1; leg <= 3; leg++){
            // stores the number of times the Scout moved forward 5 cm before detecting an obstacle
            int moves = scout.driveUntilBlocked();
            // prints the current leg number and how many moves the Scout made during that leg
            System.out.println("Leg " + leg + ": " + moves + " moves");
            // checks if the Scout is not on its final leg
            if (leg < 3){
                // calls turnTowardOpenSide to turn the Scout toward the most open direction
                scout.turnTowardOpenSide();
            }
        }
        // prints when the scout reaches the goal
        System.out.println(scout + " reached the goal");
    }

}
