package part21;
// imports the classes from the mbot package so they can be used in this program
import mbot.*;

// Guide: GUIDE.md in this folder, steps 4–9
//
// SECTION A — FOLLOW ALONG: type the main method from the guide in this class.
//    It makes a Rover and drives it until it is close to the wall.
//    Leave the package, import, @MBotLab and class lines alone. Type everything else.
//
// SECTION B — COMMENTS: put a // comment ABOVE every line of code, in YOUR OWN WORDS.
// specifies the world setup for the mBot simulation, with a wall ahead
@MBotLab(world = "wall-ahead")
// defines the name of the class
public class FollowAlong {
    // the main method is where the program starts running
    public static void main(String[] args){
        // creates a new Rover object called scout with the name "Scout"
        Rover scout = new Rover("Scout");
        // prints the Rover's description followed by "is ready"
        System.out.println(scout + " is ready");
        // calls the driveUntilBlocked method for the scout Rover
        scout.driveUntilBlocked();
        // prints after the rover has stopped
        System.out.println(scout + " stopped. Something is less than 20 cm ahead.");
    }

}
