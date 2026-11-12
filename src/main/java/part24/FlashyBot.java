package part24;
// imports the classes from the mbot package so they can be used in this program
import mbot.*;

// Guide: GUIDE.md in this folder, steps 4 and 6
//
// SECTION A — FOLLOW ALONG: type the FlashyBot class from the guide.
//    Leave the package, import and class lines alone. Type everything else.
//
// SECTION B — COMMENTS: put a // comment ABOVE every line of code, in YOUR OWN WORDS.
// defines the FlashyBot class, which extends MBot2 and inherits its methods and attributes
public class FlashyBot extends MBot2 {
    // a public constructor for the FlashyBot class
    public FlashyBot(){
        // calls the MBot2's constructor to initialize the inherited part of the FlashyBot
        super();
    }
    // tells Java that the method below is intended to override a method from the parent class
    @Override
    // overrides MBot2's turnLeft method using the same parameter and return type
    public void turnLeft(double degrees){
        // prints out text alerting that the FlashyBot is turning left
        System.out.println("Flash! Turning left " + degrees);
        // turns on the first LED and changes its color to blue
        turnLedOn(1,0,0,255);
        // calls MBot2's original turnLeft method to perform the turn
        super.turnLeft(degrees);
        // turns off the first LED
        turnLedOff(1);
    }
    // tells Java that the method below is intended to override a method from the parent class
    @Override
    // overrides MBot2's turnRight method using the same parameter and return type
    public void turnRight(double degrees) {
        // prints out text alerting that the FlashyBot is turning right
        System.out.println("Flash! Turning right " + degrees);
        // turns on the first LED and changes its color to green
        turnLedOn(1, 0, 255, 0);
        // calls MBot2's original turnRight method to perform the turn
        super.turnRight(degrees);
        // turns off the first LED
        turnLedOff(1);
    }
    // tells Java that the method below is intended to override a method from the parent class
    @Override
    // overrides MBot2's run method, has the same name and returns nothing
    public void run(){
        // repeats the instructions inside the loop 4 times
        for (int i = 0; i < 4; i++){
            // calls MBot2's original straight method to move forward 40cm
            straight(40);
            // calls the FlashyBot's turnLeft method to turn left by 90 degrees
            turnLeft(90);
        }
    }
}
