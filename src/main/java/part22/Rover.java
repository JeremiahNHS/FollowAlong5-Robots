package part22;
// imports the classes from the mbot package so they can be used in this program
import mbot.*;

// Guide: GUIDE.md in this folder, steps 1–9
//
// Part 22 — behaviors: methods that use the sensors to decide what the robot does.
//
// SECTION A — FOLLOW ALONG: type the Rover class from the guide in this class.
//    Leave the "package part22;" line, the "import mbot.*;" line and the class line alone.
//    Type everything else yourself.
//
// SECTION B — COMMENTS: when you finish, put a // comment ABOVE every line of code,
//    saying in YOUR OWN WORDS what that line does.
// defines the name of the class
public class Rover {
    // declares the private attribute name of type String
    private String name;
    // declares a private attribute called base of type Chassis that stores the Rover's chassis
    private Chassis base;
    // declares the private attribute eyes of type Ultrasonic
    private Ultrasonic eyes;
    // declares a private attribute called floor of type LineSensor that stores the Rover's line sensor
    private LineSensor floor;
    // declares the private attribute lineWasLeft of type boolean
    private boolean lineWasLeft;
    // the constructor for the Rover class that takes 1 parameter: String name
    public Rover(String name) {
        // assigns the name passed into the constructor to this Rover's name attribute
        this.name = name;
        // assigns a new Chassis object to this Rover's base attribute first
        this.base = new Chassis();
        //  creates a new Ultrasonic object, connects it to the Rover's chassis, and assigns it to the eyes attribute
        this.eyes = new Ultrasonic(base);
        //  creates a new LineSensor object, connects it to the Rover's chassis, and assigns it to the floor attribute
        this.floor = new LineSensor(base);
    }
    // defines a public method called driveUntilBlocked that takes a distance in centimeters and returns an int
    public int driveUntilBlocked(double cm){
        // keeps track of how many times the rover moves forward
        int moves = 0;
        // continues driving forward 5 centimeters while the measured distance is greater than cm
        while (eyes.distance() > cm){
            // tells the chassis to drive straight forward 5 centimeters
            base.straight(5);
            // increments moves by 1
            moves++;
        }
        // returns the number of times the rover moved forward 5 centimeters
        return moves;
    }
    // a public method called goAroundLeft which takes a distance sideways in cm and returns nothing
    public void goAroundLeft(double sideways){
        // tells the chassis to turn left 90 degrees
        base.turnLeft(90);
        // tells the chassis to drive sideways for the specified distance
        base.straight(sideways);
        // tells the chassis to turn right 90 degrees
        base.turnRight(90);
    }
    // a public method called reachGoal which takes no parameters and returns nothing
    public void reachGoal(){
        // stores the number of forward movements before the rover detects its first obstacle
        int first = driveUntilBlocked(15);
        // prints out the text along with the amount of moves it took
        System.out.println("Blocked after " + first + " moves. Going round.");
        // calls the goAroundLeft method to move 60 centimeters around the obstacle
        goAroundLeft(60);
        // stores the number of forward movements before the rover detects its second obstacle
        int second = driveUntilBlocked(15);
        // prints out the text along with the amount of moves it took
        System.out.println("Blocked after " + second + " moves. That is the far wall.");
        // tells the chassis to turn right 90 degrees
        base.turnRight(90);
        // tells the chassis to drive straight forward 50 centimeters
        base.straight(50);
    }
    // a public method followLine that takes in int steps as a parameter and returns nothing
    public void followLine(int steps){
        // runs the code inside the {} as long as i is less than steps
        for (int i = 0; i < steps; i++){
            // stores the LineSensor status, which represents where the tape is detected
            int s = floor.status();
            // checks whether the tape is detected on the left sensors
            if (s == 4 || s == 8 || s == 12){
                // tells the chassis to turn left 4 degrees
                base.turnLeft(4);
                // remembers that the tape was last detected on the left
                lineWasLeft = true;
                // checks whether the tape is detected on the right sensors
            } else if (s == 1 || s == 2 || s == 3){
                // tells the chassis to turn right 4 degrees
                base.turnRight(4);
                // remembers that the tape was last detected on the right
                lineWasLeft = false;
            // checks if the line sensor lost the tape
            } else if (s == 0){
                // checks the last location of the line, whether it was left or right
                if (lineWasLeft){
                    // if left, it tells the chassis to turn left 4 degrees
                    base.turnLeft(4);
                // otherwise if it isn't left
                } else {
                    // if not left, it tells the chassis to turn right 4 degrees
                    base.turnRight(4);
                }
            // runs when the tape is detected in the middle sensors
            } else {
                // tells the chassis to drive straight forward 1 centimeter
                base.straight(1);
            }
        }
    }
    // overrides the built-in toString method to return a description of the Rover
    public String toString(){
        // returns the Rover's name followed by "the rover" as a String
        return name + " the rover";
    }
}
