package part22;
// imports the classes from the mbot package so they can be used in this program
import mbot.*;

// Guide: GUIDE.md in this folder, steps 3–6
//
// SECTION A — FOLLOW ALONG: type the main method from the guide in this class.
//    It makes a Rover and sends it round the box to the goal.
//    Leave the package, import, @MBotLab and class lines alone. Type everything else.
//
// SECTION B — COMMENTS: put a // comment ABOVE every line of code, in YOUR OWN WORDS.
// specifies the world setup for the mBot simulation, with obstacles
@MBotLab(world = "obstacles")
// defines the name of the class
public class ObstacleRun {
    // the main method is the start of the program
    public static void main(String[] args) {
        // creates a new Rover object called rover with the name "Dash"
        Rover rover = new Rover("Dash");
        // calls the reachGoal method for the rover Rover
        rover.reachGoal();
        // prints after the rover has reached the goal
        System.out.println(rover + " reached the goal");
    }
}
