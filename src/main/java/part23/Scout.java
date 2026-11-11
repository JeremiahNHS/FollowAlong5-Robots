package part23;
// imports the classes from the mbot package so they can be used in this program
import mbot.*;

// Guide: GUIDE.md in this folder, steps 1–5
//
// Part 23 — inheritance: your own robot class, built on top of MBot2.
//
// SECTION A — FOLLOW ALONG: type the Scout class from the guide.
//    Step 1 changes the class line below: that is the one line you DO change.
//    Leave the "package part23;" line and the "import mbot.*;" line alone.
//    Type everything else yourself.
//
// SECTION B — COMMENTS: when you finish, put a // comment ABOVE every line of code,
//    saying in YOUR OWN WORDS what that line does.
// defines the name of the class, Scout, which is a type of Mbot2 so it inherits driving and sensors from it
public class Scout extends MBot2 {
    // declares the private name attribute of type String
    private String name;
    // declares the private scanner attribute of type Scanner which is an ultrasonic sensor
    private Scanner scanner;
    // public constructor for the Scout class that takes 1 parameter: String name
    public Scout(String name){
        // calls the MBot2 constructor to initialize the inherited parts of the Scout
        super();
        // assigns the name passed into the constructor to this Scout's name attribute
        this.name = name;
        // assigns a new Scanner sensor to this Scout's scanner attribute
        this.scanner = new Scanner(this);
    }
    // defines a public method called driveUntilBlocked that takes no parameters and returns an int
    public int driveUntilBlocked(){
        // keeps track of how many times the scout moves forward
        int moves = 0;
        // keeps driving 5cm while the measured distance is less than 25; calls the readUltrasonic()  method which is inherited from Mbot2
        while(readUltrasonic() > 25){
            // tells the scout to go straight 5 cm; inherited method from the Mbot2
            straight(5);
            // increments moves by 1
            moves++;
        }
        // returns the amount of times the scout moved forward 5cm before it got blocked
        return moves;
    }
    // defines a public method called openestIndex that takes no parameters and returns an int
    public int openestIndex(){
        // stores the 7 distances returned by scanner.scan() in an array of doubles called d
        double[] d = scanner.scan();
        // starts best at index 0, which is the first distance in the array; saves the index of the greatest distance
        int best = 0;
        // looks through every distance after the first to find the biggest
        for (int i = 1; i < d.length; i++){
            // checks if distance at index i is greater than the distance at index best
            if (d[i] > d[best]){
                // sets best equal to i if true
                best = i;
            }
        }
        // returns the index of the greatest distance
        return best;
    }
    // a public method called turnTowardOpenSide that takes no parameters and returns nothing
    public void turnTowardOpenSide(){
        // initializes the variable i which holds the index of the angle with the greatest distance
        int i = openestIndex();
        // checks whether the angle with the greatest distance is pointing left
        if (Scanner.ANGLES[i] > 0){
            // calls the inherited turnLeft method to turn the Scout 90 degrees left
            turnLeft(90);
        // runs if the greatest angle is not to the left
        } else {
            // calls the inherited turnRight method to turn the Scout 90 degrees right
            turnRight(90);
        }
    }
    // overrides the built-in toString method to return a description of the Scout
    public String toString(){
        // returns the Scout's name followed by "the scout" as a String
        return name + " the scout";
    }
}
