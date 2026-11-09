package part22;
// imports the classes from the mbot package so they can be used in this program
import mbot.*;

// Guide: GUIDE.md in this folder, steps 7–9
//
// SECTION A — FOLLOW ALONG: type the main method from the guide in this class.
//    It makes a Rover and follows the loop of tape all the way round.
//    Leave the package, import, @MBotLab and class lines alone. Type everything else.
//
// SECTION B — COMMENTS: put a // comment ABOVE every line of code, in YOUR OWN WORDS.
// specifies the world setup for the mBot simulation, with a line-track
@MBotLab(world = "line-track")
// defines the name of the class
public class LineRun {
    // the main method is the start of the program
    public static void main(String[] args){
        // creates a new Rover object called rover with the name "Tracker"
        Rover rover = new Rover("Tracker");
        // calls the followLine method for the rover with 400 steps passed in an argument
        rover.followLine(400);
        // prints out the text when the rover reaches halfway around the track
        System.out.println("Halfway round");
        // calls the followLine method for the rover with 325 steps passed in an argument
        rover.followLine(325);
        // prints when the rover finishes its lap around the track
        System.out.println(rover + " finished a lap");
    }
}
