package part21;
// imports the classes from the mbot package so they can be used in this program
import mbot.*;

// Guide: GUIDE.md in this folder, steps 2–8
//
// Part 21 — composition: a Rover HAS-A Chassis and HAS-AN Ultrasonic.
//
// SECTION A — FOLLOW ALONG: type the Rover class from the guide in this class.
//    Leave the "package part21;" line, the "import mbot.*;" line and the class line alone.
//    Type everything else yourself.
//
// SECTION B — COMMENTS: when you finish, put a // comment ABOVE every line of code,
//    saying in YOUR OWN WORDS what that line does.
//
// SECTION C — STRETCH B adds a LineSensor and two methods to this class.
// defines the name of the class
public class Rover {
    // declares the attribute name of type String that can only be accessed within the class
    private String name;
    // declares the attribute base of type Chassis that can only be accessed within the class
    private Chassis base;
    // declares the attribute eyes of type Ultrasonic that can only be accessed within the class
    private Ultrasonic eyes;
    // the constructor for the Rover class that takes 1 parameter: String name
    private LineSensor floor;

    public Rover(String name){
        // assigns the name passed into the constructor to this Rover's name attribute
        this.name = name;
        // assigns a new Chassis object to this Rover's base attribute first
        this.base = new Chassis();
        //  creates a new Ultrasonic object, connects it to the Rover's chassis, and assigns it to the eyes attribute
        this.eyes = new Ultrasonic(base);
        this.floor = new LineSensor(base);
    }
    // defines a public method called somethingAhead that takes a distance in centimeters and returns a boolean
    public boolean somethingAhead(double cm){
        // asks the sensors how far away something is, and returns true if it's less than cm
        return eyes.distance() < cm;
    }
    // a public method called driveUntilBlocked which takes no parameters and returns nothing
    public void driveUntilBlocked(){
        // keeps running while there is nothing detected within 20 centimeters
        while (!somethingAhead(20)){
            // tells the chassis to drive straight forward 5 centimeters
            base.straight(5);
        }
    }

    public void driveToTape(){
        while (!floor.seesTape()){
            base.straight(2);
        }
    }

    public void forward(double cm){
        base.straight(cm);
    }
    // overrides the built-in toString method to return a description of the Rover
    public String toString(){
        // returns the Rover's name followed by "the rover" as a String
        return name + " the rover";
    }
}